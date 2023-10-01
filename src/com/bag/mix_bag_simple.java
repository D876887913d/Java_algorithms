package com.bag;
import java.util.Scanner;
/*
有N 种物品和一个容量是T的背包。
物品一共有三类:
    第一类物品只能用1次 (01背包)
    第二类物品可以用无限次 (完全背包) ;
    第三类物品最多只能用 s 次 (多重背包) ;
每种体积是 vi，价值是 wi。
求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。输出最大价值。
输入格式
    第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
    接下来有  行，每行三个整数 ,w,s，用空格隔开，分别表示第种物品的体积、价值和数量。
        s = -1 表示第 种物品只能用1次
        s = 0 表示第种物品可以用无限次:
        s > 0表示第种物品可以使用 s次
输出格式
    输出一个整数，表示最大价值。

4 5
1 2 -1
2 4 1
3 4 0
4 5 2
 */
// 整体的思路: 将所有的样本转化为 0 - 1 背包问题的格式：
// 完全背包问题： 将其number设定为总体积除以该物品的体积向下取整
// 获取好每种物品的个数后，采用二进制优化的方式将其转化为 0 - 1 背包问题

public class mix_bag_simple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();

        int volum, value, number;

        int cnt = 0;

        int[] volumes = new int[100010];
        int[] values  = new int[100010];

//      =============================二进制优化================================
        for(int i = 0; i < N; i ++){
            volum = scanner.nextInt();
            value = scanner.nextInt();
            number = scanner.nextInt();

            if(number == -1)number = 1;
            else if(number == 0)number = V / volum;

            int k = 1;
            while(k <= number){
//              注意！这部分进行二进制分解的时候是用的k一段一段来进行分解
                volumes[cnt] = volum * k;
                values[cnt] = value * k;
                cnt += 1;
                number -= k;
                k *= 2;
            }

            if(number > 0){
                volumes[cnt] = volum * number;
                values[cnt] = value * number;
                cnt += 1;
            }
        }
//      ===========================二进制优化结束================================

//      ===========================拷贝数组优化=================================
        int[] dp = new int[V + 1];
        for(int i = 1; i <= cnt; i ++){
            for(int j = V; j >= volumes[i - 1]; j --){
                dp[j] = Math.max(dp[j], dp[j - volumes[i - 1]] + values[i - 1]);
            }
        }
        System.out.println(dp[V]);
//      =========================拷贝数组优化结束=================================
    }

}
