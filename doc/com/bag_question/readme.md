这个部分主要记录常见的几个背包问题的算法实现，包括0-1背包问题、完全背包问题、多重背包问题及其优化算法：
- [x] 0-1背包问题
- [x] 完全背包问题
- [x] 多重背包问题 - 无优化
- [x] 多重背包问题 - 二进制优化 
- [x] 多重背包问题 - 单调队列优化
- [ ] 混合背包问题
- [ ] 二维费用的背包问题
- [ ] 分组背包问题
- [ ] 有依赖的背包问题
- [ ] 背包问题求方案数
- [ ] 背包问题求具体方案

算法优化部分TODO：
- [ ] 拷贝数组法优化。
- [ ] 滚动数组法优化。

# 背包问题 二维基本状态转移

```
int [][] dp = new int [cnt+1][V+1];

for(int i = 1; i <= cnt; i++){
    for(int j = 1; j <= V; j++){
        if(j < volumes[i-1]){
            dp[i][j] = dp[i - 1][j];
        }else{
            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j-volumes[i - 1]] + values[i - 1]);
        }
    }
}

System.out.println(dp[N][V]);
```





# 多重背包问题 - 二进制优化
这个部分主要是在输入部分进行处理的，将多重背包问题转化为朴素背包问题，将背包的个数进行展开：
```
// 主要代码如下
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
``` 

# 滚动数组
将原本的数组的维度转化为dp[2][V + 1]，能这样做的原因是：
1. 二者之间具有的转移关系就只存在于两个相邻的元素上，跟其余的元素无关；
2. 二者之间进行转移的过程中不会对其他元素产生对应的一些影响。