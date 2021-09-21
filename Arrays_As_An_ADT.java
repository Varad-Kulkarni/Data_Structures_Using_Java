//import java.util.Scanner;

class MyArray {
    /*public void setVal(int arr[], int size) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
    }*/

    public void show(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void insert(int arr[], int size, int val, int capacity, int index) {
        if (index >= capacity) {
            return;
        } else {
            for (int i = size - 1; i >= index; i--) {
                arr[i + 1] = arr[i];
            }
            arr[index] = val;
        }
    }

    public void delete(int arr[], int size, int index) {
        if (index > size) {
            return;
        } else {
            for (int i = index; i < size; i++) {
                arr[i] = arr[i + 1];
            }
        }
    }

    public boolean linear_Search(int arr[], int size, int val) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == val) {
                return true;
            }
        }
        return false;
    }

    public boolean binary_Search(int arr[], int size, int val) {
        int low, mid, high;
        low = 0;
        high = size - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == val) {
                return true;
            }
            if (arr[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public int min(int arr[], int size) {
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] < m) {
                m = arr[i];
            }
        }
        return m;
    }

    public int max(int arr[], int size) {
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;
    }
}

class Arrays_As_An_ADT {
    public static void main(String args[]) {
        // int arr[]=new int[5];
        int a[] = new int[10];
        for (int i = 0; i < 5; i++) {
            a[i] = i;
        }
        MyArray m = new MyArray();
        // m.setVal(arr,5);
        // m.show(arr,5);
        m.show(a, 5);
        m.insert(a, 5, 10, 10, 3);
        m.show(a, 6);
        m.delete(a, 6, 1);
        m.show(a, 5);
        System.out.println(m.linear_Search(a,5,10));
        System.out.println(m.linear_Search(a,5,11));
        int vrr[]={1,2,3,4,5,6,7,8};
        System.out.println(m.binary_Search(vrr, 8, 3));
        System.out.println(m.binary_Search(vrr, 8, 11));
        System.out.println(m.min(a, 5));
        System.out.println(m.max(a, 5));
    }
}
