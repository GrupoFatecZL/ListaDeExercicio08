package view;

import controller.Grafo_Geracao;
import controller.Grafo_Geracao.Aresta;
import controller.Grafo_Geracao.Vertice;

public class Main_grafo {

	public static void main(String[] args) {
		
			Grafo_Geracao g = new Grafo_Geracao();
	        Vertice s = g.addVertice("s");
	        Vertice t = g.addVertice("t");
	        Vertice y = g.addVertice("y");
	        Aresta st = g.addAresta(s, t);
	        Aresta sy = g.addAresta(s, y);
	        Aresta ty = g.addAresta(t, y);
	        Aresta yt = g.addAresta(y, t);
	        System.out.println(g);
		
		
	}

}
