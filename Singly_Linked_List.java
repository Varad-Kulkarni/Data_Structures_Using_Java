class node {
    private int data;
    private node next;

    public node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public node getNext() {
        return this.next;
    }

    public void setNext(node next) {
        this.next = next;
    }
}

class Custom_List {
    private node head;

    public Custom_List() {
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public void insert_At_Head(int data) {
        node new_Node = new node(data);
        new_Node.setNext(head);
        head = new_Node;
    }

    public void insert(int data) {
        node new_Node = new node(data);
        node curr_Node = head;
        if (head == null) {
            head = new_Node;
        } else {
            while (curr_Node.getNext() != null) {
                curr_Node = curr_Node.getNext();
            }
            curr_Node.setNext(new_Node);
            new_Node = null;
        }
    }

    public void insert_At(int index, int data) {
        node new_Node = new node(data);
        node curr_Node = head;
        for (int i = 0; i < index - 1; i++) {
            curr_Node = curr_Node.getNext();
        }
        new_Node.setNext(curr_Node.getNext());
        curr_Node.setNext(new_Node);
    }

    public void delete_At_Index(int index) {
        node curr_Node = head;
        for (int i = 0; i < index - 1; i++) {
            curr_Node = curr_Node.getNext();
        }
        curr_Node.setNext(curr_Node.getNext().getNext());
    }

    public void delete_At_Head(){
        node curr_Node=head;
        if(isEmpty()){
            System.out.println("List Underflow");
        }
        else if(curr_Node.getNext()==null){
            head=null;
        }
        else{
            if(curr_Node.getNext()!=null){
                //curr_Node=curr_Node.getNext().getNext();
                head=curr_Node.getNext();
            }
        }
    }

    public void show() {
        node curr_Node = head;
        System.out.print("[");
        while (curr_Node.getNext() != null) {
            System.out.print(curr_Node.getData() + " ");
            curr_Node = curr_Node.getNext();
        }
        System.out.print(curr_Node.getData() + "]");
        System.out.println();
    }

    /*public node reverse(){
        node current=head;
        node previous=null;
        node next_Node;

        while(current.getNext()!=null){
            next_Node=current.getNext();
            current.setNext(previous);
            previous=current;
            current=next_Node;
        }
        return previous;
    }

    public int max(){
        node curr_Node=head;
        int m=head.getData();
        while(curr_Node!=null){
            if(curr_Node.getData()>m){
                m=curr_Node.getData();
            }
            curr_Node=curr_Node.getNext();
        }
        //if(curr_Node.getData()>m){
        //    m=curr_Node.getData();
        //}
        return m;
    }

    public int min(){
        node curr_Node=head;
        int m=head.getData();
        while(curr_Node!=null){
            if(curr_Node.getData()<m){
                m=curr_Node.getData();
            }
            curr_Node=curr_Node.getNext();
        }
        //if(curr_Node.getData()<m){
        //    m=curr_Node.getData();
        //}
        return m;
    }*/
}

public class Singly_Linked_List {
    public static void main(String args[]) {
        Custom_List ls = new Custom_List();
        Custom_List lst = new Custom_List();

        lst.insert_At_Head(0);
        System.out.println(lst.isEmpty());
        lst.delete_At_Head();
        System.out.println(lst.isEmpty());
        lst.delete_At_Head();

        ls.insert(0);
        ls.insert(1);
        ls.insert_At_Head(3);
        ls.insert(4);
        ls.insert_At(2, 5);
        ls.show();

        ls.delete_At_Head();
        ls.delete_At_Index(2);
        ls.show();
        //System.out.println(ls.reverse());
        //ls.show();
        //System.out.println(ls.max());
        //System.out.println(ls.min());
    }
}
