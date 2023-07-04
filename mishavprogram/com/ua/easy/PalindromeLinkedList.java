package mishavprogram.com.ua.easy;

public class PalindromeLinkedList {

    public class ListNode {
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
    }

    public boolean isPalindrome(ListNode head) {
        ListNode currentNode = head;
        StringBuilder original = new StringBuilder();

        while (currentNode.next != null) {
            original.append(currentNode.val);
            currentNode = currentNode.next;
        }
        original.append(currentNode.val);

        StringBuilder reversed = new StringBuilder(original).reverse();

        String originalStr = original.toString();
        String reversedStr = reversed.toString();

        return originalStr.equals(reversedStr);
    }

    public static void main(String[] args) {
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode head = p.createLinkedList(new int[]{1, 2, 3, 4, 3, 2, 1});
        p.printLinkedList(head);

        System.out.print("is palindrome ?   ");
        System.out.println(p.isPalindrome(head));
    }

    public ListNode createLinkedList(int[] args) {
        ListNode head = null;
        ListNode node = new ListNode();
        head = node;

        for (int i = 0; i <= args.length - 2; i++) {
            node.val = args[i];
            node.next = new ListNode(args[i + 1]);
            node = node.next;
        }
        node.next = null;

        return head;
    }

    public void printLinkedList(ListNode head) {
        System.out.println();

        ListNode node = head;
        while (node.next != null) {
            System.out.print(node.val);
            System.out.print(", ");
            node = node.next;
        }
        System.out.print(node.val);
        System.out.println(".");
    }
}
