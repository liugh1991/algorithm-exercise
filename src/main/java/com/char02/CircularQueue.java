package main.java.com.char02;

public class CircularQueue {
    private int size ;
    private int head;
    private int tail;
    private String[] arr;
    public CircularQueue(int capacity){
        this.size = capacity;
        arr = new String[capacity];
        head = tail = 0;
    }

    public boolean add(String str){
        if(isFull()){//队列满了
            return false;
        }
        arr[tail] = str;
        tail = (tail + 1) % size;
        return true;
    }

    public String poll(){
        if(isEmpty()) return null;
        String ans = arr[head];
        head = (head + 1) % size;
        return ans;
    }
    public boolean isEmpty(){
        return tail == head;
    }
    public boolean isFull(){
        return (tail + 1) % size == head;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(10);
        for (int i = 0; i < 10; i++) {
            queue.add(String.valueOf(i));
        }
        for (int i = 0; i < 5; i++) {
           queue.poll();
        }
        for (int i = 10; i < 20; i++) {
            queue.add(String.valueOf(i));
        }
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
