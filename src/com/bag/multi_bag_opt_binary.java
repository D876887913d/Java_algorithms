package com.bag;
import java.util.Scanner;

// 题目具体介绍见multi-bag-simple，这里主要体现的是二进制优化的思路，

public class multi_bag_opt_binary {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int n = 12010;
        int m = 2010;

        int [] volums = new int [n];
        int [] values = new int [n];

        int N = scanner.nextInt();
        int V = scanner.nextInt();

        // =======================Binary optimizer starting========================
        // 用来作为索引的下标，同时最后也能标记出来最终的数组长度。
        int cnt = 0;

        for(int i = 0 ;i < N; i++){
            int vo, va, num;
            vo = scanner.nextInt();
            va = scanner.nextInt();
            num = scanner.nextInt();

            int k = 1;
            while(k <= num){
                volums[cnt] = k * vo;
                values[cnt] = k * va;
                // 每分出去一组，原本的总数就要减少。
                num -= k;
                k *= 2;
                cnt ++ ;
            }

            if(num > 0){
                volums[cnt] = num * vo;
                values[cnt] = num * va;
                cnt++;
            }
        }
        // =======================Binary optimizer Finished========================

        scanner.close();


        int [][] dp = new int [cnt + 1][V + 1];

        for(int i = 1;i <= cnt; i ++){
            for(int j = 1; j <= V; j ++){
                if(j >= volums[i - 1])dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - volums[i - 1]] + values[i - 1]);
                else dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[cnt][V]);
    }
}
