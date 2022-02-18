package Multithreading;


public class Maze {
   private final int[][] maze=new int[][]{
           {1, 0, 1, 1, 1}, //y=0
           {1, 0, 0, 0, 1}, //y=1
           {1, 1, 0, 1, 1}, //y=2
           {1, 0, 0, 0, 1}, //y=3
           {1, 1, 1, 0, 1}
   };

    private final Position start = new Position(1, 0);
    private final Position finish = new Position(3, 4);


    public int[][] getMaze() {
        return maze;
    }

    public Position getFinish() {
        return finish;
    }

    public Position getStart() {
        return start;
    }

    public int getSize(){
        return maze.length;
    }


}
