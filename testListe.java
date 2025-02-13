public class testListe{
    public static void main(String args[]){
     Liste liste= new Liste("bonjour");
     liste.Append(new Liste("hello"));
     liste.Append(new Liste("ELHADJI"));
     liste.afficherListeAvant();
     Liste trier =liste.Quicksort(liste);
     liste.afficherListeApres(trier);
    }
    
}
