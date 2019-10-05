package model;

import model.Account;

import model.factories.AccountFactory;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAccount {

    @Test
    public void testIsValidAccount(){
        Account aAccount = AccountFactory.createAccountComplete("inc", "Ignacio", "Crovara",
                "inc@gmail.com", 42322344, "Quilmes", "Mitre");
        
        assertTrue(aAccount.isValidAccount());
    }

    @Test
    public void testNotIsEmptyUserName() {
    	Account aAccount = AccountFactory.createAccountWithUsername("INC");
    	assertFalse(aAccount.isEmptyUserName());
    }
    
    @Test
    public void testNotIsEmptyName() {
    	Account aAccount = AccountFactory.createAccountWithName("Ignacio");
    	
    	assertFalse(aAccount.isEmptyName());
    }
    
    @Test
    public void testNotIsEmptySurname() {
    	Account aAccount = AccountFactory.createAccountWithSurname("Crovara");
        
    	assertFalse(aAccount.isEmptySurname());
    }
    
    @Test
    public void testHasAEmailValid() {
    	Account aAccount = AccountFactory.createAccountWithEmailValid("inc@gmail.com");
    	
    	assertTrue(aAccount.hasAEmailValid());
    }
    
    @Test
    public void testIsntEmptyPhone() {
    	Account aAccount = AccountFactory.createAccountWithPhone(42322344);
    	
    	assertFalse(aAccount.isEmptyPhone());
    }
    
    @Test
    public void testHasValidLocation() {
    	Account aAccount = AccountFactory.createAccountWithLocation("Quilmes");
        
    	assertTrue(aAccount.hasValidLocation());
    }
    
    @Test
    public void testHasValidDirection() {
    	Account aAccount = AccountFactory.createAccountWithDirection("Mitre");
    	
    	assertTrue(aAccount.hasValidDirection());
    }
    
    @Test
    public void testAccountHasName() {
    	final String ACCOUNT_NAME = "Name";
    	
    	Account anyAccount = AccountFactory.anyAccount();
    	anyAccount.setName(ACCOUNT_NAME);
    	
    	assertTrue(anyAccount.getName().equals(ACCOUNT_NAME));
    }
}
