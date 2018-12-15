import OutThere.Planete;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Axel on 09/01/2017.
 */
public class PlaneteTest {

    Planete p = new Planete("EXG55","Géante gazeuse");

    @Test
    public void testGetterAndToString(){
        assertEquals("EXG55", p.getNom());
        assertEquals("Géante gazeuse", p.getType());
        assertEquals("Nom: EXG55 // Type: Géante gazeuse", p.toString());
    }

}
