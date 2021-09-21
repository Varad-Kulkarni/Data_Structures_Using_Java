//import java.io.*;

class Linked_List_Operations{
    node head;

    static class node{
        int data;
        node next;

        node(int d){
            data=d;
            next=null;
        }
    }

    public static Linked_List_Operations insert(Linked_List_Operations ls,int data){
        node new_node=new node(data);
        new_node.next=null;

        if(ls.head==null){
            ls.head=new_node;
        }
        else{
            node last=ls.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=new_node;
        }
        return ls;
    }

    public static void printList(Linked_List_Operations ls){
        node curr_node=ls.head;
        System.out.print("[ ");

        while(curr_node!=null){
            System.out.print(curr_node.data+" ");
            curr_node=curr_node.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public static Linked_List_Operations deleteByKey(Linked_List_Operations ls,int key){
        node curr_node=ls.head;
        node prev=null;

        if(curr_node!=null && curr_node.data==key){
            ls.head=curr_node.next;
            return ls;
        }
        else{
            while(curr_node!=null && curr_node.data!=key){
                prev=curr_node;
                curr_node=curr_node.next;
            }
            if(curr_node!=null){
                prev.next=curr_node.next;
            }
            if(curr_node==null){
                System.out.println("Key not found");
            }
            return ls;
        }
    }
    public static void main(String args[]){
        Linked_List_Operations ls=new Linked_List_Operations();
        ls=insert(ls,2);
        ls=insert(ls,3);
        ls=insert(ls,4);
        ls=insert(ls,5);
        ls=insert(ls,6);
        ls=insert(ls,7);
        printList(ls);
        deleteByKey(ls,4);
        deleteByKey(ls,1);
        printList(ls);
    }
}

