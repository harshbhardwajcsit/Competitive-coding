
package path_btw_nodes;

import java.util.ArrayList;
import java.util.List;
public class Path_btw_nodes {


 public static void main(String[] args) {
    new Path_btw_nodes().run();
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

List<Integer> list1=new ArrayList<Integer>();
List<Integer> list2=new ArrayList<Integer>();

  //run

  public void run() {
    // build the simple tree from chapter 11.
    Node root = new Node(8);

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
   System.out.print("list1: "+list1);
   System.out.print("list2: "+list2);

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

 System.out.println("Lowest common ancestor : "+node.value); // get lowest common ancestor

 tracePath1(node,a);
 tracePath2(node,b);                     //call trace path find the path between two nodes
 }





 }

 void tracePath1(Node node,int x){
     if(node.value>x){
         list1.add(node.value);
     tracePath1(node.left, x);}
      if(node.value<x){
         list1.add(node.value);
     tracePath1(node.right, x);}
   if(node.value==x){list1.add(node.value);
   }

 }
  void tracePath2(Node node,int x){
       if(node.value>x){
         list2.add(node.value);
     tracePath1(node.left, x);}
      if(node.value<x){
         list2.add(node.value);
     tracePath1(node.right, x);}
   if(node.value==x){
       list2.add(node.value);
   }


 }


 }



