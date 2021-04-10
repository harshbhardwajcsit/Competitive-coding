import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathBtwNodes {
    // Returns true if there is a path from root
    // to the given node. It also populates
    // 'arr' with the given path
    public static boolean hasPath(Node root, ArrayList<Integer> arr, int x) {
        // if root is NULL
        // there is no path
        if (root == null)
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
    public static List<Integer> PathRootToNode(Node root, int x) {
        // ArrayList to store the path
        ArrayList<Integer> arr = new ArrayList<>();

        // if required node 'x' is present
        // then print the path
        if (hasPath(root, arr, x)) {
            return arr;
        }

        // 'x' is not present in the binary tree
        else
            return Collections.emptyList();
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<Integer> arr1 = PathRootToNode(root, 5);
        List<Integer> arr2 = PathRootToNode(root, 4);
        PathBtwNodes(arr1, arr2);
    }

    public static void PathBtwNodes(List<Integer> l1, List<Integer> l2) {
        List path = Collections.EMPTY_LIST;
        int lca = 0;
        for (int i = l1.size() - 1; i >= 0; i--) {
            if (!l2.contains(l1.get(i))) {
                path.add(l1.get(i));
            }
            lca = l1.get(i);
            break;
        }
        path.addAll(l2.subList(l2.indexOf(lca), l2.size() - 1));
        System.out.println(path);
    }
}
