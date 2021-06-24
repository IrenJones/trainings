package leetcode.medium;

public class MatchsticksToSquare {

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum += matchsticks[i];
        }

        int maxSideSize = sum / 4;

        if (maxSideSize * 4 != sum) {
            return false;
        }

        return helper(0, new int[4], matchsticks, maxSideSize);
    }

    public boolean helper(int i, int[]a, int[] arr, int maxSideSize) {
        if (i == arr.length) {
            return a[0] == a[1] && a[2] == a[3] && a[0] == a[3];
        }

        for (int j = 0; j < 4; j++) {
            if (a[j] + arr[i] <= maxSideSize) {
                a[j] += + arr[i];
                if (helper(i + 1, a, arr, maxSideSize)) {
                    return true;
                }
                a[j] -= arr[i];
            }
        }
        return false;
    }

    // faster
    public boolean makesquareFaster(int[] matchsticks) {
        if(matchsticks.length < 4){
            return false;
        }

        int sum = 0;
        for(int i = 0; i < matchsticks.length; i++){
            sum += matchsticks[i];
        }

        int maxSideSize = sum / 4;

        if(maxSideSize * 4 != sum){
            return false;
        }

        return helper(0, 0, 0, 0, 0, matchsticks, maxSideSize);
    }

    public boolean helper(int i, int a1, int a2, int a3, int a4, int[] arr, int maxSideSize){
        if(i == arr.length){
            return a1 == a2 && a3 == a4 && a1 == a4;
        }

        if(a1 + arr[i] <= maxSideSize && helper(i + 1, a1 + arr[i], a2, a3, a4, arr, maxSideSize)){
            return true;
        }
        if(a2 + arr[i] <= maxSideSize && helper(i + 1, a1, a2 + arr[i], a3, a4, arr, maxSideSize)){
            return true;
        }
        if(a3 + arr[i] <= maxSideSize && helper(i + 1, a1, a2, a3 + arr[i], a4, arr, maxSideSize)){
            return true;
        }
        if(a4 + arr[i] <= maxSideSize && helper(i + 1, a1, a2, a3, a4 + arr[i], arr, maxSideSize)){
            return true;
        }
        return false;
    }
}
