package oldpractice;

public class RemoveLLElement {

    public static void main(String[] args) {
        RemoveLLElement e = new RemoveLLElement();
        ListNode output = e.removeElements(new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7))))), 7);
        System.out.println(output);
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }

        ListNode current = new ListNode(-1, head);
        head = current;
        while(current.next != null) {
            if(current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head.next;

    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "oldpractice.ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}

