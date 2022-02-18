package Generics;

import java.util.ArrayList;
import java.util.List;




public class GasStationMain {
    public static void main(String[] args) {
        List<Triple<String,GasolineType,Double>> gasStation = new ArrayList<>();
        gasStation.add(new Triple<>("Газпром",  GasolineType.DIESEL_FUEL, 30.0 ));
        gasStation.add(new Triple<>("НашаЗаправка",  GasolineType.DIESEL_FUEL, 25.0 ));
        gasStation.add(new Triple<>("Лукоил",  GasolineType. OCTANE_RATE_95, 30.0 ));
        gasStation.add(new Triple<>("ЛучшийБензин",  GasolineType. OCTANE_RATE_95, 28.0 ));

        findBestPrice(gasStation, GasolineType. OCTANE_RATE_95);

    }

    static void findBestPrice(List<Triple<String, GasolineType, Double>> gasStation, GasolineType type){
        Pair<String, Double> perem= new Pair<>("",1000.0);
        for(Triple<String,GasolineType,Double> triple: gasStation){
            if(type.equals(triple.second)&&(perem.second>triple.third)) {
                perem.first = triple.getFirst();
                perem.second=triple.getThird();
            }
        }
        System.out.println("Самый дешевый бензин на "+perem.first + " стоимость " + perem.second);
    }
}
