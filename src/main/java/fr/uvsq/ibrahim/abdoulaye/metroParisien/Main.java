package fr.uvsq.ibrahim.abdoulaye.metroParisien;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Décrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Main
{
    public static void copieTableau( int []tabSource, int []tabDest)
    {
        for(int i=0; i< tabSource.length; i++)
        {
            tabDest[i]= tabSource[i];
        }
    }
    
    public static int distanceMin(Dijkstra d, ListeSommets ls, MatriceChemins matrice)
    {
        //d = new Dijkstra(matrice, ls.source[0], ls.destination[0]);
        int disMin = d.distancePlusCourtChemin();
        int distance = 2;
        for(int i=0; i<ls.nbSource; i++)
        {
            if(ls.source[i] == -1 )
                {
                    return disMin;
                }
            //System.out.println("ici");
            for(int j=0; j<ls.nbDest; j++)
            {
                if(ls.destination[i] == -1 )
                {
                    break;
                }
                //System.out.println("ici");
                Dijkstra newd = new Dijkstra(matrice,  ls, ls.source[i], ls.destination[j]);
                distance = newd.distancePlusCourtChemin();
                if(disMin > distance)
                {
                    disMin = distance;
                    copieTableau(newd.pred,d.pred);
                    d.setSource(ls.source[i]);
                    d.setDest(ls.destination[j]);
                }
            }
        }
        return disMin;
    }
    
    
    
    public static void main(String[] args)
    {
    	Scanner _sc = new Scanner(System.in);
    	String fichier = args[0];
        ListeSommets ls;
        ls = new ListeSommets(383);
        MatriceChemins matrice;
        Dijkstra d;
        int disMin = Integer.MAX_VALUE;

        // A terminer
        // test
        try{
            matrice = new MatriceChemins(383);
            matrice.initialiser();
            matrice.remplireMatrice(fichier);
            ls.remplireTableauSommet(fichier);
           
            System.out.println("\nSation de depart: ");
            ls.idenSource(_sc.nextLine());
            System.out.println("Sation d'Arrivee: ");
            ls.idenDestination(_sc.nextLine());
            //ls.idenDestination("La Motte Picquet, Grenelle");
           
            d = new Dijkstra(matrice, ls, ls.source[0], ls.destination[0]);
            
            disMin = distanceMin(d,ls, matrice);
            
            d.itineraire();// obtenir l'itineraire
            //itineraire = d.itineraire();
            //System.out.println(d.itineraire);
            d.afficher();
            System.out.println(disMin/60 + " min "+ disMin%60 + " s");
            
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch(NoSuchElementException t)
        {
            System.out.println(t.getMessage());
        }
        _sc.close();
    }
}
