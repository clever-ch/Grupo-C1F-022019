package model;

import junit.framework.TestCase;
import model.factories.AccountFactory;
import org.junit.Test;

public class AccountTest extends TestCase {

    @Test
    public void testCreationAccountCorrectFields(){
        Account aAccount = AccountFactory.createAccountComplete("inc", "Ignacio", "Crovara",
                "inc@gmail.com", 42322344, "Quilmes", "Mitre");
        assertEquals("inc", aAccount.getUserName());
        assertEquals("Ignacio", aAccount.getName());
        assertEquals("Crovara", aAccount.getSurname());
        assertEquals("inc@gmail.com", aAccount.getEmail());
        assertEquals(42322344, aAccount.getPhone());
        assertEquals("Quilmes", aAccount.getLocation());
        assertEquals("Mitre", aAccount.getDirection());
    }



}
