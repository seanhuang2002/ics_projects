package adress.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil 
{

    //Modifier le format en fonction des besoins 
    private static final String DATE_PATTERN = "dd.MM.yyyy";

    // Formattage de la date. 
    
    private static final DateTimeFormatter DATE_FORMATTER = 
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * Retourne la date et le string formatté
     * {@link DateUtil#DATE_PATTERN} is used.
     * 
     * @param date à retourner comme string
     * @return string formatté
     */
    public static String format(LocalDate date) 
    {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Conversion de la date en string selon les spécifications de {@link DateUtil#DATE_PATTERN}
     * à l'objet {@link LocalDate}.
     * 
     * Retourne Null si le formattage ne peut pas se faire
     * 
     * @param retourne dateString comme un String
     * @return Retourne Null si le formattage ne peut pas se faire
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * vérification si le String est une date valide.
     * 
     * @param dateString
     * @return true si la date est valide
     */
    public static boolean validDate(String dateString) {
        return DateUtil.parse(dateString) != null;
    }

}