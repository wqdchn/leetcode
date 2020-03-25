package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @author: wqdong
 * @create: 2020-03-25 13:05
 **/
public class RemoveNthNodeFromEndOfList {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
  public ListNode removeNthFromEnd(ListNode head, int n) {

    if (head == null) {
      return null;
    }
    if (head.next == null && n == 1) {
      return null;
    }

    int length = 0;
    ListNode temp = head;
    while (temp != null) {
      length++;
      temp = temp.next;
    }

    if (length == n) {
      return head.next;
    }

    temp = head;
    for (int i = 1; i < length - n; i++) {
      temp = temp.next;
    }

    temp.next = temp.next.next;

    return head;
  }

}
