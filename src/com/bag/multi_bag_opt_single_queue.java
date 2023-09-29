package com.bag;
import java.util.Scanner;

public class multi_bag_opt_single_queue {
    public static void main(String [] args){
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

        int [][] dp = new int [N + 1][V + 1];
        int [] m_queue = new int [V + 1];

        for(int i = 1; i <= N; i ++){
            for(int r = 0; r <= volums[i - 1]; ++ r){
                int mq_head = 0;
                int mq_tail = -1;
                for(int j = r; j <= V; j += volums[i - 1]){
//                  滑动窗口开始滑动，队头前移
                    while(mq_head <= mq_tail && j - m_queue[mq_head] > numbers[i-1] * volums[i - 1]){
                        mq_head += 1;
                    }

//                  判断新进入的元素具体的位置。具体位置确定方式是根据的满足条件的位置前移。
                    while(mq_head <= mq_tail &&  dp[i - 1][m_queue[mq_tail]]
                    + (j - m_queue[mq_tail]) / volums[i - 1] * values[i - 1] <= dp[i - 1][j]){
                        mq_tail -= 1;
                    }

//                  新元素入队
                    m_queue[++ mq_tail] = j;

//                  更新状态
                    dp[i][j] = dp[i - 1][m_queue[mq_head]] + (j - m_queue[mq_head])
                            / volums[i - 1] * values[i - 1];
                }
            }

        }

        System.out.println(dp[N][V]);
    }
}
