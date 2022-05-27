package se.yrgo.schedule;

/**
 * A factory to get a formatter (XML or JSON)
 */
public class FormatterFactory {

    private static Formatter XML_FORMATTER = new XmlFormatter();
    private static Formatter JSON_FORMATTER = new JsonFormatter();

    /**
     * Returns a formatter for the given contentType
     *
     * @param -The content type you want to format to (JSON and XML implemented..)
     * @return -A Formatter of the correct type, depending on the provided
     * contentType. Throws IllegalArgumentException if argument is not XML or JSON.
     */
    public static Formatter getFormatter(String contentType) {
        if (contentType.equalsIgnoreCase("xml")) {
            return XML_FORMATTER;
        } else if (contentType.equalsIgnoreCase("json")) {
            return JSON_FORMATTER;
        } else {
            throw new IllegalArgumentException("Format not supported");
        }
    }
}
