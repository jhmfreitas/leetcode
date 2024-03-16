package blind75;

import java.util.Objects;

public class ClimbingStairs {

    // Dynamic Programming
    int o = 0;

    public int climbStairs(int n) {
        int one =1;
        int two = 1;

        for(int i = 0; i < n-1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }

        return one;
    }


    // DFS + Backtracking solution
    public int climbStairs(int n) {
        int[] res = new int[1];
        dfs(n, res, 0);
        return res[0];
    }

    private void dfs(Integer n, int[] paths, int tmp) {
        if(tmp == n){
            paths[0]++;
            return;
        }

        for (int i = 1; i <= 2; i++){
            int stepsClimbed = tmp + i;
            if(stepsClimbed <=n) {
                dfs(n, paths, stepsClimbed);
            }
        }
    }


    // DFS + Backtracking + Memoization solution
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return dfs(n,0, memo);
    }

    private int dfs(int n, int tmp, int[] memo) {
        if (tmp == n) {
            return 1;
        }

        if (memo[tmp] != 0)
            return memo[tmp];

        int paths = 0;
        for (int i = 1; i <= 2; i++) {
            int stepsClimbed = tmp + i;
            if (stepsClimbed <= n) {
                paths += dfs(n, stepsClimbed, memo);
            }
        }

        memo[tmp] = paths;
        return memo[tmp];
    }
}
