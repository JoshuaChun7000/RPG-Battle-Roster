public class Jester extends Combatant implements Specialist {
    private int luck;
    public Jester(String name, int hp, int maxHp, int luck, int lvl, boolean buffed, boolean down, boolean stunned) {
        super(name, hp, lvl, maxHp, buffed, down, stunned);
        this.luck = luck;
    }
    public double getLuck() {
        return luck;
    }
    public void rollLuck() {
        int min = 0;
        int max = 100;
        luck = (int) (Math.random() * (max - min + 1)) + min;
    }
    @Override public String attack(Combatant target){
        if (!getDown()) {
            if (getStunned()) {
                int attackDamage = getLvl() * 2;
                if (getBuffed()) {
                    target.setHp(-attackDamage);
                    target.setStunned(false);
                    return getName() + " weakly tackles " + target.getName() + "! -" +
                            attackDamage + " health!\n"
                            + target.getName() + "'s current health: " + target.getHp();
                } else {
                    attackDamage *= 2;
                    setBuffed(false);
                    return getName() + " tackles " + target.getName() + "! -" +
                            attackDamage + " health!\n"
                            + target.getName() + "'s current health: " + target.getHp();
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
        }
    }
    @Override public String toString() {
        return "Name: " + getName() +
                "\nHP: " + getHp() +
                "\nlvl: " + getLvl();
    }
    @Override public String useSpecialMove1(Combatant target) {
        if (!getDown()) {
            if (getStunned()) {
                rollLuck();
                if (getLuck() <= 5) {
                    int attackDamage = getLvl() * 50;
                    target.setHp(-attackDamage);
                    target.setStunned(false);
                    return getName() + " shoots " + target.getName() +
                            " with their Deagle! -" +
                            attackDamage + " health!\n"
                            + target.getName() + "'s current health: " + target.getHp();
                } else if (getLuck() <= 20 && getLuck() > 5) {
                    int attackDamage = getLvl() * 15;
                    target.setHp(-attackDamage);
                    target.setStunned(false);
                    return getName() + " swings a massive katana at " + target.getName() +
                            "! -" + attackDamage + " health!\n"
                            + target.getName() + "'s current health: " + target.getHp();
                } else if (getLuck() <= 50 && getLuck() > 20) {
                    int attackDamage = getLvl() * 10;
                    target.setHp(-attackDamage);
                    target.setStunned(false);
                    return getName() + " throws playing cards at " + target.getName() +
                            "! -" + attackDamage + " health!\n"
                            + target.getName() + "'s current health: " + target.getHp();
                } else {
                    return getName() + " picks their nose!";
                }
            } else {
                return getName() + " is stunned!";
            }
        } else {
            return getName() + " is downed!";
        }
    }
    @Override public String useSpecialMove2 (Combatant target) {
        if (!getDown()) {
            if (getStunned()) {
                if (getLvl() >= 10) {
                    rollLuck();
                    if (getLuck() <= 50) {
                        target.setStunned(true);
                        return getName() + " dances like an idiot and makes " + target.getName() + " laugh, stunning them";
                    } else {
                        setStunned(true);
                        return getName() + " makes a horrible political joke! Nobody laughs, so " + getName() + " bursts into tears";
                    }
                } else {
                    return getName() + " is too inexperienced for that move!";
                }
            } else {
                return getName() + " is stunned!";
            }
        } else {
            return getName() + " is downed!";
        }
    }
    @Override public String useSpecialMove3(Combatant target) {
        if (!getDown()) {
            if (getStunned()) {
                if (getLvl() >= 20) {
                    rollLuck();
                    if (getLuck() <= 50) {
                        target.setHp(-target.getHp());
                        return getName() + " sneezes so hard that it kills " + target.getName() + "\n" +
                                target.getName() + "'s current health: " + target.getHp();
                    } else {
                        setDown(true);
                        return getName() + " experiences a heart attack and collapses";
                    }
                } else {
                    return getName() + " is too inexperienced for that move!";
                }
            } else {
                return getName() + " is stunned!";
            }
        } else {
            return getName() + " is downed!";
        }
    }
}
