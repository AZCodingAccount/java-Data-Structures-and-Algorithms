package com.zh.datastructures.tree.binarytree;

import java.util.LinkedList;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2023-11-14 19:44
 * @description: 二叉树的遍历实现
 **/
public class Traversal {
    /*
     * 二叉树的遍历是非常适合使用递归的，首先使用递归进行前中后序遍历，传进来一个节点，打印他的值即可
     * */
    // 前序遍历，节点->左子树->右子树
    public static void preOrder(TreeNode node) {
        // 定义一个结束条件
        if (node == null) {
            return;
        }
        System.out.printf(node.val + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    // 中序遍历，左子树->节点->右子树
    public static void inOrder(TreeNode node) {
        // 定义一个结束条件
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.printf(node.val + "\t");
        inOrder(node.right);
    }

    // 后序遍历，左子树->右子树->节点
    public static void postOrder(TreeNode node) {
        // 定义一个结束条件
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.printf(node.val + "\t");
    }


    /*
     *
     * 使用非递归方式进行二叉树的三种遍历，需要实现栈
     * */
    public static void order(TreeNode root) {
        // 前序遍历
        // 定义一个变量记录当前的节点
        TreeNode curr = root;
        // 创建一个栈记录当前遍历的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 记录一下最近弹栈的元素
        TreeNode pop = null;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                // 把当前节点压入栈中
                stack.push(curr);
                // 打印当前节点的值
                System.out.println("前序遍历：" + curr.val);
                // 更新节点找左子树
                curr = curr.left;
            }
            // 左子树遍历完成以后要回来遍历右子树
            else {
                // 拿出栈中第一个元素
                TreeNode peek = stack.peek();
                // 没有右子树
                if (peek.right == null) {
                    System.out.println("中序遍历：" + peek.val);
                    pop = stack.pop();
                    System.out.println("后序遍历：" + pop.val);
                }// 右子树处理完成
                else if (peek.right == pop) {
                    pop = stack.pop();
                    System.out.println("后序遍历：" + pop.val);
                }// 待处理的右子树
                else {
                    System.out.println("中序遍历：" + peek.val);
                    curr = peek.right;
                }
            }

        }
    }

    public static void preOrder2(TreeNode root) {
        // 前序遍历
        // 定义一个变量记录当前的节点
        TreeNode curr = root;
        // 创建一个栈记录当前遍历的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                // 把当前节点压入栈中
                stack.push(curr);
                // 打印当前节点的值
                System.out.println("前序遍历：" + curr.val);
                // 更新节点找左子树
                curr = curr.left;
            }
            // 左子树遍历完成以后要回来遍历右子树
            else {
                // 弹出栈中第一个元素
                TreeNode peek = stack.pop();
                // 处理当前的右节点
                curr = peek.right;
            }
        }
    }

    public static void inOrder2(TreeNode root) {
        // 前序遍历
        // 定义一个变量记录当前的节点
        TreeNode curr = root;
        // 创建一个栈记录当前遍历的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                // 把当前节点压入栈中
                stack.push(curr);
                // 更新节点找左子树
                curr = curr.left;
            }
            // 左子树遍历完成以后要回来遍历右子树
            else {
                // 拿出栈中第一个元素
                TreeNode pop = stack.pop();
                // 打印元素
                System.out.println("中序遍历：" + pop.val);
                curr = pop.right;
            }

        }
    }

    public static void postOrder2(TreeNode root) {
        // 前序遍历
        // 定义一个变量记录当前的节点
        TreeNode curr = root;
        // 创建一个栈记录当前遍历的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                // 把当前节点压入栈中
                stack.push(curr);
                // 更新节点找左子树
                curr = curr.left;
            }
            // 左子树遍历完成以后要回来遍历右子树
            else {
                // 这次就不能简单的进行弹栈了，因为遍历的时候需要用到栈的元素
                TreeNode peek = stack.peek();   // 获取栈顶的元素
                // 判断右子树是否为空，为空，就直接弹栈打印，并且记录一下当前弹栈的元素
                if (peek.right == null) {
                    pop = stack.pop();
                    System.out.println("后序遍历：" + pop);
                } // 判断该弹这个元素的时候右子树是不是遍历完成了，根据已经弹出的最近的元素来判断
                // 如果当前元素的右孩子已经弹出去了（一定是右孩子，如果遍历完成以后），那么就可以弹栈了
                else if (peek.right == pop) {
                    pop = stack.pop();
                    System.out.println("后序遍历：" + pop.val);
                }// 其他情况，右子树还需要处理，那就更新curr，让上面的逻辑去处理，然后递归到这边再进行处理
                else {
                    curr = peek.right;
                }

            }

        }
    }


    /*
     *       2
     *   4       8
     * 1   6   7   空
     * 前序：2  4  1  6  8  7
     * 中序：1  4  6  2  7  8
     * 后序：1  6  4  7  8  2
     * */
    public static void main(String[] args) {
        // 创建一个三层的二叉树（有一个头结点即可）
        TreeNode treeNode = new TreeNode(
                new TreeNode(new TreeNode(1), 4, new TreeNode(6)),
                2,
                new TreeNode(new TreeNode(7), 8, null));
        // 前中后序遍历
        /*preOrder(treeNode);
        System.out.println();
        inOrder(treeNode);
        System.out.println();
        postOrder(treeNode);*/
        // 非递归遍历
        // order(treeNode);
        // preOrder2(treeNode);
        // inOrder2(treeNode);
        postOrder2(treeNode);

    }
}
