package src.medium;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/sort-list/
 * @author: wqdong
 * @create: 2020-03-25 16:05
 **/
public class SortList {

  // Runtime: 11 ms, faster than 12.92% of Java online submissions for Sort List.
  public ListNode sortList(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    ListNode tempHead = head;

    while (tempHead != null) {
      if (treeMap.containsKey(tempHead.val)) {
        treeMap.put(tempHead.val, treeMap.get(tempHead.val) + 1);
      } else {
        treeMap.put(tempHead.val, 1);
      }
      tempHead = tempHead.next;
    }

    tempHead = new ListNode(0);
    head = tempHead;
    for (int val : treeMap.keySet()) {
      if (treeMap.get(val) > 1) {
        for (int i = 0; i < treeMap.get(val); i++) {
          tempHead.next = new ListNode(val);
          tempHead = tempHead.next;
        }
        continue;
      }
      tempHead.next = new ListNode(val);
      tempHead = tempHead.next;
    }

    return head.next;
  }

  // Runtime: 2 ms, faster than 99.36% of Java online submissions for Sort List.
  public ListNode sortList2(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    int size = 0;
    ListNode p = head;
    while (p != null) {
      size++;
      p = p.next;
    }

    int[] data = new int[size];
    p = head;
    int i = 0;
    while (p != null) {
      data[i++] = p.val;
      p = p.next;

    }

    Arrays.sort(data);

    head = new ListNode(0);
    p = head;
    for (i = 0; i < size; i++) {
      ListNode node = new ListNode(data[i]);
      p.next = node;
      p = node;
    }

    return head.next;

  }

}
