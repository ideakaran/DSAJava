package oldpractice;

public class EvenOddNode {
    public static void main(String[] args) {
        EvenOddNode e = new EvenOddNode();
        ListNode output = e.oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        System.out.println(output);
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;

        while(evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = evenHead;
        return head;

    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "oldpractice.ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
