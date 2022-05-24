/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author jamar
 */
@FacesValidator("validNumeric")
public class ValidNumeric implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String numeric = value.toString().trim();
        boolean isNumeric;
        
        if (numeric.length() == 0) {
            throw new ValidatorException(new FacesMessage("Campo obligatorio"));
        } else {
            try {
                Integer.parseInt(numeric);
                isNumeric = true;
            } catch (Exception e) {
                System.out.println(e);
                isNumeric = false;
            }
            
            if (!isNumeric) {
                throw new ValidatorException(new FacesMessage("Debe ser numerico"));
            }
        }
    }
    
}
