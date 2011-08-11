/*
 * Copyright© 2011 Priya Limaye, Nandini Mahendran

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

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 * Read resources file and retrieve value for entered key.
 * @author Priya
 */
public class MessageProvider {

    private ResourceBundle bundle;
    public ResourceBundle getBundle() {
        if (bundle == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            bundle = context.getApplication().getResourceBundle(context, "msg");
        }
        return bundle;
    }

    public String getValue(String key) {

        String result = null;
        try {
            result = getBundle().getString(key);
        } catch (MissingResourceException e) {
            result = null;
        }
        return result;
    }
}
