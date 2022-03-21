package leetcode.leetcode_by_topics.array;

import java.util.LinkedList;
import java.util.Queue;

public class DuplicateZeros {

    public static void main(String[] args) {
        DuplicateZeros solution = new DuplicateZeros();
        solution.duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
    }

    public void duplicateZeros(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        boolean wasZero = false;

        for(int i = 0; i < arr.length; i++){
            if(wasZero){
                q.add(arr[i]);
                arr[i] = 0;
                wasZero = false;
            } else{
                if(q.size() == 0){
                    if(arr[i] == 0){
                        wasZero = true;
                    }
                } else{
                    int value = q.poll();
                    if(value == 0){
                        wasZero = true;
                    }
                    q.add(arr[i]);
                    arr[i] = value;
                }
            }
        }
    }
}
