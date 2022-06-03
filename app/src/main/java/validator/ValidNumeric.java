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
        
        if (numeric.equals("0")) {
            throw new ValidatorException(new FacesMessage("Debe ser diferente a 0"));
        } else {
            String textFormat = "[0-9]*"; 
            
            boolean isNumeric = Pattern.matches(textFormat, numeric);
            
            if (!isNumeric) {
                throw new ValidatorException(new FacesMessage("Solo ingrese numeros"));
            }
        }
    }
    
}
