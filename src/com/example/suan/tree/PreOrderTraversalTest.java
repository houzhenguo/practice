package com.example.suan.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalTest {
    // 二叉树 的前序遍历 非递归版本
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        if (root == null) {
            return list;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return list;
    }
}
class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;
}
