import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Combatant> party = new ArrayList<>();
        Mage mage = new Mage("Domingo", 100, 100, 100, 1,
                100, 20, false, false, false);
        party.add(mage);
        Knight knight = new Knight("Ollie", 100, 100, 3, 3, 3,
                1, false, false, false);
        party.add(knight);
        Rogue rogue = new Rogue("William", 100, 1, 100, 0,
                20, false, false, false);
        party.add(rogue);
        Healer healer = new Healer("Bodhi", 100, 100, 1, 1,
                1, false, false, false);
        party.add(healer);
        Jester jester = new Jester("Graham", 100, 100, 1, 1,
                false, false, false);
        party.add(jester);
        ArrayList<Specialist> coolPeople = new ArrayList<>();
        for (Combatant c : party) {
            coolPeople.add((Specialist) c);
        }
        basicCombatant enemy = new basicCombatant("Test Dummy", 100, 1, 100, false, false, false);
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
        useAllSpecialAbilities(party, mage, knight, rogue, healer, coolPeople, enemy);
        Debugging.doTheThing(2);
        useAllSpecialAbilities(party, mage, knight, rogue, healer, coolPeople, enemy);
        Debugging.doTheThing(2);
        useAllSpecialAbilities(party, mage, knight, rogue, healer, coolPeople, enemy);
        Debugging.doTheThing(2);
        Debugging.everyoneLevelUp(party, enemy);
    }
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