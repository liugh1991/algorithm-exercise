package main.java.com.char03;

/**
 * https://leetcode.cn/problems/linked-list-cycle/description/
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null &&  fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
