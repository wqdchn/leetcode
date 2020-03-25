package src.easy;

import src.easy.Reverse_Linked_List.ListNode;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/middle-of-the-linked-list/
 * @author: wqdong
 * @create: 2020-03-25 12:37
 **/
public class MiddleOfTheLinkedList {

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

}
