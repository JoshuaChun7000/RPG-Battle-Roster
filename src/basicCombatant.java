public class basicCombatant extends Combatant {
    public basicCombatant(String name, int hp, int lvl) {
        super(name, hp, lvl);
    }
    @Override public String attack(Combatant target){
        return getName() +
                " attacks " + target.getName();
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
                "\nlvl: " + getLvl();
    }
}
