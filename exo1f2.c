#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct maillon {
    char *mot;
    struct maillon *suiv;
};

typedef struct maillon MAILLON, *PTR;

PTR ajoute_debut(char *mot, PTR L) {
    PTR new_node = (PTR)malloc(sizeof(MAILLON));
    
    new_node->mot = mot;
    if(!L)
    return new_node;

    new_node->suiv = L;
    return new_node;
}

PTR ajoute_fin(char *mot, PTR L) {
    PTR new_node = (PTR)malloc(sizeof(MAILLON));
   
    new_node->mot = mot;
    new_node->suiv = NULL;
    PTR temp = L;
    // if(temp->suiv)

    while (temp->suiv){
    temp = temp->suiv;
    }
    temp->suiv = new_node;
    
    return L;
}

PTR supprimer(char *mot, PTR L) {
    if (!L) return L; 

    PTR temp = L, valide = NULL;

    while (temp && strcmp(temp->mot, mot) != 0) {
        valide = temp;
        temp = temp->suiv;
    }

    if (!temp){
     printf(" le mot n'as pas été trouvé dans la liste !\n");
     printf(" la liste reste inchanger ! :\t");
     return L; 
    }

    
    if (!valide) L = L->suiv; // si le mot a supprimer est au niveau du premier noeud
    else valide->suiv = temp->suiv;

    free(temp->mot);
    free(temp);

    return L;
}


void premiers(PTR liste, int n) {
    PTR temp = liste;
    printf("la liste des %d prmiers mots est : \n");
    while (temp && n > 0) {
        printf(" %s\n", temp->mot);
        temp = temp->suiv;
        n--;
    }
}

void purifie(MAILLON *liste) {
    if (!liste) return 0;

    MAILLON *current = liste;
    while (current) {
        MAILLON *valide = current;
        MAILLON *temp = current->suiv;
        
        while (temp) {
            if (strcmp(current->mot, temp->mot) == 0) {
               
                valide->suiv = temp->suiv;
                free(temp->mot);
                free(temp);
                temp = valide->suiv; 
            } else {
                valide = temp;
                temp = temp->suiv;
            }
        }
        current = current->suiv;
    }
    
}

int main() {
    PTR liste = NULL;
    
    
    liste = ajoute_debut("elhadji", liste);
    liste = ajoute_fin("souleymane", liste);
    liste = ajoute_debut("thiandoum", liste);
    liste = ajoute_fin("adolphe", liste);
    liste = ajoute_fin("bonjourrr", liste);
    liste = ajoute_fin("thiandoum", liste); 
    liste = ajoute_debut("lamine", liste);

    printf("Liste après ajouts :\n");
    premiers(liste,7); 

    
    liste = supprimer("thiandoum", liste);  
    printf("liste après suppression de 'thiandoum' :\n");
    premiers(liste, 7); 

    purifie(liste);  
    printf("iste après purification des doublons :\n");
    premiers(liste, 7);  
    liste = supprimer("wally", liste);  
    premiers(liste, 7);  

    return 0;
}