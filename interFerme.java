public class interFerme extends interOuvert {
    public interFerme(int bInf, int bSup) {
        super(bInf, bSup);
    }

    @Override
    public void estVide() {
        int card = super.getBSup() - super.getBInf() + 1; 
        System.out.printf((card == 0) ? "L'intervalle [%d ; %d] est vide !\n\n" : "L'intervalle [%d ; %d] n'est pas vide !\n\n", super.getBInf(), super.getBSup());
    }

    @Override
    public void estDans(int n) {
        System.out.printf((n >= super.getBInf() && n <= super.getBSup()) ? "[%d] est dans l'intervalle [%d ; %d] !\n\n" : "[%d] n'est pas dans l'intervalle [%d ; %d] !\n\n", n, super.getBInf(), super.getBSup());
    }

    
    public void contient(interFerme I) {
        if (I instanceof interFerme) {
            System.out.printf((super.getBInf() <= I.getBInf() && super.getBSup() >= I.getBSup()) ? "L'intervalle [%d ; %d] est dans l'intervalle [%d ; %d] !\n\n" : "L'intervalle [%d ; %d] n'est pas dans l'intervalle [%d ; %d] !\n\n", I.getBInf(), I.getBSup(), super.getBInf(), super.getBSup());
        } else {
            System.out.printf((super.getBInf() <= I.getBInf() && super.getBSup() >= I.getBSup()) ? "L'intervalle ]%d ; %d[ est dans l'intervalle [%d ; %d] !\n\n" : "L'intervalle ]%d ; %d[ n'est pas dans l'intervalle [%d ; %d] !\n\n", I.getBInf(), I.getBSup(), super.getBInf(), super.getBSup());
        }
    }

    
    public void intersection(interFerme I) {
        int nouvelleBInf = Math.max(super.getBInf(), I.getBInf());
        int nouvelleBSup = Math.min(super.getBSup(), I.getBSup());
        
        if (nouvelleBInf > nouvelleBSup) {
            System.out.println("Les intervalles n'ont pas d'intersection.\n");
        } else 

          System.out.printf("L'intersection des deux intervalles est : [%d ; %d]\n\n", nouvelleBInf, nouvelleBSup);
    }
}
