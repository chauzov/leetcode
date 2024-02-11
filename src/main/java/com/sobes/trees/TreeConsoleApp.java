package com.sobes.trees;

public class TreeConsoleApp {
    public static void main(String[] args) {
        AVLTree<Integer, String> tree = new AVLTree<>();

        for (int i = 1; i <= 10; i++) {
            String value = "Value of node " + i;
            tree.insertNode(tree.getRoot(), new AVLNode<>(i, value));
        }

        System.out.println("Size is " + tree.getSize());
        System.out.println("Height is " + tree.getHeight());

        tree.print(tree.getRoot(), 1);

    }
}
