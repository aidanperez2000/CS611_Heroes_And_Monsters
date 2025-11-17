package characters;

import java.util.ArrayList;
import java.util.List;

/*Class for managing hero party/
public class Party {
    public static final int MAX_PARTY_SIZE = 3;

    private final List<Hero> heroes;

    public Party() {
        heroes = new ArrayList<>();
    }

    public boolean addHero(Hero hero) {
        if (heroes.size() >= MAX_PARTY_SIZE) {
            System.out.println("Party is full");
            return false;
        }
        heroes.add(hero);
        return true;
    }

    public Hero getHero(int heroId) {
        return heroes.get(heroId);
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public int getHeroCount() {
        return heroes.size();
    }

    public void showParty() {
        System.out.println("Party:");
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println((i + 1) + ". " + heroes.get(i).getName() + " HP: " + heroes.get(i).getHp()
                + " Level: " + heroes.get(i).getLevel() + " Mana: " + heroes.get(i).getMana());
        }
    }
}
