package Generics;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class PhonMain {
    public static void main(String[] args) {
        List<Triple<String,Double,Double>> app = new ArrayList<>();
        app.add(new Triple<>("Вотсапп", 40.0, 4.0 ));
        app.add(new Triple<>("Вайбер",  60.0, 4.5 ));
        app.add(new Triple<>("Телеграмм",  120.0, 5.0 ));
        app.add(new Triple<>("Скайп",  5.0, 3.0 ));
        sortCountReviews(app);
        bestApp(app);
        lowApp(app);
    }

    static void sortCountReviews(final List<Triple<String,Double,Double>> app){
        System.out.printf("Месседжеры по количеству отзывов");
        app.stream()
                .sorted(Comparator.comparingDouble(Triple::getSecond))
                .forEach(
                (t) -> System.out.printf("%s, %s, %s\n", t.getFirst(), t.getSecond(), t.getThird()));
    }

    static void bestApp(final List<Triple<String,Double,Double>> app){
        System.out.printf("Лучший месседжер:\n");
        Triple<String,Double,Double> perem= new Triple<>("",0.0, 0.0);
        for(Triple<String,Double,Double> triple: app){
            if(triple.third>perem.third) {
                perem=triple;
            }
        }
        System.out.println(perem.getFirst() + " оценка " + perem.getThird());
    }

    static void lowApp(final List<Triple<String,Double,Double>> app){
        System.out.printf("Худший месседжер:\n");
        Triple<String,Double,Double> perem= new Triple<>("",0.0, 1000.0);
        for(Triple<String,Double,Double> triple: app){
            if(triple.third<perem.third) {
                perem=triple;
            }
        }
        System.out.println(perem.getFirst() + " оценка " + perem.getThird());
    }
}
