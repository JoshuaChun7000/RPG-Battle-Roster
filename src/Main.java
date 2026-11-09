import java.io.FileWriter;
import java.util.ArrayList;

public static class Main {
    private static void useAllSpecialAbilities(ArrayList<Combatant> party, Mage mage, Knight knight, Rogue rogue, Healer healer, Jester jester, ArrayList<Specialist> coolPeople, basicCombatant enemy) {
        regenAll(mage, knight, rogue, healer, jester);
        Debugging.everyoneUseSpecialAbility1(coolPeople, enemy);
        Debugging.doTheThing(1);
        regenAll(mage, knight, rogue, healer, jester);
        Debugging.everyoneUseSpecialAbility2(coolPeople, enemy);
        Debugging.doTheThing(1);
        regenAll(mage, knight, rogue, healer, jester);
        Debugging.everyoneUseSpecialAbility3(coolPeople, enemy);
        Debugging.doTheThing(1);
        for (int i = 1; i < 10; i++) {
            Debugging.everyoneLevelUpSecretly(party, enemy);
        }
        Debugging.showEveryoneStats(party, enemy);
    }

    private static void regenAll(Mage mage, Knight knight, Rogue rogue, Healer healer, Jester jester) {
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
        jester.rollLuck();
    }
}

void main() throws IOException {
    Scanner fileScanner = new Scanner(new File("save.txt"));
    ArrayList<Combatant> party = new ArrayList<>();
    ArrayList<Specialist> coolPeople = new ArrayList<>();
    basicCombatant enemy = new basicCombatant("Test Dummy",
            100, 1, 100, false, false,
            false, "Basic");
    Mage mage = null;
    Knight knight = null;
    Rogue rogue = null;
    Healer healer = null;
    Jester jester = null;
    while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        String[] parts = line.split(",");
        System.out.println("LINE: " + line);
        System.out.println("PARTS: " + parts.length);
        System.out.println("TYPE: " + parts[7]);
        String name = parts[0];
        int hp = Integer.parseInt(parts[1]);
        int lvl = Integer.parseInt(parts[2]);
        int maxHp = Integer.parseInt(parts[3]);
        boolean buffed = Boolean.parseBoolean(parts[4]);
        boolean down = Boolean.parseBoolean(parts[5]);
        boolean stunned = Boolean.parseBoolean(parts[6]);
        String type = parts[7];
        if (type.equalsIgnoreCase("mage")) {
            if (parts.length < 11) {
                System.out.println("ERROR: Invalid Mage CSV: " + line);
                continue;
            }
            int mana = Integer.parseInt(parts[8]);
            int maxMana = Integer.parseInt(parts[9]);
            int manaRegen = Integer.parseInt(parts[10]);
            mage = new Mage(name, hp, maxHp, mana, lvl, maxMana, manaRegen,
                    buffed, down, stunned, type);
            party.add(mage);
            coolPeople.add(mage);
        }
        if (type.equalsIgnoreCase("knight")) {
            if (parts.length < 11) {
                System.out.println("ERROR: Invalid Knight CSV: " + line);
                continue;
            }
            int stamina = Integer.parseInt(parts[8]);
            int maxStamina = Integer.parseInt(parts[9]);
            int staminaRegen = Integer.parseInt(parts[10]);
            knight = new Knight(name, hp, maxHp, lvl, stamina, maxStamina,
                    staminaRegen, buffed, down, stunned, type);
            party.add(knight);
            coolPeople.add(knight);
        }
        if (type.equalsIgnoreCase("rogue")) {
            if (parts.length < 10) {
                System.out.println("ERROR: Invalid Rogue CSV: " + line);
                continue;
            }
            int stealth = Integer.parseInt(parts[8]);
            int stealthRegen = Integer.parseInt(parts[9]);
            rogue = new Rogue(name, hp, lvl, maxHp, stealth, stealthRegen, buffed,
                    down, stunned, type);
            party.add(rogue);
            coolPeople.add(rogue);
        }
        if (type.equalsIgnoreCase("healer")) {
            if (parts.length < 10) {
                System.out.println("ERROR: Invalid Mage CSV: " + line);
                continue;
            }
            int healing = Integer.parseInt(parts[8]);
            int maxHealing = Integer.parseInt(parts[9]);
            healer = new Healer(name, hp, maxHp, healing, lvl, maxHealing, buffed,
                    down, stunned, type);
            party.add(healer);
            coolPeople.add(healer);
        }
        if (type.equalsIgnoreCase("jester")) {
            if (parts.length < 9) {
                System.out.println("ERROR: Invalid Mage CSV: " + line);
                continue;
            }
            int luck = Integer.parseInt(parts[8]);
            jester = new Jester(name, hp, maxHp, luck, lvl, buffed,
                    down, stunned, type);
            party.add(jester);
            coolPeople.add(jester);
        }
        if (type.equalsIgnoreCase("basic")) {
            enemy = new basicCombatant(name, hp, maxHp, lvl, buffed,
                    down, stunned, type);
        }
    }
    fileScanner.close();
    for (Combatant c : party) {
        if (c instanceof Specialist) {
            coolPeople.add((Specialist) c);
        }
    }
    Debugging.everyoneAttackEnemy(party, enemy);
    Debugging.doTheThing(1);
    Debugging.enemyAttackEveryone(party, enemy);
    Debugging.doTheThing(1);
    Debugging.everyoneLevelUp(party, enemy);
    Debugging.doTheThing(1);
    Debugging.killEveryone(party, enemy);
    Debugging.rezEveryone(party, enemy);
    Debugging.everyoneLevelUp(party, enemy);
    Debugging.buffEveryone(party, enemy);
    Debugging.everyoneAttackEnemy(party, enemy);
    Debugging.doTheThing(1);
    Debugging.enemyAttackEveryone(party, enemy);
    Debugging.doTheThing(1);
    Debugging.doTheThing(2);
    Debugging.showEveryoneStats(party, enemy);
    Main.useAllSpecialAbilities(party, mage, knight, rogue, healer, jester, coolPeople, enemy);
    Debugging.doTheThing(2);
    Main.useAllSpecialAbilities(party, mage, knight, rogue, healer, jester, coolPeople, enemy);
    Debugging.doTheThing(2);
    Main.useAllSpecialAbilities(party, mage, knight, rogue, healer, jester, coolPeople, enemy);
    Debugging.doTheThing(2);
    System.out.println(System.getProperty("user.dir"));
    Debugging.everyoneLevelUp(party, enemy);
    FileWriter writer = new FileWriter("save.txt");
    for (Combatant c : party) {writer.write(c.toCsv() + "\n");}
    writer.close();

}
