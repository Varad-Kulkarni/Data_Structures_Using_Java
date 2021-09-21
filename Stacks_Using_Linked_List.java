class snode {
    private int data;
    private snode next;

    public snode(int data) {
        this.data = data;
    }

    public int getsData() {
        return data;
    }

    public void setsData(int data) {
        this.data = data;
    }

    public snode getsNext() {
        return next;
    }

    public void setsNext(snode next) {
        this.next = next;
    }
}

class custom_L_Stack {
    private snode top;
    private int len = 0;

    public custom_L_Stack() {
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public int size() {
        return len;
    }

    public void push(int data) {
        snode new_Node = new snode(data);
        new_Node.setsNext(top);
        top = new_Node;
        len++;
    }

    public void show() {
        snode temp = top;
        if (isEmpty()) {
            System.out.println("Stack UnderFlow");
        } else {
            System.out.print("{");
            while (temp.getsNext() != null) {
                System.out.print(temp.getsData() + " ");
                temp = temp.getsNext();
            }
            System.out.print(temp.getsData() + "}");
            System.out.println();
        }
    }

    public void pop() {
        // snode temp=top;
        if (isEmpty()) {
            System.out.println("Stack UnderFlow");
        } else {
            top = top.getsNext();
            // temp=null;
        }
        len--;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack UnderFlow");
            return -1;
        }
        return top.getsData();
    }    
}

public class Stacks_Using_Linked_List {
    public static void main(String args[]) {
        custom_L_Stack s = new custom_L_Stack();
        s.push(0);
        s.show();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.show();
        s.pop();
        s.show();
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        s.show();
        s.pop();
        System.out.println(s.peek());
        s.show();
        s.pop();
        System.out.println(s.peek());
        s.pop();
        s.show();
        System.out.println(s.peek());
        // System.out.println(s.size());
    }

}
