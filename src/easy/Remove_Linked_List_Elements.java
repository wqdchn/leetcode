package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/remove-linked-list-elements/
 * @author: wqdong
 * @create: 2019-11-06 19:58
 **/
public class Remove_Linked_List_Elements {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    //简单粗暴的链表生成方式
    ListNode head = createListNode();
    ListNode p = removeElements1(head, 3);
    while (p != null) {
      System.out.print(p.val + " ");
      p = p.next;
    }

    System.out.println();

    head = createListNode();
    p = removeElements2(head, 3);
    while (p != null) {
      System.out.print(p.val + " ");
      p = p.next;
    }
  }

  public static ListNode createListNode() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(3);
    return head;
  }

  public static ListNode removeElements1(ListNode head, int val) { // 遍历
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    ListNode prev = dummyHead;
    while (prev.next != null) {
      if (prev.next.val == val) {
        prev.next = prev.next.next;
      } else {
        prev = prev.next;
      }
    }
    return dummyHead.next;
  }

  public static ListNode removeElements2(ListNode head, int val) { // 递归
    if (head == null) {
      return null;
    }
    ListNode temp = removeElements2(head.next, val);
    if (head.val == val) {
      return temp;
    }
    head.next = temp;
    return head;
  }

}
