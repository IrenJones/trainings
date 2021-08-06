package leetcode.medium;

public class MagicalString {

    public int magicalString(int n) {
        if (n <= 3) {
            return 1;
        }

        StringBuilder magic = new StringBuilder("122");
        int resEnd = 2, baseEnd = 3, count = 0;

        while (magic.length() < n) {
            if (magic.charAt(resEnd) == '2') {
                if (magic.charAt(baseEnd - 1) == '1') {
                    magic.append(22);
                }
                else {
                    magic.append(11);
                }
                baseEnd += 2;
            }
            else {
                if (magic.charAt(baseEnd - 1) == '1') {
                    magic.append(2);
                }
                else {
                    magic.append(1);
                }
                baseEnd++;
            }
            resEnd++;
        }
        for (int i = 0; i < n; i++) {
            if (magic.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
