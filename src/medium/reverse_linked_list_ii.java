package src.medium;

import java.util.List;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/reverse-linked-list-ii/
 * @author: wqdong
 * @create: 2020-02-16 09:30
 **/
public class reverse_linked_list_ii {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
  public static ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy, curr = head;

    int k = 1;
    while (curr.next != null && k != m) {
      curr = curr.next;
      pre = pre.next;
      k++;
    }
    // after first while loop:
    // dummy(0)-> 1 - 2 - 3 - 4 - 5; k = 2, m = 2, n = 4
    // pre = 1, curr = 2, curr mean that m_node of linkedlist

    while (curr.next != null && k != n) {
      ListNode preNext = pre.next;
      pre.next = curr.next;
      ListNode temp = curr.next;
      curr.next = temp.next;
      temp.next = preNext;
      k++;
    }

    // after second while loop:
    // dummy(0)-> 1 - 4 - 3 - 2 - 5; k = 4, m = 2, n = 4
    // pre = 1, curr = 2, curr mean that m_node of linkedlist

    return dummy.next;
  }

  public static ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode re_head = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return re_head;
  }

  public static void main(String[] args) {
    //简单粗暴的链表生成方式
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    //打印链表
    ListNode phead = head;
    while (phead != null) {
      System.out.print(phead.val + " ");
      phead = phead.next;
    }

    //逆序
    ListNode p = reverseBetween(head, 2, 4);
    System.out.println("\n下面打印的是逆序后的链表");

    //打印链表
    while (p != null) {
      System.out.print(p.val + " ");
      p = p.next;
    }
  }

}
