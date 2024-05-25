package ads;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "DeansOffice");
        outputPath(djk, "Canteen");

        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);
        System.out.println(" ");
        System.out.println("Depth First Search.:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "DeansOffice");
        outputPath(dfs, "Canteen");
        System.out.println(" ");
        System.out.println("Breadth First Search:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "DeansOffice");
        outputPath(bfs, "Canteen");
    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("DeansOffice", "OpenSpace");
        graph.addEdge("DeansOffice", "Library");
        graph.addEdge("OpenSpace", "Library");
        graph.addEdge("Library", "AssemblyHall");
        graph.addEdge("AssemblyHall", "Atrium");
        graph.addEdge("Library", "Atrium");
        graph.addEdge("Atrium", "Canteen");
        graph.addEdge("Library", "Canteen");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("DeansOffice", "OpenSpace", 3);
        graph.addEdge("Deans.Office", "Library", 8);
        graph.addEdge("OpenSpace", "Library", 4);
        graph.addEdge("Library", "AssemblyHall", 2);
        graph.addEdge("AssemblyHall", "Atrium", 4);
        graph.addEdge("Library", "Atrium", 6);
        graph.addEdge("Atrium", "Canteen", 6);
        graph.addEdge("Library", "Canteen", 12);
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -------> ");
        }
        System.out.println();
    }
}