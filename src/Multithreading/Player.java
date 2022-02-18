package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private Maze maze;
    private Position position;
    private Position end;
    private List<Position> log=new ArrayList<Position>();
    private int stepCounter=0;


    public Player(String name, Maze maze) {
        this.name = name;
        this.maze = maze;
        this.position = maze.getStart(); ;
        this.end = maze.getFinish();
    }


    void doStep(){
        while(!this.position.equals(this.end)){
            step();
            log.add(new Position(this.position));
        }
        System.out.println("Игрок " + this.name + "\nКоличество ходов "+ this.stepCounter+"\nПуть:\n"+this.log);
    }

    void step(){
        final Random random = new Random();
        this.stepCounter++;
        int x1=this.position.getX()+(-1+random.nextInt(3));
        int y1=this.position.getY()+random.nextInt(2);
        if(this.maze.getMaze()[y1][x1]!=1){
            this.position.setX(x1);
            this.position.setY(y1);
        }
    }

    public String getName() {
        return name;
    }

    public int getStepCounter() {
        return stepCounter;
    }

    public List<Position> getLog() {
        return log;
    }

}
