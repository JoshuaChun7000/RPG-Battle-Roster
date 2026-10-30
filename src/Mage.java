public class Mage extends Combatant implements Specialist {
    private int mana;
    private int maxMana;
    private int manaRegen;
    public Mage(String name, int hp, int maxHp, int mana, int lvl,
                int maxMana, int manaRegen, boolean buffed, boolean down, boolean stunned) {
        super(name, hp, lvl, maxHp, buffed, down, stunned);
        this.mana = mana;
        this.maxMana = maxMana;
        this.manaRegen = manaRegen;
    }
    public int getManaRegen() {return manaRegen;}
    public void setManaRegen(int addManaRegen) {manaRegen += addManaRegen;}
    public int getMana() {
        return mana;
    }
    public void setMana(int addMana) {
        mana+=addMana;
        if (mana < 0) {
            mana = 0;
        }
        if (mana > getMaxMana()) {
            mana = getMaxMana();
        }
    }
    public int getMaxMana() {return maxMana;}
    public void setMaxMana(int addMaxMana) {maxMana += addMaxMana;}
    @Override public String attack(Combatant target){
        if (!getDown()) {
            if (getStunned()) {
                int attackDamage = getLvl() * 2;
                if (getBuffed()) {
                    target.setHp(-attackDamage);
                    target.setStunned(false);
                    return getName() + " bonks " + target.getName() + " with their staff!\n" +
                            "-" + attackDamage + " health!\n" +
                            target.getName() + "'s current health: " + target.getHp();
                } else {
                    attackDamage *= 2;
                    target.setHp(-attackDamage);
                    setBuffed(false);
                    return getName() + " bonks " + target.getName() + " very hard with their staff!\n" +
                            "-" + attackDamage + " health!\n" +
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
            setManaRegen(2);
            setMaxMana(5);
            if (getDown()) {
                setDown(false);
                return getName() + " levels up!\n" +
                        "Current level: " + getLvl() +
                        "\n+35 max health\n" +
                        "+2 mana regen rate\n" +
                        "+5 max mana\n" +
                        "Healed to full\n" +
                        "Revived";
            } else {
                return getName() + " levels up!\n" +
                        "Current level: " + getLvl() +
                        "\n+35 max health\n" +
                        "+2 mana regen rate\n" +
                        "+5 max mana\n" +
                        "Healed to full";
            }
        } else {
            return getName() + " has already reached the maximum level (Level 30)";
        }
    }
    @Override public String toString() {
        return "Name: " + getName() +
                "\nHP: " + getHp() +
                "\nlvl: " + getLvl() +
                "\nMana: " + getMana();
    }
    @Override public String useSpecialMove1(Combatant target) {
        if (!getDown()) {
            if (getStunned()) {
                if (getMana() >= 50) {
                    int attackDamage = getLvl() * 20;
                    setMana(-50);
                    target.setHp(-attackDamage);
                    target.setStunned(false);
                    return getName() + " hurls a fireball at " + target.getName() + "! -" +
                            attackDamage + " health!\n"
                            + target.getName() + "'s current health: " + target.getHp() + "\n" +
                            "Current mana: " + getMana();
                } else {
                    return getName() + " doesn't have enough mana left to cast fireball\n" +
                            "Current mana: " + getMana() + "\n" +
                            "Required mana: 50";
                }
            } else {
                return getName() + " is stunned!";
            }
        } else {
            return getName() + " is downed!";
        }
    }
    @Override public String useSpecialMove2(Combatant target) {
        if (!getDown()) {
            if (getStunned()) {
                if (getLvl() >= 10) {
                    if (getMana() >= 100) {
                        int attackDamage = getLvl() * 40;
                        setMana(-100);
                        target.setHp(-attackDamage);
                        target.setStunned(true);
                        return getName() + " shoots lightning from their" +
                                " fingertips at " + target.getName() + ", blinding them!\n-" +
                                attackDamage + " health!\n" +
                                target.getName() + "'s current health: " + target.getHp() + "\n" +
                                "Current mana: " + getMana();
                    } else {
                        return getName() + " doesn't have enough mana left to cast lightning\n" +
                                "Current mana: " + getMana() + "\n" +
                                "Required mana: 100";
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
                    if (getMana() >= 150) {
                        int attackDamage = getLvl() * 60;
                        setMana(-150);
                        target.setHp(-attackDamage);
                        target.setStunned(true);
                        return getName() + " shoots a concentrated beam of light at " +
                                target.getName() + ", blinding them! -" + attackDamage + " health!\n" +
                                target.getName() + "'s current health: " +
                                target.getHp() + "\nCurrent mana: " + getMana();
                    } else {
                        return getName() +
                                " doesn't have enough mana left to cast ultralight beam\n" +
                                "Current mana: " + getMana() + "\n" +
                                "Required mana: 150";
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
    public void regenerateMana() {
        setMana(getManaRegen());
    }
}
