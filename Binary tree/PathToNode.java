import java.util.ArrayList;
// Java implementation to print the path from root
// to a given node in a binary tree

/**
 *                  1
 *                /   \
 *               2     3
 *              / \   /  \
 *             4   5  6   7
 *
 *                x = 5
 *
 * Output : 1->2->5
 */
public class PathToNode {

    // Returns true if there is a path from root
    // to the given node. It also populates
    // 'arr' with the given path
    public static boolean hasPath(Node root, ArrayList<Integer> arr, int x)
    {
        // if root is NULL
        // there is no path
        if (root==null)
            return false;

        // push the node's value in 'arr'
        arr.add(root.data);

        // if it is the required node
        // return true
        if (root.data == x)
            return true;

        // else check whether the required node lies
        // in the left subtree or right subtree of
        // the current node
        if (hasPath(root.left, arr, x) ||
                hasPath(root.right, arr, x))
            return true;

        // required node does not lie either in the
        // left or right subtree of the current node
        // Thus, remove current node's value from
        // 'arr'and then return false
//        arr.remove(arr.size()-1);
        return false;
    }

    // function to print the path from root to the
    // given node if the node lies in the binary tree
    public static void printPath(Node root, int x)
    {
        // ArrayList to store the path
        ArrayList<Integer> arr=new ArrayList<>();

        // if required node 'x' is present
        // then print the path
        if (hasPath(root, arr, x))
        {
            for (int i=0; i<arr.size()-1; i++)
                System.out.print(arr.get(i)+"->");
            System.out.print(arr.get(arr.size() - 1));
        }

        // 'x' is not present in the binary tree
        else
            System.out.print("No Path");
    }

    public static void main(String args[]) {
        Node root=new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int x=5;
        printPath(root, x);
    }
}

// A node of binary tree
class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data=data;
        left=right=null;
    }
};

