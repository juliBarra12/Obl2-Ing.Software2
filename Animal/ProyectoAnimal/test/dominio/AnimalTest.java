/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marce
 */
public class AnimalTest {
    private Animal animal;
    public AnimalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        animal = new Animal();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testConstructorSinParametros() {
        Animal unAnimal = new Animal();
        assertEquals("Sin-Nombre", unAnimal.getNombre());
        assertEquals(0, unAnimal.getPeso(),0);
        assertEquals(0, unAnimal.getAltura(),0);
        assertEquals("", unAnimal.getTipo());
        assertNull(unAnimal.getFoto());
        assertEquals("Sin-Comentarios", unAnimal.getComentarios());
    }
    
     @Test
    public void testConstructorPorParametros() {
        Animal unAnimal = new Animal("Rasta", "Perro", 1.1, 2.3, "Es rubio");
        assertEquals("Rasta", unAnimal.getNombre());
        assertEquals(1.1, unAnimal.getAltura(), 0);
        assertEquals(2.3, unAnimal.getPeso(), 0);
        assertEquals("Perro", unAnimal.getTipo());
        assertEquals("Es rubio", unAnimal.getComentarios());
        assertEquals(null, unAnimal.getFoto());
    }
     @Test
    public void testConstructorPorParametrosConPesoYAlturaMenoresQue0() {
        Animal unAnimal = new Animal("Rasta","Gato", -1.1, -2.3, "Es rubio");
        assertEquals("Rasta", unAnimal.getNombre());
        assertEquals(0.0, unAnimal.getAltura(), 0);
        assertEquals(0.0, unAnimal.getPeso(), 0);
        assertEquals("Gato", unAnimal.getTipo());
        assertEquals("Es rubio", unAnimal.getComentarios());
        assertEquals(null, unAnimal.getFoto());
    }
    
     @Test
    public void testConstructorPorParametrosConNombreYComentariosVacios() {
        Animal unAnimal = new Animal("","Caballo", -1.1, -2.3, "");
        assertEquals("Sin-Nombre", unAnimal.getNombre());
        assertEquals("Caballo", unAnimal.getTipo());
        assertEquals(0.0, unAnimal.getAltura(), 0);
        assertEquals(0.0, unAnimal.getPeso(), 0);
        assertEquals("Sin-Comentarios", unAnimal.getComentarios());
        assertEquals(null, unAnimal.getFoto());
    }
    
    @Test
    public void testSetNombre(){
        animal.setNombre("Rasta");
        assertEquals("Rasta", animal.getNombre());
    }
    
    @Test
    public void testSetTipo(){
        animal.setTipo("Perro");
        assertEquals("Perro", animal.getTipo());
    }
    
    @Test
    public void testSetNombreVacio(){
        animal.setNombre("");
        assertEquals("Sin-Nombre", animal.getNombre());
    }
    
     @Test
    public void testSetComentarios(){
        animal.setComentarios("Es rubio");
        assertEquals("Es rubio", animal.getComentarios());
    }
    
    @Test
    public void testSetComentariosVacio(){
        animal.setComentarios("");
        assertEquals("Sin-Comentarios", animal.getComentarios());
    }
    @Test
    public void testSetRutaFoto(){
        ImageIcon imagen = new ImageIcon("/interfaz.images/perro.png");
        animal.setFoto(imagen);
        assertEquals(imagen, animal.getFoto());
    }
    
    @Test
    public void testSetRutaFotoVacia(){
        animal.setFoto(null);
        assertEquals(null, animal.getFoto());
    }
    
    @Test
    public void testEqualsConOtroObjeto(){
        assertEquals(animal.equals("Animal"), false);
    }
    
    @Test
    public void testEstaAdoptadoNegativo(){
        assertEquals(animal.estaAdoptado(),false);
    }
    
    @Test
    public void testEstadoAdopcionSinAdoptar(){
        assertEquals(animal.estadoAdopcion(), "ANIMAL SIN ADOPTAR");
    }
    
    @Test
    public void testAdopcion(){
        animal.adoptar();
        assertEquals(animal.estaAdoptado(), true);
    }
    
    @Test
    public void testEstaAdoptadoPositivo(){
        animal.adoptar();
        assertEquals(animal.estaAdoptado(),true);
    }
    
    @Test
    public void testEstadoAdopcionAdoptado(){
        animal.adoptar();
        assertEquals(animal.estadoAdopcion(), "ANIMAL ADOPTADO");
    }
    
    @Test
    public void testToString(){
        String resToString = animal.toString();
        String nombre = animal.getNombre();
        assertEquals(nombre, resToString);
    }
}
