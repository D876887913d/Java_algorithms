package com.bag;

import java.util.Scanner;

/*
有 N件物品和一个容量是 V 的背包。每件物品只能使用一次。
第 i 件物品的体积是 vi ，价值是 wi。
求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
输出最大价值。

输入格式
    第一行两个整数，N，V ，用空格隔开，分别表示物品数量和背包容积。
    接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。

输出格式
    输出一个整数，表示最大价值。

数据范围
    0<N,V≤1000
    0<vi,wi≤1000

输入样例
    4 5
    1 2
    2 4
    3 4
    4 5
*/

// Question Link: https://www.acwing.com/problem/content/2/
public class binary_bag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取物品数量和背包容积
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        // 创建数组来存储物品的体积和价值
        int[] volumes = new int[N];
        int[] values = new int[N];
        // 逐行读取物品数据
        for (int i = 0; i < N; i++) {
            int vi = scanner.nextInt(); // 物品体积
            int wi = scanner.nextInt(); // 物品价值
            volumes[i] = vi;
            values[i] = wi;
        }
        scanner.close();

        int [][] dp = new int[N+1][V+1];
        dp[0][0] = 0;
        for(int i = 1;i <= N;i ++){
            for(int j = 1;j <= V; j++){
                if(j < volumes[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-volumes[i-1]] + values[i-1]);
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}
