package com.fundamental.analytics;

/**
 * @author Sui
 * @date 2018/6/1 17:31
 */
public class ThreeSumFaster {

    //时间复杂度 ~ N^2
    public int threeSumFaster(long[] a) {
        int cnt = 0;
        int len = a.length;
        for (int j = 0; j < len - 2; j++) {
            for (int k = j + 1, h = len - 1; k < h; ) {
                if (a[j] + a[k] + a[h] < 0) {
                    k++;
                } else if (a[j] + a[k] + a[h] > 0) {
                    h--;
                } else {
                    k++;
                    h--;
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}
