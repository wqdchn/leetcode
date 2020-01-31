package src.easy;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/intersection-of-two-linked-lists/
 * @author: wqdong
 * @create: 2020-01-31 09:11
 **/
public class intersection_of_two_linked_list {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static void main(String[] args) {

    ListNode rs = new ListNode(8);

    ListNode a = new ListNode(4);
    a.next = new ListNode(1);
    a.next.next = rs;
    a.next.next.next = new ListNode(4);
    a.next.next.next.next = new ListNode(5);

    ListNode b = new ListNode(5);
    b.next = new ListNode(0);
    b.next.next = new ListNode(1);
    b.next.next.next = rs;
    b.next.next.next.next = new ListNode(4);
    b.next.next.next.next.next = new ListNode(5);

    ListNode result = getIntersectionNode(a, b);
    if (result != null) {
      System.out.println(result.val);
    }

    result = getIntersectionNode2(a, b);
    if (result != null) {
      System.out.println(result.val);
    }
  }

  // Runtime: 2 ms, faster than 36.39% of Java online submissions for Intersection of Two Linked Lists.
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    ListNode a = headA;
    ListNode b = headB;

    while (a != b) {
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
    }

    return a;
  }

  // Runtime: 10 ms, faster than 11.80% of Java online submissions for Intersection of Two Linked Lists.
  public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    HashSet<ListNode> set = new HashSet<>();

    while (headA != null || headB != null) {
      if (headA != null) {
        if (set.contains(headA)) {
          return headA;
        } else {
          set.add(headA);
        }
        headA = headA.next;
      }
      if (headB != null) {
        if (set.contains(headB)) {
          return headB;
        } else {
          set.add(headB);
        }
        headB = headB.next;
      }
    }
    return null;
  }
}
