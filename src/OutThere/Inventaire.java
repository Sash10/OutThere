package OutThere;

/**
 * Created by Axel & Sasha on 11/12/2016.
 */

public class Inventaire {

    // Attributs

    private Element[] inventaire;

    // Constructeurs

    public Inventaire() {
        this.inventaire = new Element[10];
        this.inventaire[0] = new Element("hydrogene", 20, 20);
        this.inventaire[1] = new Element("oxygene", 20, 20);
        this.inventaire[2] = new Element("fer", 20, 20);
    }

    // Méthodes courantes

    public Element[] getInventaire() {
        return inventaire;
    }

    // Fonction stocker élément : parcourt l'inventaire et cherche si le même élément est déjà présent
    // La fonction trie automatiquement quand un élément est ajouté.

    public void stockerElem(Element elem) {
        for (int i = 0; i < this.inventaire.length; i++) {
            if (this.inventaire[i] != null) {
                if (this.inventaire[i].getDesignation() == elem.getDesignation()) {
                    int somme = this.inventaire[i].getQuantite() + elem.getQuantite();
                    this.inventaire[i].setQuantite(somme);
                    elem.setQuantite(somme - 20);
                    if (this.inventaire[i].getQuantite() > 20) {
                        this.inventaire[i].setQuantite(20);
                    }
                    if (elem.getQuantite() <= 0) {
                        elem = null;
                        break;
                    }
                }
            }
        }
        if (elem != null) {
            for (int i = 0; i < this.inventaire.length; i++) {
                if (this.inventaire[i] == null) {
                    this.inventaire[i] = elem;
                    break;
                }
            }
        }
    }


    public void supprimerElem(int i) {
        this.inventaire[i] = null;
    }

    // Fonction toString -> afficher l'Inventaire avec le nom des éléments, leur n° d'emplacement et leur quantité

    public String toString() {
        String resultat = "Inventaire: \n";
        String vide = "Emplacements vides: ";
        for (int i = 0; i < this.inventaire.length; i++) {
            if (this.inventaire[i] != null) {
                resultat += "Emplacement n°" + i + " -> " + this.inventaire[i] + "\n";
            }
            if (this.inventaire[i] == null) {
                vide += i + ", ";
            }
        }
        if (vide == "Emplacements vides: ")
            vide += "Aucun";
        return resultat + vide;
    }

    // Fonction consommer Element
    // parcourt l'inventaire à la recherche du même élément, fait la somme de toute la quantité de cette élément
    // consomme la quantité indiquée dans la variable nb

    public void consommerElem(String designation, int nb) {
        int somme = 0;
        for (int i = 0; i < this.inventaire.length; i++) {
            if (this.inventaire[i] != null) {
                if (this.inventaire[i].getDesignation() == designation) {
                    somme += this.inventaire[i].getQuantite();
                }
            }
        }

        if (somme > nb) {
            for (int i = 0; i < this.inventaire.length; i++) {
                if (this.inventaire[i] != null) {
                    if (this.inventaire[i].getDesignation() == designation) {
                        if (this.inventaire[i].getQuantite() - nb > 0) {
                            this.inventaire[i].setQuantite(this.inventaire[i].getQuantite() - nb);
                            break;
                        }
                        if (this.inventaire[i].getQuantite() - nb <= 0) {
                            nb = (this.inventaire[i].getQuantite() - nb) * (-1);
                            this.inventaire[i] = null;
                        }
                        if (nb <= 0)
                            break;
                    }
                }
            }
        }

        if (somme <= nb) {
            for (int i = 0; i < this.inventaire.length; i++) {
                if (this.inventaire[i] != null) {
                    if (this.inventaire[i].getDesignation() == designation) {
                        this.inventaire[i] = null;
                    }
                }
            }
        }
    }


}
