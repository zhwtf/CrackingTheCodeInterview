//method 1 : reverse and compare

boolean isPalindrome(LinkedListNode head) {
    LinkedListNode reversed = reverseAndClone(head);
    return isEqual(head, reversed);
}

LinkedListNode reverseAndClone(LinkedListNode head) {
    LinkedListNode node = head;
    head = null;
    while(node != null) {
        LinkedListNode hold = new LinkedListNode(node.data);
        hold.next = head;
        head = hold;
        node = node.next;
    }
    return head;
}

boolean isEqual(LinkedListNode one, LinkedListNode two) {
    while (one != null && two != null) {
        if (one.data != two.data) {
            return false;
        }
        one = one.next;
        two = two.next;
    }
    return one == null && two == null;
}
