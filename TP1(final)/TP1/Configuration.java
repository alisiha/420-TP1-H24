import javax.swing.*;

public class Configuration {
    private final String DESCRIPTION;
    public static final int MAX_COMPOSANTS = 20;
    private final double PRIX_MAX;
    private Composant[] tbComposants = new Composant[MAX_COMPOSANTS];

    public Configuration(String description, double prixMax, Composant[] tbComposants) {
        this.DESCRIPTION = description.toUpperCase();
        this.PRIX_MAX = prixMax;
        for(int i = 0; i < tbComposants.length; i++) {
            this.tbComposants[i] = tbComposants[i];
        }
    }

    public Configuration(Configuration supplementaire) {
        this.DESCRIPTION = supplementaire.DESCRIPTION;
        this.PRIX_MAX = supplementaire.PRIX_MAX;
        this.tbComposants = supplementaire.tbComposants;
    }

    public Configuration copier(){
        String descriptionNouv = new String(this.DESCRIPTION);
        double prixMaxNouv = this.PRIX_MAX;
        Composant[] tbComposantNouv = new Composant[this.tbComposants.length];
        for(int i = 0; i < this.tbComposants.length; i++){
            tbComposantNouv[i] = new Composant(this.tbComposants[i].getCategorie(), this.tbComposants[i].getMarque(), this.tbComposants[i].getNom(), this.tbComposants[i].getPrix());
        }
        Configuration copieConf = new Configuration(descriptionNouv, prixMaxNouv, tbComposantNouv);
        return copieConf;
    }
    //getters et setters
public Composant[] getComposants(){
        return tbComposants;
}

public int getNbComposants(){
    int compteur = 0;
    for(int i = 0; i < tbComposants.length; i++){
        if(tbComposants[i] != null ) {
            compteur = compteur + 1;
        }
    }
    return compteur;
}

    public double calculerTotal(double taxe) {
        double total = 0;
        for (int i = 0; i < this.tbComposants.length; i++) {
            if(tbComposants[i] == null){
                break;
            }
            total += this.tbComposants[i].getPrix();
        }
        return total * (1 + taxe);
    }

    public Composant rechercher(String categorie) {
        for (int i = 0; i < this.tbComposants.length; i++) {
            if(this.tbComposants[i] == null){
                break;
            } else if (this.tbComposants[i].getCategorie().equalsIgnoreCase(categorie)) {
                return this.tbComposants[i];
            }
        }
        return null;
    }

    public boolean ajouter(Composant composant) {
        for (int i = 0; i < tbComposants.length; i++) {
            if (tbComposants[i] == null && this.calculerTotal(0.15) + composant.getPrix() > PRIX_MAX) {
                return false;
            }
            if (tbComposants[i] == null) {
                tbComposants[i] = composant;
                return true;
            }
        }
        return false;
    }

    public boolean retirer(Composant composant) {
        for(int i = 0; i < tbComposants.length; i++){
            if (tbComposants[i] != null && tbComposants[i].estIdentique((composant))){
                tbComposants[i] = null;
                tabApresSup();
                return true;
            }
        }
        return false;
    }
    //nouveau tableau apres suppression en mettant les éléments null à la fin du tableau
    private void tabApresSup() {
        for(int i = 0; i < tbComposants.length - 1; i++){
            if(tbComposants[i] == null){
                tbComposants[i] = tbComposants[i + 1];
                tbComposants[i + 1] = null;
            }
        }
    }

    public boolean remplacer(Composant composant) {
    for(int i = 0; i < tbComposants.length; i++){
        if(tbComposants[i] == null){
        break;
        } else if (tbComposants[i].getCategorie().equals(composant.getCategorie())){
            tbComposants[i] = composant.copier();
            return true;
        }
    }
    return false;
}

    public String toString(){
        String resultat = DESCRIPTION + " (max " + PRIX_MAX + "$) :\n";
        for(int i = 0; i < this.tbComposants.length; i++){
            if(this.tbComposants[i] == null){
                break;
            }
            Composant composant = this.tbComposants[i];
            resultat += "    " + (i + 1) + ": " + composant + " " + "(" + composant.getPrix() + "$)" + "\n";
        }
        return resultat;
    }
    
}