/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lowestcommomancestor;

/**
 *
 * @author samsung
 */
public class LowestCommomAncestor {


 public static void main(String[] args) {
    new LowestCommomAncestor().run();
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

  public void run() {
    // build the simple tree from chapter 11.
    Node root = new Node(8);
    //System.out.println("Binary Tree Example");
    //System.out.println("Building tree with root value " + root.value);
    insert(root, 5);
    insert(root, 10);
    insert(root, 9);
    insert(root, 13);
    insert(root, 15);
    insert(root, 7);
    insert(root, 3);
    insert(root, 2);
    insert(root, 4);
    insert(root, 6);

   findAncestor(root, 12, 15);

/*


     System.out.println("After mirror image");
     mirror_image(root);
     printInOrder(root);

*/

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
          /*
        System.out.println("  Inserted " + value + " to right of "
            + node.value);  */
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



 void findAncestor(Node node, int a, int b){

 if(node.value<a&&node.value<b){findAncestor(node.right, a, b);}
 if(node.value>a&&node.value>b){findAncestor(node.left, a, b);}
 if(node.value>=a&&node.value<=b||node.value<=a&&node.value>=b){

 System.out.println("Lowest common ancestor : "+node.value);

 }





 }

}
