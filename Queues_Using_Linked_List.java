class qnode {
    private int data;
    private qnode next;

    public qnode(int data) {
        this.data = data;
    }

    public int getsData() {
        return data;
    }

    public void setsData(int data) {
        this.data = data;
    }

    public qnode getsNext() {
        return next;
    }

    public void setsNext(qnode next) {
        this.next = next;
    }
}

class custom_L_Queue {
    private qnode front;
    private qnode rear;
    private int len = 0;

    public custom_L_Queue() {
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return len;
    }

    public void enqueue(int data) {
        qnode new_Node = new qnode(data);
        if (isEmpty()) {
            front = new_Node;
            rear = new_Node;
        } else {
            // qnode temp=rear;
            rear.setsNext(new_Node);
            rear = new_Node;
        }
        len++;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("Queue UnderFlow");
        } else {
            System.out.print("{");
            qnode temp = front;
            while (temp.getsNext() != null) {
                System.out.print(temp.getsData() + " ");
                temp = temp.getsNext();
            }
            System.out.print(temp.getsData() + "}");
            System.out.println();
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue UnderFlow");
        } else {
            front = front.getsNext();
        }
        len--;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return front.getsData();
    }
}

public class Queues_Using_Linked_List {
    public static void main(String args[]) {
        custom_L_Queue q = new custom_L_Queue();
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
