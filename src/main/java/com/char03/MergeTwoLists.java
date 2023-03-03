package main.java.com.char03;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 * 合并两个有序链表
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 1){
            return null;
        }
        ListNode cur = lists[0];
        for(int i = 1; i < lists.length; i++){
            cur = mergeTwoLists(cur,lists[i]);
        }
        return cur;
    }
}
