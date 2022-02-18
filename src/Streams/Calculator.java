package Streams;

import java.util.HashMap;

public class Calculator {

    private double number1;
    private double number2;
    private String operationName;
    private HashMap<String, Operation> operMap = new HashMap<>();

   void calculate(String operationName, Double number1, Double number2){
       System.out.println(operMap.get(operationName).doOperation(number1, number2));
   }

    void addOperation(String operationName, Operation implementation){
       operMap.put(operationName,implementation);
    }


}
