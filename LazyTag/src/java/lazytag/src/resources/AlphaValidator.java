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
 * Validate input for alphabetical values.
 * @author Priya
 */
public class AlphaValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext,
            UIComponent uIComponent, Object object) throws ValidatorException {

        String enteredEmail = (String) object;
        //Set the alpha pattern string
        Pattern p = Pattern.compile("^[a-zA-Z ]*$");

        //Match the given string with the pattern
        Matcher m = p.matcher(enteredEmail);

        //Check whether match is found
        boolean matchFound = m.matches();

        if (enteredEmail.length()>0 && !matchFound) {
            FacesMessage message = new FacesMessage();
            message.setDetail(new MessageProvider().getValue("alpha"));
            message.setSummary(new MessageProvider().getValue("alpha"));
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
