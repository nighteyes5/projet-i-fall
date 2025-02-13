public class interOuvert {
    private int bInf;
    private int bSup;
    private int card;
    public interOuvert(int bInf, int bSup){
     if(bInf >= bSup)
      throw new IllegalArgumentException("veiller à ce que la borne superieure soit effectivement superieure a la borne inferieure\n\n");
     this.bInf=bInf;
     this.bSup=bSup;
    }
    public void estVide(){
        this.card= bSup-bInf-1;
        System.out.printf( (card==0)?"l'intervalle ]%d ; %d[ est vide ! \n\n":"l'intervalle ]%d ; %d[ n'est pas vide   ! \n\n",this.bInf,this.bSup);

    }
    public void estDans(int n) {

     System.out.printf((n > bInf && n < bSup) ? "[%d] est dans l'intervalle ]%d ; %d[ !\n\n" : "[%d] n'est pas dans l'intervalle ]%d ; %d[ !\n\n", n,this.bInf,this.bSup);

    }
    public void contient(interOuvert I) {
        System.out.printf((this.bInf < I.bInf && this.bSup > I.bSup)? "l'intervalle  ]%d ; %d[ est dans l'intervalle ]%d %d[ !\n\n":
        "l'intervalle  ]%d ; %d[ n'est pas  dans l'intervalle ]%d ;  %d[ !\n\n " ,I.bInf,I.bSup,this.bInf,this.bSup);
    }


    public void intersection(interOuvert I) {

        int nouvelleBInf = Math.max(this.bInf, I.bInf);
        int nouvelleBSup = Math.min(this.bSup, I.bSup);
    
        if (nouvelleBInf >= nouvelleBSup) 
            System.out.println("Les intervalles n'ont pas d'intersection.\n");

        System.out.printf("L'intersection des deux intervalles est : ]%d ; %d[\n\n", nouvelleBInf, nouvelleBSup);
    
    }

    public int getBInf(){
        return bInf;
    }
    public int getBSup(){
        return bSup;
    }
     

}


