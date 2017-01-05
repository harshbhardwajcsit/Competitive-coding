/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package augment_tree;

/**
 *
 * @author samsung
 */
public class Augment_tree {

    public static void main(String[] args) {
    new Augment_tree().run();
  }
//node class
  static class Node {
    Node left;

    Node right;

    int value;

    public Node(int value) {
      this.value = value;
    }
  }



  //run
   int count=0,value=5;
  public void run() {
    // build the simple tree from chapter 11.
    Node root = new Node(50);
    System.out.println("Binary Tree Example");
    System.out.println("Building tree with root value " + root.value);
   insert(root, 50);
   insert(root, 40);
   insert(root, 60);
   insert(root, 58);
   insert(root, 57);
   insert(root, 59);
   insert(root, 62);
   insert(root, 61);
   insert(root, 65);
   insert(root, 38);
   insert(root, 45);
   insert(root, 36);
   insert(root, 39);
   insert(root, 42);
   insert(root, 48);
   insert(root, 47);
   insert(root, 49);
   insert(root, 35);
   insert(root, 37);
   insert(root, 34);

    System.out.println("Traversing tree in order");
    printInOrder(root);

     // left_subtree(root.left);
   // System.out.println("count: "+count);
      Augment(root);

    //System.out.println("After mirror image");

     //printInOrder(root);



  }

  public void insert(Node node, int value) {
    if (value < node.value) {
      if (node.left != null) {
        insert(node.left, value);
      } else {/*
        System.out.println("  Inserted " + value + " to left of "
            + node.value);*/
        node.left = new Node(value);
      }
    } else if (value > node.value) {
      if (node.right != null) {
        insert(node.right, value);
      } else {
          /*
        System.out.println("  Inserted " + value + " to right of "
            + node.value); */
        node.right = new Node(value);
      }
    }
  }

  public int search(Node node,int value){

     if(node.value==value)
       return node.value;
     if (node.value >value){
        return search(node.left, value);}
     else{
    return search(node.right, value);}
  }

  public void printInOrder(Node node) {
    if (node != null) {
      printInOrder(node.left);
      System.out.println(  node.value);
      printInOrder(node.right);
    }
  }

// Augment function to find the kth element in tree

void Augment(Node node){

    left_subtree(node.left);
    System.out.println("count: "+count);

    if(value==count+1){ System.out.println("the key is :"+node.value);}
    else if(value>count){
        Augment(node.right);}
    else if(value<count){
        Augment(node.left);}




}

void left_subtree(Node node){

    if(node!=null){
        count++;
    left_subtree(node.left.left);
    left_subtree(node.right.right);

    }




}






 }



