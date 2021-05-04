/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topviewoftree;

import java.util.HashMap;
import java.util.Map;

public class TopViewOfTree {

    public static void main(String[] args) {
        new TopViewOfTree().run();
    }

    static class Node {
        Node left;

        Node right;

        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void run() {
        // build the simple tree from chapter 11.
        Node root = new Node(25);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.value);
        insert(root, 13);
        insert(root, 30);
        insert(root, 12);
        insert(root, 15);
        insert(root, 11);
        insert(root, 14);
        insert(root, 36);
        insert(root, 32);
        insert(root, 34);
        insert(root, 33);
        insert(root, 35);


        System.out.println("Traversing tree in order");
        printInOrder(root);
        ShowTopView(root, 0);
        System.out.println("The elements seen from the top" + map.values());

    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("  Inserted " + value + " to left of "
                        + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + node.value);
                node.right = new Node(value);
            }
        }
    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.value);
            printInOrder(node.right);
        }
    }


    void ShowTopView(Node node, int val) {
        if (node == null) {
        } else {
            if (node.left != null && node.right != null) {
                if (map.containsKey(val) == false) {

                    map.put(val, node.value);

                }

                ShowTopView(node.left, val - 1);
                ShowTopView(node.right, val + 1);
            }

            if (node.left != null && node.right == null) {
                if (map.containsKey(val) == false) {

                    map.put(val, node.value);

                }
                ShowTopView(node.left, val - 1);
            }

            if (node.left == null && node.right != null) {
                if (map.containsKey(val) == false) {

                    map.put(val, node.value);

                }
                ShowTopView(node.right, val + 1);
            }

            if (node.left == null && node.right == null) {
                if (!map.containsKey(val)) {

                    map.put(val, node.value);

                }
            }
        }
    }
}

