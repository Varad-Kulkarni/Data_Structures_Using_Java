class custom_Queues {
    private int size;
    private int rear;
    private int front;
    private int arr[];

    public custom_Queues(int size) {
        this.size = size;
        rear = 0;
        front = 0;
        arr = new int[size];
    }

    public boolean isFull() {
        return rear == size;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue OverFlow");
        } else {
            arr[rear] = data;
            rear++;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue UnderFlow");
        }
        for (int i = 0; i < rear - 1; i++) {
            arr[i] = arr[i + 1];
        }
        if (rear < size) {
            arr[rear] = 0;
        }
        rear--;
    }

    public void show() {
        if (isFull()) {
            System.out.println("Queue OverFlow");
        } else if (isEmpty()) {
            System.out.println("Queue UnderFlow");
        } else {
            System.out.print("{ ");
            for (int i = front; i < rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("}");
            System.out.println();
        }
    }

    public int peek() {
        if (isFull()) {
            System.out.println("Queue OverFlow");
            return -1;
        } else if (isEmpty() || rear < 0) {
            System.out.println("Queue UnderFlow");
            return -1;
        }
        return arr[rear - 1];
    }
}

public class Queues_Using_Arrays {
    public static void main(String args[]) {
        custom_Queues q = new custom_Queues(6);
        q.enqueue(0);
        q.show();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.show();
        q.dequeue();
        q.show();
        System.out.println(q.peek());
        q.dequeue();
        q.show();
        System.out.println(q.peek());
        q.dequeue();
        q.show();
        System.out.println(q.peek());
        q.dequeue();
        q.show();
        System.out.println(q.peek());
        q.dequeue();
        q.show();
        System.out.println(q.peek());
        q.dequeue();
        q.show();
        System.out.println(q.peek());
    }

}
