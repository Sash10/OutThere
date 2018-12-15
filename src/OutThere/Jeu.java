package OutThere;
import java.util.Scanner;

/**
 * Created by Axel & Sasha on 11/12/2016.
 */

public class Jeu {

    // Attributs

    private Vaisseau v;
    private Inventaire i;

    // Constructeurs

    public Jeu() {
        this.v = new Vaisseau();
        this.i = new Inventaire();
    }

    // Méthode principale du jeu, affiche un menu de jeu avec 6 choix possibles en fonction de la position actuelle du vaisseau

    public void menu(Systeme s, String etat, int ressourcesOK, long score) {
        int entree = 0;

        // Calcul Score :
        // Visite système               = 500 pts
        // Orbite planète & Atterrir    = 75 pts
        // Recolter ressources          = 50 pts
        // Recolter ressources Again    = 5 pts

        if (this.v.getCoque() <= 0 || this.v.getOxygene() <= 0 || this.v.getCarburant() <= 0) {
            System.out.println("C'est la fin de votre aventure, merci d'avoir joué !");
            System.out.println("Vous avez établi un score de " +score+" !");
            while (entree != 1) {
                System.out.println("Appuyer sur '1' pour continuer");
                Scanner sc = new Scanner(System.in);
                entree = sc.nextInt();
                if (entree != 1)
                    System.out.println("Erreur, recommencez");
            }
            if (entree == 1)
            System.exit(0);
        }

        System.out.println("\n" + this.v.toString());
        this.v.position(s, etat);


        if (etat == "orbitePlanete0")
            System.out.println("(1) Atterrir sur: " + s.getSysteme()[0].toString());
        else if (etat == "landPlanete0")
            System.out.println("(1) Récolter ressources sur: " + s.getSysteme()[0].toString());
        else
            System.out.println("(1) Aller sur: " + s.getSysteme()[0].toString());


        if (etat == "orbitePlanete1")
            System.out.println("(2) Atterrir sur: " + s.getSysteme()[1].toString());
        else if (etat == "landPlanete1")
            System.out.println("(2) Récolter ressources sur: " + s.getSysteme()[1].toString());
        else System.out.println("(2) Aller sur: " + s.getSysteme()[1].toString());


        if (etat == "orbitePlanete2")
            System.out.println("(3) Atterrir sur: " + s.getSysteme()[2].toString());
        else if (etat == "landPlanete2")
            System.out.println("(3) Récolter ressources sur: " + s.getSysteme()[2].toString());
        else System.out.println("(3) Aller sur: " + s.getSysteme()[2].toString());


        if (etat == "orbitePlanete3")
            System.out.println("(4) Atterrir sur: " + s.getSysteme()[3].toString());
        else if (etat == "landPlanete3")
            System.out.println("(4) Récolter ressources sur: " + s.getSysteme()[3].toString());
        else System.out.println("(4) Aller sur: " + s.getSysteme()[3].toString());


        System.out.println("(5) Aller sur un autre système solaire");
        System.out.println("(6) Voir la soute du vaisseau");

        while (entree < 1 || entree > 6) {
            System.out.println("Que voulez-vous faire? (1-6)");
            Scanner sc = new Scanner(System.in);
            entree = sc.nextInt();
            if (entree < 1 || entree > 6)
                System.out.println("Erreur, recommencez");
        }

        if (entree == 1) {
            if (etat == "orbiteSys" || etat == "orbitePlanete1" || etat == "orbitePlanete2" || etat == "orbitePlanete3"
                    || etat == "landPlanete1" || etat == "landPlanete2" || etat == "landPlanete3") {
                this.v.deplacer("orbite");
                score += 75;
                menu(s, "orbitePlanete0", 0,score);
            }
            if (etat == "orbitePlanete0") {
                this.v.deplacer("atterrir");
                score += 75;
                menu(s, "landPlanete0", 0,score);
            }
            if (etat == "landPlanete0") {
                if (ressourcesOK == 0) {
                    Element e = new Element();
                    this.i.stockerElem(this.v.recolterRessources(s.getSysteme()[0], e));
                    score += 50;
                    menu(s, "landPlanete0", 1,score);
                }
                if (ressourcesOK == 1) {
                    Element e = new Element();
                    this.i.stockerElem(this.v.recolterRessourcesAgain(s.getSysteme()[0], e));
                    score += 5;
                    menu(s, "landPlanete0", 1,score);
                }
            }

        }
        if (entree == 2) {
            if (etat == "orbiteSys" || etat == "orbitePlanete0" || etat == "orbitePlanete2" || etat == "orbitePlanete3"
                    || etat == "landPlanete0" || etat == "landPlanete2" || etat == "landPlanete3") {
                this.v.deplacer("orbite");
                score += 75;
                menu(s, "orbitePlanete1", 0,score);
            }
            if (etat == "orbitePlanete1") {
                this.v.deplacer("atterrir");
                score += 75;
                menu(s, "landPlanete1", 0,score);
            }
            if (etat == "landPlanete1") {
                if (ressourcesOK == 0) {
                    Element e = new Element();
                    this.i.stockerElem(this.v.recolterRessources(s.getSysteme()[1], e));
                    score += 50;
                    menu(s, "landPlanete1", 1,score);
                }
                if (ressourcesOK == 1) {
                    Element e = new Element();
                    this.i.stockerElem(this.v.recolterRessourcesAgain(s.getSysteme()[1], e));
                    score += 5;
                    menu(s, "landPlanete1", 1,score);
                }
            }
        }
        if (entree == 3) {
            if (etat == "orbiteSys" || etat == "orbitePlanete1" || etat == "orbitePlanete0" || etat == "orbitePlanete3"
                    || etat == "landPlanete1" || etat == "landPlanete0" || etat == "landPlanete3") {
                this.v.deplacer("orbite");
                score += 75;
                menu(s, "orbitePlanete2",0,score);
            }
            if (etat == "orbitePlanete2") {
                this.v.deplacer("atterrir");
                score += 75;
                menu(s, "landPlanete2",0,score);
            }
            if (etat == "landPlanete2") {
                if (ressourcesOK == 0) {
                    Element e = new Element();
                    this.i.stockerElem(this.v.recolterRessources(s.getSysteme()[2], e));
                    score += 50;
                    menu(s, "landPlanete2", 1,score);
                }
                if (ressourcesOK == 1) {
                    Element e = new Element();
                    this.i.stockerElem(this.v.recolterRessourcesAgain(s.getSysteme()[2], e));
                    score += 5;
                    menu(s, "landPlanete2", 1,score);
                }
            }
        }
        if (entree == 4) {
            if (etat == "orbiteSys" || etat == "orbitePlanete1" || etat == "orbitePlanete2" || etat == "orbitePlanete0"
                    || etat == "landPlanete1" || etat == "landPlanete2" || etat == "landPlanete0") {
                this.v.deplacer("orbite");
                score += 75;
                menu(s, "orbitePlanete3",0,score);
            }
            if (etat == "orbitePlanete3") {
                this.v.deplacer("atterrir");
                score += 75;
                menu(s, "landPlanete3",0,score);
            }
            if (etat == "landPlanete3") {
                if (ressourcesOK == 0) {
                    Element e = new Element();
                    this.i.stockerElem(this.v.recolterRessources(s.getSysteme()[3], e));
                    score += 50;
                    menu(s, "landPlanete3", 1,score);
                }
                if (ressourcesOK == 1) {
                    Element e = new Element();
                    this.i.stockerElem(this.v.recolterRessourcesAgain(s.getSysteme()[3], e));
                    score += 5;
                    menu(s, "landPlanete3", 1,score);
                }
            }
        }
        if (entree == 5) {
            Systeme s2 = new Systeme();
            this.v.deplacer("systeme");
            score += 500;
            menu(s2, "orbiteSys",0,score);
        }
        if (entree == 6) {
            System.out.println(this.i.toString());
            menuInv(this.i, s, etat,score);
            menu(s, "orbiteSys",0,score);
        }

    }

