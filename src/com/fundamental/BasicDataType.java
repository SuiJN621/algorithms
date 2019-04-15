package com.fundamental;

import java.util.Arrays;

public class BasicDataType {

    public static void main(String[] args) {
//        basicDataCalculate();
//        toBinaryString(5);
//        printTwoDimensionBooleanArray(new boolean[][]{{true, true, true, true}, {true, true, true, false}, {true,
//                true, false, false}, {true, false, false, false}, {false, false, false, false}});
//        transposition(new int[][]{{1,2,3},{4,5,6}});
//        System.out.println(lg(31));
//        System.out.println(exR1(6));
//        Integer.toBinaryString(10);
    }

    private static void basicDataCalculate() {
        //int类型相除，小数部分丢失
        int i1 = (0 + 15) / 2;
        //int和double相加自动转型为double，再相除小数不会丢失
        double i2 = 1 + 2 + 3 + 4.0;
        double i3 = (1 + 2.236) / 2;
        //+遇到String重载为连接符
        String s = 1 + 2 + "3";
        double i4 = 2.0e-6 * 100000000.1;
        boolean b1 = true && false || true && true;
        boolean b2 = 4.1 >= 4;
        System.out.println("(0 + 15) / 2 = " + i1);
        System.out.println("1 + 2 + 3 + 4.0 = " + i2);
        System.out.println("(1 + 2.236) / 2 = " + i3);
        System.out.println("2.0e-6 * 100000000.1 = " + i4);
        System.out.println("true && false || true && true is " + b1);
        System.out.println("4.1 >= 4 is " + b2);
        System.out.println(s);

        //字符相加转为int
        System.out.println('a' + 'b');
        System.out.println((char) ('a' + 4));
    }

    private static void stringFormat() {
        double t = 9.0;
        while (Math.abs(t - 9.0) / t > .001)
            t = (9.0 / t + t) / 2.0;
        System.out.printf("%.5f\n", t);
    }

    /**
     * 输出整数n的二进制
     *
     * @param n
     */
    private static void toBinaryString(int n) {
        assert n > 0 : "number must be positive";
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i /= 2) {
            sb.append(i % 2);
        }
        System.out.println(sb.toString());
    }

    private static void printTwoDimensionBooleanArray(boolean[][] booleans) {

        final char TRUE = '*';
        final char FALSE = ' ';
        System.out.print('$');
        for (int j = 0; j < booleans[0].length; j++) {
            System.out.print(j + 1);
        }
        System.out.println();
        boolean header = true;
        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans[i].length; j++) {
                if (header) {
                    System.out.print(i + 1);
                    header = false;
                }
                System.out.print(booleans[i][j] ? TRUE : FALSE);
            }
            header = true;
            System.out.println();
        }
    }

    private static void transposition(int[][] matrix) {
        int length = matrix.length;
        int width = matrix[0].length;
        int[][] transpose = new int[width][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(transpose));
    }

    private static int lg(int target) {
        int index = 1;
        if (target < 2) {
            return 0;
        }
        while ((target /= 2) >= 2) {
            index++;
        }
        return index;
    }

    private static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}
