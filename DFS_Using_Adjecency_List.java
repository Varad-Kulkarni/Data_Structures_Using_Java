import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class custom_DFS_Graph{
    private List<List<Integer>> ls;
    private boolean visited[];

    public custom_DFS_Graph(int index){
        ls=new ArrayList<>();
        visited=new boolean[index];

        for(int i=0;i<index;i++){
            ls.add(i,new ArrayList<>());
        }
    }

    public void addEdge(int a,int b){
        ls.get(a).add(b);
        ls.get(b).add(a);
    }

    public void dfs(int start){
        Stack<Integer> s=new Stack<>();
        s.push(start);
        visited[start]=true;
        while(!s.isEmpty()){
            Integer node=s.pop();
            System.out.print(node+" ");
            List<Integer> neighbours=ls.get(node);
            for(Integer n:neighbours){
                if(!visited[n]){
                    s.push(n);
                    visited[n]=true;
                }
            }
        }
    }
}

public class DFS_Using_Adjecency_List {

    public static void main(String[] args) {
        int nodes = 7;

        custom_DFS_Graph a = new custom_DFS_Graph(nodes);

        a.addEdge(0, 1);
        a.addEdge(0, 2);
        a.addEdge(1, 3);
        a.addEdge(2, 4);
        a.addEdge(3, 5);
        a.addEdge(4, 5);
        a.addEdge(4, 6);

        a.dfs(0);
    }

}