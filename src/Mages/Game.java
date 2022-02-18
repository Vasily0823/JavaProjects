package Mages;

import java.util.*;

import static Mages.Character.output;

public class Game extends Field {

    ArrayList<Character> players= new ArrayList<>();
    int counter; //итератор персонажа, не используется


    //определяем поле,количество монстров и магов, зануляем счетчик, не используется
    Game (int field){
        super(field);
        this.counter=0;
    }

    //можно убрать
    // Вызов конструктора для монстра
    void createMonster(String monsterName, Integer monsterHp){
        players.add(new Monsters (monsterName, monsterHp, counter));
        putPosition(counter);
        counter++;
    }

    // Вызов конструктора для мага
    void createMage(String mageName, Integer mageHp){
        players.add(new Mages ( mageName, mageHp, counter));
        putPosition(counter);
        counter++;
    }


//может быть ошибка в копировании коллекции, метод не особо, но что с ним сделать не ясно.
   void turn(){
       ArrayList<Character> perm = new ArrayList<Character> (players);
        for(Character iterator1: players){
            for(int i=(int)(Math.random() * (perm.size()-1)); i< perm.size(); i++) {
                if (iterator1 instanceof Monsters && iterator1.position!=perm.get(i).position) {
                    ((Monsters) iterator1).doDamage(perm.get(i));
                    break;
                }
                if (iterator1 instanceof Mages && iterator1.position!=perm.get(i).position) {
                    ((Mages) iterator1).doDamage(perm);
                    break;
                }
            }
        }
       players.clear();
       players=perm;
   }

//проверка сдох не сдох
    void dead(){
        ListIterator<Character> listIterator = players.listIterator();
        while (listIterator.hasNext()) {
            Character pers = listIterator.next();
            if(pers.hp<0){
                output(pers.type+" "+pers.name+" погиб.");
                listIterator.remove();
                CharacterMain.numberOfHaracters=CharacterMain.numberOfHaracters-1;
            }
        }
    }

    void winner(){
        if(players.size()==1){
            output("Победил "+players.get(0).type+" "+ players.get(0).name);
        }
        else
            output("Победивших нет");
    }
}


