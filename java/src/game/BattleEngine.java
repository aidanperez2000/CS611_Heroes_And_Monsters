package game;

import characters.Hero;
import characters.Monster;
import characters.Party;
import helpers.IntHelpers;
import items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*Class for handling battles*/
public class BattleEngine {
    private final Party party;
    private final List<Monster> monsters;
    private final Scanner scanner;
    private final Random random = new Random();

    public BattleEngine(Party party, List<Monster> monsters, Scanner scanner) {
        this.party = party;
        this.monsters = monsters;
        this.scanner = scanner;
    }

    /*Run the battle loop
     * returns: true if heroes win, false if monsters win*/
    public boolean startBattle() {
        System.out.println("\n=== BATTLE START ===");
        printStatus();
        while (true) {
            heroesTurn();

            if (allMonstersDefeated()) {
                System.out.println("All monsters have been defeated!");
                handleVictory();
                return true;
            }

            monstersTurn();

            if (allHeroesDefeated()) {
                System.out.println("All heroes have been defeated!");
                return false;
            }

            endOfRoundRegen();
            printStatus();
        }
    }

    /*Handle the heroes' turn*/
    private void heroesTurn() {
        for (Hero hero : party.getHeroes()) {
            if (hero.isDead())
                continue;

            if (allMonstersDefeated())
                return;

            boolean actionTaken = false;
            while (!actionTaken) {
                System.out.println("It's " + hero.getName() + "'s turn.");
                System.out.println("Choose action: ");
                System.out.println("1) Attack");
                System.out.println("2) Cast spell");
                System.out.println("3) Use potion");
                System.out.println("4) Change equipment");
                System.out.println("5) Info");
                System.out.println("6) Skip");

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        heroAttack(hero);
                        actionTaken = true;
                        break;
                    case "2":
                        heroCastSpell(hero);
                        actionTaken = true;
                        break;
                    case "3":
                        heroUsePotion(hero);
                        actionTaken = true;
                        break;
                    case "4":
                        heroChangeEquipment(hero);
                        // allow them to change and then re-choose action
                        break;
                    case "5":
                        printStatus();
                        break;
                    case "6":
                        System.out.println(hero.getName() + " skips their turn.");
                        actionTaken = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

    /*Handle hero attack
    * hero: hero that attacks*/
    private void heroAttack(Hero hero) {
        Monster monster = chooseMonster();
        if (monster == null)
            return;

        Weapon weapon = hero.getEquippedWeapon();
        double weaponDamage = (weapon != null) ? weapon.getDamage() : 0;
        double strength = hero.getStrength();

        double baseDamage = (weaponDamage + strength) * 0.05;

        if (monsterDodges(monster)) {
            System.out.println(hero.getName() + " attacked " + monster.getName() +
                    " but they dodged.");
            return;
        }

        double defenseReduction = monster.getDefense() * 0.1;
        double damageAfterDefense = baseDamage - defenseReduction;
        if (damageAfterDefense < 0)
            damageAfterDefense = 0;

        int finalDamage = (int) Math.round(damageAfterDefense);
        monster.takeDamage(finalDamage);


        if (monster.isDead())
            System.out.println(monster.getName() + " has been killed.");
    }

    /*Hero casts a spell
    * hero: hero that casts spell*/
    private void heroCastSpell(Hero hero) {
        List<Spell> spells = hero.getInventory().getSpells();
        if (spells.isEmpty()) {
            System.out.println(hero.getName() + " has no spells.");
            return;
        }

        System.out.println("\nSpells:");
        for (int i = 0; i < spells.size(); i++) {
            Spell spell = spells.get(i);
            System.out.println((i + 1) + ") " + spell.getName()
                + " | Damage: " + spell.getDamage()
                + " | Mana cost: " + spell.getManaCost());
        }

        System.out.println("Choose spell number or 0 to cancel.");

        int choice = IntHelpers.getInt(scanner) - 1;

        if (choice < 0 || choice >= spells.size())
            return;

        Spell spell = spells.get(choice);

        if (hero.getMana() < spell.getManaCost()) {
            System.out.println("Not enough mana to cast spell.");
            return;
        }

        Monster monster = chooseMonster();
        if (monster == null)
            return;

        double dexterity = hero.getDexterity();

        double baseDamage = spell.getDamage()
                + (dexterity / 10000.0) * spell.getDamage();

        hero.spendMana(spell.getManaCost());

        if (monsterDodges(monster)) {
            System.out.println(hero.getName() + " cast " + spell.getName() + " on "
                    + monster.getName() + " but they dodged.");
            return;
        }

        double damageAfterDefense = Math.max(0, baseDamage - monster.getDefense());
        int finalDamage = (int) Math.round(damageAfterDefense);

        monster.takeDamage(finalDamage);

        System.out.println(hero.getName() + " cast " + spell.getName() + " on "
                + monster.getName() + " for " + finalDamage + " damage");

        applySpellEffect(spell, monster);

        if (monster.isDead())
            System.out.println(monster.getName() + " has been killed.");

        hero.getInventory().removeSpell(spell);
    }

    /*Hero uses a potion on themselves
    * hero: hero that uses potion*/
    private void heroUsePotion(Hero hero) {
        List<Potion> potions = hero.getInventory().getPotions();
        if (potions.isEmpty()) {
            System.out.println(hero.getName() + " has no potions.");
            return;
        }

        System.out.println("\nPotions:");
        for (int i = 0; i < potions.size(); i++) {
            Potion potion = potions.get(i);
            System.out.println((i + 1) + ") " + potion.getName()
                + " | Amount: " + potion.getEffectAmount()
                + " | Effect: " + potion.getAffectedStats() );
        }
        System.out.println("Choose potion number or 0 to cancel.");

        int choice = IntHelpers.getInt(scanner) - 1;
        if (choice < 0 || choice >= potions.size())
            return;

        Potion potion = potions.get(choice);
        hero.applyPotion(potion);
        hero.getInventory().removePotion(potion);

        System.out.println(hero.getName() + " used potion " + potion.getName());
    }

    /*Hero changes equipment (weapon or armor)
    * hero: hero that changes equipment*/
    private void heroChangeEquipment(Hero hero) {
        System.out.println("\nChange equipment for " + hero.getName() + ":");
        System.out.println("1) Equip weapon");
        System.out.println("2) Equip armor");
        System.out.println("3) Back");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                List<Weapon> weapons = hero.getInventory().getWeapons();
                if (weapons.isEmpty()) {
                    System.out.println("No weapons in inventory.");
                    return;
                }
                System.out.println("\nWeapons:");
                for (int i = 0; i < weapons.size(); i++) {
                    Weapon w = weapons.get(i);
                    System.out.println((i + 1) + ") " + w.getName()
                            + " | Damage: " + w.getDamage());
                }
                System.out.println("Choose weapon number or 0 to cancel:");
                System.out.print("> ");
                int idx = IntHelpers.getInt(scanner) - 1;
                if (idx >= 0 && idx < weapons.size()) {
                    hero.equipWeapon(weapons.get(idx));
                    System.out.println(hero.getName()
                            + " equipped " + weapons.get(idx).getName() + ".");
                }
                break;
            case "2":
                List<Armor> armors = hero.getInventory().getArmors();
                if (armors.isEmpty()) {
                    System.out.println("No armor in inventory.");
                    return;
                }
                System.out.println("\nArmor:");
                for (int i = 0; i < armors.size(); i++) {
                    Armor a = armors.get(i);
                    System.out.println((i + 1) + ") " + a.getName()
                            + " | Damage reduction: " + a.getDamageReduction());
                }
                System.out.println("Choose armor number or 0 to cancel:");
                System.out.print("> ");
                idx = IntHelpers.getInt(scanner) - 1;
                if (idx >= 0 && idx < armors.size()) {
                    hero.equipArmor(armors.get(idx));
                    System.out.println(hero.getName()
                            + " equipped " + armors.get(idx).getName() + ".");
                }
                break;
            case "3":
                // back
                break;
            default: System.out.println("Invalid choice."); break;
        }
    }

    /*Choose a monster for the hero to fight
    * returns: monster for hero to fight*/
    private Monster chooseMonster() {
        List<Monster> livingMonsters = new ArrayList<>();
        for (Monster monster : monsters)
            if (!monster.isDead())
                livingMonsters.add(monster);

        if (livingMonsters.isEmpty())
            return null;

        System.out.println("\nChoose a target:");
        for (int i = 0; i < livingMonsters.size(); i++) {
            Monster monster = livingMonsters.get(i);
            System.out.println((i + 1) + ") " + monster.getName() +
                    " | HP: " + monster.getHp());
        }

        int choice = IntHelpers.getInt(scanner) - 1;
        if (choice < 0 || choice >= livingMonsters.size())
            return null;

        return livingMonsters.get(choice);
    }

    /*Handle the monsters' turn*/
    private void monstersTurn() {
        System.out.println("\n--- Monsters' Turn ---");

        for (Monster monster : monsters) {
            if (monster.isDead())
                continue;

            Hero hero = chooseHero();
            if (hero == null)
                return;

            if (heroDodges(hero)) {
                System.out.println(monster.getName() + " attacked " + hero.getName() +
                        " but they dodged.");
                continue;
            }

            double baseDamage = monster.getDamage() * 0.05 + monster.getLevel() * 0.1;

            Armor armor = hero.getEquippedArmor();
            double armorReduction = (armor != null) ? armor.getDamageReduction() : 0;

            double damageAfterDefense = Math.max(
                    0,
                    baseDamage - armorReduction
            );

            int finalDamage = (int) Math.round(damageAfterDefense);

            hero.takeDamage(finalDamage);

            System.out.println(monster.getName() + " attacked " + hero.getName() +
                    " for " + finalDamage + " damage.");

            if (hero.isDead())
                System.out.println(hero.getName() + " is dead.");
        }
    }

    private Hero chooseHero() {
        List<Hero> livingHeroes = new ArrayList<>();
        for (Hero h: party.getHeroes())
            if (!h.isDead())
                livingHeroes.add(h);

        if (livingHeroes.isEmpty())
            return null;
        return livingHeroes.get(random.nextInt(livingHeroes.size()));
    }
    /*Does the monster dodge?
    * monster: monster that may or may not dodge
    * returns: true if monster dodges and false otherwise*/
    private boolean monsterDodges(Monster monster) {
        double chance = monster.getDodgeChance() / 10000.0;
        return random.nextDouble() < chance;
    }

    /*Does the hero dodge?
    * hero: hero that may or may not dodge
    * returns: true if hero dodges and false otherwise*/
    private boolean heroDodges(Hero hero) {
        double chance = hero.getAgility() / 10000.0;
        return random.nextDouble() < chance;
    }

    /*Apply spell effect: reduce some monster stat by 10%
    * spell: spell to use
    * monster: monster to apply effect to*/
    private void applySpellEffect(Spell spell, Monster monster) {
        switch (spell.getSpellType()) {
            case FIRE:
                monster.reduceDefenseByPercent(0.1);
                System.out.println(monster.getName() + "'s defense was reduced!");
                break;
            case ICE:
                monster.reduceDamageByPercent(0.1);
                System.out.println(monster.getName() + "'s damage was reduced!");
                break;
            case LIGHTNING:
                monster.reduceDodgeChanceByPercent(0.1);
                System.out.println(monster.getName() + "'s dodge chance was reduced!");
                break;
        }
    }

    /*At the end of each round, living heroes regenerate some HP and mana*/
    private void endOfRoundRegen() {
        for (Hero hero : party.getHeroes()) {
            if (!hero.isDead()) {
                //simple regen: 10% of current hp and mana
                int hpRegen = Math.max(1, hero.getHp() / 10);
                int manaRegen = Math.max(1, hero.getMana() / 10);
                hero.increaseHp(hpRegen);
                hero.increaseMana(manaRegen);
            }
        }
    }

    /*Are all the monsters defeated?
    * returns: true if all monsters are defeated and false otherwise*/
    private boolean allMonstersDefeated() {
        for (Monster monster : monsters)
            if (!monster.isDead())
                return false;
        return true;
    }

    /*Are all the heroes defeated?
    * returns: true if heroes are defeated and false otherwise*/
    private boolean allHeroesDefeated() {
        for (Hero hero : party.getHeroes())
            if (!hero.isDead())
                return false;
        return true;
    }

    /*Handle hero victory by reviving dead heroes and
    * increasing gold and experience*/
    private void handleVictory() {
        int numMonsters = monsters.size();
        int totalMonsterLevel = 0;
        for (Monster monster : monsters)
            totalMonsterLevel += monster.getLevel();
        int averageMonsterLevel =  totalMonsterLevel / numMonsters;

        for (Hero h: party.getHeroes()) {
            if (h.isDead()) {
                h.reviveAtHalf();
                System.out.println(h.getName()
                        + " has been revived at half HP and mana (no rewards).");
                continue;
            }

            int goldGain = numMonsters * averageMonsterLevel * 10;
            int expGain = numMonsters * averageMonsterLevel * 2;

            h.increaseGold(goldGain);
            h.gainExperience(expGain);

            System.out.println(h.getName() + " gained "
                + goldGain + " gold and " + expGain + " experience.");
        }
    }

    /*Print statuses of heroes and monsters*/
    private void printStatus() {
        System.out.println("\n=== HEROES ===");
        for (Hero h : party.getHeroes()) {
            System.out.println(h.getName()
                    + " | HP: " + h.getHp()
                    + " | MP: " + h.getMana()
                    + " | STR: " + h.getStrength()
                    + " | DEX: " + h.getDexterity()
                    + " | AGI: " + h.getAgility()
                    + " | Gold: " + h.getGold()
                    + " | Dead: " + h.isDead());
        }

        System.out.println("=== MONSTERS ===");
        for (Monster monster : monsters) {
            System.out.println(monster.getName() +
                    " | lvl: " + monster.getLevel() +
                    " | HP: " + monster.getHp() +
                    " | Damage: " + monster.getDamage() +
                    " | Defense: " + monster.getDefense() +
                    " | Dodge: " + monster.getDodgeChance());
        }
        System.out.println();
    }
}
