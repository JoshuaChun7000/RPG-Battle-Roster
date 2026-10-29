public class Healer extends Combatant implements Specialist {
    private int healing;
    private int maxHealing;
    public Healer(String name, int hp, int maxHp, int healing, int lvl,
                  int maxHealing , boolean buffed, boolean down) {
        super(name, hp, lvl, maxHp, buffed, down);
        this.healing = healing;
        this.maxHealing = maxHealing;
    }
    public int getHealing() {
        return healing;
    }
    public void setHealing(int addHealing) {
        healing+=addHealing;
        if (healing < 0) {
            healing = 0;
        }
        if (healing > getMaxHealing()) {
            healing = getMaxHealing();
        }
    }
    public int getMaxHealing() {return maxHealing;}
    public void setMaxHealing(int addMaxHealing) {maxHealing += addMaxHealing;}
    public int getHealingAmount() {return getLvl() * 2 + 5;}
    public int getHealingRegen() {return 1;}
    @Override public String attack(Combatant target){
        int attackDamage = getLvl() * 5;
        if (getBuffed()) {
            target.setHp(-attackDamage);
            return getName() + " smacks " + target.getName() + "! -" +
                    attackDamage + " health!\n"
                    + target.getName() + "'s current health: " + target.getHp();
        } else {
            attackDamage *= 2;
            return getName() + " smacks " + target.getName() + " very hard! -" +
                    attackDamage + " health!\n"
                    + target.getName() + "'s current health: " + target.getHp();
        }
    }
    @Override public String takeDamage(){
        return getName() + " takes a hit!";
    }
    @Override public String levelUp() {
        return getName() + " levels up!";
    }
    @Override public String toString() {
        return "Name: " + getName() +
                "\nHP: " + getHp() +
                "\nlvl: " + getLvl() +
                "\nMana: " + getHealing();
    }
    @Override public String useSpecialMove1(Combatant target) {
        if (getHealing() >= 1) {
            setHealing(-1);
            target.setHp(+getHealingAmount());
            return getName() + " heals " + target.getName() + " for " + getHealingAmount()
                    + " hp!\n" + target.getName() + "'s current health: " + target.getHp();
        } else {
            return getName() + " doesn't have enough healing left to perform basic heal\nCurrent healing: " +
                    getHealing() + "\nRequired healing: 1";
        }
    }
    @Override public String useSpecialMove2(Combatant target) {
        if (getLvl() >= 10) {
            if (getHealing() >= 2) {
                setHealing(-2);
                target.setHp(+getHealingAmount());
                target.setBuffed(true);
                return getName() + " heals " + target.getName() + " for " + getHealingAmount()
                        + " hp and buffs their attack damage!" +
                        "\n" + target.getName() + "'s current health: " + target.getHp();
            } else {
                return getName() + " doesn't have enough healing left to perform basic buff\nCurrent healing: " +
                        getHealing() + "\nRequired healing: 2";
            }
        } else {
            return getName() + " is too inexperienced for that move!";
        }
    }
    @Override public String useSpecialMove3(Combatant target) {
        if (getLvl() >= 20) {
            if (getHealing() >= 3) {
                setHealing(-3);
                if (!target.getDown()) {
                    target.altSetHp(target.getMaxHp());
                    return getName() + " heals " + target.getName() +
                            " for full!" +
                            "\n" + target.getName() + "'s current health: "
                            + target.getHp();
                } else {
                    target.setDown(false);
                    target.altSetHp(target.getMaxHp() / 2);
                    return target.getName() + " is resurrected from the grave!\n" +
                            target.getName() + "'s current health: " + target.getHp();
                }
            } else {
                return getName() + " doesn't have enough healing " +
                        "left to perform max heal/resurrect\nCurrent healing: " +
                        getHealing() + "\nRequired healing: 3";
            }
        } else {
            return getName() + " is too inexperienced for that move!";
        }
    }
}
