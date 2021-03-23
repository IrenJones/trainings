package leetcode.leetcode_by_topics.math;

import java.util.ArrayList;
import java.util.List;

public class ReorderedPowerOf2 {

    public static void main(String[] args) {
        ReorderedPowerOf2 s = new ReorderedPowerOf2();
        s.reorderedPowerOf2(10);
    }

    boolean answer = false;

    public boolean reorderedPowerOf2(int N) {
        List<Integer> list = new ArrayList<>(10);
        for(int i = 0; i < 10; i++) {
            list.add(0);
        }
        if (isPowerOf2(N)) {
            return true;
        }
        else {
            int count = 0;
            while (N > 0) {
                list.set(N % 10, list.get(N % 10) + 1);
                N = N / 10;
                count++;
            }

            combine(list, new ArrayList<>(), count);
            return answer;
        }
    }

    private void combine(List<Integer> numbers, List<Integer> cur, int count) {
        if(answer){
            return;
        }

        if(cur.size() == count){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < count; i++){
                sb.append(cur.get(i));
            }
            if(isPowerOf2(Integer.parseInt(sb.toString()))){
                answer = true;
            };
            return;
        }

        for(int i = 0; i < 10; i++){
            if(cur.size() == 0 && i == 0){
                continue;
            } else{
                if(numbers.get(i) > 0){
                    List<Integer> copy = new ArrayList<>(numbers);
                    copy.set(i, copy.get(i) - 1);
                    cur.add(i);
                    combine(copy, new ArrayList<>(cur), count);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    public boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }
}
