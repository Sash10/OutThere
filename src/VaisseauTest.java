import OutThere.Element;
import OutThere.Planete;
import OutThere.Systeme;
import OutThere.Vaisseau;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Axel on 09/01/2017.
 */
public class VaisseauTest {

    Vaisseau v = new Vaisseau(50,50,50);

    @Test
    public void testGetter(){
        assertEquals(50, v.getCoque());
        assertEquals(50, v.getOxygene());
        assertEquals(50, v.getCarburant());
    }

    @Test
    public void testRemplirNiveau(){
        v.remplirNiveau("fer", 10);          // 10 fer = 20 coque
        assertEquals(70, v.getCoque());
        v.remplirNiveau("helium", 5);
        assertEquals(65, v.getCarburant());     // 5 helium = 15 carburant
        v.remplirNiveau("oxygene", 7);
        assertEquals(64, v.getOxygene());       // 7 oxygene = 14 oxygene
    }

    @Test
    public void testToString(){
        assertEquals("Etat du vaisseau --> Coque = 50/100 | Carburant = 50/100 | Oxygène = 50/100", v.toString());
    }

    @Test
    public void testCheckAction(){
        assertTrue(v.checkAction());
    }

    @Test
    public void testrecolterRessources(){
        Planete p = new Planete("P","Miniere");
        Element e = new Element();
        Element crée = v.recolterRessources(p,e);
        assert (5 <= crée.getQuantite());
        assert (crée.getQuantite() <= 15);
        if (crée.getDesignation() == "fer")
                assertEquals("fer", crée.getDesignation());
        if (crée.getDesignation() == "titane")
            assertEquals("titane", crée.getDesignation());
    }

    @Test
    public void testrecolterRessourcesAgain(){
        Planete p = new Planete("P","Miniere");
        Element e = new Element();
        Element crée = v.recolterRessourcesAgain(p,e);
        assert (0 <= crée.getQuantite());
        assert (crée.getQuantite() <= 55);
        if (crée.getDesignation() == "fer")
            assertEquals("fer", crée.getDesignation());
        if (crée.getDesignation() == "titane")
            assertEquals("titane", crée.getDesignation());
    }

    @Test
    public void testDeplacer(){
        v.deplacer("systeme");
        assertEquals(42, v.getOxygene());
        assertEquals(34, v.getCarburant());
    }

    @Test
    public void testPosition(){
        Systeme s = new Systeme();
        assertEquals("orbitePlanete0", v.position(s,"orbitePlanete0"));
    }

}
