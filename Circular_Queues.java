class custom_C_Queues{
    int front,rear,size,arr[];

    public custom_C_Queues(int size){
        this.size=size;
        front=-1;
        rear=-1;
        arr=new int[size];
    }

    public boolean isEmpty(){
        return front==rear && rear==-1;
    }

    public boolean isFull(){
        return (rear+1)%size==front;
    }

    public void enqueue(int data){
        if(isEmpty()){
            front=0;
            rear=0;
            arr[rear]=data;
        }
        else if(isFull()){
            System.out.println("Queue OverFlow");
        }
        else{
            rear=(rear+1)%size;
            arr[rear]=data;
        }
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue UnderFlow");
        }
        else if(front==rear){
            front=-1;
            rear=-1;
        }
        else{
            front=(front+1)%size;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[front%size];
    }

    public void show(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        else{
            System.out.print("{ ");
            for(int i=front;i<=rear%size;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.print("}");
            System.out.println();
        }
    }
}


public class Circular_Queues {
    public static void main(String args[]){
        custom_C_Queues q = new custom_C_Queues(6);
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