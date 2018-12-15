import OutThere.Element;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Axel on 09/01/2017.
 */
public class ElementTest {

    Element e = new Element("fer", 15,20);

    @Test
    public void testCourant(){
        assertEquals("fer", e.getDesignation());
        assertEquals(15, e.getQuantite());
        assertEquals("Elément : fer, quantité = 15/20", e.toString());
        e.setQuantite(8);
        assertEquals(8, e.getQuantite());

    }
}
