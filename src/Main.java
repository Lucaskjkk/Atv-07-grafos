import java.util.List;
public class Main {
    public static void main(String[] args) {
        
        Grafo grafo = new Grafo(false);

        
        grafo.adicionarVertice("A");
        grafo.adicionarVertice("B");
        grafo.adicionarVertice("C");
        grafo.adicionarVertice("D");
        grafo.adicionarVertice("E");

        
        grafo.adicionarAresta("A", "B");
        grafo.adicionarAresta("A", "C");
        grafo.adicionarAresta("B", "D");
        grafo.adicionarAresta("C", "E");

        
        List<String> ordem = grafo.dfs("A");
        System.out.println("Ordem de visitação DFS: " + ordem);
    }
}
