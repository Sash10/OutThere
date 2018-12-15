package OutThere;
import java.util.Scanner;

/**
 * Created by Axel & Sasha on 11/12/2016.
 */

public class Vaisseau {

    //Attributs

    private int coque; // Etat de la coque
    private int oxygene; // Niveau d'oxygene
    private int carburant; // Niveau de carburant

    // Constructeur

    public Vaisseau() {
        coque = 100;
        oxygene = 100;
        carburant = 100;
    }

    public Vaisseau(int coque, int oxygene, int carburant) {
        this.coque = coque;
        this.oxygene = oxygene;
        this.carburant = carburant;
    }

    // Accesseurs

    public int getCoque() {
        return coque;
    }

    public int getOxygene() {
        return oxygene;
    }

    public int getCarburant() {
        return carburant;
    }

    public void setCoque(int coque) {
        this.coque = coque;
    }

    public void setOxygene(int oxygene) {
        this.oxygene = oxygene;
    }

    public void setCarburant(int carburant) {
        this.carburant = carburant;
    }

    public void remplirNiveau(String element, int nb) {
        assert (nb > 0 && nb < 100);
        if (element == "hydrogene") {
            this.carburant += nb * 2;   // Hydrogène (H) --> l'unité d'hydrogène vaut 2 points de carburant
            if (this.carburant > 100)
                this.carburant = 100;
        }
        if (element == "oxygene") {
            this.oxygene += nb * 2;     // Oxygène (O) --> l'unité d'oxygène vaut 2 points d'air respirable
            if (this.oxygene > 100)
                this.oxygene = 100;
        }
        if (element == "helium") {
            this.carburant += nb * 3;   // Helium (He) --> l'unité d'helium vaut 3 points de carburant
            if (this.carburant > 100)
                this.carburant = 100;
        }
        if (element == "fer") {         // Fer (Fe) --> l'unité de fer vaut 2 points de réparation
            this.coque += nb * 2;
            if (this.coque > 100)
                this.coque = 100;
        }
        if (element == "titane") {      // Titane (Ti) --> l'unité de titane vaut 3 points de réparation
            this.coque += nb * 3;
            if (this.coque > 100)
                this.coque = 100;
        }

    }

    public String toString() {
        return "Etat du vaisseau --> Coque = " + coque + "/100" + " | Carburant = " + carburant + "/100" + " | Oxygène = " + oxygene + "/100";
    }

    public boolean checkAction() {
        boolean checkSuccess = false;
        int entree = 0;


        if (this.oxygene <= 0 || this.carburant <= 0 || this.coque <= 0) {
            System.out.println("Cette manoeuvre m'a l'air risquée au vu des réserves de mon veaisseau... \n" +
                    "Je vais essayer de me concentrer et de consommer le moins possible... *silence*");

            while (entree != 1) {
                System.out.println("Appuyer sur '1' pour continuer");
                Scanner sc = new Scanner(System.in);
                entree = sc.nextInt();
                if (entree != 1)
                    System.out.println("Erreur, recommencez");
            }

            int nbAlea = 1 + (int) (Math.random() * ((5 - 1) + 1)); // Borne [1-5]
            if (nbAlea == 1) {
                checkSuccess = true;
                if (this.oxygene <= 0) {
                    System.out.println("J'ai réussi ! Il ne me reste plus beaucoup d'oxygène," +
                            " espérons que je puisse en trouver ici...");
                    this.oxygene = 1;
                }
                if (this.carburant <= 0) {
                    System.out.println("J'ai réussi ! Il ne me reste plus beaucoup de carburant," +
                            " espérons que je puisse en trouver ici...");
                    this.carburant = 1;
                }
                if (this.coque <= 0) {
                    System.out.println("J'ai réussi ! La coque a tenu tant bien que mal, " +
                            "il faut absolument que je trouve de quoi la réparer ici...");
                    this.coque = 1;
                }
            }
            if (nbAlea != 1) {
                checkSuccess = false;
                if (this.oxygene <= 0) {
                    System.out.println("Je n'ai pas réussi à faire ce que je voulais et mes réserves d'oxygène" +
                            " sont trop faibles pour continuer mon périple..." +
                            "Je retourne dans ma cellule de cryogénisation et espère qu'on me trouvera un jour...");
                }
                if (this.carburant <= 0) {
                    System.out.println("Je n'ai pas réussi à faire ce que je voulais et je n'ai plus une goutte de carburant." +
                            "Je vais donc retourner dans ma cellule de cryogénisation et dériver dans l'espace infini...");
                }
                if (this.coque <= 0) {
                    System.out.println("La coque n'a pas tenu et nous n'avons plus eu aucune nouvelles de notre aventurier.");
                }
            }
        } else {
            checkSuccess = true;
        }
        return checkSuccess;
    }

    // Méthode pour récolter ressources --> 6 carburant, 2 coque

