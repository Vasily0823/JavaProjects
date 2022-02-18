package Generics;

import java.util.ArrayList;
import java.util.List;

public class animalMain {
    public static void main(String[] args) {
        List<Pair<Animal, String>> animalsAndFood = new ArrayList<>();
        animalsAndFood.add(new Pair<>(new Animal("Барсик"), "Вискас"));
        animalsAndFood.add(new Pair<>(new Animal("Бобик"), "Кость"));
        animalsAndFood.add(new Pair<>(new Animal("Тюлень"), "Шоколад"));

        feedAnimals(animalsAndFood);
    }


   static void feedAnimals(List<Pair<Animal,String>> animalsAndFood){
        int number = (int)(Math.random() * animalsAndFood.size());
        int index = 0;
        for(Pair<Animal,String> pair:animalsAndFood){
            if (number == index) {
                System.out.printf(
                        "Счастливое животное \"%s\" получает двойную порцию \"%s\"\n",
                        pair.getFirst().getName(), pair.getSecond());
            } else {
                System.out.printf(
                        "Животное \"%s\" с радостью съедает \"%s\"\n",
                        pair.getFirst().getName(), pair.getSecond());
            }
            index++;
        }
    }


}
