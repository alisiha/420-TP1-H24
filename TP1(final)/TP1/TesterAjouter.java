public class TesterAjouter {

    public static void main(String[] args) {
        TesterAjouter tester = new TesterAjouter();
        tester.testAjouterComposantSucces();
        tester.testAjouterComposantMemeCategorie();
        tester.testAjouterDepassementPrixMax();
        tester.testAjouterDepassementNombreMaxComposants();
    }

    public void testAjouterComposantSucces() {
        Configuration configuration = new Configuration("Configuration de test", 1000.0, new Composant[Configuration.MAX_COMPOSANTS]);
        Composant composant = new Composant("Carte graphique", "Nvidia", "GTX 1080", 500.0);
        if (configuration.ajouter(composant)) {
            System.out.println("Test réussi : Ajout d'un composant à la configuration pour que ça fonctionne.");
        } else {
            System.out.println("Test échoué : Ajout d'un composant à la configuration pour que ça fonctionne.");
        }
    }

    public void testAjouterComposantMemeCategorie() {
        Configuration configuration = new Configuration("Configuration de test", 1000.0, new Composant[Configuration.MAX_COMPOSANTS]);
        Composant composant1 = new Composant("Carte graphique", "Nvidia", "GTX 1080", 500.0);
        Composant composant2 = new Composant("Carte graphique", "AMD", "RX 580", 300.0);
        configuration.ajouter(composant1);
        if (!configuration.ajouter(composant2)) {
            System.out.println("Test réussi : Ajout d'un composant à la configuration pour que ça ne fonctionne pas (même catégorie).");
        } else {
            System.out.println("Test échoué : Ajout d'un composant à la configuration pour que ça ne fonctionne pas (même catégorie).");
        }
    }

    public void testAjouterDepassementPrixMax() {
        Configuration configuration = new Configuration("Configuration de test", 1000.0, new Composant[Configuration.MAX_COMPOSANTS]);
        configuration.ajouter(new Composant("Processeur", "Intel", "i9-9900k", 600.0));
        if (!configuration.ajouter(new Composant("Carte mère", "ASUS", "ROG Strix", 500.0))) {
            System.out.println("Test réussi : Ajout d'un composant à la configuration pour que ça ne fonctionne pas (dépassement du prix maximal).");
        } else {
            System.out.println("Test échoué : Ajout d'un composant à la configuration pour que ça ne fonctionne pas (dépassement du prix maximal).");
        }
    }

    public void testAjouterDepassementNombreMaxComposants() {
        Configuration configuration = new Configuration("Configuration de test", 1000.0, new Composant[Configuration.MAX_COMPOSANTS]);
        for (int i = 0; i < Configuration.MAX_COMPOSANTS; i++) {
            configuration.ajouter(new Composant("RAM", "Corsair", "DDR4", 50.0));
        }
        if (!configuration.ajouter(new Composant("Disque dur", "Seagate", "1TB", 100.0))) {
            System.out.println("Test réussi : Ajout d'un composant à la configuration pour que ça ne fonctionne pas (dépassement du nombre maximal de composants).");
        } else {
            System.out.println("Test échoué : Ajout d'un composant à la configuration pour que ça ne fonctionne pas (dépassement du nombre maximal de composants).");
        }
    }
}