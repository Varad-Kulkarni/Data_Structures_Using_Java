class cnode {
    private int data;
    private cnode next;

    public cnode(int data) {
        this.data = data;
    }

    public int getcData() {
        return data;
    }

    public void setcData(int data) {
        this.data = data;
    }

    public cnode getcNext() {
        return next;
    }

    public void setcNext(cnode next) {
        this.next = next;
    }
}

class custom_C_List {
    private cnode head;
    private cnode tail;

    public custom_C_List() {
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(int data) {
        cnode new_Node = new cnode(data);
        if (isEmpty()) {
            head = new_Node;
        } else {
            tail.setcNext(new_Node);
        }
        tail = new_Node;
        new_Node.setcNext(head);
    }

    public void show() {
        cnode temp = head;
        System.out.print("[ ");
        do {
            System.out.print(temp.getcData() + " ");
            temp = temp.getcNext();
        } while (temp.getcNext() != head);
        System.out.print(temp.getcData() + " ]");
        System.out.println();
    }

    public void delete() {
        cnode temp = head;
        if (isEmpty()) {
            System.out.println("List UnderFlow");
        } else {
            while (temp.getcNext() != tail) {
                temp = temp.getcNext();
            }
            temp.setcNext(head);
            tail = temp;
        }
    }

    public boolean search(int data){
        if(isEmpty()){
            return false;
        }
        cnode temp=head;
        if(temp.getcData()==data){
            return true;
        }
        temp=temp.getcNext();
        while(temp.getcNext()!=head){
            if(temp.getcData()==data){
                return true;
            }
            temp=temp.getcNext();
        }
        if(temp.getcData()==data){
            return true;
        }
        return false;
    }

    /*
     * public void delete_At_First(){ if(isEmpty()){
     * System.out.println("List UnderFlow"); } else{ tail.setcNext(head.getcNext());
     * head.setcNext(null); } }
     * 
     * public void delete_At(int data){ cnode temp=head; if(isEmpty()){
     * System.out.println("List UnderFlow"); } else{ if(temp.getcData()==data){
     * delete_At_First(); break; } else if(tail.getcData()==data){ delete(); break;
     * } else{ temp=temp.getcNext(); while(temp.getcNext()!=head){
     * if(temp.getcNext().getcData()==data){
     * temp.setcNext(temp.getcNext().getcNext()); break; } temp=temp.getcNext(); } }
     * } }
     */
}

public class Circular_Linked_List {
    public static void main(String args[]) {
        custom_C_List ls = new custom_C_List();
        ls.insert(0);
        ls.insert(1);
        ls.insert(2);
        ls.insert(3);
        ls.insert(4);
        ls.insert(5);
        ls.insert(6);
        ls.show();
        ls.delete();
        ls.show();
        System.out.println(ls.search(3));
        System.out.println(ls.search(6));
        // ls.delete_At_First();
        // ls.show();
        // ls.delete_At(3);
        // ls.show();
    }
}
