
package main.java.com.char02;

public class ArrayHeap {
    private int index ;
    private final int size;
    private int[] array;

    public  ArrayHeap(int size){
        array = new int[size];
        this.size = size;
        this.index = 0;
    }

    public void push(int num) throws Exception{
        if(index == size ){
            throw new Exception("the heap is full");
        }
        array[index] = num;
        heapInset(array,index++);
    }

    public void heapInset(int[] arr,int index){
        while (array[index] > array[(index - 1) / 2]) {
            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return size == index;
    }
    //每次弹出最大值
    public int pop(){
        int ans = array[0];
        swap(array,0,--index);
        heapify(array,0,index);
        return ans;
    }

    private void heapify(int[] array, int index, int heapSize) {
        int left = index * 2 + 1;
        //如果有左孩子
        while(left < heapSize){
            int max = left + 1 < heapSize && array[left + 1] > array[left] ? left + 1 : left;
            max = array[index] > array[max] ? index : max;
            if(index == max){
                return;
            }
            swap(array,index,max);
            index = max;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) throws Exception {
        int value = 1000;
        int limit = 100;
        int testTimes  = 10000;
        for (int i = 0; i < testTimes; i++) {
          int curLimit =   (int) (Math.random() * limit) + 1;
          ArrayHeap arrayHeap = new ArrayHeap(curLimit);
          RightMaxHeap rightMaxHeap = new RightMaxHeap(curLimit);
          int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if(arrayHeap.isEmpty() != rightMaxHeap.isEmpty()){
                    System.out.println("Oops");
                }
                if(arrayHeap.isFull() != rightMaxHeap.isFull()){
                    System.out.println("Oops");
                }
                if(arrayHeap.isEmpty()){
                    int curValue = (int)(Math.random() * value) + 1;
                    arrayHeap.push(curValue);
                    rightMaxHeap.push(curValue);
                } else if(arrayHeap.isFull()){
                    if(arrayHeap.pop() != rightMaxHeap.pop()){
                        System.out.println("Oops");
                    }
                } else{
                    if(Math.random() > 0.5){
                        int curValue = (int)(Math.random() * value) + 1;
                        arrayHeap.push(curValue);
                        rightMaxHeap.push(curValue);
                    } else {
                        if(arrayHeap.pop() != rightMaxHeap.pop()){
                            System.out.println("Oops");
                        }
                    }
                }
            }
        }
        System.out.println("sussess!");
    }

    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }

    }

}
