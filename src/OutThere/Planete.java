package OutThere;

/**
 * Created by Axel & Sasha on 11/12/2016.
 */

public class Planete {

    // Attributs

    private String type;    // type de la planète (1 -> gazeuze ; 2 -> miniere ; 3 -> à atmosphère respirable)
    private String nom;     // nom de la planète générée aléatoirement

    // Constructeur

    public Planete() {
        int nbAleaType = 1 + (int) (Math.random() * ((3 - 1) + 1));    // génération nombre aléatoire pour le type [1-3]
        if (nbAleaType == 1)
            type = "Géante gazeuze";
        if (nbAleaType == 2)
            type = "Miniere";
        if (nbAleaType == 3)
            type = "Atmosphère respirable";
        this.nom = generate();
    }

    public Planete(String nom, String type){
        this.nom = nom;
        this.type = type;
    }

    // Méthodes courantes

    public String getType() {
        return type;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return "Nom: " + this.nom + " // Type: " + this.type;
    }

    // Méthode de génération aléatoire de nom

    public String generate() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // caractères utilisables
        String nb = "0123456789";                    // chiffres utilisables
        String charnb = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String pass = "";
        for (int x = 0; x < 2; x++) {
            int i = (int) Math.floor(Math.random() * 26); // position aléatoire du char
            pass += chars.charAt(i);
        }
        int j = (int) Math.floor(Math.random() * 36); // position aléatoire du char
        pass += charnb.charAt(j);
        for (int x = 0; x < 2; x++) {
            int k = (int) Math.floor(Math.random() * 10); // position aléatoire du char
            pass += nb.charAt(k);
        }
        return pass;
    }

}
