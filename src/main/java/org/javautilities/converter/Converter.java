package org.javautilities.converter;

import org.javautilities.converter.conversor.DoubleArrayConversor;
import org.javautilities.converter.conversor.StringListConversor;

/**
 * Class responsible for converting from a data type to another one
 * 
 * @author Thiago Ferreira
 * @since 2020-10-31
 * @version 0.0.1
 */
public class Converter {

    /** To Double[] */
    public final static DoubleArrayConversor toDoubleArray;

    /** To List&lt;String&gt; */
    public final static StringListConversor toStringList;

    static {
        toDoubleArray = new DoubleArrayConversor();
        toStringList = new StringListConversor();
    }

    /**
     * Private constructor to prevent instantiation
     * 
     * @throws IllegalAccessException instantiating utility class
     */
    private Converter() throws IllegalAccessException {
        throw new IllegalAccessException("Instantiating utility class");
    }
}