package fr.uvsq.ibrahim.abdoulaye.metroParisien;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class MatriceChemins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MatriceChemins
{
    public  Chemin [][] matrice;
    public  int Taille;
    public ArrayList<Integer>[] succ; // successeurs de chaque sommet
    //final protected ArrayList<Integer>[] pred; // predecesseurs de chaque sommet
    
    

    /**
     * Constructor for objects of class MatriceChemins
     */
//    @SuppressWarnings("unchecked")
	public MatriceChemins(int taille)
    {
        
        matrice = new Chemin [taille][taille];
        Taille =taille;
        this.succ = new ArrayList[taille];
        //this.pred = new ArrayList[taille];
        
        for (int k = 0; k < taille; k++) {
			succ[k] = new ArrayList<Integer>();
			//pred[k] = new ArrayList<Integer>();
		}
    }
    
    public void initialiser()
    {
        for(int i=0; i<this.Taille; i++)
        {
            for(int j=0; j<this.Taille;j++){
                this.matrice[i][j] = new Chemin();
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public  void remplireMatrice(String monFichier) throws IOException, NoSuchElementException, NullPointerException
    {
        
        String index;
        int distance, id1, id2;
        int ligne;
        String direction;
        
        try( FileInputStream fs = new FileInputStream (new File(monFichier));
                Scanner scanner = new Scanner(fs))
        {
             
            while(scanner.hasNextLine())
            {
                index = scanner.next();
            
                if(index.equals("#") ||index.equals("V") )
                {
                    scanner.nextLine();
                }
                
                else if(index.equals("E"))
                {
                     id1 = scanner.nextInt();
                     id2 = scanner.nextInt();
                     distance = scanner.nextInt();
                     ligne = scanner.nextInt();
                     direction = scanner.nextLine();
                     
                     /*matrice[id1][id2]=new Chemin();
                     matrice[id1][id2].id1 = id1;
                     matrice[id1][id2].id2 = id2;
                     matrice[id1][id2].distance = distance;
                     matrice[id1][id2].ligne = ligne;
                     matrice[id1][id2].direction = direction;*/
                     matrice[id1][id2]= new Chemin(distance, ligne, direction);
                     succ[id1].add(id2);
                     //System.out.println(id1+" "+id2+" "+distance+" "+ligne+" "+direction);
                     //System.out.println(matrice[id1][id2].affichage()); // test
                    
                }
              
                
            }
            fs.close();
            scanner.close();
           
        }
        
            
    }
}
