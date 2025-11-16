package data;

import characters.Hero;
import characters.Monster;
import items.Armor;
import items.Potion;
import items.Spell;
import items.Weapon;

import java.io.IOException;
import java.util.List;

/*Class for building database for game*/
public class GameDatabase {
    public static List<Hero> warriors;
    public static List<Hero> paladins;
    public static List<Hero> sorcerers;

    public static List<Monster> dragons;
    public static List<Monster> exoskeletons;
    public static List<Monster> spirits;

    public static List<Weapon> weapons;
    public static List<Armor> armor;
    public static List<Potion> potions;
    public static List<Spell> fireSpells;
    public static List<Spell> iceSpells;
    public static List<Spell> lightningSpells;

    private static final String BASE = "Legends_Monsters_And_Heroes/";

    /*Load all data from files into database*/
    public static void LoadAll() {
        HeroLoader heroLoader = new HeroLoader();
        MonsterLoader monsterLoader = new MonsterLoader();
        WeaponLoader weaponLoader = new WeaponLoader();
        ArmorLoader armorLoader = new ArmorLoader();
        PotionLoader potionLoader = new PotionLoader();
        SpellLoader spellLoader = new SpellLoader();

        warriors = heroLoader.load(BASE + "Warriors.txt");
        paladins = heroLoader.load(BASE + "Paladins.txt");
        sorcerers = heroLoader.load(BASE +"Sorcerers.txt");

        dragons = monsterLoader.load(BASE + "Dragons.txt");
        exoskeletons = monsterLoader.load(BASE + "Exoskeletons.txt");
        spirits = monsterLoader.load(BASE + "Spirits.txt");

        weapons = weaponLoader.load(BASE + "Weaponry.txt");
        armor = armorLoader.load(BASE + "Armory.txt");
        potions = potionLoader.load(BASE + "Potions.txt");

        fireSpells = spellLoader.load(BASE + "FireSpells.txt");
        iceSpells = spellLoader.load(BASE + "IceSpells.txt");
        lightningSpells = spellLoader.load(BASE + "LightningSpells.txt");
    }
}
