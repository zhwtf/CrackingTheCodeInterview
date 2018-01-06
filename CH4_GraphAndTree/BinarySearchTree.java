class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    //Constructor
    BinarySearchTree () {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    //A recursive function to insert a new key in BST;
    Node insertRec(Node root, int key) {
        //if the root is empty, just insert the new node;
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //recur down the tree;
        if (root.key > key) {
            root.left = insertRec(root.left, key);
        }else if (root.key < key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }
}
