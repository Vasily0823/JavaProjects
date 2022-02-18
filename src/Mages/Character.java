package Mages;

public class Character implements Damage {

    String name;
    Integer hp;
    int position;//временно не используется
    int damage;
    String type;


    //конструктор персонажа
    Character(String name, Integer hp){
        this.hp=hp;
        this.name=name;
    }

    //конструктор персонажа на поле
    Character(String name, Integer hp, int position){
        this(name, hp);
        this.position=position;
    }

  @Override
  public void doDamage(Character value){}


    public static void output(String str){
        CharacterMain.log=CharacterMain.log+str+"\n";
        System.out.println(str);
    }
}
