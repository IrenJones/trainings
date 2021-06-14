package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnATruck {

    public static void main(String[] args) {
        MaximumUnitsOnATruck s = new MaximumUnitsOnATruck();
        int[][] arr = {
            {5,10},
            {2,5},
            {4,7},
            {3,9}
        };
        s.maximumUnits(arr, 10);
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int count = 0;

        Comparator<int[]> comparator = (int[]a, int[] b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1];

        Arrays.sort(boxTypes, comparator);

        int i = 0;
        while(truckSize > 0 && i < boxTypes.length){
                count += boxTypes[i][1] * Math.min(boxTypes[i][0], truckSize);
                truckSize -= boxTypes[i][0];
                i++;
        }

        return count;
    }
}
