package leetcode.leetcode_by_topics.string;

public class CountBinarySubstrings {

    public static void main(String[] args) {
        CountBinarySubstrings s = new CountBinarySubstrings();
        s.countBinarySubstringsBetter("000111000");
    }

    public int countBinarySubstringsBetter(String s) {
        int count = 0;
        int prev = 0;
        int cur = 1;

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                cur++;
            } else{
                count += Math.min(cur, prev);
                prev = cur;
                cur = 1;
            }
        }

        return count + Math.min(cur, prev);
    }

    // tle
    public int countBinarySubstrings(String s) {
        int count = 0;

        for(int i = 0; i < s.length() - 1; i++){
            for(int size = 2; size < s.length() - i; size = size + 2){
                if(isOk(s, i, size)){
                    count++;
                }
            }
        }

        return count;
    }


    public boolean isOk(String s, int start, int size){
        if(s.charAt(start) == s.charAt(start + size - 1)) {
            return false;
        }

        for(int i = 0; i < size / 2 - 1; i++){
            if(s.charAt(start + i) != s.charAt(start + i + 1)
                || s.charAt(start + size - 1 - i) != s.charAt(start + size - 2 - i)){
                return false;
            }
        }
        return true;
    }
}
