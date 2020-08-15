package com.apache.book.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * author: jerry
 * created on: 2020/8/14 1:13 PM
 * description:
 */
class FirstDemo {
    public static void main(String[] args) {
        int [] array = {2,4,6,9,8,12};
        int[] result = findIndex(array,12);
        System.out.println(result[0] + ":"+result[1]);
    }

    /**
     * 从数组中找出第一次出现 2个数相加等于target指的元素坐标
     * @param array
     * @param target
     * @return
     */
    private static int[] findIndex(int[] array, int target){
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




}
