public abstract class Combatant {
    protected int hp;
    protected String name;
    protected int lvl;
    protected int maxHp;
    protected boolean buffed;
    protected boolean down;
    protected boolean stunned;
    public Combatant(String name, int hp, int lvl, int maxHp, boolean buffed,
                     boolean down, boolean stunned) {
        this.name = name;
        this.hp = hp;
        this.lvl = lvl;
        this.maxHp = maxHp;
        this.buffed = buffed;
        this.down = down;
        this.stunned = stunned;
    }
    public abstract String attack(Combatant target);
    public abstract String takeDamage();
    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getLvl() {
        return lvl;
    }
    public void setHp(int addHp) {
        hp+=addHp;
        if (hp < 0) {
            hp = 0;
        }
        if (hp > maxHp) {
            hp = maxHp;
        }
    }
    public void altSetHp(int newHp) {
        hp = newHp;
        if (hp < 0) {
            hp = 0;
        }
        if (hp > maxHp) {
            hp = maxHp;
        }
    }
    public int getMaxHp() {
        return maxHp;
    }
    public void setMaxHp(int addMaxHp) {
        maxHp += addMaxHp;
    }
    public void setLvl(int addLevel) {
        lvl+=addLevel;
    }
    public void setBuffed(boolean isBuffed) {
        buffed = isBuffed;
    }
    public boolean getBuffed() {return !buffed;}
    public void setDown(boolean isDown) {down = isDown;}
    public boolean getDown() {return down;}
    public void setStunned(boolean isStunned) {stunned = isStunned;}
    public boolean getStunned() {return stunned;}
    public abstract String levelUp();
    public abstract String toString();
}