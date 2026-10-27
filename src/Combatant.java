public abstract class Combatant {
    protected int hp;
    protected String name;
    protected int lvl;
    public Combatant(String name, int hp, int lvl) {
        this.name = name;
        this.hp = hp;
        this.lvl = lvl;
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
    }
    public void setLvl(int addLevel) {
        lvl+=addLevel;
    }
    public abstract String levelUp();
    public abstract String toString();
}