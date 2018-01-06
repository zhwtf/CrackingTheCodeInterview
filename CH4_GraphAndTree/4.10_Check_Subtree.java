boolean containsTree(TreeNode t1, TreeNode t2) {
    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();

    getOrderString(t1, s1);
    getOrderString(t2, s2);

    return s1.indexOf(s2.toString()) != -1;
}

void getOrderString(TreeNode t, StringBuilder s) {
    // pre-order traversal
    if (t == null) {
        s.append("X");
        return;
    }

    s.append(t.data + " ");  //add root;
    getOrderString(t.left, s);
    getOrderString(t.right, s);
}
