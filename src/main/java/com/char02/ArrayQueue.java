package main.java.com.char02;

public class ArrayQueue {
    private int head ;
    private int tail ;
    private int size;
    private int[] arr;

    public ArrayQueue(int size){
        this.size = size;
        arr = new int[size];
        head = 0;
        tail = 0;
    }

    public boolean isEmpty(){
        return head == tail;
    }

    public boolean isFull(){
        return tail - head == size;
    }

    public void add(int value){
        if(tail == size){
            if(head == 0) throw new RuntimeException("queue is full");
            for (int i = head; i < tail; i++) {
                arr[i - head] = arr[i];
            }
            head = 0;
            tail -= head;
        } else{
            arr[tail++] = value;
        }
    }

    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        int ans = arr[head++];
        return ans;
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        queue.add(4);
        queue.add(5);
        System.out.println(queue.poll());
        queue.add(7);
        queue.add(8);
        queue.add(6);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
