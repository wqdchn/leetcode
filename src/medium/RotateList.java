package src.medium;


/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/rotate-list/
 * @author: wqdong
 * @create: 2020-03-23 08:28
 **/

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

}

public class RotateList {

  // Runtime: 6 ms, faster than 8.17% of Java online submissions for Rotate List.
  public static ListNode rotateRight(ListNode head, int k) {

    if (head == null) {
      return null;
    }

    int length = 0;
    ListNode temp = head;

    while (temp != null) {
      length++;
      temp = temp.next;
    }

    k %= length;

    for (int i = 0; i < k; i++) {
      head = reverse(head, length);
    }

    return head;
  }

  private static ListNode reverse(ListNode head, int length) {
    head = reverseBetween(head, 1, length);
    head = reverseBetween(head, 2, length);
    return head;
  }

  private static ListNode reverseBetween(ListNode head, int begin, int end) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy, curr = head;

    int k = 1;
    while (curr.next != null && k != begin) {
      curr = curr.next;
      pre = pre.next;
      k++;
    }

    while (curr.next != null && k != end) {
      ListNode preNext = pre.next;
      pre.next = curr.next;
      ListNode temp = curr.next;
      curr.next = temp.next;
      temp.next = preNext;
      k++;
    }

    return dummy.next;
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
  public static ListNode rotateRight2(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode fast = dummy;
    ListNode slow = dummy;

    int length = 0;
    while (fast.next != null) {
      length++;
      fast = fast.next;
    }

    if (k % length == 0) {
      return head;
    }

    for (int i = length - k % length; i > 0; i--) {
      slow = slow.next;
    }

    fast.next = dummy.next;
    dummy.next = slow.next;
    slow.next = null;

    return dummy.next;
  }
}
