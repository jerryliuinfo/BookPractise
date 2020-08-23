package com.apache.book.arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * author: jerry
 * created on: 2020/8/16 8:15 PM
 * description:
 */
class ArrayDemo {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int [] result = mergeArray(nums1,3,nums2,3);
        System.out.println(Arrays.toString(result));



        int [] array = {2,4,6,9,8,12};
        int[] result2 = findTargetIndex(array,12);
        System.out.println(result2[0] + ":"+result2[1]);

        int [][] the2DArray = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30},
        };
        boolean exist = findNumberIn2DArray(the2DArray,9);
        System.out.println("exist:"+exist);


    }

    /**
     * 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    private static int[] mergeArray(int [] nums1, int m, int [] nums2, int n){
        int i1 = m - 1;
        int i2 = n - 1;
        int i = m + n -1;
        while (i1 >= 0 && i2 >= 0){
            if (nums1[i1] > nums2[i2]){
                nums1[i] = nums1[i1];
                i1 --;
                i--;
            }else {
                nums1[i] = nums2[i2];
                i2 --;
                i--;
            }
        }
        while (i2 >= 0){
            nums1[i] = nums2[i2];
            i--;
            i2--;
        }
        return nums1;

    }



    /**
     * 从数组中找出第一次出现 2个数相加等于target指的元素坐标
     * @param array
     * @param target
     * @return
     */
    private static int[] findTargetIndex(int[] array, int target){
        int [] result = new int[]{-1,-1};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (map.containsKey(target - value)){
                result[0] = map.get(target - value);
                result[1] = i;
            }

            map.put(value,i);
        }
        return result;
    }


    /**
     *  二维数组中的查找
     *  1.先将当前点定位到 右上角(第一行，最后一列)的点
     *  2.当前值大于目标值, 说明当前列下边的都比target大， 排除当前这一列，列的j要--
     *  3.当前值小于目标值, 说明当前行左边的都比target小，行的 i要++
     * @param matrix
     * @param target
     * @return
     */
    private static boolean findNumberIn2DArray(int [][] matrix,int target){
        //行数
        int n = matrix.length;
        if (n == 0){
            return false;
        }
       // 列
        int m = matrix[0].length;
        //行
        int i = 0;
        //列
        int j = m -1;
        //第0行第m-1 列， 也就是右上角的元素
        while (i < n && j >= 0){
            if (matrix[i][j] == target){
                return true;
            }
            //当前值大于目标值, 说明当前列下边的都比target大， 排除当前这一列，j --
            else if (matrix[i][j] > target){
                j --;
            }
            //当前值小于目标值, 说明当前行左边的都比target小，行要++
            else {
                i ++;
            }
        }
        return false;
    }

}
