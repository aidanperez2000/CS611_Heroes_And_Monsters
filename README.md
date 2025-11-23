# CS611
## Heroes and Monsters
---------------------------------------------------------------------------
- Name: Aidan Perez
- Email: aperez00@bu.edu
- Student ID: U83281909

## Files
---------------------------------------------------------------------------
- java
  - src
    - characters
      - Character.java: base character class, hero and monster class inherit from this
      - DragonBehavior.java: Class for determining behavior of dragon, implements MonsterBehaviorStrategy class
      - ExoskeletonBehavior.java: Class for determining behavior of exoskeleton, implements MonsterBehaviorStrategy class
      - Hero.java: class that contains all attributes and methods for a hero, inherits from character class
      - HeroClass.java: enum class that determines the type of the hero, includes WARRIOR, PALADIN, and SORCERER
      - LevelUpStrategy.java: base interface with methods that determine how different hero types level up
      - Monster.java: class that contains all attributes and methods for a monster, inherits from character class
      - MonsterBehaviorStrategy.java: base interface with methods that determine monster behavior strategy
      - MonsterFactory.java: Factory class which creates the monsters for a given battle
      - MonsterType.java: Enum class that contains the different monster types.  Includes DRAGON, EXOSKELETON, and SPIRIT
      - PaladinLevelUp.java: implements LevelUpStrategy for a Paladin
      - Party.java:  Class for managing heroes in party
      - SorcererLevelUp.java: Class that implements LevelUpStrategy for a Sorcerer
      - SpiritBehavior.java: Class that implements MonsterBehaviorStrategy for a Spirit
      - WarriorLevelUp.java: Class that implements LevelUpStrategy for a Warrior
    - data
      - ArmorLoader.java: load armor data from txt files and convert to a list of armors
      - DataLoader.java: base DataLoader interface which contains a method for loading data which all loader implement
      - FileParser.java: Helper class which parses the data from txt files
      - GameDatabase.java: Class that loads all data into a database 
      - HeroLoader.java: load hero data from txt files and convert to a list of heroes
      - MonsterLoader.java: load monster data from txt files and convert to a list of monsters
      - PotionLoader.java: load potion data from txt files and convert to a list of potions
      - SpellLoader.java: load spell data from txt files and convert to a list of spells
      - WeaponLoader.java: load weapon data from txt files and convert to a list of weapons
    - game
      - BattleEngine.java: class with all logic for battles
      - GameEngine.java: class with all logic for running games
      - MarketEngine.java: class with all logic for markets
    - helpers
      - IntHelpers.java: class with all helper functions for ints
    - items
      - Armor.java: class with all attributes and methods for armor, inherits from item class
      - Inventory.java: class that manages items in inventory
      - Item.java: base item class which all other item classes inherit from
      - Potion.java: class with all attributes and methods for potion, inherits from item class
      - Spell.java: class with all attributes and methods for spell, inherits from item class
      - SpellType.java: enum that contains different spell types, includes FIRE, ICE, and LIGHTNING
      - StatType.java: enum that contains different potion types, includes HEALTH, MANA, STRENGTH, DEXTERITY, AGILITY, and DEFENSE
      - Weapon.java: class with all attributes and methods for weapon, inherits from item class
    - world
      - CommonBehavior.java: class that determines how a common tile behaves, implements TileBehavior interface
      - InaccessibleBehavior.java: class that determines how an inaccessible tile behaves, implements TileBehavior interface
      - MarketBehavior.java: class that determines how a market tile behaves, implements TileBehavior interface
      - Tile.java: class that contains attributes and methods for a tile
      - TileBehavior.java: base interface with methods for determining tile behavior




## Notes
---------------------------------------------------------------------------
1. Use of strategy pattern for determining behavior for tiles, heroes, and monsters.
2. 20% chance hero gets in battle when they are in a common tile.
3. Load data from txt files and convert to class.  Txt files are used as database.  Factory pattern is used for this.
4. Random chance heroes and monsters dodge based on monster's dodge chance and hero's agility



## How to compile and run
---------------------------------------------------------------------------
### In IntelliJ:
1. Go to Main.java under CS611_Heroes_And_Monsters/java/src/
2. Click Play button.

### In terminal:
1. `cd CS611_Heroes_And_Monsters/java`
2. `javac -d out $(find src -name "*.java")`
3. `java -cp out:resources Main`

