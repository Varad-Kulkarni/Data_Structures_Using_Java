class bnode{
    private int data;
    private bnode right;
    private bnode left;

    public bnode(int data){
        this.data=data;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data=data;
    }

    public bnode getRight(){
        return right;
    }

    public void setRight(bnode right){
        this.right=right;
    }

    public bnode getLeft(){
        return left;
    }

    public void setLeft(bnode left){
        this.left=left;
    }
}

class custom_Tree{
    public custom_Tree(){}

    public bnode insert(bnode root,int data){
        if(root==null){
            root=new bnode(data);
        }
        else{
            if(root.getData()<data){
                root.setRight(insert(root.getRight(),data));
            }
            else if(root.getData()>data){
                root.setLeft(insert(root.getLeft(),data));
            }
        }
        return root;
    }

    //Traversals from here

    public void preOrder(bnode root){
        if(root!=null){
            System.out.print(root.getData()+" ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public void inOrder(bnode root){
        if(root!=null){
            inOrder(root.getLeft());
            System.out.print(root.getData()+" ");
            inOrder(root.getRight());
        }
    }

    public void postOrder(bnode root){
        if(root!=null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData()+" ");
        }
    }

    // Traversal ends
    // Searching starts

    public boolean search(bnode root,int data){
        if(root==null){
            return false;
        }
        while(root!=null){
            if(root.getData()==data){
                return true;
            }
            else if(root.getData()<data){
                root=root.getRight();
            }
            else{
                root=root.getLeft();
            }
        }
        return false;
    }

    //Searching ends
    //finding max ans min in binary search tree

    public bnode max(bnode root){
        if(root==null){
            return null;
        }
        while(root.getLeft()!=null){
            root=root.getLeft();
        }
        return root;
    }

    public bnode min(bnode root){
        if(root==null){
            return null;
        }
        while(root.getRight()!=null){
            root=root.getRight();
        }
        return root;
    }
}    

public class Binary_Search_Tree {
    public static void main(String args[]){
        custom_Tree t=new custom_Tree();
        bnode root=new bnode(11);
        t.insert(root,5);
        t.insert(root,7);
        t.insert(root,9);
        t.insert(root,8);
        t.insert(root,10);
        t.insert(root,13);
        t.insert(root,4);
        t.insert(root,12);
        t.insert(root,20);
        System.out.print("[ ");
        t.preOrder(root);
        System.out.print("]");
        System.out.println();
        System.out.print("[ ");
        t.inOrder(root);
        System.out.print("]");
        System.out.println();
        System.out.print("[ ");
        t.postOrder(root);
        System.out.print("]");
        System.out.println();
        System.out.println(t.min(root).getData());
        System.out.println(t.max(root).getData());

        /*  ____11_____
           |           |
          _5_         _13_
         |   |       |    |
         4   7       12   20
          ___|
         |   |
         8   9
             |
             10               */
    }
}
