class dnode {
    private int data;
    private dnode next;
    private dnode prev;

    public dnode(int data) {
        this.data = data;
    }

    public int getdData() {
        return data;
    }

    public void setdData(int data) {
        this.data = data;
    }

    public dnode getdNext() {
        return next;
    }

    public void setdNext(dnode next) {
        this.next = next;
    }

    public dnode getdPrev() {
        return prev;
    }

    public void setdPrev(dnode prev) {
        this.prev = prev;
    }
}

class custom_D_List {
    private dnode head;
    private dnode tail;

    public custom_D_List() {
    }

    public void insert_At_Head(int data) {
        dnode new_Node = new dnode(data);
        if (head == null) {
            tail = new_Node;
        } else {
            head.setdPrev(new_Node);
        }
        new_Node.setdNext(head);
        head = new_Node;
    }

    public void insert(int data) {
        dnode new_Node = new dnode(data);
        // dnode curr_Node = head;
        /*
         * if (head == null) { head.setdNext(new_Node); new_Node.setdPrev(null); } else
         * { while (curr_Node.getdNext() != null) { curr_Node = curr_Node.getdNext(); }
         * curr_Node.setdNext(new_Node); new_Node.setdPrev(new_Node);
         * new_Node.setdNext(null); }
         */
        tail.setdNext(new_Node);
        new_Node.setdPrev(tail);
        this.tail = new_Node;
    }

    public void insert_At(int index, int data) {
        dnode new_node = new dnode(data);
        dnode curr_Node = head;
        if (isEmpty()) {
            insert_At_Head(data);
        } else {
            for (int i = 0; i < index - 1; i++) {
                curr_Node = curr_Node.getdNext();
            }
            new_node.setdPrev(curr_Node);
            new_node.setdNext(curr_Node.getdNext());
            curr_Node.setdNext(new_node);
            new_node.getdNext().setdPrev(new_node);
        }
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public void show() {
        dnode curr_Node = head;
        if (isEmpty()) {
            System.out.println("List UnderFlow");
        } else {
            System.out.print("[");
            while (curr_Node.getdNext() != null) {
                System.out.print(curr_Node.getdData() + " ");
                curr_Node = curr_Node.getdNext();
            }
            System.out.print(curr_Node.getdData() + "]");
            System.out.println();
        }
    }

    public void delete_At_Head() {
        dnode temp_Node = head;
        this.head = temp_Node.getdNext();
        this.head.setdPrev(null);
    }

    public void delete() {
        dnode prev_Node = tail.getdPrev();
        prev_Node.setdNext(null);
        this.tail = prev_Node;
    }

    public void delete_At(int index) {
        dnode temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getdNext();
        }
        temp.setdNext(temp.getdNext().getdNext());
        temp.getdNext().setdPrev(temp);
    }
}

public class Doubly_Linked_List {
    public static void main(String args[]) {
        custom_D_List ls = new custom_D_List();
        ls.insert_At_Head(9);
        ls.show();
        ls.insert(7);
        ls.show();
        ls.insert_At_Head(4);
        ls.insert(5);
        ls.show();
        ls.insert_At(2, 2);
        ls.show();
        ls.delete_At_Head();
        ls.show();
        ls.delete();
        ls.show();
        ls.delete_At(1);
        ls.show();
    }

}
