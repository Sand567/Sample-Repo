/**
 * Created by Sharath Nagendra on 8/27/2017.
 */
public class graphCycle {

    int V,E;
    Edge edge[];

    class Edge{
        int src,dest;
    }

    graphCycle(int v,int e){
        V=v;
        E=e;
        edge = new Edge[E];
        for(int i=0;i<e;i++){
            edge[i] = new Edge();

        }
    }


    static int find(int parent[], int i)
    {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    static void Union(int parent[], int x, int y)
    {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public static int isCycle(graphCycle graph){
        int parent[] = new int[graph.V];
        for(int i=0;i<parent.length;i++)
            parent[i] = -1;

        for(int i=0;i<graph.E;i++){
            int x = find(parent, graph.edge[i].src);
            int y = find(parent,graph.edge[i].dest);

            if(x==y)
                return 1;
            Union(parent, x,y);

        }
        return 0;
    }


    public static void main(String[] args) {
        int V=3,E=3;
        graphCycle graph = new graphCycle(V,E);

        //edge 0->1
        graph.edge[0].src=0;
        graph.edge[0].dest=1;

        //edge 1->2
        graph.edge[1].src=1;
        graph.edge[1].dest=2;

        //edge 0->2
//        graph.edge[0].src=0;
//        graph.edge[0].dest=2;


        if(isCycle(graph)==1){
            System.out.println("cycle present");
        }
        else
            System.out.println("No cycle");
    }
}
