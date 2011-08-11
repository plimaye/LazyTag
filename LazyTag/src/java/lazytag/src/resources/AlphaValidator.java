/*
    Copyright© 2011 Priya Limaye, Nandini Mahendran

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

    Contact: plimaye@pdx.edu, mnandini@pdx.edu
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
