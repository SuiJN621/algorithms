package com.fundamental;

import java.util.Arrays;

/**
 * @author Sui
 * @date 2018/5/19 23:57
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(56, new int[]{123, 1123, 123, 134, 1, 3212, 535, 756, 97, 687, 43, 356, 446,
                2, 34, 34, 68, 9, 84, 3555, 55}));
    }

    private static int binarySearch(int target, int[] a) {
        Arrays.sort(a);
        return doSearch(target, a, 0, a.length) - 1;
    }

    private static int doSearch(int target, int[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (a[mid] > target) {
            return doSearch(target, a, lo, mid - 1);
        } else if (a[mid] < target) {
            return doSearch(target, a, mid + 1, hi);
        } else {
            return a[mid];
        }
    }
}
