package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/swap-nodes-in-pairs/
 * @author: wqdong
 * @create: 2019-08-05 14:43
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 **/
public class Swap_nodes_in_pairs {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }

    public static void main(String[] args){

        //简单粗暴的链表生成方式
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        //两两逆序
        ListNode p = swapPairs(head);
        System.out.println("\n下面打印的是两两逆序后的链表");

        //打印链表
        while (p != null){
            System.out.print(p.val + " ");
            p = p.next;
        }

    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode temp = head.next;
        head.next = head.next.next;

        temp.next = head;
        head = temp;

        head.next.next = swapPairs(head.next.next);

        return head;
    }
}
