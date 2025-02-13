public class testInterOuvert {
    
 public static void main(String args[]){
    interOuvert intervalle =new interOuvert(2, 3);
    intervalle.estVide();
    intervalle.estDans(100);
    intervalle.contient(new interOuvert(50, 90) ) ;
    intervalle.intersection(new interOuvert(2,60 ));
    interFerme fermer =new interFerme(23, 30);
    fermer.intersection(new interFerme(20,40 ));
   
 }

}
