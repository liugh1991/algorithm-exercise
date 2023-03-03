package main.java.com.char03;

public class ReverseLinkedList {
    public static class LinkedList{
        int val;
        LinkedList next;

        public LinkedList(int value){
            this.val = value;
        }
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList next = null;
        LinkedList pre = null;
        while(head != null){
             next = head.next;
             head.next = pre;
             pre = head;
             head = next;
        }
        return  pre;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(2);
        LinkedList list2 = new LinkedList(3);
        LinkedList list3 = new LinkedList(4);
        LinkedList list4= new LinkedList(5);
        LinkedList list5 = new LinkedList(6);
        list1.next = list2;
        list1.next.next = list3;
        list1.next.next.next = list4;
        list1.next.next.next.next = list5;
        LinkedList head1 = list1;
        LinkedList head2 = list1;
        while(head1 != null){
            System.out.println(head1.val);
            head1 = head1.next;
        }
        LinkedList head3 = reverseLinkedList(head2);
        System.out.println("---------------------------");
        while(head3 != null){
            System.out.println(head3.val);
            head3 = head3.next;
        }
    }
}
