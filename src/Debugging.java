import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Debugging {
    public static void doTheThing(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static void killEveryone(ArrayList<Combatant> party, Combatant enemy) {
        for (Combatant c : party) {
            c.setDown(true);
        }
        enemy.setDown(true);
    }
    public static void buffEveryone(ArrayList<Combatant> party, Combatant enemy) {
        for (Combatant c : party) {
            c.setBuffed(true);
        }
        enemy.setBuffed(true);
    }
    public static void everyoneLevelUp(ArrayList<Combatant> party, Combatant enemy) {
        for (Combatant c : party) {
            System.out.println(c.levelUp());
            System.out.println("================");
        }
        System.out.println(enemy.levelUp());
        System.out.println("===============");
    }
    public static void everyoneAttackEnemy(ArrayList<Combatant> party, Combatant enemy) {
        for (Combatant c : party) {
            System.out.println(c.attack(enemy));
            System.out.println("===============");
        }
    }
    public static void enemyAttackEveryone(ArrayList<Combatant> party, Combatant enemy) {
        for (Combatant c : party) {
            System.out.println(enemy.attack(c));
            System.out.println("===============");
        }
    }
    public static void showEveryoneStats(ArrayList<Combatant> party, Combatant enemy) {
        for (Combatant c : party) {
            System.out.println(c);
            System.out.println("===============");
        }
        System.out.println(enemy);
        System.out.println("===============");
    }
    public static void everyoneLevelUpSecretly(ArrayList<Combatant> party, Combatant enemy) {
        for (Combatant c : party) {
            c.levelUp();
        }
        enemy.levelUp();
    }
    public static void reviveEnemy(Combatant enemy) {
        enemy.setDown(false);
        enemy.altSetHp(enemy.getMaxHp());
    }
    public static void everyoneUseSpecialAbility1(ArrayList<Specialist> party, Combatant enemy) {
        for (Specialist c : party) {
            System.out.println(c.useSpecialMove1(enemy));
            System.out.println("===============");
            reviveEnemy(enemy);
        }
    }
    public static void everyoneUseSpecialAbility2(ArrayList<Specialist> party, Combatant enemy) {
        for (Specialist c : party) {
            System.out.println(c.useSpecialMove2(enemy));
            System.out.println("===============");
            reviveEnemy(enemy);
        }
    }
    public static void everyoneUseSpecialAbility3(ArrayList<Specialist> party, Combatant enemy) {
        for (Specialist c : party) {
            System.out.println(c.useSpecialMove3(enemy));
            System.out.println("===============");
            reviveEnemy(enemy);
        }
    }
}