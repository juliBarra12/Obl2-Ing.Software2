/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

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
public class AdopcionTest {
    
    
    Adopcion adopcion;
    Animal a;
    
    public AdopcionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        a = new Animal("Lola", "Perro", 0.20, 2.5, "");
        adopcion = new Adopcion("Pablo","Perez", 42229467,a);
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testSetNombreAdoptante() {
        adopcion.setNombreAdoptante("Mauricio");
        assertEquals("Mauricio", adopcion.getNombreAdoptante());
    }

    
    @Test
    public void testGetNombreAdoptante() {
        adopcion.setNombreAdoptante("Pablo");
        assertEquals("Pablo", adopcion.getNombreAdoptante());
    }

    
    @Test
    public void testSetApellidoAdoptante() {
        adopcion.setApellidoAdoptante("Lopez");
        assertEquals("Lopez", adopcion.getApellidoAdoptante());
    }

    
    @Test
    public void testGetApellidoAdoptante() {
        adopcion.setApellidoAdoptante("Lopez");
        assertEquals("Lopez", adopcion.getApellidoAdoptante());
    }

    
    @Test
    public void testSetTelefono() {
        adopcion.setTelefono(26395712);
        assertEquals(26395712,adopcion.getTelefono());
    }

    
    @Test
    public void testGetTelefono() {
        adopcion.setTelefono(26395712);
        assertEquals(26395712, adopcion.getTelefono());
    }

    
    @Test
    public void testSetAnimal() {
        Animal a = new Animal("Gaturro","Gato",0.25,4.5,"");
        adopcion.setAnimal(a);
        assertEquals(a,adopcion.getAnimal());
    }

    
    @Test
    public void testGetAnimal() {
        Animal a = new Animal("Gaturro","Gato",0.25,4.5,"");
        adopcion.setAnimal(a);
        assertEquals(adopcion.getAnimal(), a);
    }

    
    @Test
    public void testToString() {
        assertEquals(adopcion.getNombreAdoptante()+" "+adopcion.getApellidoAdoptante(),adopcion.toString());
    }
    
}
