package Streams;

import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        List<Lection> lectionList =new ArrayList<>();

        addLections( lectionList);
        addStudents(studentList,lectionList );
        visitedMatan(studentList);
        sumAllLections(studentList);
        mostPopularLections( studentList,lectionList );

        visitedLectionPerDay(studentList);
        statisticCourses( studentList,lectionList );
    }

    static void statisticCourses(List<Student> studentList, List<Lection> lectionList ) {
        ArrayList<Pair>countStudents=new ArrayList<>();



        for(int i=0;i<5;i++){
            countStudents.add(new Pair(0, lectionList.get(i).getName()));
        }

        for(Student student:studentList) {
            student.getLections().stream()
                    .map(Lection::getName)
                    .distinct()
                    .forEach(s ->{
                        for(Pair lection:countStudents){
                            if(lection.getValue().equals(s)){
                                lection.setKey(lection.getKey()+1);
                            }
                        }
                    });
        }
        System.out.println("Сколько разных студентов посетивших лекции по предмету");
        for(Pair lection:countStudents){
            System.out.println(lection.getValue()+" "+ lection.getKey());
        }


    }


    static void visitedLectionPerDay(List<Student> studentList) {
        System.out.println("Количество посещенных лекций за день");
        Map<String, Integer> mostVisitsPerDayByStudent = new HashMap<>();

        studentList.forEach(student -> {
            Map<Integer, Integer> numberLection = new HashMap<>();
            student.getLections().forEach(lection -> numberLection.merge(lection.getDate(), 1, Integer::sum));
            mostVisitsPerDayByStudent.put(student.getName(), Collections.max(numberLection.values()));
        });
        System.out.println(mostVisitsPerDayByStudent.toString());
        }


   static void visitedMatan(List<Student> studentList) {
        System.out.println("Список студентов посетивших матанализ");
        for(Student student:studentList){
            student.getLections().stream()
                    .map(Lection::getName)
                    .distinct()
                    .filter(s->s.equals("матанализ"))
                    .forEach(s->System.out.println(student.getName()));
        }

    }

    static void mostPopularLections(List<Student> studentList,List<Lection> lectionList ) {
        ArrayList<Pair>popularity=new ArrayList<>();

        for(int i=0;i<5;i++){
            popularity.add(new Pair(0, lectionList.get(i).getName()));
        }



        for(Student student:studentList) {
            student.getLections().stream()
                    .map(Lection::getName)
                    .forEach(s ->{
                        for(Pair lection:popularity){
                            if(lection.getValue().equals(s)){
                                lection.setKey(lection.getKey()+1);
                            }
                        }
                    });
        }
        System.out.println("Статистика посещаемости лекций");
        for(Pair lection:popularity){
            System.out.println(lection.getValue()+" "+ lection.getKey());
        }

    }

    static void sumAllLections(List<Student> studentList) {
        System.out.println("Статистика посещений");
        for(Student student:studentList){
            System.out.println(student.getName()+" "+student.getLections().size());
        }
    }

    static void addLections(List<Lection> lectionList){
        lectionList.add(new Lection("матанализ", (int)(Math.random()*30)));
        lectionList.add(new Lection("философия", (int)(Math.random()*30)));
        lectionList.add(new Lection("английкий язык", (int)(Math.random()*30)));
        lectionList.add(new Lection("история", (int)(Math.random()*30)));
        lectionList.add(new Lection("физкультура", (int)(Math.random()*30)));
        lectionList.add(new Lection("матанализ", (int)(Math.random()*30)));
        lectionList.add(new Lection("философия", (int)(Math.random()*30)));
        lectionList.add(new Lection("английкий язык", (int)(Math.random()*30)));
        lectionList.add(new Lection("история", (int)(Math.random()*30)));
        lectionList.add(new Lection("физкультура", (int)(Math.random()*30)));
    }

   static void addStudents(List<Student>studentList,List<Lection> lectionList ){
       String[] students=new String[]{"Кирилл", "Петя", "Иван", "Федя", "Алексей", "Коля",
               "Артем", "Игорь", "Саша", "Сергей"};
       for(String s:students) studentList.add(new Student(s, lectionList));
    }



}
