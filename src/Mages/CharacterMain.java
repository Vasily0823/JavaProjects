package Mages;

import static Mages.Character.output;
import static Mages.file.WorkWithFile.*;
import java.util.Scanner;


public class CharacterMain {
    static int numberOfHaracters = 4;
    static String log="";

    public static void main(String[] args) {
    startgame();
    }


    static void startgame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы хотите проиграть реплей (ввести 1) или сыграть новую партию (ввести 2)? Для выхода нажмите 0.");
        int choice= scanner.nextInt();
        if(choice==1){
            System.out.println("Введите порядковый номер реплея");
            int number_replay= scanner.nextInt();
            readFromFile(number_replay +".txt");
        }
        if(choice==2){
            System.out.println("Введите порядковый номер реплея");
            int number_replay= scanner.nextInt();
            Game q1 = new Game(10);
            q1.createMonster("bobic", 40);
            q1.createMonster("sharic", 50);
            q1.createMage("mage1", 90);
            q1.createMage("mage2", 30);
            int raund = 1;
            while(numberOfHaracters>1) {
                output("Раунд " +raund);
                q1.turn();
                q1.dead();
                raund++;
            }
            q1.winner();
            //   createPackage("");
            writeInFile(log, number_replay+".txt");
            numberOfHaracters=4;
            log="";
        }
        if(choice==0) System.exit(0);
        startgame();
    }

}
