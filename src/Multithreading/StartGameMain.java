package Multithreading;

public class StartGameMain {



    public static void main(String[] args) throws InterruptedException {
        Player player1=new Player("Игрок1", new Maze());
        Player player2=new Player("Игрок2", new Maze());
        Player player3=new Player("Игрок3", new Maze());


        Thread t1 = new Thread(() -> player1.doStep());
        Thread t2 = new Thread(() -> player2.doStep());
        Thread t3 = new Thread(() -> player3.doStep());

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();


            int perStep; String perName;
            perName=player1.getName();
            perStep= player1.getStepCounter();
            if(perStep>player2.getStepCounter()){
                perName= player2.getName();
                perStep=player2.getStepCounter();
            }
            if(perStep>player3.getStepCounter()){
                perName= player3.getName();
                perStep=player3.getStepCounter();
            }
          System.out.println("Меньше всего шагов сделал " + perName +" всего шагов "+perStep);

    }





}
