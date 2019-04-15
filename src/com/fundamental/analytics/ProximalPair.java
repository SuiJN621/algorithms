package com.fundamental.analytics;

/**
 * @author Sui
 * @date 2018/6/1 17:34
 */
public class ProximalPair {

    public static void main(String[] args) {

    }

    public static void find(double[] array) {
        double minNum = Double.MAX_VALUE;
        int minI = 0;
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i + 1] - array[i] < minNum) {
                minI = i;
                minNum = array[i + 1] - array[i];
            }
        }
        System.out.println("最接近的两个数为:" + array[minI]);
        System.out.println("和:" + array[minI + 1]);
    }
}
