class custom_Stack {
    private int size;
    private int arr[];
    private int top;

    public custom_Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack OverFlow");
        } else {
            arr[++top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack UnderFlow");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (isFull()) {
            System.out.println("Stack OverFlow");
            return -1;
        } else if (isEmpty()) {
            System.out.println("Stack UnderFlow");
            return -1;
        }
        return arr[top];
    }

    public void show() {
        if (isFull()) {
            System.out.println("Stack OverFlow");
        } else if (isEmpty()) {
            System.out.println("Stack UnderFlow");
        } else {
            System.out.print("{ ");
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("}");
            System.out.println();
        }
    }
}

public class Stacks_Using_Arrays {
    public static void main(String args[]) {
        custom_Stack s = new custom_Stack(6);
        s.push(0);
        s.show();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.show();
        System.out.println(s.peek());
        s.pop();
        s.show();
        System.out.println(s.peek());
        s.pop();
        s.show();
        System.out.println(s.peek());
        s.pop();
        s.show();
        System.out.println(s.peek());
        s.pop();
        s.show();
        System.out.println(s.peek());
        s.pop();
        s.show();
        System.out.println(s.peek());
        s.pop();
        s.show();

    }
}
