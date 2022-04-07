package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnATruck {

    public static void main(String[] args) {
        MaximumUnitsOnATruck s = new MaximumUnitsOnATruck();
        int[][] arr = {
            {5, 10},
            {2, 5},
            {4, 7},
            {3, 9}
        };
        s.maximumUnits(arr, 10);
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int count = 0;

        Comparator<int[]> comparator = (int[] a, int[] b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1];

        Arrays.sort(boxTypes, comparator);

        int i = 0;
        while (truckSize > 0 && i < boxTypes.length) {
            count += boxTypes[i][1] * Math.min(boxTypes[i][0], truckSize);
            truckSize -= boxTypes[i][0];
            i++;
        }

        return count;
    }

    public int maximumUnitsAgain(int[][] boxTypes, int truckSize) {
        Comparator<int[]> comparator = Comparator.comparingInt((int[] a) -> a[1]).reversed().thenComparingInt((int[] b) -> b[0]);

        Arrays.sort(boxTypes, comparator);

        int count = 0;
        int vol = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            while (count <= truckSize && boxTypes[i][0] > 0) {
                boxTypes[i][0] -= 1;
                count++;
                vol += boxTypes[i][1];
            }

            if (truckSize == count) {
                return vol;
            }
        }

        return vol;
    }

    public int maximumUnits3v(int[][] boxTypes, int truckSize) {
        Comparator<int[]> comparator = Comparator.comparingInt((int[] a) -> a[1]).reversed();

        Arrays.sort(boxTypes, comparator);

        int countUnits = 0;
        int size = 0;
        int index = 0;
        while (size < truckSize && index < boxTypes.length) {
            int[] boxes = boxTypes[index];
            if (boxes[0] + size <= truckSize) {
                countUnits += boxes[0] * boxes[1];
                size += boxes[0];
                index++;
            }
            else {
                countUnits += (truckSize - size) * boxes[1];
                size = truckSize;
            }
        }
        return countUnits;
    }



































    public int maximumUnitsAaaa(int[][] boxTypes, int truckSize) {
        Comparator<int[]> comparator = Comparator.comparingInt((int[] arr) -> arr[1]).reversed();

        Arrays.sort(boxTypes, comparator);

        int total = 0;
        for(int i = 0; i < boxTypes.length && truckSize > 0; i++){
            int count = boxTypes[i][0];
            if(truckSize - count >= 0){
                truckSize -= count;
                total += boxTypes[i][1]*count;
            } else{
                truckSize = 0;
                total += boxTypes[i][1]*truckSize;
            }
        }

        return total;
    }
}
