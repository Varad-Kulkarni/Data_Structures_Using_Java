class Custom_Heap{
    private int size;
    private int max_Size;
    private int heap[];
    private static final int front=1;

    public Custom_Heap(int max_Size){
        this.size=0;
        this.max_Size=max_Size;
        heap=new int[max_Size+1];
        heap[0]=Integer.MIN_VALUE;
    }

    private int parent(int pos){
        return pos/2;
    }

    private int left_Child(int pos){
        return pos*2;
    }

    private int right_Child(int pos){
        return (pos*2)+1;
    }

    private boolean is_Leaf(int pos){
        if(pos>(size/2) && pos<=size){
            return true;
        }
        return false;
    }

    private void swap(int pos1,int pos2){
        int temp=heap[pos1];
        heap[pos1]=heap[pos2];
        heap[pos2]=temp;
    }

    private void min_Heapify(int pos){
        if(!is_Leaf(pos)){
            if(heap[pos]>heap[left_Child(pos)] || heap[pos]>heap[right_Child(pos)]){
                swap(pos,left_Child(pos));
                min_Heapify(left_Child(pos));
            }
            else{
                swap(pos,right_Child(pos));
                min_Heapify(right_Child(pos));
            }
        }
    }

    public void put_Min(int data){
        if(size>=max_Size){
            return;
        }
        heap[++size]=data;
        int current_Pos=heap[size];
        while(heap[current_Pos]<heap[parent(current_Pos)]){
            swap(current_Pos,parent(current_Pos));
            current_Pos=parent(current_Pos);
        }
    }

    public void show(){
        for(int i=1;i<=size/2;i++){
            System.out.print("Parent: "+heap[i]+" | "+"Left-Child: "+heap[i*2]+" | "+"Right-Child: "+heap[(i*2)+1]);
            System.out.println();
        }
    }

    public int remove(){
        int element=heap[front];
        heap[front]=heap[size--];
        min_Heapify(front);
        return element;
    }
}


public class Heap_Tree {
    public static void main(String args[]){
        Custom_Heap h=new Custom_Heap(150);
        h.put_Min(22);
        h.put_Min(39);
        h.put_Min(76);
        h.put_Min(6);
        h.put_Min(9);
        h.put_Min(33);
        h.put_Min(34);
        h.put_Min(1);
        h.put_Min(100);
        h.put_Min(98);
        h.put_Min(11);
        h.put_Min(40);
        h.put_Min(25);
        h.put_Min(3);
        h.put_Min(3);
        h.show();

    }
}
