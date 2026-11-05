import java.io.FileWriter;
import java.util.ArrayList;

public static class Main {
    private static void useAllSpecialAbilities(ArrayList<Combatant> party, Mage mage, Knight knight, Rogue rogue, Healer healer, ArrayList<Specialist> coolPeople, basicCombatant enemy) {
        regenAll(mage, knight, rogue, healer);
        Debugging.everyoneUseSpecialAbility1(coolPeople, enemy);
        Debugging.doTheThing(1);
        regenAll(mage, knight, rogue, healer);
        Debugging.everyoneUseSpecialAbility2(coolPeople, enemy);
        Debugging.doTheThing(1);
        regenAll(mage, knight, rogue, healer);
        Debugging.everyoneUseSpecialAbility3(coolPeople, enemy);
        Debugging.doTheThing(1);
        for (int i = 1; i < 10; i++) {
            Debugging.everyoneLevelUpSecretly(party, enemy);
        }
        Debugging.showEveryoneStats(party, enemy);
    }

    private static void regenAll(Mage mage, Knight knight, Rogue rogue, Healer healer) {
        Debugging.doTheThing(1);
        while (!(mage.getMana() == mage.getMaxMana())) {
            mage.regenerateMana();
        }
        while (!(knight.getStamina() == knight.getMaxStamina())) {
            knight.regenerateStamina();
        }
        while (!(rogue.getStealth() == rogue.getMaxStealth())) {
            rogue.regenerateStealth();
        }
        while (!(healer.getHealing() == healer.getMaxHealing())) {
            healer.regenerateHealing();
        }
    }
}

void main() throws IOException {
    FileWriter writer = new FileWriter("save.txt");
    Scanner fileScanner = new Scanner(new File("save.txt"));
    ArrayList<Combatant> party = new ArrayList<>();
    ArrayList<Specialist> coolPeople = new ArrayList<>();
    while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        String[] parts = line.split(",");
        String name = parts[0];
        int hp = Integer.parseInt(parts[1]);
        int lvl = Integer.parseInt(parts[2]);
        int maxHp = Integer.parseInt(parts[3]);
        boolean buffed = Boolean.parseBoolean(parts[4]);
        boolean down = Boolean.parseBoolean(parts[5]);
        boolean stunned = Boolean.parseBoolean(parts[6]);
        String type = parts[7];
        if (type.equalsIgnoreCase("mage")) {
            int mana = Integer.parseInt(parts[8]);
            int maxMana = Integer.parseInt(parts[9]);
            int manaRegen = Integer.parseInt(parts[10]);
            Mage saveMage = new Mage(name, hp, maxHp, mana, lvl, maxMana, manaRegen,
                    buffed, down, stunned, type);
            party.add(saveMage);
            coolPeople.add(saveMage);
        }
        if (type.equalsIgnoreCase("knight")) {
            int stamina = Integer.parseInt(parts[8]);
            int maxStamina = Integer.parseInt(parts[9]);
            int staminaRegen = Integer.parseInt(parts[10]);
            Knight saveKnight = new Knight(name, hp, maxHp, lvl, stamina, maxStamina,
                    staminaRegen, buffed, down, stunned, type);
            party.add(saveKnight);
            coolPeople.add(saveKnight);
        }
        if (type.equalsIgnoreCase("rogue")) {
            int stealth = Integer.parseInt(parts[8]);
            int stealthRegen = Integer.parseInt(parts[9]);
            Rogue saveRogue = new Rogue(name, hp, lvl, maxHp, stealth, stealthRegen, buffed,
                    down, stunned, type);
            party.add(saveRogue);
            coolPeople.add(saveRogue);
        }
        if (type.equalsIgnoreCase("healer")) {
            int healing = Integer.parseInt(parts[8]);
            int maxHealing = Integer.parseInt(parts[9]);
            Healer saveHealer = new Healer(name, hp, maxHp, healing, lvl, maxHealing, buffed,
                    down, stunned, type);
            party.add(saveHealer);
            coolPeople.add(saveHealer);
        }
        if (type.equalsIgnoreCase("jester")) {
            int luck = Integer.parseInt(parts[8]);
            Jester saveJester = new Jester(name, hp, maxHp, luck, lvl, buffed,
                    down, stunned, type);
            party.add(saveJester);
            coolPeople.add(saveJester);
        }
        if (type.equalsIgnoreCase("basic")) {
            basicCombatant saveEnemy = new basicCombatant(name, hp, maxHp, lvl, buffed,
                    down, stunned, type);
        }
    }
    fileScanner.close();
    Mage mage = new Mage("Domingo", 100, 100, 100, 1,
            100, 20, false, false,
            false, "Mage");
    party.add(mage);
    Knight knight = new Knight("Ollie", 100, 100, 3, 3, 3,
            1, false, false, false,
            "Knight");
    party.add(knight);
    Rogue rogue = new Rogue("William", 100, 1, 100, 0,
            20, false, false, false,
            "Rogue");
    party.add(rogue);
    Healer healer = new Healer("Bodhi", 100, 100, 1, 1,
            1, false, false, false, "Healer");
    party.add(healer);
    Jester jester = new Jester("Graham", 100, 100, 1, 1,
            false, false, false, "Jester");
    party.add(jester);
    for (Combatant c : party) {
        coolPeople.add((Specialist) c);
    }
    basicCombatant enemy = new basicCombatant("Test Dummy",
            100, 1, 100, false, false,
            false, "Basic");
    Debugging.everyoneAttackEnemy(party, enemy);
    Debugging.doTheThing(1);
    Debugging.enemyAttackEveryone(party, enemy);
    Debugging.doTheThing(1);
    Debugging.everyoneLevelUp(party, enemy);
    Debugging.doTheThing(1);
    Debugging.killEveryone(party, enemy);
    Debugging.everyoneLevelUp(party, enemy);
    Debugging.buffEveryone(party, enemy);
    Debugging.everyoneAttackEnemy(party, enemy);
    Debugging.doTheThing(1);
    Debugging.enemyAttackEveryone(party, enemy);
    Debugging.doTheThing(1);
    Debugging.doTheThing(2);
    Debugging.showEveryoneStats(party, enemy);
    Main.useAllSpecialAbilities(party, mage, knight, rogue, healer, coolPeople, enemy);
    Debugging.doTheThing(2);
    Main.useAllSpecialAbilities(party, mage, knight, rogue, healer, coolPeople, enemy);
    Debugging.doTheThing(2);
    Main.useAllSpecialAbilities(party, mage, knight, rogue, healer, coolPeople, enemy);
    Debugging.doTheThing(2);
    System.out.println(System.getProperty("user.dir"));
    Debugging.everyoneLevelUp(party, enemy);
    for (Combatant c : party) {writer.write(c.toCsv() + "\n");}
    writer.close();

}
