package com.apache.book.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * author: jerry
 * created on: 2020/8/23 6:03 PM
 * description:
 */

public class TreeDemo {
    public static void main(String[] args) {
        TreeNode A  = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        A.left = node4;
        A.right = node5;

        node4.left = new TreeNode(1);
        node4.right = new TreeNode(2);

        TreeNode B  = new TreeNode(4);
        TreeNode B1Node  = new TreeNode(2);
        B.left = B1Node;

        System.out.println(isSubStructure(A,B));


        TreeDemo treeDemo = new TreeDemo();
        TreeNode root  = new TreeNode(5);
        TreeNode secondLeft  = new TreeNode(3);
        TreeNode secondRight  = new TreeNode(6);
        root.left = secondLeft;
        root.right = secondRight;

        TreeNode thirdLeft = new TreeNode(2);
        TreeNode thirdRight = new TreeNode(4);

        secondLeft.left = thirdLeft;
        secondLeft.right = thirdRight;

        thirdLeft.left = new TreeNode(1);



        int theKThSamllest = treeDemo.testTheKthSmallest(root,4);
        System.out.println("theKThSamllest:"+theKThSamllest);

    }

    /**
     * 二叉搜索树第K小元素
     *  二叉搜索树特点是左节点值小于根节点，而右节点值大于根节点；利用这个特性可以采用二分法，将整个树的节点分为左节点和右节点两部分，当k值等于左节点值+1时，说明此时root为要求的第k小元素；当k值小于左节点值时，说明第k小元素位于根节点左侧；当k值大于左节点时，说明第k小元素位于根节点右侧；
     *  之后递归，在满足条件的左右两侧节点中进行遍历划分，直到求出第k小
     * @param root
     * @param k
     *
     *    5
     *   /  \
     *   3   6
     *  /    \
     *  2    4
     *  /
     *  1
     * @return
     */
    private Integer testTheKthSmallest(TreeNode root, int k){
        List<Integer> order = new ArrayList<>();
        zhongxu(root,order,k);
        return order.get(k - 1);
    }

    /**
     * 中序遍历的函数
     * @param root
     * @param array
     * @param k
     */
    void zhongxu(TreeNode root,List<Integer> array,int k){
        if (root == null){
            return;
        }
        //如果arr已经包含了K个元素，则说明第K小的元素已经找到，可以退出递归
        if (array.size() == k){
            return;
        }
        //如果
        zhongxu(root.left,array,k);
        array.add(root.value);
        zhongxu(root.right,array,k);
    }


    /**
     * 树的子结构
     * @param A
     * @param B
     * @return
     */
    private static boolean isSubStructure(TreeNode A, TreeNode B){
        if (B == null || A == null){
            return false;
        }
        boolean result = check(A,B);
        if (result){
            return true;
        }
        if (A.left != null){
            result = isSubStructure(A.left,B);
            if (result){
                return true;
            }
        }
        if (A.right != null){
            result = isSubStructure(A.right,B);
            if (result){
                return true;
            }
        }
        return false;
    }

    private static boolean check(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null){
            return false;
        }
        if (A.value != B.value){
            return false;
        }
        return check(A.left,B.left) && check(A.right,B.right);
    }


    private static class TreeNode{
        public TreeNode left,right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value,TreeNode left, TreeNode right ) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}