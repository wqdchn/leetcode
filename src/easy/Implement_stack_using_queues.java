package src.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/implement-stack-using-queues/
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 * @author: wqdong
 * @create: 2019-08-10 15:02
 **/
public class Implement_stack_using_queues {

    Queue<Integer> q;

    public static void main(String[] args){
        Implement_stack_using_queues q = new Implement_stack_using_queues();

        q.push(1);
        q.push(2);

        q.pop();

        q.push(3);
        q.push(4);

        q.pop();

        System.out.println(q.top());
    }

    /** Initialize your data structure here. */
    public Implement_stack_using_queues() {
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 1; i < q.size(); i++){
            q.offer(q.poll());
        }
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        for (int i = 1; i < q.size(); i++){
            q.offer(q.poll());
        }
        int top = q.peek();
        q.offer(q.poll());
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
