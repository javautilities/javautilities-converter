package org.javautilities.converter.conversor;

import java.util.List;

public class StringListConversor implements Conversor<List<String>> {

    public List<String> from(final int[] array) {
        return null;
    }

    public List<String> from(final double[] array) {
        return null;
    }

    public List<String> from(final String[] array) {
        return null;
    }

    public <S> List<String> from(final List<S> items) {

        if (items == null) {
            return null;
        }

        return null;
    }
}
