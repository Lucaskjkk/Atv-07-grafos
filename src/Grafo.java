//Escolhemos o DFS como algorítimo 

import java.util.*;

public class Grafo {
    private Vector<Vertice> vertices;
    private Vector<Aresta> arestas;
    private boolean ehDigrafo;

    public Grafo(boolean digrafo) {
        vertices = new Vector<>();
        arestas = new Vector<>();
        ehDigrafo = digrafo;
    }


    public void adicionarVertice(String nome) {
        vertices.add(new Vertice(nome));
    }


    public void adicionarAresta(String nomeOrigem, String nomeDestino) {
        Vertice origem = buscarVertice(nomeOrigem);
        Vertice destino = buscarVertice(nomeDestino);

        if (origem != null && destino != null) {
            arestas.add(new Aresta(origem, destino));
            if (!ehDigrafo) {
                arestas.add(new Aresta(destino, origem)); 
            }
        }
    }

    private Vertice buscarVertice(String nome) {
        for (Vertice v : vertices) {
            if (v.getNome().equals(nome)) {
                return v;
            }
        }
        return null;
    }


    public List<String> dfs(String nomeVerticeInicial) {
        Vertice inicial = buscarVertice(nomeVerticeInicial);
        List<String> ordemVisita = new ArrayList<>();
        if (inicial == null) {
            return ordemVisita; 
        }


        Set<Vertice> visitados = new HashSet<>();

        dfsRecursivo(inicial, visitados, ordemVisita);
        return ordemVisita;
    }


    private void dfsRecursivo(Vertice vertice, Set<Vertice> visitados, List<String> ordemVisita) {

        visitados.add(vertice);
        ordemVisita.add(vertice.getNome());


        for (Aresta aresta : arestas) {
            if (aresta.getOrigem().equals(vertice) && !visitados.contains(aresta.getDestino())) {
                dfsRecursivo(aresta.getDestino(), visitados, ordemVisita);
            }
        }
    }


    public void imprimir() {
        for (Vertice v : vertices) {
            System.out.println("Vértice: " + v.getNome());
            for (Aresta aresta : arestas) {
                if (aresta.getOrigem().equals(v)) {
                    System.out.println("   Aresta para: " + aresta.getDestino().getNome());
                }
            }
        }
    }
}
