package Streams;

import java.util.ArrayList;

public class Pair {

    private  Integer key;
    private  String value;
    private ArrayList<Integer> intList =new ArrayList<>();

    public Pair(Integer aKey, String aValue)
        {
            key   = aKey;
            value = aValue;
        }

    public Pair(String value, ArrayList<Integer> intList) {
        this.value = value;
        this.intList = intList;
    }

    public ArrayList<Integer> getIntList() {
        return intList;
    }

    public void setIntList(ArrayList<Integer> intList) {
        this.intList = intList;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
