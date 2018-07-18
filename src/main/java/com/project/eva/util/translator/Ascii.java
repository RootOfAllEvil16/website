package com.project.eva.util.translator;

/**
 * The interface describes a set of methods
 * for translate to ASCII and from ASCII.
 *

 */
public interface Ascii {

    /**
     * Translates value to ASCII.
     * If value is blank then returns empty string.
     *
     * @return The translated string or empty string.
     */
    String to();

    /**
     * Translates value from ASCII.
     * If value is blank then returns empty string.
     *
     * @return The translated string or empty string.
     */
    String from();
}
