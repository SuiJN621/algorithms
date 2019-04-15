package com.fundamental.analytics;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author Sui
 * @date 2018/6/1 17:59
 */
public class LocalMinimum {

    public static void main(String[] args) {
        double[] x = {1,2,3,4,5,4,6,8,0,7,8,3,2,1,8,0};
        int i = find(x);
        System.out.println(x[i]);


        ArrayList<String> strings = new ArrayList<>();
        strings.add(null);
        System.out.println(strings.size());
        strings.forEach(System.out::println);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));

    }

    public static int localMaximum(int[] x) {
        if (x == null || x.length == 0) {
            return -1;
        }
        if (x.length == 1 || x[0] > x[1]) {
            return 0;
        }
        if (x[x.length - 1] > x[x.length - 2]) {
            return x.length - 1;
        }

        int mid = 0;
        int left = 1;
        int right = x.length - 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (x[mid - 1] < x[mid]) {
                left = mid + 1 ;
            } else if (x[mid + 1] < x[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    public static int bitonicSearch(int[] x, int t) throws Exception {
        if (x == null || x.length < 1) return -1;
        if (x.length < 4) {
            Exception exception = new Exception("该数组不是双调数组");
            throw exception;
        }
        //获取最大值
        int maximumIndex = localMaximum(x);

        if (x[maximumIndex] > t) {
            //往左边查找
            int left = 0;
            int right = maximumIndex;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (x[mid] < t) {
                    left = mid + 1;
                } else if (x[mid] > t) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }

            //往右边查找
            int left2 = maximumIndex;
            int right2 = x.length - 1;
            int mid2 = 0;
            while (left2 <= right2){
                mid2 = (left2 +right2) / 2;
                if (x[mid2] < t){
                    right2 = mid2 - 1;
                }else if (x[mid2] > t){
                    left2 = mid2 + 1;
                }else {
                    return mid2;
                }
            }

            return -1;

        } else if (x[maximumIndex] < t) {
            return -1;
        } else {
            return maximumIndex;
        }
    }

    public static int find (double[] x) {
        int mid = 0;
        int left = 0;
        int right = x.length - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (x[mid - 1] < x[mid]) {
                right = mid - 1;
            } else if (x[mid + 1] < x[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
