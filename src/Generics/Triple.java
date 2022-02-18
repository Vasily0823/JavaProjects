package Generics;
import java.util.Objects;

public class Triple<A, B, C>{
    A first;
    B second;
    C third;

    Triple(A first, B second, C third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    A getFirst (){
        return first;
    }

    B getSecond(){
        return second;
    }

    C getThird(){
        return third;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Triple<?, ?, ?> triple = (Triple<?, ?,?>) obj;
        return first.equals(triple.first) &&
                second.equals(triple.second)&&
                third.equals(triple.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return "Triple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
