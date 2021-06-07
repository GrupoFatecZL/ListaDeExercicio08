package controller;

import java.util.ArrayList;
import java.util.List;

public class Grafo_Geracao {

	public class Vertice {
	        String nome;
	        List<Aresta> adj;

	        Vertice(String nome) {
	            this.nome = nome;
	            this.adj = new ArrayList<Aresta>();
	        }

	        void addAdj(Aresta e) {
	            adj.add(e);
	        }
	    }

	    public class Aresta {
	        Vertice origem;
	        Vertice destino;

	        Aresta(Vertice origem, Vertice destino) {
	            this.origem = origem;
	            this.destino = destino;
	        }
	    }

	    List<Vertice> vertices;
	    List<Aresta> arestas;

	    public Grafo_Geracao() {
	        vertices = new ArrayList<Vertice>();
	        arestas = new ArrayList<Aresta>();
	    }

	    public Vertice addVertice(String nome) {
	        Vertice v = new Vertice(nome);
	        vertices.add(v);
	        return v;
	    }

	    public Aresta addAresta(Vertice origem, Vertice destino) {
	        Aresta e = new Aresta(origem, destino);
	        origem.addAdj(e);
	        arestas.add(e);
	        return e;
	    }

	    public String toString() {
	        String r = "";
	        for (Vertice u : vertices) {
	            r += u.nome + " -> ";
	            for (Aresta e : u.adj) {
	                Vertice v = e.destino;
	                r += v.nome + ", ";
	            }
	            r += "\n";
	        }
	        return r;
	    }
	
}
