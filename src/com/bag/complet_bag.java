package com.bag;
import java.util.Scanner;

/**
 * 有 N 种物品和一个容量是V 的背包，每种物品都有无限件可用。
 * 第i种物品的体积是 vi，价值是 wi。
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 * 输入格式:
     * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
     * 接下来有 V 行，每行两个整数 ,wi，用空格隔开，分别表示第 种物品的体积和价值。
 * 输出格式:
     * 输出一个整数，表示最大价值。
 * 数据范围:
     * 0 < N,V < 1000
     * 0 < vi,wi < 1000
 */

/*
输入样例
    4 5
    1 2
    2 4
    3 4
    4 5
 */

public class complet_bag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();

        int [] volums = new int[N];
        int [] values = new int[N];

        for(int i = 0 ; i < N; i ++){
            int vi = scanner.nextInt();
            int wi = scanner.nextInt();
            volums[i] = vi;
            values[i] = wi;
        }

        scanner.close();

        int [][] dp = new int[N+1][V+1];
        dp[0][0] = 0;
        for(int i = 1;i <= N ; i++){
            for(int j = 1; j <= V; j++){
                for(int k =0 ; k*volums[i-1] <= j ; k++ ){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-k*volums[i-1]]+k*values[i-1] );
                }
            }
        }

        System.out.println(dp[N][V]);
    }
}
