import javax.swing.*;

public class Configuration {
    private final String description = "";
    private final int MAX_COMPOSANTS = 20;
    private int nbComposants;
    private int prixMax;
    private Composant composants[] = new Composant[MAX_COMPOSANTS];

    public Configuration( String description, int prixMax, Composant[] composants){
        this.prixMax = prixMax;
        this.composants = composants;
    }
    //getters et setters

    public String getDescription() {
        return description;
    }
    public int getPrixMax(){
        return prixMax;
    }

    public void setPrixMax(int prixMax) {
        this.prixMax = prixMax;
    }

    public Composant[] getComposants() {
        return composants;
    }

    public void setComposants(Composant[] composants) {
        this.composants = composants;
    }

    public int getNbComposants(){
        return nbComposants;
    }

    public void setNbComposants(int nombreComposants) {
        this.nbComposants = nbComposants;
    }

    //calcule le prix total de tous les composants avec la taxe
    public double calculerTotal(double taxe){
    return taxe;
    }
    
}
