package Streams;

import java.util.*;

public class Person {
    private String name;
    private int age;
    private static final String[] NAMES = {"Вася","Петя","Никита","Олег","Даша","Лена","Катя"};
    private static final int[] AGES = {10,20,45,30,32,18,17};


    public Person(){
        this.name=NAMES[new Random().nextInt(NAMES.length)];;
        this.age=AGES[new Random().nextInt(AGES.length)];
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List <Person> persons=new ArrayList<>();
        for(int i =0; i<10;i++){
            persons.add(new Person());
        }

        Collections.sort(persons, Comparator.comparing(Person::getName));
        System.out.println(persons);
        Collections.sort(persons, Comparator.comparing(Person::getAge));
        System.out.println(persons);



    }


}
