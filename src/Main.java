void main (){
    ArrayList<Combatant> party = new ArrayList<>();
    party.add(new Mage("Mage", 100, 100, 1, 100));
    party.add(new Knight("Knight", 100, 1, 1, 2, 2, 1));
    party.add(new Rogue("Rogue", 100, 10, 1));
    party.add(new Healer("Healer", 100, 100, 1));
    party.add(new Jester("Jester", 100, 100, 1));
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