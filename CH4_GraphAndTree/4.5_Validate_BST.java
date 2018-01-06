//implemente a function to check if a binary tree is a binary search tree;

//keep min and max and update

boolean checkBST(TreeNode n, Integer min, Integer max) {
    if (n == null) {
        return true;
    }
    if ((min != null && n.data <= min) || (max != null && n.data > max)) {
        return false;
    }
    if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
        return false;
    }
    return true;
}
