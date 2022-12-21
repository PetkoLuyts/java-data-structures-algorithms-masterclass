package divide_and_conquer;

public class LongestCommonSubsequence {
    private int findLCSLength(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length() || i2 == s2.length()) {
            return 0;
        }

        int subProblem1 = 0;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            subProblem1 = 1 + findLCSLength(s1, s2, i1 + 1, i2 + 1);
        }

        int subProblem2 = findLCSLength(s1, s2, i1, i2 + 1);
        int subProblem3 = findLCSLength(s1, s2, i1 + 1, i2);

        return Math.max(subProblem1, Math.max(subProblem2, subProblem3));
    }

    public int findLCSLength(String s1, String s2) {
        return findLCSLength(s1, s2, 0, 0);
    }
}
