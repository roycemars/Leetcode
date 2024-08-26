public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}

        @Override
        public String toString() {
            return String.format("%s", val);
        }

        public static String printList(ListNode node) {
            String s = node.toString();
            node = node.next;
            while (node != null) {
                s += String.format("-> %s", node.toString());
                node = node.next;
            }
            return s;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));
        System.out.println(ListNode.printList(reverseList(head)));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode out = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = out;
            out = head;
            head = tmp;
        }

        return out;
    }
}
