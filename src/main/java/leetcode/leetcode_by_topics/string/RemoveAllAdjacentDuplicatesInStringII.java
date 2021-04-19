package leetcode.leetcode_by_topics.string;

public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        if (s.length() < 2) {
            return s;
        }

        int[] count = new int[s.length()];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            int last = sb.length() - 1;
            count[last] = 1 + (last > 0 && sb.charAt(last) == sb.charAt(last - 1) ? count[last - 1] : 0);
            if (count[last] == k) {
                sb.delete(sb.length() - k, sb.length());
            }
        }

        return sb.toString();
    }
}
