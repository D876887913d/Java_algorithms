这个部分主要记录常见的几个背包问题的算法实现，包括0-1背包问题、完全背包问题、多重背包问题及其优化算法：
- [x] 0-1背包问题
- [x] 完全背包问题
- [x] 多重背包问题 - 无优化
- [x] 多重背包问题 - 二进制优化 
- [ ] 多重背包问题 - 单调队列优化

算法优化部分TODO：
- [ ] 采用一维优化动态数组，提高动态数组的运行效率，并减少其空间消耗。

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