package src.easy;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/linked-list-cycle/
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list,
 *
 * we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to.
 *
 * If pos is -1, then there is no cycle in the linked list.
 * @author: wqdong
 * @create: 2019-08-06 13:53
 **/
public class Linked_list_cycle {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args){

        //简单粗暴的链表生成方式
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next;

        //1->2->3->4->5->指针回头指向3

        if (hasCycle(head) == true){
            System.out.println("链表有环！");
        }else{
            System.out.println("链表无环！");
        }

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
