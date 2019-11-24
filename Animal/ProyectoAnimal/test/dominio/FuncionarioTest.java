/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import encriptacion.PasswordUtils;
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
public class FuncionarioTest {
    
    private Funcionario f;
    
    public FuncionarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        f = new Funcionario("", "", "");
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testGetEmail() {;
        f.setEmail("p.perez@gmail.com");
        assertEquals("p.perez@gmail.com", f.getEmail());
    }

    
    @Test
    public void testGetUsername() {
        f.setUsername("PabloPerez");
        assertEquals("PabloPerez", f.getUsername());
    }

    
    @Test
    public void testGetPassword() {
        f.setPassword("pp231094");
        
        assertEquals(f.getPassword(), PasswordUtils.generarPasswordSeguro("pp231094", f.getGeneratedSalt()));
    }

    

    
    @Test
    public void testSetUsername() {
        f.setUsername("PabloP");
        assertEquals("PabloP", f.getUsername());
    }

    
    @Test
    public void testSetEmail() {
        f.setEmail("perez23@gmail.com");
        assertEquals("perez23@gmail.com", f.getEmail());
    }

    
    @Test
    public void testSetPassword() {
        f.setPassword("pabloPerez2310");
        assertEquals(PasswordUtils.generarPasswordSeguro("pabloPerez2310", f.getGeneratedSalt()), f.getPassword());
    }

    
    @Test
    public void testEqualsConOtroObjeto() {
        assertEquals(f.equals("Pablo"), false);
    }
    
    
    @Test
    public void testEqualsFuncionarioMismoNombre(){
        Funcionario func = new Funcionario(f.getUsername(), "pabloPerez2310", "pPerez@gmail.com");
        f.setEmail("pabloperez@gmail.com");
        assertEquals(true, f.equals(func));
    }
    
    @Test
    public void testEqualsFuncionarioMismoMail(){
        Funcionario func = new Funcionario("PPerez","pabloPerez2310", "perez23@gmail.com");
        f.setEmail(func.getEmail());
        f.setUsername("Pablito");
        assertEquals(true, f.equals(func));
    }
}