    public Element recolterRessources(Planete p, Element e) {
        this.carburant -= 6;
        this.coque -= 2;
        if (checkAction() == true) {
            int quantite = 7 + (int) (Math.random() * ((15 - 7) + 1));

            if (p.getType() == "Géante gazeuze") {
                int nbAlea = 1 + (int) (Math.random() * ((4 - 1) + 1));
                if (nbAlea == 4)
                    e = new Element("helium", quantite, 20);
                else e = new Element("hydrogene", quantite, 20);
            }
            if (p.getType() == "Miniere") {
                int nbAlea2 = 1 + (int) (Math.random() * ((4 - 1) + 1));
                if (nbAlea2 == 4)
                    e = new Element("titane", quantite, 20);
                else e = new Element("fer", quantite, 20);
            }
            if (p.getType() == "Atmosphère respirable") {
                e = new Element("fer", quantite, 20);
                this.oxygene = 100;
            }

            System.out.println("Vous avez récupéré:\n" + e.toString());
        }
        return e;
    }

    public Element recolterRessourcesAgain(Planete p, Element e) {
        this.carburant -= 6;
        this.coque -= 2;
        if (checkAction() == true) {
            int quantite = 1 + (int) (Math.random() * ((5 - 1) + 1));

            if (p.getType() == "Géante gazeuze") {
                int nbAlea = 1 + (int) (Math.random() * ((4 - 1) + 1));
                if (nbAlea == 4)
                    e = new Element("helium", quantite, 20);
                else e = new Element("hydrogene", quantite, 20);
            }
            if (p.getType() == "Miniere") {
                int nbAlea2 = 1 + (int) (Math.random() * ((4 - 1) + 1));
                if (nbAlea2 == 4)
                    e = new Element("titane", quantite, 20);
                else e = new Element("fer", quantite, 20);
            }
            if (p.getType() == "Atmosphère respirable") {
                e = new Element("fer", quantite, 20);
                this.oxygene = 100;
            }

            System.out.println("Vous avez récupéré:\n" + e.toString());
        }
        return e;
    }

    // Méthode pour deplacement vaisseau, avec consommation des ressources, action desespérée & vérification de réussite
    // Mise en orbite --> 8 carburant, 6 oxygene
    // Atterrir --> 4 carburant, 4 oxygene, 4 coque
    // Décoller --> 4 carburant , 6 oxygene, 4 coque
    // Aller vers un systeme --> de 10 a 25 carburant et de 5 à 10 oxygene

    public void deplacer(String action) {
        int consoCarburant = 0;
        int consoOxygene = 0;
        int consoCoque = 0;

        if (action == "orbite") {
            consoCarburant = 8;
            consoOxygene = 6;
            consoCoque = 0;
        }

        if (action == "atterrir") {
            consoCarburant = 4;
            consoOxygene = 4;
            consoCoque = 4;
        }

        if (action == "decoller") {
            consoCarburant = 4;
            consoOxygene = 6;
            consoCoque = 4;
        }

        if (action == "systeme") {
            consoCarburant = 16;
            consoOxygene = 8;
            consoCoque = 0;
        }

        this.carburant -= consoCarburant;
        this.oxygene -= consoOxygene;
        this.coque -= consoCoque;
        this.checkAction();

    }

    public String position(Systeme s, String etat) {
        String afficherPos = "Vous vous trouvez dans le système " + s.getNom();
        if (etat == "orbiteSys") {
             afficherPos += ", en orbite";
             System.out.println(afficherPos);
        }
        if (etat == "orbitePlanete0") {
            afficherPos += ", en orbite de la planète "+s.getSysteme()[0].getNom();
            System.out.println(afficherPos);
        }
        if (etat == "orbitePlanete1") {
            afficherPos += ", en orbite de la planète "+s.getSysteme()[1].getNom();
            System.out.println(afficherPos);
        }
        if (etat == "orbitePlanete2") {
            afficherPos += ", en orbite de la planète "+s.getSysteme()[2].getNom();
            System.out.println(afficherPos);
        }
        if (etat == "orbitePlanete3") {
            afficherPos += ", en orbite de la planète "+s.getSysteme()[3].getNom();
            System.out.println(afficherPos);
        }
        if (etat == "landPlanete0") {
            afficherPos += ", sur la planète "+s.getSysteme()[0].getNom();
            System.out.println(afficherPos);
        }
        if (etat == "landPlanete1") {
            afficherPos += ", sur la planète "+s.getSysteme()[1].getNom();
            System.out.println(afficherPos);
        }
        if (etat == "landPlanete2") {
            afficherPos += ", sur la planète "+s.getSysteme()[2].getNom();
            System.out.println(afficherPos);
        }
        if (etat == "landPlanete3") {
            afficherPos += ", sur la planète "+s.getSysteme()[3].getNom();
            System.out.println(afficherPos);
        }

        return etat;
    }

}
