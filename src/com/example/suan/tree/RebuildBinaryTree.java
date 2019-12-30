package com.example.suan.tree;
import java.util.*;

public class RebuildBinaryTree {
    // 缓存 中序遍历 key = 中序的值， value = 对应的数组 index
    public static Map<Integer, Integer> indexInOrdersMap = new HashMap<>();

    public static TreeNode reBuildBinaryTree(int[] pre, int[] in) {
        if (pre.length != in.length) {
            System.out.println("两个数组长度不同，请检查");
            return null;
        }
        for (int i = 0; i < in.length; i++) {
            indexInOrdersMap.put(in[i], i);
        }
        if (indexInOrdersMap.size() != in.length) {
            return null;
        }

        return reBuildTree(pre, 0, pre.length - 1, 0);
    }

    /**
     *
     * @param pre 前序遍历数组
     * @param preL 前序遍历的 下标当前位置
     * @param preR
     * @param inL 中序遍历数组 左部分的开始下标
     * @return
     */
    public static TreeNode reBuildTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        if (preL <0 || preR>=pre.length) {
            System.out.println("数组越界");
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]); // 按顺序 根据当前前序遍历 的左 构建当前子树的 根节点
        Integer inIndex = indexInOrdersMap.get(root.val); // 获取数值在 中序数组中的位置
        if (inIndex == null) {
            System.out.println("异常情况");
            return null;
        }
        int leftTreeSize = inIndex - inL; // 中序遍历 数组 左边部分的长度
        root.left = reBuildTree(pre, preL + 1, preL + leftTreeSize, inL); // 构建左子树 ,前序遍历 从 Pre+1 -> Pre+size 是左子树部分
        root.right = reBuildTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    /**
     *  二叉树的后续遍历
     * @param root
     * @return
     */
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            result.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }

    public static List<Integer> preOrderTraversal(TreeNode node) {
        // 根 左 右
        List<Integer> result = new ArrayList<>();
        if(node == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(node);
        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            if (n != null) {
                result.add(n.val);
                stack.push(n.right);
                stack.push(n.left);
            }
        }
        return result;
    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();

        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null) {
                stack.push(cur);
                cur  = cur.left;
            }
            TreeNode n = stack.pop();
            if (n != null) {
                result.add(n.val);
                cur = n.right;
            }
        }
        return result;

    }

    /**
     *  镜像反转
     * @param root
     * @return
     */
    public static TreeNode mirrorReverse(TreeNode root) {
        if (root == null)
            return null;
        swap(root);
        mirrorReverse(root.left);
        mirrorReverse(root.right);
        return root;
    }
    // 将左右子树交换
    private static void swap(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }


    // 节点的定义
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,8,6};


        TreeNode root = reBuildBinaryTree(preOrder, inOrder); // 构建 二叉树
        List<Integer> result = postOrderTraversal(root); // 后续遍历 （题目1）
       // result.forEach(System.out::println); // 7,4,2,5,8,6,3,1

        // preOrder
        List<Integer> preRes = inOrder(root);
        preRes.forEach(System.out::println);

        // 镜像反转 测试
        TreeNode mirrorNodeRoot = mirrorReverse(root);
        List<Integer> mirrorResult = postOrderTraversal(mirrorNodeRoot);
        //mirrorResult.forEach(System.out::println); // 8,6,5,3,7,4,2,1 (题目2结果)
    }

}
