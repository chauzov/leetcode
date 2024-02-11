package com.sobes.trees;

public class AVLTree<K extends Comparable<K>, E> {
    private AVLNode<K, E> root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getHeight() {
        return getHeight(root);
    }

    public int getSize() {
        return size;
    }

    public AVLNode<K, E> getRoot() {
        return root;
    }

    public AVLNode<K, E> insertNode(AVLNode<K, E> currentNode, AVLNode<K, E> newNode) {
        System.out.println("Inserting node with key " + newNode.getKey());
        if (currentNode == null) {
            if (root == null) {
                root = newNode;
            }
            size++;
            return newNode;
        }

        if (currentNode != null && currentNode.getKey().compareTo(newNode.getKey()) == 0) {
            System.out.println("There is an existing object with the key " + newNode.getKey());
            return currentNode;
        }

        if (newNode.getKey().compareTo(currentNode.getKey()) < 0) {
            currentNode.setLeft(insertNode(currentNode.getLeft(), newNode));
        } else {
            currentNode.setRight(insertNode(currentNode.getRight(), newNode));
        }

        return balanceSubTree(currentNode);
    }

    private AVLNode<K, E> balanceSubTree(AVLNode<K, E> node) {
        fixHeight(node);

        if (getBalanceFactor(node) == 2) {
            if (getBalanceFactor(node.getRight()) < 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }

        if (getBalanceFactor(node) == -2) {
            if (getBalanceFactor(node.getRight()) > 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }

        return node;
    }

    private int getHeight(AVLNode<K, E> node) {
        return node != null ? node.getHeight() : 0;
    }
    private void fixHeight(AVLNode<K, E> node) {
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());

        int newHeight = Math.max(leftHeight, rightHeight) + 1;
        node.setHeight(newHeight);
        System.out.printf("Set new height %d for the node with key %d\n", newHeight, node.getKey());
    }

    private int getBalanceFactor(AVLNode<K, E> node) {
        return getHeight(node.getRight()) - getHeight(node.getLeft());
    }

    private AVLNode<K, E> rotateRight(AVLNode<K, E> top) {
        System.out.println("Rotating right subtree under " + top.getKey());
        AVLNode<K, E> newTop = top.getLeft();
        top.setLeft(newTop.getRight());
        newTop.setRight(top);
        fixHeight(top);
        fixHeight(newTop);
        return newTop;
    }

    private AVLNode<K, E> rotateLeft(AVLNode<K, E> top) {
        System.out.println("Rotating left subtree under " + top.getKey());
        AVLNode<K, E> newTop = top.getRight();
        top.setRight(newTop.getLeft());
        newTop.setLeft(top);
        fixHeight(top);
        fixHeight(newTop);
        return newTop;
    }

    public void print(AVLNode<K, E> node, int indent) {
        if (node == null) {
            return;
        }

        if (node.getRight() != null) {
            print(node.getRight(), indent + 4);
        }

        if (indent != 0) {
            System.out.println(new String(new char[indent]).replace("\0", " "));
        }

        if (node.getRight() != null) {
            System.out.println("/");
            System.out.println(new String(new char[indent]).replace("\0", " "));
        }
        System.out.println(node.getKey());

        if (node.getLeft() != null) {
            System.out.println(new String(new char[indent]).replace("\0", " ") + "\\");
            print(node.getLeft(), indent + 4);
        }

    }
}
