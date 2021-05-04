package leetcode.medium;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;

        for(int i = 0; i < n - 1; i++) {
            if(heights[i] < heights[i + 1]){
                pq.add(heights[i + 1] - heights[i]);
            }
            // cover the smallest
            if(pq.size() > ladders) {
                bricks -= pq.poll();
            }

            // not enough bricks for next move
            if(bricks < 0) {
                return i;
            }
        }
        return n - 1;
    }
}
