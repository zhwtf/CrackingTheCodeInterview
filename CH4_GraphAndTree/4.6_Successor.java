//consider two cases
//case 1: has right subtree;
//case 2: no right subtree;

TreeNode inorderSucc(TreeNode n) {
    if (n == null) {
        return null;
    }

    //Found right subtree, return the leftmost node of the right subtree;
    if (n.right != null) {
        return leftMostChild(n.right);
    } else {
        TreeNode q = n;
        TreeNode x = q.parent;
        while (x != null && x.left != q) {
            q = x;
            x = q.parent;
        }
        return x;
    }
}

TreeNode leftMostChild(TreeNode n) {
    if (n == null) {
        return null;
    }

    while (n.left != null) {
        n = n.left;
    }
    return n;
}
