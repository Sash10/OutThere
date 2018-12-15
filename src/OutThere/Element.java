package OutThere;

/**
 * Created by Axel & Sasha on 11/12/2016.
 */

public class Element {

    // Attributs

    private int quantite;           // quantité de l'élément
    private int LIMITE_QTE;    // borne quantité
    private String designation;     // désignation de l'élément

    // Constructeur

    public Element(String designation, int quantite, int LIMITE_QTE) {
        this.designation = designation;
        this.quantite = quantite;
        this.LIMITE_QTE = LIMITE_QTE;
    }

    public Element() {
        this.quantite = 0;
        this.LIMITE_QTE = 20;
        this.designation = "";
    }

    // Méthodes courantes

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDesignation() {
        return designation;
    }

    public String toString() {
        return "Elément : " + this.designation + ", quantité = " + this.quantite + "/" + this.LIMITE_QTE;
    }

}
