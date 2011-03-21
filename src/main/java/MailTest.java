import java.net.UnknownHostException;

import javax.mail.Message.RecipientType;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.MailException;
import org.codemonkey.simplejavamail.Mailer;

/**
 * Demonstration program for the Simple Java Mail framework.
 * <p>
 * <b>IMPORTANT</b>: <br />
 * This testclass was designed to run from the commandline (or by Ant) and expects some system properties to be present. See
 * <b>Readme.txt</b> for instructions. Alternatively, you can assign the host, username and password a hard value and ignore the system
 * properties altogether.
 * 
 * @author Benny Bottema
 */
public class MailTest {

	public static void main(final String[] args)
			throws MailException, UnknownHostException {
		final Email email = new Email();
		email.setFromAddress("lollypop", "lol.pop@somemail.com");
		email.addRecipient("C.Cane", "candycane@candyshop.org", RecipientType.TO);
		email.setText("We should meet up!");
		email.setTextHTML("<b>We should meet up!</b>");
		email.setSubject("hey");
		sendMail(email);
	}

	private static void sendMail(final Email email) {
		final String host = System.getProperty("host") != null ? System.getProperty("host") : "";
		final String username = System.getProperty("username") != null ? System.getProperty("username") : "";
		final String password = System.getProperty("password") != null ? System.getProperty("password") : "";
		new Mailer(host, 25, username, password).sendMail(email);
	}
}