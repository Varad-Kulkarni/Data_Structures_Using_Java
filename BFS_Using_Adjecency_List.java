import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

class custom_Queue_For_Adjls {
    private List<List<Integer>> ls;
    private boolean visited[];

    public custom_Queue_For_Adjls(int max) {
        ls = new ArrayList<>();
        visited = new boolean[max];
        for (int i = 0; i < max; i++) {
            ls.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {
        ls.get(a).add(b);
        ls.get(b).add(a);
    }

    public void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            System.out.print(node + " ");
            List<Integer> neighbour = ls.get(node);
            for (Integer n : neighbour) {
                if (!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
    }
}

public class BFS_Using_Adjecency_List {
    public static void main(String args[]) {
        custom_Queue_For_Adjls g = new custom_Queue_For_Adjls(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 3);
        System.out.println("BFS Visits:- ");
        g.bfs(0);
    }
}
