package main.java.com.char02;

public class CircularQueue2 {
    private int capatity;
    private int size;
    private int tail ;
    private int head;
    private String[] arr;
    public CircularQueue2(int capatity){
        this.capatity = capatity;
        arr = new String[capatity];
        head = tail = size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capatity;
    }

    public boolean add(String str){
        if(isFull()) return false;
        tail = tail == capatity ? 0 : tail;
        arr[tail++] = str;
        size++;
        return true;
    }

    public String poll (){
        if(isEmpty()) return null;
        head = head == capatity ? 0 : head;
        String ans = arr[head++];
        size--;
        return ans;
    }


    public static void main(String[] args) {
        CircularQueue2 queue = new CircularQueue2(10);
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
