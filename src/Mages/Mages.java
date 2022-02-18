package Mages;

import java.util.ArrayList;
import java.util.ListIterator;

public class Mages extends Character {

    Mages(String name, Integer hp, int position) {
        super(name, hp, position);
        type = "Маг";
        damage = (int) (Math.random() * 10 + 1);
    }


    public void doDamage(ArrayList<Character> perm) {
        switch ((int) (Math.random() * 3 + 1)) {
            case 1:
                this.hill();
                break;
            case 2:
                Character mage1 = perm.get((int) (Math.random() * (perm.size() - 1)));
                if (mage1.position != this.position) {
                    this.lightning(mage1);
                    break;
                } else
                    doDamage(perm);
                break;
            case 3:
                migrane(perm);
                break;
            default:
                break;
        }
    }

    //Spellbook
//-------------------------------------------------------------------------------
    void hill() {
        if(this.hp<15) {
            this.hp = this.hp + this.damage;
            output("Маг " + this.name + " используя лечение добавил себе " + this.damage + " здоровья"+
                    " у " + this.type + " " + this.name + " стало " + this.hp + " хп.");
        }
        else
            output("Маг " + this.name + " неудачно попытался востановить здоровье");
    }

    void lightning(Character character) {
        character.hp = character.hp - this.damage;
        output("Маг " + this.name + " использует молнию на " + character.type + " " + character.name +
                " и наносит " + this.damage +" урона"+" у " + character.type + " " + character.name + " осталось " + character.hp + " хп.");
    }


    void migrane(ArrayList<Character> perm) {
        output("Маг " + this.name + " использует мигрень");

        ListIterator<Character> listIterator = perm.listIterator();
        while (listIterator.hasNext()) {
            Character pers = listIterator.next();
            if (pers instanceof Mages) {
                output(pers.type + " " + pers.name + " получает " + this.damage + " урона." +" осталось " + pers.hp+" хп." );
            }
        }
    }

}
