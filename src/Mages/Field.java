package Mages;

//понадобится в случае, если персонажи начнут ходить или их позиции будут играть значение.
public class Field {
   int[] map;

    //принимает размер поля и создает его, заполняя от 0 до map
    Field(int map){
        this.map= new int[map];
        for(int i=0; i<this.map.length; i++){
            this.map[i]=-1;
        }
    }

    //установка на поле
    void putPosition(int pos){
        map[pos]=pos;
    }

    //Возврат позиции
    int returnPosition(int i){
        return map[i];
    }

    //создание пустой позиции
    void deletePosition(int i){
        map[i]=-1;
    }

}
