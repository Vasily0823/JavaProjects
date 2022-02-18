package Streams;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    private String name;
    private Set<Lection> lections;

    public Student(String name, List<Lection> lectionList) {
        this.name = name;
        this.lections = initLections(lectionList);
    }

    private Set<Lection> initLections( List<Lection> lections){
        Set<Lection> lections1 = new HashSet<>();
        for (int i = 0; i < lections.size(); i++) {
            // считаем, что в среднем студент не посещает половину лекций из расписания
            if(2 > rndIn(0, 3)) lections1.add(lections.get(i));
        }
        return lections1;
    }
    static int rndIn(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lection> getLections() {
        return lections;
    }

    public void setLections(Set<Lection> lections) {
        this.lections = lections;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lections=" + lections +
                '}';
    }
}
