package main.java.com.char02;

public class ArrayStack {
    private int size ;
    private int index;
    private int[] arr;
    public ArrayStack(int size){
        arr = new int[size];
        this.size = size;
        index = 0;
    }

    public boolean isEmpty(){
        return index == 0;
    }

    public boolean isFull(){
        return index == size;
    }

    public void push(int value) {
        if(isFull()){
          throw new RuntimeException("stack is full");
        }
        arr[index++] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        int ans = arr[--index];
        return ans;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
