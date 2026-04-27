import java.util.*;

public class Tsp {
    static int n = 4;
    static int[][] dist = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };
    static int[][] dp;

    static int tsp(int mask, int pos) {
        if (mask == (1 << n) - 1) return dist[pos][0];
        if (dp[mask][pos] != -1) return dp[mask][pos];
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int cost = dist[pos][city] + tsp(mask | (1 << city), city);
                ans = Math.min(ans, cost);
            }
        }
        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {
        dp = new int[1 << n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(tsp(1, 0));
    }
}