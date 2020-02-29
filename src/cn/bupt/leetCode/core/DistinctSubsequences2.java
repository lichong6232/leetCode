package cn.bupt.leetCode.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:59 2019/10/8
 */
public class DistinctSubsequences2 {

    public int distinctSubseqII(String S) {
        int n = S.length();
        int dp[] = new int[n+1];
        dp[0] = 1;

        Map<Character,Integer> pre = new HashMap<>(n);
        int MOD = 1_000_000_007;
        for (int i=1;i<=n;i++){
            dp[i] = dp[i-1]*2%MOD;
            char c = S.charAt(i-1);
            if (pre.containsKey(c)){
                dp[i]-=dp[pre.get(c)-1];
            }
            dp[i]%=MOD;
            pre.put(c,i);
        }
        dp[n]--;
        if (dp[n]<0){
            dp[n] += MOD;
        }
        return dp[n];
    }

    public int distinctSubseqII1(String S) {
        int MOD = 1_000_000_007;
        int N = S.length();
        int[] dp = new int[N+1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < N; ++i) {
            int x = S.charAt(i) - 'a';
            dp[i+1] = dp[i] * 2 % MOD;
            if (last[x] >= 0)
                dp[i+1] -= dp[last[x]];
            dp[i+1] %= MOD;
            last[x] = i;
        }

        dp[N]--;
        if (dp[N] < 0) dp[N] += MOD;
        return dp[N];
    }

    public static void main(String[] args) {
        DistinctSubsequences2 distinctSubsequences2 = new DistinctSubsequences2();
        String s = "aba";
        int i = distinctSubsequences2.distinctSubseqII(s);
        System.out.println(i);
    }
}
