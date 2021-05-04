package leetcode.leetcode_by_topics.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if(bound == 0 && (x != 0 || y != 0)){
            return new ArrayList<>();
        }

        Set<Integer> set = new HashSet<>();

        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        // calculate possible values for both x and y
        if(x == 1){
            setX.add(1);
        } else{
            for(int i = 0; (int)Math.pow(x, i) < bound; i++){
                setX.add((int)Math.pow(x, i));
            }
        }

        if(y == 1){
            setY.add(1);
        } else{
            for(int i = 0; (int)Math.pow(y, i) < bound; i++){
                setY.add((int)Math.pow(y, i));
            }
        }

        for(int xx: setX){
            for(int yy: setY){
                if(xx + yy <= bound){
                    set.add(xx + yy);
                }
            }
        }

        return new ArrayList<>(set);
    }
}
