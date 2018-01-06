//method 1: with links to parents;

TreeNode commonAncestor(TreeNode p, TreeNode q) {
    int delta = depth(p) - depth(q); //get difference of depths
    TreeNode first = delta > 0 ? q : p //get shallower node;
    TreeNode second = delta > 0 ? p : q // get deeper node;

    second = goUpBy(second, Math.abs(delta));

    //find the intersection
    while (first != second && first != null && second != null) {
        first = first.parent;
        second = second.parent;
    }

    return first == null || second == null ? null : first;
}

int depth(TreeNode n) {
    int d = 0;
    while (n != null) {
        d++;
        n = n.parent;
    }
    return d;
}

TreeNode goUpBy(TreeNode n, int delta) {
    while (n != null && delta > 0) {
        n = n.parent;
        delta--;
    }
    return n;
}
