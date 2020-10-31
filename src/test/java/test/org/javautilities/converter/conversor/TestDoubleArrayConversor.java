package test.org.javautilities.converter.conversor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.javautilities.converter.conversor.DoubleArrayConversor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestDoubleArrayConversor {

    private DoubleArrayConversor conversor = new DoubleArrayConversor();

    @Test
    void shouldReturnEmptyWhenInputIsEmpty() {

        assertTrue(conversor.from(new int[] {}).length == 0);
        assertTrue(conversor.from(new double[] {}).length == 0);
        assertTrue(conversor.from(new String[] {}).length == 0);
        assertTrue(conversor.from(new ArrayList<>()).length == 0);
    }

    @Test
    void shouldReturnNonEmptyWhenInputIsNonEmptyIntegerArray() {

        Double[] actual = conversor.from(new int[] { 2, 3 });

        assertEquals(2, actual.length);
        assertEquals(2.0, actual[0]);
        assertEquals(3.0, actual[1]);
    }
    
    @Test
    void shouldReturnNonEmptyWhenInputIsNonEmptyDoubleArray() {

        Double[] actual = conversor.from(new double[] { 2.3, 3.5 });

        assertEquals(2, actual.length);
        assertEquals(2.3, actual[0]);
        assertEquals(3.5, actual[1]);
    }
    
    @Test
    void shouldReturnNonEmptyWhenInputIsNonEmptyStringArray() {

        Double[] actual = conversor.from(new String[] { "2", "3" });

        assertEquals(2, actual.length);
        assertEquals(2.0, actual[0]);
        assertEquals(3.0, actual[1]);
    }
    
    @Test
    void shouldReturnNonEmptyWhenInputIsNonEmptyStringList() {

        Double[] actual = conversor.from(Arrays.asList("2.3", "3.5"));

        assertEquals(2, actual.length);
        assertEquals(2.3, actual[0]);
        assertEquals(3.5, actual[1]);
    }
    
    @Test
    void shouldReturnNonEmptyWhenInputIsNonEmptyDoubleList() {

        Double[] actual = conversor.from(Arrays.asList(2.4, 3.5));

        assertEquals(2, actual.length);
        assertEquals(2.4, actual[0]);
        assertEquals(3.5, actual[1]);
    }
    
    @Test
    @DisplayName("Do not use default equals()")
    void shouldReturnNonEmptyWhenInputIsNonEmptyIntegerList() {

        @SuppressWarnings("serial")
        Double[] actual = conversor.from(new ArrayList<Integer>() {{
            add(4);
            add(5);
        }});

        assertEquals(2, actual.length);
        assertEquals(4.0, actual[0]);
        assertEquals(5.0, actual[1]);
    }
    
    @Test
    void notnull() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        assertNull(conversor.getClass().getDeclaredMethod("from", int[].class).invoke(conversor, new Object[]{ null }));
        assertNull(conversor.getClass().getDeclaredMethod("from", double[].class).invoke(conversor, new Object[]{ null }));
        assertNull(conversor.getClass().getDeclaredMethod("from", String[].class).invoke(conversor, new Object[]{ null }));
        assertNull(conversor.getClass().getDeclaredMethod("from", List.class).invoke(conversor, new Object[]{ null }));
        
    }
    
    @Test
    void shouldThrowExceptionWhenListIsNotValid() {

        assertThrows(IllegalArgumentException.class, () -> {

            conversor.from(Arrays.asList(new Object(), new Object()));
        });
    }
}
