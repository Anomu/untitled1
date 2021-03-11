package ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void count() {
        //Prueba sin colisiones
        HashTable h = new HashTable();
        for (int i = 0; i < 10; i++) {
            h.put(String.valueOf(i),String.valueOf(i+1));
        }
        Assertions.assertEquals(10, h.count());

        for (int i = 0; i < 5; i++) {
            h.drop(String.valueOf(i));
        }
        Assertions.assertEquals(5, h.count());

        //Prueba con colisiones

        h.put("1","hola");
        h.put("12","hola");
        h.put("01","hola");
        Assertions.assertEquals(8,h.count());

        h.drop("1");
        h.drop("12");
        h.drop("01");
        Assertions.assertEquals(5,h.count());

    }

    @Test
    void size() {
        HashTable h = new HashTable();
        Assertions.assertEquals(16, h.size());
    }

    @Test
    void put() {
        ex1.HashTable h = new ex1.HashTable();

        try {
            h.put("1", "hola");
            h.put("01", "hola");
            Assertions.assertEquals("\n bucket[1] = [1, hola] -> [01, hola]", h.toString());
            Assertions.assertTrue(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            Assertions.assertTrue(false);
        }

        try {
            h.put("asasas", "hola");
            Assertions.assertTrue(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            Assertions.assertTrue(false);
        }

        try {
            h.put("555555555", "hola");
            Assertions.assertTrue(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            Assertions.assertTrue(false);
        }


    }

    @Test
    void get() {
        ex1.HashTable h = new ex1.HashTable();

        h.put("1","hola");
        h.put("12","hola");
        h.put("01","hola");


        Assertions.assertEquals("hola", h.get("1"));
        Assertions.assertEquals("hola", h.get("12"));
        Assertions.assertEquals("hola", h.get("01"));
        Assertions.assertEquals(null, h.get("5"));

    }

    @Test
    void drop() {
//Drop sin colisiones.
        HashTable h = new HashTable();
        h.put("1", "hola");
        h.put("2","hola");
        h.put("3","hola");
        h.drop("1");
        Assertions.assertEquals("\n bucket[2] = [2, hola]\n bucket[3] = [3, hola]", h.toString());

        //Drop con colisiones.
        HashTable j = new HashTable();
        j.put("1", "hola");
        j.put("01", "hola");
        j.put("12","hola");
        j.drop("1");
        Assertions.assertEquals("\n bucket[2] = [01, hola]\n bucket[3] = [12, hola]", j.toString());

    }
}