package id.swhp.javaee.soap.business.account.boundary;

import id.swhp.javaee.soap.business.account.entity.Account;
import id.swhp.javaee.soap.business.account.entity.Message;
import id.swhp.javaee.soap.business.account.entity.Status;
import java.util.Random;
import javax.ejb.Stateless;

/**
 *
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Stateless
public class AccountManagement {
    
    // hard-coded the correct username
    private static final String CORRECT_USERNAME = "swhp";

    public Message validateAccount(Account account) {
        Status status = null;
        if(account.getUsername().equalsIgnoreCase(CORRECT_USERNAME)) {
            status = new Status("99", "SUCCESS");
        } else {
            status = new Status("00", "FAILED");
        }
        // generate random request number with java.util.Random
        return new Message(new Random().nextLong(), status);
    }
}
