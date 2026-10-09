/* int arraylist representation
from scratch exercise
 */

import java.util.Arrays;

public class IntArrayList {
    private int[] arr; // array holds data
    private int length; // how much of the array is occupied
    // length is index of where the next item goes
    public IntArrayList() {
        arr = new int[4];
        length = 0;
    }

    public void add(int x) {
        int[] b = null;
        // are we out of space and do we need to make a new array
        if(arr.length == length) {
            b = new int[arr.length * 2];
            for(int i = 0; i < arr.length; i++) {
                b[i] = arr[i];
            }
        }
        arr[length] = x;
        length++;
        arr = b;
    }

    public int get(int i) {
        if(i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        return arr[i];
    }

    public void set(int index, int value) {
        if(index - 1 > length) {
            throw new IllegalArgumentException("non valid index");
        }
        arr[index] = value;
    }

    public int size() {
        return length;
    }

    public String toString() {
        return("Int Array List:" + Arrays.toString(arr) + "length = " + length);
    }

    public static void main(String[] args) {
        IntArrayList ial = new IntArrayList();
        ial.add(1);
        System.out.println(ial);

        for(int n = 1000; n < 10_000_000; n = n * 2) {
            IntArrayList l = new IntArrayList();
            long start = System.currentTimeMillis();
            for(int i = 1; i <= n; i++) {
                l.add(i);
            }
            long end = System.currentTimeMillis();
            long time = start - end;
            System.out.println(time);
        }
    }
}