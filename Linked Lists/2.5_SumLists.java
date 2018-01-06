//sum two lists

LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
    if (l1 == null && l2 == null && carry == 0) {
        return null;
    }

    LinkedListNode node = new LinkedListNode();
    int sum = carry;

    if (l1 != null) {
        sum += l1.value;
    }
    if (l2 != null) {
        sum += l2.value;
    }

    node.value = sum%10;

    if (l1 != null || l2 != null) {
        LinkedListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum >=
                                        10 ? 1 : 0);
        node.next = more;
    }
    return node;










}
