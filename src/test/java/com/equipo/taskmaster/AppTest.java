package com.equipo.taskmaster;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAddTask() {
        App.tasks.clear();
        App.addTask("Terminar Ejercicio Maven");
        assertEquals(1, App.tasks.size());
    }
}
