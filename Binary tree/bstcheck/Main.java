/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bstcheck;
class Node
{
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

class BSTcheck
{
    // Root of Binary Tree
   static Node root;

    BSTcheck()
    {
        root = null;
    }

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    void printPostorder(Node node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder()  {     printPostorder(root);  }
    void printInorder()    {     printInorder(root);   }
    void printPreorder()   {     printPreorder(root);  }

    // Driver method
    public static void main(String[] args)
    {
        BSTcheck tree = new BSTcheck();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(4);
          tree.root.right.left = new Node(9);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
        System.out.println("Check for bst ");
        System.out.print(tree.BST(root));

    }
int result=1;
int BST(Node node){

if(node!=null){
    System.out.println("for node " + node.key);
if(node.left!=null&&node.right!=null){
if(node.left.key<node.key&&node.right.key>node.key){
     System.out.println("for node " + node.key);
      System.out.println("result is  " + result);
    BST(node.left);BST(node.right);}
else{result=0;}
}
if(node.left==null&&node.right==null){ System.out.println("stop");}
if(node.left!=null&&node.right==null){if(node.left.key<node.key){BST(node.left);}else{result=0;}}
if(node.right!=null&&node.left==null){if(node.right.key>node.key){BST(node.right);}else{result=0;}}
}

return result;
}




}



