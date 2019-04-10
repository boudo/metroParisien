package fr.uvsq.ibrahim.abdoulaye.metroParisien;
/**
 * Write a description of class Noeud here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
// Noeud d'un graphe
public class Noeud implements Comparable {

  final int id; // identifiant
  final int val; // valeur

  // constructeur
  Noeud(int i, int v){
    id = i;
    val = v;
  }

  // fonction de comparaison
  public int compareTo(Object o1) {
    Noeud n = (Noeud) o1;
    if (this.val == n.val) return (this.id - n.id);
    return this.val - n.val;
  }
}