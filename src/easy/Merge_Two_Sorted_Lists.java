package src.easy;

/**
 * @program: leetcode
 * @description: ${description}
 * @author: wqdong
 * @create: 2019-11-01 11:22
 **/
public class Merge_Two_Sorted_Lists {

  //Definition for singly-linked list.
  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static ListNode createList() {
    //简单粗暴的链表生成方式
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    return head;
  }


  public static void main(String[] args) {
    ListNode l1 = createList();
    ListNode l2 = createList();

    // solution 1
    ListNode merge_l = mergeTwoLists(l1, l2);
    while (merge_l != null) {
      System.out.print(merge_l.val);
      merge_l = merge_l.next;
    }

    // solution 2
    l1 = createList();
    l2 = createList();
    merge_l = mergeTwoLists2(l1, l2);
    while (merge_l != null) {
      System.out.print(merge_l.val);
      merge_l = merge_l.next;
    }
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return l2 == null ? l1 : l2;
    }
    ListNode dummpy = (l1.val < l2.val) ? l1 : l2;
    dummpy.next = mergeTwoLists2(dummpy.next, dummpy == l1 ? l2 : l1);
    return dummpy;
  }
}