    // Méthode qui affiche le menu de l'inventaire et qui permet d'effectuer une action de stockage ou de suppression d'éléments

    public void menuInv(Inventaire i, Systeme s, String etat, long score) {
        int entree = 0;
        System.out.println("(1) Utiliser élément");
        System.out.println("(2) Supprimer élément");
        System.out.println("(3) Retour au menu système");
        while (entree < 1 || entree > 3) {
            System.out.println("Que voulez-vous faire? (1-3)");
            Scanner sc = new Scanner(System.in);
            entree = sc.nextInt();
            if (entree < 1 || entree > 3)
                System.out.println("Erreur, recommencez");
        }

        if (entree == 1) {
            int saisie = -1;
            while (saisie < 0 || saisie > 9) {
                System.out.println("Saisissez l'emplacement de l'élément à utiliser (0-9)");
                Scanner sc2 = new Scanner(System.in);
                saisie = sc2.nextInt();
                if (saisie < 0 || saisie > 9)
                    System.out.println("Erreur, recommencez");
            }
            for (int cpt = 0; cpt < i.getInventaire().length; cpt++) {
                if (cpt == saisie) {
                    int qte = i.getInventaire()[cpt].getQuantite();
                    String elem = i.getInventaire()[cpt].getDesignation();
                    int saisieQte = 0;
                    while (saisieQte < 1 || saisieQte > qte) {
                        System.out.println("Vous disposez de " + qte + " unités, combien voulez-vous en utiliser ?");
                        Scanner sc3 = new Scanner(System.in);
                        saisieQte = sc3.nextInt();
                        if (saisieQte < 1 || saisie > qte)
                            System.out.println("Erreur, recommencez");
                    }
                    i.consommerElem(elem, saisieQte);
                    v.remplirNiveau(elem, saisieQte);
                }
            }
        }


        if (entree == 2)

        {
            int saisie = -1;
            while (saisie < 0 || saisie > 9) {
                System.out.println("Saisissez l'emplacement de l'élément à supprimer (0-9)");
                Scanner sc2 = new Scanner(System.in);
                saisie = sc2.nextInt();
                if (saisie < 0 || saisie > 9)
                    System.out.println("Erreur, recommencez");
            }
            for (int cpt = 0; cpt < i.getInventaire().length; cpt++) {
                if (cpt == saisie) {
                    i.supprimerElem(cpt);
                }
            }
        }

        if (entree == 3)

        {
            menu(s, etat,0,score);
        }
    }

