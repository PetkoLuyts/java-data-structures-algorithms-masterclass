package dynamic_programming;

public class HouseRobber {
    private int maxMoneyTopDown(int[] dp, int[] houseNetWorth, int currentIndex) {
        if (currentIndex >= houseNetWorth.length)
            return 0;

        if (dp[currentIndex] == 0) {
            int stealCurrent = houseNetWorth[currentIndex] + maxMoneyTopDown(dp, houseNetWorth, currentIndex + 2);
            int skipCurrent = maxMoneyTopDown(dp, houseNetWorth, currentIndex + 1);
            dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
        }
        return dp[currentIndex];
    }

    public int maxMoneyTopDown(int[] houseNetWorth) {
        int dp[] = new int[houseNetWorth.length];
        return maxMoneyTopDown(dp, houseNetWorth, 0);
    }

    public int maxMoneyBottomUp(int[] wealth) {
        int dp[] = new int[wealth.length + 2];
        dp[wealth.length] = 0;

        for (int i = wealth.length - 1; i >= 0; i--) {
            dp[i] = Math.max(wealth[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }

}
