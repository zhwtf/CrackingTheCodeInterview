/*
Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

*/

//method 1: depth first search
void createLevelLinkedList(Tree root, ArrayList<LinkedList<TreeNode>> lists, int level){
    if (root == null) {
        return;
    }//base case;

    LinkedList<TreeNode> list = null;
    if (lists.size() == level) { //level not contained in list;
        list = new LinkedList<TreeNode>();
        lists.add(list);
    } else {
        list = lists.get(level);
    }
    list.add(root);
    createLevelLinkedList(root.left, lists, level+1);
    createLevelLinkedList(root.right, lists, level+1);
}

ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
    ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
    createLevelLinkedList(root, lists, 0);
    return lists;
}

//method 2: breadth first search;
ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    if (root != null) {
        current.add(root);
    }
    while (current.size() > 0) {
        result.add(current); //add previous level;
        LinkedList<TreeNode> parents = current;
        current = new LinkedList<TreeNode>();
        for (TreeNode parent : parents) {
            //visit the children;
            if (parent.left != null) {
                current.add(parent.left);
            }
            if (parent.right != null) {
                current.add(parent.right);
            }
        }
    }
    return result;
}
