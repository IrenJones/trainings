package leetcode.leetcode_by_topics.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleIII {

    public static void main(String[] args) {
        CourseScheduleIII s = new CourseScheduleIII();
        int[][] arr = {{7,17},{3,12},{10,20},{9,10},{5,20},{10,19},{4,18}};
            s.scheduleCourseQueue(arr);
    }

    // TLE
    public int scheduleCourse(int[][] courses) {
        Comparator<int[]> comparator = Comparator.comparingInt((int[] a) -> a[1]);
        Arrays.sort(courses, comparator);

        int n = courses.length;
        int lastTime = courses[n - 1][1];

        Integer[][] greedy = new Integer[n][lastTime + 1];


        return helper(courses, 0, 0, greedy, n);
    }

    public int helper(int[][] courses, int i, int totalTime, Integer[][] greedy, int n){
        if(i == n){
            return 0;
        }

        if(greedy[i][totalTime] != null){
            return greedy[i][totalTime];
        }

        int count = 0;
        if(totalTime + courses[i][0] <= courses[i][1]){
            count = 1 + helper(courses, i + 1, totalTime + courses[i][0], greedy, n);
        }
        greedy[i][totalTime] = Math.max(count, helper(courses, i + 1, totalTime, greedy, n));
        return greedy[i][totalTime];
    }

    public int scheduleCourseIterative(int[][] courses) {

        Comparator<int[]> comparator = Comparator.comparingInt((int[] a) -> a[1]);
        Arrays.sort(courses, comparator);

        int n = courses.length;
        int totalTime = 0;
        int count = 0;

        for(int i = 0; i < n; i++){
            if(totalTime + courses[i][0] <= courses[i][1]){
                totalTime += courses[i][0];
                count++;
            } else {
                int prevMax = i;
                // look through the previous courses
                for(int j = 0; j < i; j++){
                    if(courses[prevMax][0] < courses[j][0]){
                        prevMax = j;
                    }
                }

                if(courses[prevMax][0] != courses[i][0]){
                    totalTime += -courses[prevMax][0] + courses[i][0];
                    courses[prevMax][0] = -1;
                } else {
                    courses[i][0] = -1;
                }
            }
        }
        return count;
    }

    public int scheduleCourseQueue(int[][] courses) {
        Comparator<int[]> comparator = Comparator.comparingInt((int[] a) -> a[1]);
        Arrays.sort(courses, comparator);

        int totalTime = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for (int[] course : courses) {
            if (totalTime + course[0] <= course[1]) {
                q.add(course[0]);
                totalTime += course[0];
            }
            else {

                if (!q.isEmpty()) {
                    int maxCourseLen = q.peek();
                    if (maxCourseLen > course[0]) {
                        q.poll();
                        totalTime += -maxCourseLen + course[0];
                        q.add(course[0]);
                    }
                }
            }
        }
        return q.size();
    }
}
