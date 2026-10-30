public class basicCombatant extends Combatant {
    public basicCombatant(String name, int hp, int lvl, int maxHp, boolean buffed, boolean down, boolean stunned) {
        super(name, hp, lvl, maxHp, buffed, down, stunned);
    }
    @Override public String attack(Combatant target){
        if (!getDown()) {
            if (getStunned()) {
                int attackDamage = getLvl() * 5;
                if (getBuffed()) {
                    target.setHp(-attackDamage);
                    target.setStunned(false);
                    return getName() +
                            " attacks " + target.getName() + "\n" +
                            target.getName() + "'s current health: " + target.getHp();
                } else {
                    attackDamage *= 2;
                    target.setHp(-attackDamage);
                    return getName() +
                            " lunges at " + target.getName() + "\n" +
                            target.getName() + "'s current health: " + target.getHp();
                }
            } else {
                return getName() + " is stunned!";
            }
        } else {
            return getName() + " is downed!";
        }
    }
    @Override public String levelUp() {
        if (getLvl() < 30) {
            setLvl(1);
            setMaxHp(35);
            altSetHp(getMaxHp());
            if (getDown()) {
                setDown(false);
                return getName() + " levels up!\n" +
                        "Current level: " + getLvl() +
                        "\n+35 max health\n" +
                        "Healed to full\n" +
                        "Revived";
            } else {
                return getName() + " levels up!\n" +
                        "Current level: " + getLvl() +
                        "\n+35 max health\n" +
                        "Healed to full";
            }
        } else {
            return getName() + " has already reached the maximum level (Level 30)";
        }    }
    @Override public String toString() {
        return "Name: " + getName() +
                "\nHP: " + getHp() +
                "\nlvl: " + getLvl();
    }
}
