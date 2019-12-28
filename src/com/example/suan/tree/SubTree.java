package com.example.suan.tree;

public class SubTree {

    // 判断 B 是否是 A 的一个子结构
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (isPart(root1, root2)) { // 判断第 二棵树是否在 第一颗树中全部存在
            return true;
        }
        // 递归 root1 的左右子树，
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    boolean isPart (TreeNode r1, TreeNode r2) {
        if (r2 == null) { // 说明 B 当前分支已经没有 点了
            return true;
        }
        if (r1 == null || r1.val != r2.val) { // 当前 r1没有点了，但是r2有点，说明 r1不够了，返回 false
            return false;
        }
        return isPart(r1.left, r2.left) && isPart(r1.right, r1.right); // 递归的查找 左右子树
    }
}
