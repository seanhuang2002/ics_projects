package adress.util;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;
/**
 * Ce fichier permet de gérer la conversion de la date 
 * locale du programme java vers le fichier XML (marshall)
 * et l'inverse (Unmarshall)
 * @author seanhuang
 *
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}