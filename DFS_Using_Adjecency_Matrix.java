import java.util.Stack;

class Vertex {
    char label;
    boolean was_Visited;

    public Vertex(char lab) {
        label = lab;
        was_Visited = false;
    }
}

class Graph_dfs_mat {
    private Vertex vertexList[];
    private int adjMat[][];
    private final int max_Verts = 20;
    private Stack<Integer> s;
    private int nVerts;

    public Graph_dfs_mat() {
        vertexList = new Vertex[max_Verts];
        adjMat = new int[max_Verts][max_Verts];
        s = new Stack<Integer>();
        nVerts = 0;
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void printVertx(int v) {
        System.out.print(vertexList[v].label + " ");
    }

    public int get_Unvisited_Adj_Vertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (vertexList[i].was_Visited == false && adjMat[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public void dfs() {
        vertexList[0].was_Visited = true;
        printVertx(0);
        s.push(0);
        while (!s.isEmpty()) {
            int v = get_Unvisited_Adj_Vertex(s.peek());
            if (v == -1) {
                s.pop();
            } else {
                vertexList[v].was_Visited = true;
                printVertx(v);
                s.push(v);
            }
        }
    }
}

public class DFS_Using_Adjecency_Matrix {
    public static void main(String args[]) {
        Graph_dfs_mat g = new Graph_dfs_mat();
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
        System.out.println("DFS Visits:- ");
        g.dfs();
    }
}
