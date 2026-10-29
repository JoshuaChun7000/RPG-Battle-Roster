void main (){
    ArrayList<Combatant> party = new ArrayList<>();
    party.add(new Mage("Mage", 100, 100, 100, 1,
            100, 20, false, false));
    party.add(new Knight("Knight", 100, 100, 3, 1, 3,
            3, 3, 1, 1, false, false));
    party.add(new Rogue("Rogue", 100, 1, 100, 0,
            20, false, false));
    party.add(new Healer("Healer", 100, 100, 1, 1,
            1, false, false));
    party.add(new Jester("Jester", 100, 100, 1, 1,
            false, false));
    basicCombatant enemy = new basicCombatant("Test Dummy", 100, 1);
    while (enemy.getHp() > 0) {
        for (Combatant c : party) {
            System.out.println(c.attack(enemy));
            System.out.println("------------------");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (enemy.getHp() <= 0) {
                break;
            }
        }
    }
}