## Input/Output Example
---------------------------------------------------------------------------
```
Output:
Welcome to Monsters and Heroes!
How many heroes do you want to choose? (1-3)
Input:
3
Output:
1: Parzival
2: Sehanine_Moonbow
3: Skoraeus_Stonebones
4: Garl_Glittergold
5: Amaryllis_Astra
6: Caliber_Heist
7: Rillifane_Rallathil
8: Segojan_Earthcaller
9: Reign_Havoc
10: Reverie_Ashels
11: Kalabar
12: Skye_Soar
13: Gaerdal_Ironhand
14: Sehanine_Monnbow
15: Muamman_Duathall
16: Flandal_Steelskin
17: Undefeated_Yoj
18: Eunoia_Cyn
Choose hero #1:
Input:
3
Output:
Choose hero #2:
Input:
5
Output:
Choose hero #3:
Input:
12
Output:
Your adventure begins!
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . P . 
. M M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
a
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M P M . 
. M M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
a
Output:
You stepped onto a market tile! Press M if you want to enter the market.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X P . M . 
. M M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
m
Output:

=== MARKET ===
1) Buy
2) Sell
3) Hero Info
4) Exit Market
Input:
1
Output:
Choose hero:
1) Skoraeus_Stonebones
2) Amaryllis_Astra
3) Skye_Soar
Input:
1
Output:

What would you like to buy?
1) Weapons
2) Armor
3) Potions
4) Spells
5) Back
Input:
1
Output:
=== ITEMS FOR SALE ===
Item 1: Sword | Price: 500 | Required Level: 1
Item 2: Bow | Price: 300 | Required Level: 2
Item 3: Scythe | Price: 1000 | Required Level: 6
Item 4: Axe | Price: 550 | Required Level: 5
Item 5: TSwords | Price: 1400 | Required Level: 8
Item 6: Dagger | Price: 200 | Required Level: 1
Choose item number or 0 to cancel
Input:
1
Output:
=== ITEMS FOR SALE ===
Item 1: Sword | Price: 500 | Required Level: 1
Item 2: Bow | Price: 300 | Required Level: 2
Item 3: Scythe | Price: 1000 | Required Level: 6
Item 4: Axe | Price: 550 | Required Level: 5
Item 5: TSwords | Price: 1400 | Required Level: 8
Item 6: Dagger | Price: 200 | Required Level: 1
Choose item number or 0 to cancel
1
Skoraeus_Stonebones bought Sword for 500!

=== MARKET ===
1) Buy
2) Sell
3) Hero Info
4) Exit Market
Input:
1
Output:
Choose hero:
1) Skoraeus_Stonebones
2) Amaryllis_Astra
3) Skye_Soar
Input:
2
Output:

What would you like to buy?
1) Weapons
2) Armor
3) Potions
4) Spells
5) Back
Input:
4
Output:
Choose spell type:
1) Fire Spells
2) Ice Spells
3) Lightning Spells
Input:
1
Output:
=== ITEMS FOR SALE ===
Item 1: Flame_Tornado | Price: 700 | Required Level: 4
Item 2: Breath_of_Fire | Price: 350 | Required Level: 1
Item 3: Heat_Wave | Price: 450 | Required Level: 2
Item 4: Lava_Comet | Price: 800 | Required Level: 7
Item 5: Hell_Storm | Price: 600 | Required Level: 3
Choose item number or 0 to cancel
Input:
2
Output:
=== MARKET ===
1) Buy
2) Sell
3) Hero Info
4) Exit Market
Input: 
3
Output:
Party:
1. Skoraeus_Stonebones HP: 100 Level: 1 Mana: 250 Gold: 2000
2. Amaryllis_Astra HP: 100 Level: 1 Mana: 500 Gold: 2150
3. Skye_Soar HP: 100 Level: 1 Mana: 1000 Gold: 2500

=== MARKET ===
1) Buy
2) Sell
3) Hero Info
4) Exit Market
Input:
4
Output:
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X P . M . 
. M M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
d
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M P M . 
. M M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
s
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . M . 
. M M . X P M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
s
Output:
You stepped onto a market tile! Press M if you want to enter the market.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . M . 
. M M . X . M M 
M M . . X P M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
s
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . M . 
. M M . X . M M 
M M . . X M M M 
X . . . . P . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
a
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . M . 
. M M . X . M M 
M M . . X M M M 
X . . . P . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
a
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . M . 
. M M . X . M M 
M M . . X M M M 
X . . P . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
w
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . M . 
. M M . X . M M 
M M . P X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
w
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . M . 
. M M P X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
a
Output:
You stepped onto a market tile! Press M if you want to enter the market.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . M . 
. M P . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
w
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . P X M . M . 
. M M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
w
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X P X M X . . 
M . . X M . M . 
. M M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
w
Output:
You stepped onto a market tile! Press M if you want to enter the market.
. M X . . . . . 
. . . X M . X . 
X . P M . . X X 
. X . X M X . . 
M . . X M . M . 
. M M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
s
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X P X M X . . 
M . . X M . M . 
. M M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input: 
s
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . P X M . M . 
. M M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command: 
Input:
a
Output:
The area seems peaceful...for now.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M P . X M . M . 
. M M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input: 
s
Output:
You stepped onto a market tile! Press M if you want to enter the market.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . M . 
. P M . X . M M 
M M . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input: 
s
Output:
You stepped onto a market tile! Press M if you want to enter the market.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . M . 
. M M . X . M M 
M P . . X M M M 
X . . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input: 
s
Output:

A wild group of monsters appears!

=== BATTLE START ===

=== HEROES ===
Skoraeus_Stonebones | HP: 100 | MP: 250 | STR: 650 | DEX: 350 | AGI: 600 | Gold: 2000 | Dead: false
Amaryllis_Astra | HP: 100 | MP: 500 | STR: 500 | DEX: 500 | AGI: 500 | Gold: 2150 | Dead: false
Skye_Soar | HP: 100 | MP: 1000 | STR: 700 | DEX: 500 | AGI: 400 | Gold: 2500 | Dead: false
=== MONSTERS ===
Casper | lvl: 1 | HP: 100 | Damage: 100 | Defense: 100 | Dodge: 65
Blinky | lvl: 1 | HP: 100 | Damage: 450 | Defense: 350 | Dodge: 46
Natsunomeryu | lvl: 1 | HP: 100 | Damage: 132 | Defense: 200 | Dodge: 10

It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:
Choose a target:
1) Casper | HP: 100
2) Blinky | HP: 100
3) Natsunomeryu | HP: 100
Input:
1
Output:
Skoraeus_Stonebones attacked Casper for 23 damage
It's Amaryllis_Astra's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
2
Output:
Spells:
1) Breath_of_Fire | Damage: 450 | Mana cost: 100
Choose spell number or 0 to cancel.
Input:
1
Output:
Choose a target:
1) Casper | HP: 77
2) Blinky | HP: 100
3) Natsunomeryu | HP: 100
Input:
1
Output:
Amaryllis_Astra cast Breath_of_Fire on Casper for 373 damage
Casper's defense was reduced!
Casper has been killed.
It's Skye_Soar's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
3
Output:
Skye_Soar has no potions.
It's Skye_Soar's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
4
Output:

Change equipment for Skye_Soar:
1) Equip weapon
2) Equip armor
3) Back
Input:
1
Output:
No weapons in inventory.
It's Skye_Soar's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:
Choose a target:
1) Blinky | HP: 100
2) Natsunomeryu | HP: 100
Input:
1
Output:
Skye_Soar attacked Blinky for 0 damage

--- Monsters' Turn ---
Blinky attacked Skye_Soar for 23 damage.
Natsunomeryu attacked Skoraeus_Stonebones for 7 damage.

=== HEROES ===
Skoraeus_Stonebones | HP: 102 | MP: 275 | STR: 650 | DEX: 350 | AGI: 600 | Gold: 2000 | Dead: false
Amaryllis_Astra | HP: 110 | MP: 440 | STR: 500 | DEX: 500 | AGI: 500 | Gold: 2150 | Dead: false
Skye_Soar | HP: 84 | MP: 1100 | STR: 700 | DEX: 500 | AGI: 400 | Gold: 2500 | Dead: false
=== MONSTERS ===
Casper | lvl: 1 | HP: 0 | Damage: 100 | Defense: 90 | Dodge: 65
Blinky | lvl: 1 | HP: 100 | Damage: 450 | Defense: 350 | Dodge: 46
Natsunomeryu | lvl: 1 | HP: 100 | Damage: 132 | Defense: 200 | Dodge: 10

It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
2
Output:
Skoraeus_Stonebones has no spells.
It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:
Choose a target:
1) Blinky | HP: 100
2) Natsunomeryu | HP: 100
Input:
1
Output:
Skoraeus_Stonebones attacked Blinky for 0 damage
It's Amaryllis_Astra's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
5
Output:
=== HEROES ===
Skoraeus_Stonebones | HP: 102 | MP: 275 | STR: 650 | DEX: 350 | AGI: 600 | Gold: 2000 | Dead: false
Amaryllis_Astra | HP: 110 | MP: 440 | STR: 500 | DEX: 500 | AGI: 500 | Gold: 2150 | Dead: false
Skye_Soar | HP: 84 | MP: 1100 | STR: 700 | DEX: 500 | AGI: 400 | Gold: 2500 | Dead: false
=== MONSTERS ===
Casper | lvl: 1 | HP: 0 | Damage: 100 | Defense: 90 | Dodge: 65
Blinky | lvl: 1 | HP: 100 | Damage: 450 | Defense: 350 | Dodge: 46
Natsunomeryu | lvl: 1 | HP: 100 | Damage: 132 | Defense: 200 | Dodge: 10

It's Amaryllis_Astra's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
6
Output:
Amaryllis_Astra skips their turn.
It's Skye_Soar's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
2
Output:
Skye_Soar has no spells.
It's Skye_Soar's turn
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
4

Output:
Change equipment for Skye_Soar:
1) Equip weapon
2) Equip armor
3) Back
Input:
1
Output:
No weapons in inventory.
It's Skye_Soar's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1

Output:
Choose a target:
1) Blinky | HP: 100
2) Natsunomeryu | HP: 100
Input:
1
Output:
Skye_Soar attacked Blinky for 0 damage

--- Monsters' Turn ---
Blinky attacked Skoraeus_Stonebones for 23 damage.
Natsunomeryu attacked Skye_Soar for 7 damage.

=== HEROES ===
Skoraeus_Stonebones | HP: 86 | MP: 302 | STR: 650 | DEX: 350 | AGI: 600 | Gold: 2000 | Dead: false
Amaryllis_Astra | HP: 121 | MP: 484 | STR: 500 | DEX: 500 | AGI: 500 | Gold: 2150 | Dead: false
Skye_Soar | HP: 84 | MP: 1210 | STR: 700 | DEX: 500 | AGI: 400 | Gold: 2500 | Dead: false
=== MONSTERS ===
Casper | lvl: 1 | HP: 0 | Damage: 100 | Defense: 90 | Dodge: 65
Blinky | lvl: 1 | HP: 100 | Damage: 450 | Defense: 350 | Dodge: 46
Natsunomeryu | lvl: 1 | HP: 100 | Damage: 132 | Defense: 200 | Dodge: 10

It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
4

Output:
Change equipment for Skoraeus_Stonebones:
1) Equip weapon
2) Equip armor
3) Back
Input:
1
Output:

Weapons:
1) Sword | Damage: 800
Choose weapon number or 0 to cancel:
> 
Input:
1
Output:
Skoraeus_Stonebones equipped Sword.
It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:

Choose a target:
1) Blinky | HP: 100
2) Natsunomeryu | HP: 100
Input:
1
Output:
Skoraeus_Stonebones attacked Blinky for 38 damage
It's Amaryllis_Astra's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
4
Output:

Change equipment for Amaryllis_Astra:
1) Equip weapon
2) Equip armor
3) Back
Input:
1
Output:
No weapons in inventory.
It's Amaryllis_Astra's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:
Choose a target:
1) Blinky | HP: 62
2) Natsunomeryu | HP: 100
Input:
1
Output:
Amaryllis_Astra attacked Blinky for 0 damage
It's Skye_Soar's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1

Output:
Choose a target:
1) Blinky | HP: 62
2) Natsunomeryu | HP: 100
Input:
1
Output:
Skye_Soar attacked Blinky for 0 damage

--- Monsters' Turn ---
Blinky attacked Amaryllis_Astra for 23 damage.
Natsunomeryu attacked Skoraeus_Stonebones for 7 damage.

=== HEROES ===
Skoraeus_Stonebones | HP: 86 | MP: 332 | STR: 650 | DEX: 350 | AGI: 600 | Gold: 2000 | Dead: false
Amaryllis_Astra | HP: 107 | MP: 532 | STR: 500 | DEX: 500 | AGI: 500 | Gold: 2150 | Dead: false
Skye_Soar | HP: 92 | MP: 1331 | STR: 700 | DEX: 500 | AGI: 400 | Gold: 2500 | Dead: false
=== MONSTERS ===
Casper | lvl: 1 | HP: 0 | Damage: 100 | Defense: 90 | Dodge: 65
Blinky | lvl: 1 | HP: 62 | Damage: 450 | Defense: 350 | Dodge: 46
Natsunomeryu | lvl: 1 | HP: 100 | Damage: 132 | Defense: 200 | Dodge: 10

It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
4
Output:

Change equipment for Skoraeus_Stonebones:
1) Equip weapon
2) Equip armor
3) Back
Input:
1
Output:

Weapons:
1) Sword | Damage: 800
Choose weapon number or 0 to cancel:
>
Input: 
1
Output:
Skoraeus_Stonebones equipped Sword.
It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:

Choose a target:
1) Blinky | HP: 62
2) Natsunomeryu | HP: 100
Input:
1
Output:
Skoraeus_Stonebones attacked Blinky for 38 damage
It's Amaryllis_Astra's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:

Choose a target:
1) Blinky | HP: 24
2) Natsunomeryu | HP: 100
Input:
1
Output:
Amaryllis_Astra attacked Blinky for 0 damage
It's Skye_Soar's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:
Choose a target:
1) Blinky | HP: 24
2) Natsunomeryu | HP: 100
Input:
1
Output:
Skye_Soar attacked Blinky for 0 damage

--- Monsters' Turn ---
Blinky attacked Skoraeus_Stonebones for 23 damage.
Natsunomeryu attacked Skoraeus_Stonebones for 7 damage.

=== HEROES ===
Skoraeus_Stonebones | HP: 61 | MP: 365 | STR: 650 | DEX: 350 | AGI: 600 | Gold: 2000 | Dead: false
Amaryllis_Astra | HP: 117 | MP: 585 | STR: 500 | DEX: 500 | AGI: 500 | Gold: 2150 | Dead: false
Skye_Soar | HP: 101 | MP: 1464 | STR: 700 | DEX: 500 | AGI: 400 | Gold: 2500 | Dead: false
=== MONSTERS ===
Casper | lvl: 1 | HP: 0 | Damage: 100 | Defense: 90 | Dodge: 65
Blinky | lvl: 1 | HP: 24 | Damage: 450 | Defense: 350 | Dodge: 46
Natsunomeryu | lvl: 1 | HP: 100 | Damage: 132 | Defense: 200 | Dodge: 10

It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
4
Output:

Change equipment for Skoraeus_Stonebones:
1) Equip weapon
2) Equip armor
3) Back
Input:
1
Output:

Weapons:
1) Sword | Damage: 800
Choose weapon number or 0 to cancel:
> 
Input:
1
Output:
Skoraeus_Stonebones equipped Sword.
It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:

Choose a target:
1) Blinky | HP: 24
2) Natsunomeryu | HP: 100
Input:
1
Output:
Skoraeus_Stonebones attacked Blinky for 38 damage
Blinky has been killed.
It's Amaryllis_Astra's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:
Choose a target:

1) Natsunomeryu | HP: 100
Input:
1
Output:
Amaryllis_Astra attacked Natsunomeryu for 5 damage
It's Skye_Soar's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:

Choose a target:
1) Natsunomeryu | HP: 95
Input:
1
Output:
Skye_Soar attacked Natsunomeryu for 15 damage

--- Monsters' Turn ---
Natsunomeryu attacked Amaryllis_Astra for 7 damage.

=== HEROES ===
Skoraeus_Stonebones | HP: 67 | MP: 401 | STR: 650 | DEX: 350 | AGI: 600 | Gold: 2000 | Dead: false
Amaryllis_Astra | HP: 121 | MP: 643 | STR: 500 | DEX: 500 | AGI: 500 | Gold: 2150 | Dead: false
Skye_Soar | HP: 111 | MP: 1610 | STR: 700 | DEX: 500 | AGI: 400 | Gold: 2500 | Dead: false
=== MONSTERS ===
Casper | lvl: 1 | HP: 0 | Damage: 100 | Defense: 90 | Dodge: 65
Blinky | lvl: 1 | HP: 0 | Damage: 450 | Defense: 350 | Dodge: 46
Natsunomeryu | lvl: 1 | HP: 80 | Damage: 132 | Defense: 200 | Dodge: 10

It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:
Skye_Soar attacked Natsunomeryu for 15 damage

--- Monsters' Turn ---
Natsunomeryu attacked Amaryllis_Astra for 7 damage.

=== HEROES ===
Skoraeus_Stonebones | HP: 67 | MP: 401 | STR: 650 | DEX: 350 | AGI: 600 | Gold: 2000 | Dead: false
Amaryllis_Astra | HP: 121 | MP: 643 | STR: 500 | DEX: 500 | AGI: 500 | Gold: 2150 | Dead: false
Skye_Soar | HP: 111 | MP: 1610 | STR: 700 | DEX: 500 | AGI: 400 | Gold: 2500 | Dead: false
=== MONSTERS ===
Casper | lvl: 1 | HP: 0 | Damage: 100 | Defense: 90 | Dodge: 65
Blinky | lvl: 1 | HP: 0 | Damage: 450 | Defense: 350 | Dodge: 46
Natsunomeryu | lvl: 1 | HP: 80 | Damage: 132 | Defense: 200 | Dodge: 10

It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input: 
4
Output:

Change equipment for Skoraeus_Stonebones:
1) Equip weapon
2) Equip armor
3) Back
Input:
1

Weapons:
1) Sword | Damage: 800
Choose weapon number or 0 to cancel:
>
Input:
1
Output:
Skoraeus_Stonebones equipped Sword.
It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:

Choose a target:
1) Natsunomeryu | HP: 80
Input:
1
Output:
Skoraeus_Stonebones attacked Natsunomeryu for 53 damage
It's Amaryllis_Astra's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:

Choose a target:
1) Natsunomeryu | HP: 27
Input:
1
Output:
Amaryllis_Astra attacked Natsunomeryu for 5 damage
It's Skye_Soar's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:

Choose a target:
1) Natsunomeryu | HP: 22
Input:
1
Output:
Skye_Soar attacked Natsunomeryu for 15 damage

--- Monsters' Turn ---
Natsunomeryu attacked Skye_Soar for 7 damage.

=== HEROES ===
Skoraeus_Stonebones | HP: 73 | MP: 441 | STR: 650 | DEX: 350 | AGI: 600 | Gold: 2000 | Dead: false
Amaryllis_Astra | HP: 133 | MP: 707 | STR: 500 | DEX: 500 | AGI: 500 | Gold: 2150 | Dead: false
Skye_Soar | HP: 114 | MP: 1771 | STR: 700 | DEX: 500 | AGI: 400 | Gold: 2500 | Dead: false
=== MONSTERS ===
Casper | lvl: 1 | HP: 0 | Damage: 100 | Defense: 90 | Dodge: 65
Blinky | lvl: 1 | HP: 0 | Damage: 450 | Defense: 350 | Dodge: 46
Natsunomeryu | lvl: 1 | HP: 7 | Damage: 132 | Defense: 200 | Dodge: 10

It's Skoraeus_Stonebones's turn.
Choose action: 
1) Attack
2) Cast spell
3) Use potion
4) Change equipment
5) Info
6) Skip
Input:
1
Output:

Choose a target:
1) Natsunomeryu | HP: 7
Input:
1
Output:
Skoraeus_Stonebones attacked Natsunomeryu for 53 damage
Natsunomeryu has been killed.
All monsters have been defeated!
Skoraeus_Stonebones gained 30 gold and 6 experience.
Amaryllis_Astra gained 30 gold and 6 experience.
Skye_Soar gained 30 gold and 6 experience.
. M X . . . . . 
. . . X M . X . 
X . M M . . X X 
. X . X M X . . 
M . . X M . M . 
. M M . X . M M 
M M . . X M M M 
X P . . . . . . 

Controls:
W/A/S/D(w/a/s/d) - Move
M(m) - Market
I(i) - Info
Q(q) - Quit

Enter command:
Input:
q
Output:
Goodbye, hero!
```
