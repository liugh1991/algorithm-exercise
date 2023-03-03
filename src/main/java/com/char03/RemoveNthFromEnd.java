package main.java.com.char03;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 * 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {
    /**
     * 最简单的方法，先求长度L，然后遍历到 L-N + 1节点
     * @param head
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head,int n){
        ListNode dummy = new ListNode(0,head);
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        head = dummy;
        for (int i = 1; i < length - n + 1 ; i++) {
            head = head.next;
        }
        head.next =  head.next.next;
        return dummy.next;
    }

    /**
     * 遍历一遍，将节点压入栈中，然后弹出 n 个,栈顶元素就是要删除节点的前驱节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head,int n){
        ListNode dummy = new ListNode(0,head);
        Stack<ListNode> stack = new Stack<>();
        ListNode pre = dummy;
        while(pre != null){
            stack.push(pre);
            pre = pre.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        pre = stack.peek();
        pre.next = pre.next.next;
        return dummy.next;
    }

    /**
     * 利用双指针，first在secend的前面，间隔 n-1 个节点，当first 走到表尾的时候，secend刚好走到n
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd3(ListNode head,int n){
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode sec = dummy;
        for (int i = 1; i < n; i++) {
            first = first.next;
        }
        while(first.next != null ){
            first = first.next;
            sec = sec.next;
        }
        sec.next = sec.next.next;
        return dummy.next;
    }



}
