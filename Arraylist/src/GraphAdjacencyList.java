import java.util.*;

/**
 * Created by Sharath Nagendra on 8/31/2017.
 */
public class GraphAdjacencyList {

    private Map<Integer, List<Integer>> Adjacency_List;

    /*
     * Initializes the map to with size equal to number of vertices in a graph
     * Maps each vertex to a given List Object
     */
    public GraphAdjacencyList(int number_of_vertices) {
        Adjacency_List = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= number_of_vertices; i++) {
            Adjacency_List.put(i, new LinkedList<Integer>());
        }
    }


    /* Adds nodes in the Adjacency list for the corresponding vertex */
    public void setEdge(int source, int destination) {
        if (source > Adjacency_List.size() || destination > Adjacency_List.size()) {
            System.out.println("the vertex entered in not present ");
            return;
        }
        List<Integer> slist = Adjacency_List.get(source);
        slist.add(destination);
        List<Integer> dlist = Adjacency_List.get(destination);
        dlist.add(source);
    }

    /* Returns the List containing the vertex joining the source vertex */
    public List<Integer> getEdge(int source) {
        if (source > Adjacency_List.size()) {
            System.out.println("the vertex entered is not present");
            return null;
        }
        return Adjacency_List.get(source);
    }

    /*
     * Main Function reads ,e number of vertices and edges in a graph.
     * then creates a Adjacency List for the graph and prints it
     */
    public static void main(String... arg) {
        int source=0, destination=0;
        int number_of_edges, number_of_vertices;
        int count = 1;
            GraphAdjacencyList adjacencyList = null;


        // String[] input = {"employee_id,name,department",};
        Scanner scan = new Scanner(System.in);
        try {
             /* Read the number of vertices and edges in graph */
            System.out.println("Enter the number of vertices and edges in graph");
            number_of_vertices = scan.nextInt();
            number_of_edges = scan.nextInt();

            //friend matrix<source> <Destination>


            System.out.println("Enter the vertices");
                //for scanning the unordered vertices
                for (int x = 0; x < number_of_vertices; x++)

                    adjacencyList = new GraphAdjacencyList(scan.nextInt());
            
             /* Reads the edges present in the graph */
                System.out.println("Enter the edges in graph Format : <source index> <destination index>");
                while (count <= number_of_edges) {
                    source = scan.nextInt();
                    destination = scan.nextInt();
                    adjacencyList.setEdge(source, destination);
                    count++;
                }

             /* Prints the adjacency List representing the graph.*/
                System.out.println("the given Adjacency List for the graph \n");
                for (int i = 1; i <= number_of_vertices; i++) {
                    System.out.print(i + ":");
                    //if(adjacencyList.getEdge(i)==null)
                    //    System.out.println("none");
                    List<Integer> edgeList = adjacencyList.getEdge(i);
                    if (edgeList.size() == 0)
                        System.out.println("none");
                    for (int j = 1; j <= edgeList.size(); j++) {
                        if (j != edgeList.size()) {
                            System.out.print(edgeList.get(j - 1) + ",");
                        } else {
                            System.out.print(edgeList.get(j - 1));
                            break;
                        }
                    }
                    System.out.println();
                }
            }

        catch(InputMismatchException inputMismatch)
            {
                System.out.println("Error in Input Format. \nFormat : <source index> <destination index>");
            }
            scan.close();


    }
}
