package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * @author: wqdong
 * @create: 2020-01-20 10:42
 **/
public class remove_duplicates_from_sorted_list {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(-1);
    head.next = new ListNode(0);
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(0);
    head.next.next.next.next = new ListNode(3);

    head = deleteDuplicates(head);
    while (head != null){
      System.out.print(head.val + " ");
      head = head.next;
    }
  }

  // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
  public static ListNode deleteDuplicates(ListNode head) {
    ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
    dummyHead.next = head;
    ListNode prev = dummyHead;
    while (prev.next != null){
      if (prev.next.val == prev.val){
        prev.next = prev.next.next;
      }else {
        prev = prev.next;
      }
    }
    return dummyHead.next;
  }
}
