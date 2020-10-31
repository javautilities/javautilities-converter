package org.javautilities.converter.conversor;

import java.util.List;

public class DoubleArrayConversor implements Conversor<Double[]> {

    public Double[] from(final int[] array) {

        if (array == null) {
            return null;
        }

        Double[] output = new Double[array.length];

        for (int i = 0; i < array.length; i++) {
            output[i] = Double.valueOf(array[i]);
        }

        return output;
    }

    public Double[] from(final double[] array) {

        if (array == null) {
            return null;
        }

        Double[] output = new Double[array.length];

        for (int i = 0; i < array.length; i++) {
            output[i] = Double.valueOf(array[i]);
        }

        return output;
    }

    public Double[] from(final String[] array) {

        if (array == null) {
            return null;
        }

        Double[] output = new Double[array.length];

        for (int i = 0; i < array.length; i++) {
            output[i] = Double.parseDouble(array[i]);
        }

        return output;
    }

    public <S> Double[] from(final List<S> items) {

        if (items == null) {
            return null;
        }

        Double[] array = new Double[items.size()];

        for (int i = 0; i < items.size(); i++) {

            S item = items.get(i);

            if (item instanceof Double) {
                array[i] = (Double) item;
            } else if (item instanceof String) {
                array[i] = Double.parseDouble((String) item);
            } else if (item instanceof Integer) {
                array[i] = Double.valueOf((Integer) item);
            } else {
                throw new IllegalArgumentException("invalid type");
            }
        }

        return array;
    }
}
