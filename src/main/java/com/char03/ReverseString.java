package main.java.com.char03;

public class ReverseString {
    public static void reverseString(char[] s) {
        if(s == null || s.length < 2){
            return;
        }
        process(s,0,s.length - 1);
    }

    private static void process(char[] s, int l, int r){
        if(l >= r){
            return;
        }
        swap(s,l,r);
        process(s,l + 1,r - 1);
    }

    public static void swap(char[] arr,int i ,int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        char[] s = new char[] {'h','e','l','l','o','1'};
        reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
    }

    public  void reverseString2(char[] s) {
        for (int head = 0, tail = s.length - 1; head < tail; head++,tail--) {
            char tmp = s[head];
            s[head] = s[tail];
            s[tail] = tmp;
        }
    }
}
