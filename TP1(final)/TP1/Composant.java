import static java.lang.System.out;

public class Composant {
    private final String categorie;
    private String marque;
    private String nom;
    private Double prix;
    private Double rabais = 0.0;


    public Composant(String categorie, String marque, String nom, double prix) {
        this.categorie = categorie.toUpperCase();
        this.marque = marque;
        this.nom = nom;
        this.prix = prix;
    }
    public Composant copier(){
       return new Composant(this.categorie, this.marque, this.nom, this.prix);
    }

    public String getCategorie() {
        return categorie;
    }
    public String getMarque() {
        return marque;
    }
    public String getNom() {
        return nom;
    }
    public Double getRabais(){
        return rabais;
    }
    public void setRabais(double pRabais){
        this.rabais = pRabais;

    }    public Double getPrix() {
        return prix * (1 - rabais / 100);
    }
    public void setPrix(double pPrix){
        this.prix = pPrix;
    }
    public Boolean estIdentique(Composant autre) {
        return this.categorie.equals(autre.categorie) && this.marque.equals(autre.marque) && this.nom.equals(autre.nom);
    }
    public String toString(){
        return "[" + this.getCategorie() + "]" + this.getMarque() + this.getNom();
    }
}
