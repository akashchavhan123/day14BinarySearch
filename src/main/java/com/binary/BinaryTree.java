package com.binary;

public class BinaryTree<K extends Comparable <K>> {

    MyBinaryNode<K> root;

    public void add(K key) {

        this.root = this.addRecursive(root,key);
    }

    private MyBinaryNode<K> addRecursive(MyBinaryNode<K> root, K key) {
        if(root == null) {
            return new MyBinaryNode<>(key);
        }else {
            int result = key.compareTo(root.key);
            if(result == 0) return root;
            if(result < 0) {
                root.left = addRecursive(root.left, key);
            }else {
                root.right = addRecursive(root.right, key);
            }
            return root;
        }
    }
    public int getSize() {
        return this.getSizeRecursive(root);
    }

    private int getSizeRecursive(MyBinaryNode<K> rootData) {
        return rootData == null ? 0 : 1 + this.getSizeRecursive(rootData.left)+this.getSizeRecursive(rootData.right);
    }

    private boolean searchKey(MyBinaryNode<K> rootData, K key) {
        if(rootData == null) return false;
        if(rootData.key == key) return true;
        if(searchKey(rootData.left, key)) return true;
        return searchKey(rootData.right, key);
    }
    public static void main(String args[]) {
        BinaryTree<Integer> binary = new BinaryTree<>();
        binary.add(56);
        binary.add(30);
        binary.add(70);
        binary.add(22);
        binary.add(40);
        binary.add(60);
        binary.add(95);
        binary.add(11);
        binary.add(3);
        binary.add(16);
        binary.add(65);
        binary.add(63);
        binary.add(67);
        int bstSize = binary.getSize();
        System.out.println("Size of binary tree is : "+bstSize);

        if(binary.searchKey(null, 63)) {
            System.out.println("63 not found in binary search tree");
        } else {
            System.out.println("63 found in binary search tree");
        }
    }
}
