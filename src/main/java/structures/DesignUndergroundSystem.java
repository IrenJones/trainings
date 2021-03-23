package structures;

import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

public class DesignUndergroundSystem {

    public static void main(String[] args) {
        DesignUndergroundSystem undergroundSystem = new DesignUndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000.
        // There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        undergroundSystem.getAverageTime("Leyton", "Waterloo"); // return 11.00000.
        // There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3
        // to time=15 and a customer with id=27 from time=10 to time=20.
        // So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo"); // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");  // return 12.00000
    }

    Map<String, Pair<Integer, Integer>> end; // route - <TotalTime, Count>
    Map<Integer, Pair<String, Integer>> start; // id - <StationName, Time>

    public DesignUndergroundSystem() {
        this.start = new HashMap<>();
        this.end = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        start.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> startPoint = start.get(id);
        String route = startPoint.getKey() + "-" + stationName;
        int time = t - startPoint.getValue();
        Pair<Integer, Integer> upd = end.getOrDefault(route, new Pair<>(0, 0));
        end.put(route, new Pair<>(upd.getKey() + time, upd.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        Pair<Integer, Integer> pair = end.get(route);
        return (double) pair.getKey() / pair.getValue();
    }
}
