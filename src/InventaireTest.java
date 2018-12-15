import OutThere.Element;
import OutThere.Inventaire;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Axel on 09/01/2017.
 */
public class InventaireTest {

    Inventaire i = new Inventaire();

    @Test
    public void testStockerEtConsommer(){

        assertEquals(20,i.getInventaire()[0].getQuantite());
        assertEquals("oxygene", i.getInventaire()[1].getDesignation());
        Element e1 = new Element("hydrogene",15,20);
        i.stockerElem(e1);
        assertEquals("hydrogene", i.getInventaire()[3].getDesignation());
        assertEquals(15,i.getInventaire()[3].getQuantite());
        Element e2 = new Element("hydrogene",12,20);
        i.stockerElem(e2);
        assertEquals("hydrogene", i.getInventaire()[3].getDesignation());
        assertEquals(20,i.getInventaire()[3].getQuantite());
        assertEquals("hydrogene", i.getInventaire()[4].getDesignation());
        assertEquals(7,i.getInventaire()[4].getQuantite());
        i.consommerElem("hydrogene", 45);
        assertEquals(null,i.getInventaire()[0]);
        assertEquals(null,i.getInventaire()[3]);
        assertEquals("hydrogene",i.getInventaire()[4].getDesignation());
        assertEquals(2,i.getInventaire()[4].getQuantite());

    }

    @Test
    public void testSupprimerElem(){
        i.supprimerElem(2);
        assertEquals(null, i.getInventaire()[2]);
        assertEquals(20,i.getInventaire()[0].getQuantite());
        assertEquals("oxygene", i.getInventaire()[1].getDesignation());
        i.supprimerElem(1);
        assertEquals(null, i.getInventaire()[1]);
    }

}
