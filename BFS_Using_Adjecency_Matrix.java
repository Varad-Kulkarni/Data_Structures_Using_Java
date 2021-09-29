import java.util.Queue;
import java.util.LinkedList;

class BVertex {
    public char bvertex;
    public boolean wasVisited;

    public BVertex(char label) {
        bvertex = label;
        wasVisited = false;
    }
}

class BFS_Custom_Graph {
    private BVertex vList[];
    private int adjMat[][];
    private int nVerts;
    private final int maxIndex = 20;
    private Queue<Integer> q;

    public BFS_Custom_Graph() {
        nVerts = 0;
        adjMat = new int[maxIndex][maxIndex];
        vList = new BVertex[maxIndex];
        q = new LinkedList<Integer>();
    }

    public void addVertex(char lab) {
        vList[nVerts++] = new BVertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int lab) {
        System.out.print(vList[lab].bvertex+" ");
    }

    public int get_Unvisited_Adj_Vertex(int lab) {
        for (int i = 0; i < nVerts; i++) {
            if (vList[i].wasVisited == false && adjMat[lab][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public void bfs() {
        vList[0].wasVisited = true;
        displayVertex(0);
        q.add(0);
        int v2;
        while (!q.isEmpty()) {
            int v1 = q.remove();
            while ((v2 = get_Unvisited_Adj_Vertex(v1)) != -1) {
                vList[v2].wasVisited = true;
                displayVertex(v2);
                q.add(v2);
            }
        }
    }
}

public class BFS_Using_Adjecency_Matrix {
    public static void main(String args[]) {
        BFS_Custom_Graph g = new BFS_Custom_Graph();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 3);
        System.out.println("BFS Visits:- ");
        g.bfs();
    }
}
