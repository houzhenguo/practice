package com.example.suan.tree;

public class InvertTreeTest {
    // 镜像反转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
