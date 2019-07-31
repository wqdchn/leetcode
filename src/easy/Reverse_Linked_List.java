package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/reverse-linked-list/
 * @author: wqdong
 * @create: 2019-07-31 20:21
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 **/

//Definition for singly-linked list.

public class Reverse_Linked_List {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }

    public static ListNode reverseList(ListNode head) {
        ListNode re_head = null;
        for (ListNode curr = head; curr != null; ){
            ListNode temp = curr.next;
            curr.next = re_head;
            re_head = curr;
            curr = temp;
        }
        return re_head;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next ==null) return head;
        ListNode re_head = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return re_head;
    }

    public static void main(String[] args){
        //简单粗暴的链表生成方式
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        //打印链表
//        while (head != null){
//            System.out.print(head.val + " ");
//            head = head.next;
//        }

        //逆序
        ListNode p = reverseList2(head);
        System.out.println("\n下面打印的是逆序后的链表");

        //打印链表
        while (p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
