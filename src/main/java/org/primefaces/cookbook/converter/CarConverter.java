package org.primefaces.cookbook.converter;

/**
 * User: mertcaliskan
 * Date: 7/9/12
 */

import org.apache.commons.lang3.StringUtils;
import org.primefaces.cookbook.model.chapter3.Car;

import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.HashMap;
import java.util.Map;

@FacesConverter(value = "org.primefaces.cookbook.converter.CarConverter")
public class CarConverter implements Converter {

    public static Map<String, Car> cars = new HashMap<String, Car>();

    static {
        cars.put("CC", new Car("CC"));
        cars.put("Golf", new Car("Golf"));
        cars.put("Jetta", new Car("Jetta"));
        cars.put("Passat", new Car("Passat"));
        cars.put("Polo", new Car("Polo"));
        cars.put("Scirocco", new Car("Scirocco"));
        cars.put("Touareg", new Car("Touareg"));
    }
    
    public Object getAsObject(final FacesContext fc, final UIComponent component, final String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        else {
            return cars.get(value);
        }
    }

    public String getAsString(final FacesContext fc, final UIComponent component, final Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Car) value).getName());
        }
    }
}
