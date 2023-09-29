package com.bag;
import java.util.Scanner;
/*
有 N 种物品和一个容量是 V的背包。
第种物品最多有 S，件，每件体积是 i，价值是 wi。
求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
输出最大价值。

输入格式
    第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
    接下来有 行，每行三个整数 ,wis，用空格隔开，分别表示第种物品的体积、价值和数量。
输出格式
    输出一个整数，表示最大价值。

数据范围
    0 < N,V < 100
    0 < vi,wi, si < 100

输入样例
    4 5
    1 2 3
    2 4 1
    3 4 3
    4 5 2
 */
public class multi_bag_simple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N,V;
        N = scanner.nextInt();
        V = scanner.nextInt();

        int [] volums = new int [N];
        int [] values = new int [N];
        int [] numbers = new int [N];

        for(int i = 0 ;i < N; i++){
            volums[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
            numbers[i] = scanner.nextInt();
        }

        scanner.close();

        int [][] dp = new int [N+1][V+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= V; j++){
                for(int k = 0; k <= numbers[i-1]; k++){
                    if(k*volums[i-1]<=j){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-volums[i-1]*k]+k*values[i-1]);
                    }
                }
            }
        }

        System.out.println(dp[N][V]);
    }
}
