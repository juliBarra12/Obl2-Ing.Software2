/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juli
 */
public class PadrinoTest {
    
    Padrino p;
    
    public PadrinoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        p = new Padrino("Pablo","Perez",26597312,"p.perez23@gmail","Montevideo","Uruguay",5000,"Tarjeta de credito","Dolares","una vez");
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testSetNombre() {
        p.setNombre("Pepe");
        assertEquals("Pepe", p.getNombre());
    }

    
    @Test
    public void testGetNombre() {
        p.setNombre("Pepe");
        assertEquals("Pepe",p.getNombre());
    }

    
    @Test
    public void testSetApellido() {
        p.setApellido("Lopez");
        assertEquals("Lopez", p.getApellido());
    }

    
    @Test
    public void testGetApellido() {
        p.setApellido("Lopez");
        assertEquals("Lopez", p.getApellido());
    }

    
    @Test
    public void testSetTelefono() {
        p.setTelefono(26193762);
        assertEquals(26193762,p.getTelefono());
    }

    
    @Test
    public void testGetTelefono() {
        p.setTelefono(26876543);
        assertEquals(26876543,p.getTelefono());
    }

    
    @Test
    public void testSetEmail() {
        p.setEmail("pepelopez@gmail.com");
        assertEquals("pepelopez@gmail.com",p.getEmail());
    }

    
    @Test
    public void testGetEmail() {
        p.setEmail("pepelopez@hotmail.com");
        assertEquals("pepelopez@hotmail.com",p.getEmail());
    }

    
    @Test
    public void testSetCiudad() {
        p.setCiudad("Minas");
        assertEquals("Minas", p.getCiudad());
    }

   
    @Test
    public void testGetCiudad() {
        p.setCiudad("Minas");
        assertEquals("Minas", p.getCiudad());
    }

    
    @Test
    public void testSetPais() {
        p.setPais("Argentina");
        assertEquals("Argentina", p.getPais());
    }

    
    @Test
    public void testGetPais() {
        p.setPais("Argentina");
        assertEquals("Argentina", p.getPais());
    }

    
    @Test
    public void testAddAnimalApadrinado() {
        Animal a = new Animal("Juana", "Gato", 0.25,4.35, "");
        p.addAnimalApadrinado(a);
        assertEquals(true, p.getApadrinados().contains(a));
    }

    
    @Test
    public void testGetApadrinados() {
        Animal a = new Animal("Juana", "Gato", 0.25,4.35, "");
        p.addAnimalApadrinado(a);
        ArrayList<Animal> apadrinados = new ArrayList<>();
        apadrinados.add(a);
        assertEquals(p.getApadrinados(), apadrinados);
    }

    
    @Test
    public void testSetApadrinados() {
        Animal a = new Animal("Juana", "Gato", 0.25,4.35, "");
        ArrayList<Animal> apadrinados = new ArrayList<>();
        apadrinados.add(a);
        p.setApadrinados(apadrinados);
        assertEquals(p.getApadrinados(), apadrinados);
    }

    
    @Test
    public void testSetMonto() {
        p.setMonto(300);
        assertEquals(300, p.getMonto());
    }

    
    @Test
    public void testGetMonto() {
        p.setMonto(500);
        assertEquals(500, p.getMonto());
    }

    
    @Test
    public void testSetMetodoPago() {
        p.setMetodoPago("Transferencia bancaria");
        assertEquals("Transferencia bancaria", p.getMetodo());
    }

    
    @Test
    public void testGetMetodo() {
        p.setMetodoPago("Tarjeta de credito");
        assertEquals("Tarjeta de credito", p.getMetodo());
    }

    
    @Test
    public void testSetMoneda() {
        p.setMoneda("Pesos uruguayos");
        assertEquals("Pesos uruguayos", p.getMoneda());
    }

    
    @Test
    public void testGetMoneda() {
        p.setMoneda("Dolares");
        assertEquals("Dolares", p.getMoneda());
    }

    
    @Test
    public void testSetFrecuencia() {
        p.setFrecuencia("Semestral");
        assertEquals("Semestral", p.getFrecuencia());
    }

    
    @Test
    public void testGetFrecuencia() {
        p.setFrecuencia("Mensual");
        assertEquals("Mensual", p.getFrecuencia());
    }

    
    @Test
    public void testToString() {
        assertEquals(p.getNombre(), p.toString());
    }
    
}
