ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
    ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();

    if (node == null) {
        result.add(new LinkedList<Integer>());
        return result;
    }

    LinkedList<Integer> prefix = new LinkedList<Integer>();
    prefix.add(node.data);

    //Recurse on left and right subtrees.
    ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
    ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

    //Weave together each list from the left and right sides
    for (LinkedList<Integer> left : leftSeq) {
        for (LinkedList<Integer> right : rightSeq) {
            ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
            weaveLists(left, right, weaved, prefix);
            result.addAll(weaved);
        }
    }
    return result;
}

//Weave lists together in all possible ways. This algorithm works by removing
//the head from one list, recursing, and then doing the same thing with the
//other list
void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
    // if one list is empty, add remainder to a cloned prefix and store result
    if (first.size() == 0 || second.size() == 0) {
        LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
        result.addAll(first);
        result.addAll(second);
        results.add(result);
        return;
    }

    //Recurse with head of first added to the prefix. Removing the head will
    //damage first, so we'll need to put it back where we found it afterwards
    int headfirst = first.removeFirst();
    prefix.addLast(headfirst);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    first.addFirst(headfirst);

    //Do the same thing with second
    int headsecond = second.removeFirst();
    prefix.addLast(headsecond);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    second.addFirst(headsecond);
    
}
