package com.apache.book.arithmetic;

/**
 * author: jerry
 * created on: 2020/8/16 10:27 PM
 * description:
 */
class OtherDemo {

    public static void main(String[] args) {
        System.out.println(testNumber1CountInArray(15));
    }

    // 000000000000000001

    /**
     * 二进制中1的个数
     * @param n
     * @return
     */
    private static int testNumber1CountInArray(int n){
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1 << i) != 0){
                res++;
                System.out.println("1 in:"+ i);
            }
        }
        return res;
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     *
     * 假设 按照圣墟排序的数组在预先位置的某个点上进行了旋转
     * 例如: 数组[0,1,2,4,5,6,7] 在 2这个位置上进行了旋转
     * 变为[4,5,6,7,0,1,2]， 需要找出0这个数字
     * 可以看做是左右两个数组  左:[4,5,6,7] 和 右:[0,1,2]这两个数组组成了一个新的数组
     * 右边的数组的最大值一定是小于或者等于左边数组的最小值,所以最小值一定是在右边数组的第一个位置
     * 所以可以把最左边数组快速跳过
     *
     * @return
     */
    private static int findMin(int [] nums){
        int left = 0;
        int right = nums.length - 1;
        while (right > left){
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            }else if (nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right --;
            }
        }
        return nums[right];
    }





}