    public void menuJeu() {

        System.out.println("Bienvenue sur le jeu 'Lost in Space' ! \n");
        System.out.println("(1) Jouer au jeu\n" +
                "(2) Consulter les règles\n" +
                "(3) Quitter\n");

        int saisie = 0;
        while (saisie < 1 || saisie > 3) {
            System.out.println("Votre choix? (1-3)");
            Scanner sc = new Scanner(System.in);
            saisie = sc.nextInt();
            if (saisie < 1 || saisie > 3)
                System.out.println("Erreur, recommencez");
        }

        if (saisie == 1) {
            Systeme s1 = new Systeme();
            this.menu(s1, "orbiteSys",0,0);
        }

        if (saisie == 2) {
            System.out.println("Ce jeu est très largement inspiré du jeu OutThere.\n" +
                    "Le principe est simple, vous êtes un explorateur humain en cryogénisation depuis des décennies \n" +
                    "et vous vous réveillez à bord de votre vaisseau, prêt à découvrir l'espace.\n" +
                    "Vous avez trois jauges caractérisant la coque du vaisseau, le niveau d'oxygène et le réservoir de carburant.\n" +
                    "Si l'une d'elle atteint 0 lors d'une action, vous pourrez tenter une action desespérée et peut-être survivre, auquel cas le jeu continue.\n" +
                    "Au contraire, si l'action échoue, la partie s'arrêtera et vous dériverez dans les confins de l'Univers.\n" +
                    "Pour récolter des ressources, vous pouvez explorer les différentes planètes\n" +
                    "Les ressources obtenues peuvent être utilisées pour augmenter vos jauges et se trouvent dans la soute du vaisseau.\n\n" +
                    "Précisions sur les types de ressources :\n" +
                    "- L'oxygène se trouve sur les planètes à atmosphère respirable, votre jauge se remplira si vous atterrissez sur ce type de planète;\n" +
                    "- L'hydrogène et l'hélium se trouvent sur les géantes gazeuzes, vous remplirez votre réservoir de carburant en les utilisant;\n" +
                    "- Le fer et le titane se trouvent sur les planètes minières et servent à réparer votre coque.\n");

            int saisie2 = 0;
            while (saisie2 != 1) {
                System.out.println("(1) Retour");
                Scanner sc = new Scanner(System.in);
                saisie2 = sc.nextInt();
                if (saisie2 != 1)
                    System.out.println("Erreur, recommencez");
            }
            if (saisie2 == 1)
                menuJeu();
        }

        if (saisie == 3) {
            System.exit(0);
        }


    }

}
