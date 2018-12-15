package OutThere;
import java.util.Scanner;

/**
 * Created by Axel & Sasha on 11/12/2016.
 */

public class Systeme {

    // Attributs

    private Planete[] systeme;
    private String nom;

    // Constructeur

    public Systeme() {
        this.systeme = new Planete[4];
        for (int i = 0; i < 4; i++) {
            systeme[i] = new Planete();
        }
        this.nom = randName();
    }

    // Méthodes courantes

    public Planete[] getSysteme() {
        return systeme;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        String resultat = "Système: " + nom + "\n";
        for (int i = 0; i < this.systeme.length; i++) {
            resultat += "Planète n°" + i + " -> " + this.systeme[i] + "\n";
        }
        return resultat;
    }


    // Méthode génération nom aléatoire

    public String randName() {
        String firstLetter = "lexegezacebiso";    // sélection de syllabes prédéfinies
        String secondLetter = "azertyuiop'qsdfghjklm'xcvbn'";
        String pairs2 = "usesarmaindirea";
        String pairs3 = "eratenberalaveti";
        String pairs4 = "edor'quant'eisri'on";

        int first = 2 * (int) Math.floor(Math.random() * (firstLetter.length() / 2));
        int second = 2 * (int) Math.floor(Math.random() * (firstLetter.length() / 2));
        int pair2 = 2 * (int) Math.floor(Math.random() * (pairs2.length() / 2));
        int pair3 = 2 * (int) Math.floor(Math.random() * (pairs3.length() / 2));
        int pair4 = 2 * (int) Math.floor(Math.random() * (pairs4.length() / 2));

        int nbAlea = 3 + (int) (Math.random() * ((4 - 3) + 1));    // génération nombre aléatoire pour le nombre de paires [3-4]

        String name = "";
        name += firstLetter.substring(first, first + 1).toUpperCase() + secondLetter.substring(second, second + 1);
        name += pairs2.substring(pair2, pair2 + 2);
        name += pairs3.substring(pair3, pair3 + 2);
        if (nbAlea == 4)
            name += pairs4.substring(pair4, pair4 + 2);

        return name;
    }

}

