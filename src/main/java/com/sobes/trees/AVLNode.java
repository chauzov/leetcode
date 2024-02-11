package com.sobes.trees;

public class AVLNode<K extends Comparable<K>, E> {
    protected K key;
    protected E element;

    private AVLNode<K, E> left;
    private AVLNode<K, E> right;
    private int height;


    public AVLNode(K key, E element) {
        this.key = key;
        this.element = element;
        height = 1;
    }

    public K getKey() {
        return key;
    }

    public E getElement() {
        return element;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode<K, E> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<K, E> left) {
        this.left = left;
    }

    public AVLNode<K, E> getRight() {
        return right;
    }

    public void setRight(AVLNode<K, E> right) {
        this.right = right;
    }
}
