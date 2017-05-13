/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package childsumproperty;

/**
 *
 * @author samsung
 */
public class ChildSumProperty {



     public static void main(String[] args) {
    new ChildSumProperty().run();
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



  int hieght=0;
  public void run() {
    // build the simple tree from chapter 11.
    Node root = new Node(10);
    //System.out.println("Binary Tree Example");
    //System.out.println("Building tree with root value " + root.value);
    insert(root, 8);
    insert(root, 18);
    insert(root, 9);
    insert(root, 1);
  


    System.out.println("Traversing tree in order");

    predict(root);
    


  }

  public void insert(Node node, int value) {
    if (value < node.value) {
      if (node.left != null) {
        insert(node.left, value);
      } else {
          /*
        System.out.println("  Inserted " + value + " to left of "
            + node.value);*/
        node.left = new Node(value);
      }
    } else if (value > node.value) {
      if (node.right != null) {
        insert(node.right, value);
      } else {

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

int predict(Node node){

    if(node!=null){
    if(Math.abs(node.right.value-node.left.value)==node.value){

        predict(node.left);
        predict(node.right);

    }
    else{

        System.out.println("no child parent sum property exist");
    return 0;

    }}
    else{}


return 0;
}






  
}
