package fr.uvsq.ibrahim.abdoulaye.metroParisien;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
/**
 * Write a description of class Dijktra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


// Algorithme de Dijkstra
public class Dijkstra {
    final MatriceChemins g; // le graphe de travail
    final ListeSommets listeSommet; // la liste des sommets
    final int n; // nombre de sommets de g
    public int source; // source du plus court chemin recherche
    public int dest; // destination du plus court chemin recherche
    public List<Integer> itineraire;
    int[] dist; // tableau des distance de la source à un sommet ***
    int[] pred; // tableau de pere ***
    boolean[] traiter; //  ***
    PriorityQueue<Noeud> nonTraiter;
    //int steps = 0;

    // constructeur
    public Dijkstra(MatriceChemins g, ListeSommets ls, int source, int   dest)
    {
        
        this.g = g;
        n = g.Taille;
        this.source = source;
        this.dest = dest;
        this.listeSommet = ls;
        dist = new int [n];
        pred = new int [n];
        itineraire = new ArrayList<Integer>();
        traiter = new boolean [n];
        for(int i=0; i<n; i++) {  // initialise les destance de la source au sommet i a infini 
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;// initialise tableau de pere à -1
            traiter[i] = false;//true si pas traité
        }
//        System.out.println(this.source);
        dist[this.source] = 0; // distance de la source à la source
        pred[this.source] = this.source; // source est sont propre père
        nonTraiter = new PriorityQueue<Noeud>();
        nonTraiter.add( new Noeud(this.source, 0) );
        //System.out.println(dist[this.dest]+" "+settled[this.dest]);
     }
     
    // mise a jour de la distance, de la priorite, et du predecesseur d'un sommet
    public void update(int y, int x)
    {
        //throw new Error("a completer");
        //if(settled[y])
        int distance = g.matrice[x][y].distance; 
        if( dist[y] > dist[x] + distance){
            dist[y] = dist[x] + distance;
            pred[y] = x;
            nonTraiter.add( new Noeud(y,dist[y]) );
        }
    }
    
    // trouve le prochain sommet de nonTraiter non traite
    public int nextNoeud()
    {
        
        while( !nonTraiter.isEmpty() ){
            Noeud n = nonTraiter.poll();
            if( !traiter[n.id] ){ //return false si pas traité
                return n.id;
            }
        }
        return -1;
    }
    
    // une etape de l'algorithme Dijkstra
    public int uneEtape()
    {
        
        int sommet = nextNoeud();
        if(sommet != -1){
            traiter[sommet] = true;
            for(int i=0; i<this.g.succ[sommet].size(); i++){
                update(this.g.succ[sommet].get(i), sommet);
            }
        }
        return sommet;
    }
    
    // algorithme de Dijkstra complet
    public int distancePlusCourtChemin()
    {
        //throw new Error("a completer");
        int sommet = source;
        //System.out.println("ici");
        while( sommet != dest && sommet != -1){//&& sommet != -1){
            //System.out.println("ici");
             sommet = uneEtape();
        }
        if(sommet == -1){
            return -1;
        }
        return dist[dest];
    }
    
    public void setSource(int source)
    {
        this.source = source;
    }
    
    public void setDest(int dest)
    {
        this.dest = dest;
    }
        
    
    
    public void itineraire()
    {
        //System.out.println(this.listeSommet.tabSommet[ this.pred[this.dest] ] );
        //ArrayList<Integer> itineraire = new ArrayList<Integer>();
        this.itineraire.add(this.dest);
        int id = this.pred[this.dest];
        //System.out.println(listeSommet.tabSommet[ this.dest ]);
        while(id != this.source)
        {
            
            this.itineraire.add(id);
            //System.out.println(listeSommet.tabSommet[ id ]);
            id = this.pred[id];
            
        //itineraire.add(this.source);
        //return itineraire;
       }
       itineraire.add(id);
       //return itineraire;
       //System.out.println(listeSommet.tabSommet[ id ]);
    }
    
    // A terminer
    public void afficher()
    {
        //System.out.print("ici");
        int sommet, sommet1,ligne,ligne1;
        ligne = 0;
        ListIterator<Integer> it = this.itineraire.listIterator(this.itineraire.size());
        while(it.hasPrevious())
        {
            sommet = it.previous();
            //sommet1 = it.previous();
            //ligne = g.matrice[sommet][sommet1].getLigne();
            if(sommet == this.source)
            {
                System.out.println("\nVous êtes à "+listeSommet.tabSommet[ sommet ]);
                sommet1 = it.previous();
                ligne = g.matrice[sommet][sommet1].getLigne();
                System.out.println("Prenez la ligne "+ligne+g.matrice[sommet][sommet1].getDirection());
                it.next();
            }
            else if(sommet == this.dest)
            {
                System.out.print("\nvous devriez arriver à"+ listeSommet.tabSommet[ sommet ]+" dans ");
            }
            
            else if(sommet != this.dest)
            {
                
                sommet1 = it.previous();
                ligne1 = g.matrice[sommet][sommet1].getLigne();
                if(ligne == ligne1 && !g.matrice[sommet][sommet1].getDirection().contains("Correspondance"))
                {
                    System.out.println("A"+listeSommet.tabSommet[ sommet ]+" continuer sur la ligne "+ligne1/*+"           "+g.matrice[sommet][sommet1].getDirection()*/);
                    ligne = ligne1;
                }
                
                else if(!g.matrice[sommet][sommet1].getDirection().contains("Correspondance"))
                {
                    System.out.println("\nA"+listeSommet.tabSommet[ sommet ]+" descendre et prendre la ligne "+ligne1+"  "+g.matrice[sommet][sommet1].getDirection());
                    ligne = ligne1;
                }
                    
                it.next();
                
            }
        }
    }
        
        
}
