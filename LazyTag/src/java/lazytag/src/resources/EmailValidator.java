/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lazytag.src.resources;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Validate email format
 * @author Priya
 */
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext,
            UIComponent uIComponent, Object object) throws ValidatorException {

        String enteredEmail = (String) object;
        //Set the email pattern string
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

        //Match the given string with the pattern
        Matcher m = p.matcher(enteredEmail);

        //Check whether match is found
        boolean matchFound = m.matches();

        if (enteredEmail.length()>0 && !matchFound) {
            FacesMessage message = new FacesMessage();
            message.setDetail(new MessageProvider().getValue("invalidemail"));
            message.setSummary(new MessageProvider().getValue("invalidemail"));
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
