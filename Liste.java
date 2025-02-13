public class Liste{
    private String value;
    private Liste next;

    public Liste(String valeur ){
        this.value=valeur;
        this.next=null;
    }
    public Liste(String valeur,Liste suite){
        this.value=valeur;
        this.next=suite;
    }

    public String Getvaleur(){
        return value;
    }
    public Liste Getsuite(){
        return next;
    }
    public void setnext(Liste suite){
        this.next=suite;
    }
    

    public Liste Quicksort (Liste liste ){

    if(liste==null ||liste.next==null)
     return liste;
     
     String p =liste.value;
     Liste current=liste.next;
     Liste premiereliste=null;
     Liste deuxiemeliste=null;
    while(current!=null){
        if(current.value.compareTo(p)<0){
        premiereliste=new Liste(current.value,premiereliste);
        }
        else if(current.value.compareTo(p)>0){
            deuxiemeliste=new Liste(current.value,deuxiemeliste);
        }
        current=current.next;
        
     }
    premiereliste=Quicksort(premiereliste);
    deuxiemeliste=Quicksort(deuxiemeliste);
    return Assemblage(premiereliste, new Liste(p), deuxiemeliste);
  }
 public Liste Assemblage(Liste premeiereliste ,Liste p, Liste deuxiemListe ){
        
        if(premeiereliste==null){
        p.next=deuxiemListe;
        return p;
        }
        Liste temp=premeiereliste;
     while (temp.next!=null) {
        temp=temp.next;
        }
        p.next=deuxiemListe;
        temp.next=p;
        return premeiereliste;
    

    }   

 public void Append(Liste l){
    Liste temp=this;
    while(temp.next!=null){
        temp=temp.next;

    }
    temp.next=l;

    }
 public Liste suprimerInferieure(){
     String valeurfixe=this.value;
     Liste temp=this;
     Liste inferieure=null;
     if(temp.next==null){
        return this;
     }
     
     while(temp.next!=null){
      
        if(temp.next.value.compareTo(valeurfixe)<0){
            inferieure=new Liste(temp.next.value,inferieure);
            temp.next=temp.next.next;
        }
        temp=temp.next;
     }
     return inferieure;
   }






   public void afficherListeAvant(){
    Liste temp = this;
    System.out.print("Avant tri: ");
    while (temp != null) {
        System.out.print(temp.value + " ");
        temp = temp.next;
    }
    System.out.println();
}

// Méthode pour afficher la liste après le tri
public void afficherListeApres(Liste listeTriee){
    Liste temp = listeTriee;
    System.out.print("Après tri: ");
    while (temp != null) {
        System.out.print(temp.value + " ");
        temp = temp.next;
    }
    System.out.println();
}


}

