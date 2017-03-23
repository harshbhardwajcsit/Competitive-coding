/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package levelordertraversal;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TopLevelAttribute;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;



public class LevelOrderTraversal {


     public static void main(String[] args) {
    new LevelOrderTraversal().run();
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

Stack stack=new Stack();
Queue queue=new Queue() {

        public boolean add(Object e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean offer(Object e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Object remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Object poll() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Object element() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Object peek() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public int size() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean isEmpty() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean contains(Object o) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Iterator iterator() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Object[] toArray(Object[] a) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean remove(Object o) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean containsAll(Collection c) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean addAll(Collection c) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean removeAll(Collection c) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public boolean retainAll(Collection c) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void clear() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    };
  int hieght=0;
  public void run() {
    // build the simple tree from chapter 11.
    Node root = new Node(7);
    //System.out.println("Binary Tree Example");
    //System.out.println("Building tree with root value " + root.value);
    insert(root, 5);
    insert(root, 8);
    insert(root, 4);
    insert(root, 6);
    insert(root, 11);
    insert(root, 10);
    insert(root, 14);


    System.out.println("Traversing tree in order");
    queue.add(root);
    function1();
    System.out.print("hieght = "+hieght);


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



int function1(){
    if(queue.size()==0){return 0;}
    else{
    while(queue.size()!=0){

        stack.push(queue.remove());

    }
    function2();
    return 0;
    }



}


int function2(){

    if(queue.size()==0){
     hieght++;
    }
    while(stack.size()!=0){

        Node node=(Node) stack.pop();
          if(node.left!=null){
          queue.add(node.left);}
          if(node.right!=null)
          {queue.add(node.right);}

    }
   function1();
   return 0;

}

}
