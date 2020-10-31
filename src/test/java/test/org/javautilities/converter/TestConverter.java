package test.org.javautilities.converter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.javautilities.converter.Converter;
import org.junit.jupiter.api.Test;

public class TestConverter {

    @Test
    void shouldNotInstantiable() {

        assertThrows(Exception.class, () -> {

            Constructor<Converter> constructor = Converter.class.getDeclaredConstructor();
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
            constructor.setAccessible(true);
            constructor.newInstance();
            Converter.class.newInstance(); // exception here
        });
    }

    @Test
    void shouldReturnEmptyWhenInputIsEmpty() {

        assertNotNull(Converter.toDoubleArray);
        assertNotNull(Converter.toStringList);
    }
}
