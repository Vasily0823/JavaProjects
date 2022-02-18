package Mages;

public class Monsters extends Character {

    Monsters(String name, Integer hp, int position) {
        super(name, hp, position);
        type= "Монстр";
        damage =(int)(Math.random() * 10 +1);
    }

    @Override
    public void doDamage(Character target){
        target.hp=target.hp-this.damage;
        output( this.type+" "+ this.name + " атаковал " + target.type+" " + target.name +" и нанес " + this.damage
                    + " у " + target.type +" "+ target.name +" осталось "+ target.hp + " хп.");
    }
}

