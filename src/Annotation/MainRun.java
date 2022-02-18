package Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class MainRun {

    public static void main(String[] args)  throws IllegalAccessException, InstantiationException{
        Collection <Object> objectCollection = new ArrayList<>();
        objectCollection.add(new PersonAnot("Дмитрий",25,"qwerty"));
        objectCollection.add(new Animal("Пасюк", "Минус", 2, "Шоколадка", false));

        String serealize=DeSerializator.serialize(objectCollection);
        System.out.println("Коллекция объектов сериализована:");
        System.out.println(serealize);


        HashSet<Class> classes = new HashSet<>();
        classes.add(PersonAnot.class);
        classes.add(Animal.class);
        Collection<?> objects = DeSerializator.deserealize(serealize, classes);
        System.out.println("Коллекция объектов десериализована:");
        for (Object object :objects){
            System.out.println(object.toString());
        }
    }
}
