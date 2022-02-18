package Generics;

import java.util.Objects;

public class Pair <A,B>{
    A first;
    B second;

    Pair(A first, B second){
        this.first = first;
        this.second = second;
    }

    A getFirst (){
    return first;
   }

    B  getSecond(){
       return second;
   }

   @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
       Pair<?, ?> pair = (Pair<?, ?>) obj;
       return first.equals(pair.first) &&
               second.equals(pair.second);
   }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
