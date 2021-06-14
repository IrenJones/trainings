package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarI {

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(47, 50);
        myCalendar.book(31, 40);
        myCalendar.book(20, 30);
    }
}

class MyCalendar {

    List<Integer> starts;
    List<Integer> ends;


    public MyCalendar() {
        starts = new ArrayList<>();
        ends = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(int i = 0; i < starts.size();i++){
            if(starts.get(i) < end && start < ends.get(i)){
                return false;
            }
        }
        starts.add(start);
        ends.add(end);
        return true;
    }
}

class MyCalendarBetter {

    TreeMap<Integer, Integer> tree;


    public MyCalendarBetter() {
        tree = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if(tree.isEmpty()){
            tree.put(start, end);
            return true;
        } else {
            Integer next = tree.ceilingKey(start);
            Integer prev = tree.floorKey(start);

            if((prev == null || tree.get(prev) <= start)
                && (next == null || end <= next)) {
                tree.put(start, end);
                return true;
            }

            return false;
        }
    }
}
