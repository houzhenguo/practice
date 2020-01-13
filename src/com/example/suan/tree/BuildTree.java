package com.example.suan.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  根据 前序遍历 中序 遍历 构建二叉树
 */
public class BuildTree {
    // key = 中序遍历的值 value = 对应的数组下标
    private static Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
    // 前序遍历数组
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        Node root = rebuildTree(pre, inorder);
       //postOrderPrint(root);
//        List<Integer> res = new ArrayList<>();
//        lujing(root, res, 6);
//        res.forEach(System.out::println);


        Node newNode = mirrorNewTree(root);
        postOrderPrint(newNode);
        System.out.println("--------------");
        postOrderPrint(root);

//        Node mirrorRoot = mirrorTree(root);
//        postOrderPrint(mirrorRoot);

//        Node resNode = findNextNodeInOrder(root);
//        System.out.println(resNode.val);
    }

    public static Node rebuildTree(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }
        return buildTree(preOrder, 0, preOrder.length -1, 0, null);
    }

    public static Node buildTree(int[] pre, int preL, int preR, int inL, Node parent) {
        if (preL > preR) {
            return null;
        }
        int inOrderIndex = inOrderIndexMap.get(pre[preL]);
        int leftTreeSize = inOrderIndex - inL; // 左子树的大小
        Node root = new Node(pre[preL], parent);
        root.left = buildTree(pre, preL+1,preL+leftTreeSize, inL, root);
        root.right = buildTree(pre, preL+ leftTreeSize + 1, preR, inOrderIndex +1, root);
        return root;
    }

    // 后续遍历
    public static void postOrderPrint(Node root) {
        if (root == null) {
            return;
        }
        postOrderPrint(root.left);
        postOrderPrint(root.right);
        // visit root
        System.out.println("后续遍历" + root.val+", 该节点的父节点"+(root.parent == null ? "空" : root.parent.val));
        return;
    }

    // 镜像反转
    public static Node mirrorTree (Node root) {
        if (root == null) {
            return null;
        }
        swap(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
    public static void swap(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }


    static class Node {
        int val;
        Node left;
        Node right;
        Node parent; // 新加父节点
        public Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
        }
        public Node(int val) {
            this.val = val;
        }
    }

    // TODO : 题目三
    // 给定一颗 二叉树的节点 找到 该节点 中序遍历的下一个节点

    // 分析： 如果该节点存在 右子树，那么下一个节点为 左子树的最左孩子 如果不存在，下一个节点是 父节点
    public static Node findNextNodeInOrder(Node node) {
        if (node == null) {
            return null;
        }
        Node rootNode = node.right;
        if (rootNode == null) {
            return node.parent;
        }
        // 右孩子不为空 去查找 有孩子的最左孩子
        while ( rootNode.left != null) {
            rootNode = rootNode.left;
        }

        return rootNode;
    }

    // 判断一个 树是否是另外一个树的子结构

    // 输出根节点 到 某个节点的路径

    public static boolean lujing(Node node, List<Integer> list, int target) {
        if (node == null) {
            return false;
        }

        if (lujing(node.left, list, target) || lujing(node.right,list,target) || node.val == target) {
            list.add(node.val);
            return true;
        }
        return false;
    }

    public static Node mirrorNewTree(Node root) {
        if (root == null) {
            return null;
        }
        Node node = new Node(root.val);
        node.left = root.right;
        node.right = root.left;
        mirrorNewTree(node.left);
        mirrorNewTree(node.right);
        return node;
    }

}
