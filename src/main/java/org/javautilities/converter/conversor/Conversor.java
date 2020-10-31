package org.javautilities.converter.conversor;

import java.util.List;

public interface Conversor<T> {

    public T from(final int[] array);

    public T from(final double[] array);

    public T from(final String[] array);

    public <F> T from(final List<F> items);
}
