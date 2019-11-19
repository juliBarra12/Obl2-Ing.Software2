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
 * @author marce
 */
public class SistemaTest {

    private Sistema sis;

    public SistemaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        sis = new Sistema();
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
    public void testConstructorSinParametros(){
        Sistema unSistema = new Sistema();
        assertEquals(new ArrayList<>(), unSistema.getActividades());
        assertEquals(new ArrayList<>(), unSistema.getActsCualquieras());
        assertEquals(new ArrayList<>(), unSistema.getAlimentaciones());
        assertEquals(new ArrayList<>(), unSistema.getFechas());
        assertEquals(new ArrayList<>(), unSistema.getPaseos());
        assertEquals(new ArrayList<>(), unSistema.getAnimales());
        assertEquals(new ArrayList<>(), unSistema.getUsuarios());
        assertEquals(new ArrayList<>(), unSistema.getVeterinarias());
        assertEquals(new ArrayList<>(), unSistema.getVisitas());
    }
    
    @Test
    public void testAñadirActividadDosElementos() {
        Actividad act1 = new ActividadCualquiera();
        Actividad act2 = new Alimentacion();
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        assertTrue(sis.getActividades().contains(act1));
        assertTrue(sis.getActividades().contains(act2));
    }

    @Test
    public void testListaActicidadesPorFecha() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(10, 2, 2018);
        assertTrue(lista.contains(act1));
        assertTrue(lista.contains(act2));
    }

    @Test
    public void testListaActividadesPorFechaDistinta() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(10, 1, 2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
    }

    @Test
    public void testListaActividadesPorFechaDiaNegativo() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(-10, 2, 2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaMesNegativo() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(10, -2, 2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaAnoNegativo() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(10, 2, -2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaDiaMayorA31() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(32, 2, 2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaMesMayorA12() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(10, 13, 2018);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaAnoMenorA1() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(31, 2, 0);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaDiaMesAnoMal() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(32, -2, 0);
        assertTrue(!lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertTrue(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaDiaDistintos() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Fecha fecha2 = new Fecha(11, 2, 2018);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha2);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(10, 2, 2018);
        assertTrue(lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaMesDistintos() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Fecha fecha2 = new Fecha(10, 3, 2018);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha2);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(10, 2, 2018);
        assertTrue(lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaAnoDistintos() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Fecha fecha2 = new Fecha(10, 2, 2019);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha2);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(10, 2, 2018);
        assertTrue(lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testListaActividadesPorFechaTodaDistinta() {
        Fecha fecha = new Fecha(10, 2, 2018);
        Fecha fecha2 = new Fecha(11, 3, 2019);
        Actividad act1 = new ActividadCualquiera();
        act1.setFecha(fecha);
        Actividad act2 = new ActividadCualquiera();
        act2.setFecha(fecha2);
        sis.anadirActividad(act1);
        sis.anadirActividad(act2);
        ArrayList<Actividad> lista = sis.listaActividadesPorFecha(10, 2, 2018);
        assertTrue(lista.contains(act1));
        assertTrue(!lista.contains(act2));
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testSetUsuarios() {
        ArrayList<Usuario> lstUsuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        lstUsuarios.add(usuario);
        sis.setUsuarios(lstUsuarios);
        assertTrue(sis.getUsuarios().contains(usuario));
    }

    @Test
    public void testSetUsuariosVacio() {
        ArrayList<Usuario> lstUsuarios = new ArrayList<>();
        sis.setUsuarios(lstUsuarios);
        assertTrue(sis.getUsuarios().isEmpty());
    }

    @Test
    public void testSetPerros() {
        ArrayList<Animal> lstPerros = new ArrayList<>();
        Animal animal = new Animal();
        lstPerros.add(animal);
        sis.setMascotas(lstPerros);
        assertTrue(sis.getAnimales().contains(animal));
    }

    @Test
    public void testSetPerrosVacio() {
        ArrayList<Animal> lstAnimales = new ArrayList<>();
        sis.setMascotas(lstAnimales);
        assertTrue(sis.getAnimales().isEmpty());
    }

    @Test
    public void testAnadirAnimal() {
        Animal animal = new Animal();
        sis.agregarAnimal(animal);
        assertTrue(sis.getAnimales().contains(animal));
    }

    @Test
    public void testEliminarAnimal() {
        Animal perro = new Animal();
        sis.getAnimales().add(perro);
        sis.eliminarPerro(perro);
        assertFalse(sis.getAnimales().contains(perro));
    }

    @Test
    public void testEliminarPerroQueNoEsta() {
        Animal animal = new Animal();
        sis.eliminarPerro(animal);
        assertEquals(false, sis.getAnimales().contains(animal));
    }

    @Test
    public void testAnadirUsuario() {
        Usuario usuario = new Usuario();
        sis.añadirUsuario(usuario);
        assertTrue(sis.getUsuarios().contains(usuario));
    }

    @Test
    public void testAnadirUsuarioRepetido() {
        Usuario usuario = new Usuario();
        Usuario u = new Usuario();
        sis.añadirUsuario(usuario);
        sis.añadirUsuario(u);
        assertTrue(sis.getUsuarios().contains(u));
    }
    
    @Test
    public void testEliminarUsuario() {
        Usuario usuario = new Usuario();
        sis.getUsuarios().add(usuario);
        sis.eliminarUsuario(usuario);
        assertFalse(sis.getUsuarios().contains(usuario));
    }

    @Test
    public void testEliminarUsuarioQueNoEsta() {
        Usuario usuario = new Usuario();
        sis.eliminarUsuario(usuario);
        assertEquals(false, sis.getUsuarios().contains(usuario));
    }

    @Test
    public void testAnadirActividad() {
        Actividad act = new ActividadCualquiera();
        sis.anadirActividad(act);
        assertTrue(sis.getActividades().contains(act));
    }

    @Test
    public void testEliminarActividad() {
        Actividad act = new ActividadCualquiera();
        sis.getActividades().add(act);
        sis.eliminarActividad(act);
        assertFalse(sis.getActividades().contains(act));
    }

    @Test
    public void testEliminarActividadQueNoEsta() {
        Actividad act = new ActividadCualquiera();
        Actividad act2 = new Alimentacion();
        sis.anadirActividad(act2);
        sis.eliminarActividad(act);
        assertFalse(sis.getActividades().contains(act));
        assertTrue(sis.getActividades().contains(act2));
    }

    @Test
    public void testAnadirFecha() {
        Fecha fecha = new Fecha();
        sis.anadirFecha(fecha);
        assertTrue(sis.getFechas().contains(fecha));
    }

    @Test
    public void testEliminarFecha() {
        Fecha fecha = new Fecha();
        sis.getFechas().add(fecha);
        sis.eliminarFecha(fecha);
        assertFalse(sis.getFechas().contains(fecha));
    }

    @Test
    public void testEliminarFechaQueNoEsta() {
        Fecha fecha = new Fecha();
        Fecha fecha2 = new Fecha();
        sis.anadirFecha(fecha2);
        sis.eliminarFecha(fecha);
        assertFalse(sis.getFechas().contains(fecha));
        assertTrue(sis.getFechas().contains(fecha2));
    }

    @Test
    public void testSetFechas() {
        ArrayList<Fecha> lstFechas = new ArrayList<>();
        Fecha fecha = new Fecha();
        lstFechas.add(fecha);
        sis.setFechas(lstFechas);
        assertTrue(sis.getFechas().contains(fecha));
    }

    @Test
    public void testSetFechasVacio() {
        ArrayList<Fecha> lstFechas = new ArrayList<>();
        sis.setFechas(lstFechas);
        assertTrue(sis.getFechas().isEmpty());
    }

    @Test
    public void testBuscarUsuarioPorNombre() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Marcel");
        sis.añadirUsuario(usuario);
        assertEquals(usuario, sis.buscarUsuarioPorNombre("Marcel"));
    }
    
    @Test
    public void testBuscarUsuarioPorNombreDistintos() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Marcel");
        sis.añadirUsuario(usuario);
        assertEquals(null, sis.buscarUsuarioPorNombre("Alejandro"));
    }
    
    @Test
    public void testBuscarPerroPorNombre() {
        Animal animal = new Animal();
        animal.setNombre("Marcel");
        sis.agregarAnimal(animal);
        assertEquals(animal, sis.buscarPerroPorNombre("Marcel"));
    }
    
    @Test
    public void testBuscarPerroPorNombreDistintos() {
        Animal perro = new Animal();
        perro.setNombre("Marcel");
        sis.agregarAnimal(perro);
        assertEquals(null, sis.buscarPerroPorNombre("Alejandro"));
    }
    
    @Test
    public void testBuscarVeterinariaPorNombre() {
        Veterinaria vet = new Veterinaria();
        vet.setNombre("Marcel");
        sis.getVeterinarias().add(vet);
        assertEquals(vet, sis.buscarVetPorNombre("Marcel"));
    }
    
    @Test
    public void testBuscarVeterinariaPorNombreDistintos() {
        Veterinaria vet = new Veterinaria();
        vet.setNombre("Marcel");
        sis.getVeterinarias().add(vet);
        assertEquals(null, sis.buscarVetPorNombre("Alejandro"));
    }
    
    @Test
    public void testBuscarPaseoPorNombre() {
        Paseo paseo = new Paseo();
        paseo.setNombre("Marcel");
        sis.getPaseos().add(paseo);
        assertEquals(paseo, sis.buscarPaseoPorNombre("Marcel"));
    }
    
    @Test
    public void testBuscarPaseoPorNombreDistintos() {
        Paseo paseo = new Paseo();
        paseo.setNombre("Marcel");
        sis.getPaseos().add(paseo);
        assertEquals(null, sis.buscarPaseoPorNombre("Alejandro"));
    }
    
    @Test
    public void testBuscarVisitaPorNombre() {
        VisitaVeterinaria visita = new VisitaVeterinaria();
        visita.setNombre("Marcel");
        sis.getVisitas().add(visita);
        assertEquals(visita, sis.buscarVisitaPorNombre("Marcel"));
    }
    
    @Test
    public void testBuscarVisitaPorNombreDistintos() {
        VisitaVeterinaria visita = new VisitaVeterinaria();
        visita.setNombre("Marcel");
        sis.getVisitas().add(visita);
        assertEquals(null, sis.buscarVisitaPorNombre("Alejandro"));
    }
    
    @Test
    public void testBuscarAlimentacionPorNombre() {
        Alimentacion alim = new Alimentacion();
        alim.setNombre("Marcel");
        sis.getAlimentaciones().add(alim);
        assertEquals(alim, sis.buscarAlimentacionPorNombre("Marcel"));
    }
    
    @Test
    public void testBuscarAlimentacionPorNombreDistintos() {
        Alimentacion alim = new Alimentacion();
        alim.setNombre("Marcel");
        sis.getAlimentaciones().add(alim);
        assertEquals(null, sis.buscarAlimentacionPorNombre("Alejandro"));
    }
    
    @Test
    public void testBuscarActsPorNombre() {
        ActividadCualquiera act = new ActividadCualquiera();
        act.setNombre("Marcel");
        sis.getActsCualquieras().add(act);
        assertEquals(act, sis.buscarActCualquieraPorNombre("Marcel"));
    }
    
    @Test
    public void testBuscarActsPorNombreDistintos() {
        ActividadCualquiera act = new ActividadCualquiera();
        act.setNombre("Marcel");
        sis.getActsCualquieras().add(act);
        assertEquals(null, sis.buscarActCualquieraPorNombre("Alejandro"));
    }
    
    @Test
    public void testSetVets() {
        ArrayList<Veterinaria> lstVets = new ArrayList<>();
        Veterinaria vet = new Veterinaria();
        lstVets.add(vet);
        sis.setVeterinarias(lstVets);
        assertTrue(sis.getVeterinarias().contains(vet));
    }

    @Test
    public void testSetVetsVacio() {
        ArrayList<Veterinaria> lstVets = new ArrayList<>();
        sis.setVeterinarias(lstVets);
        assertTrue(sis.getVeterinarias().isEmpty());
    }
    
   @Test
    public void testSetActs() {
        ArrayList<ActividadCualquiera> lstActs = new ArrayList<>();
        ActividadCualquiera act = new ActividadCualquiera();
        lstActs.add(act);
        sis.setActsCualquieras(lstActs);
        assertTrue(sis.getActsCualquieras().contains(act));
    }

    @Test
    public void testSetActsVacio() {
        ArrayList<ActividadCualquiera> lstActs = new ArrayList<>();
        sis.setActsCualquieras(lstActs);
        assertTrue(sis.getActsCualquieras().isEmpty());
    }
    
    @Test
    public void testSetPaseos() {
        ArrayList<Paseo> lstPaseos = new ArrayList<>();
        Paseo paseo = new Paseo();
        lstPaseos.add(paseo);
        sis.setPaseos(lstPaseos);
        assertTrue(sis.getPaseos().contains(paseo));
    }

    @Test
    public void testSetPaseoVacio() {
        ArrayList<Paseo> lstPaseos = new ArrayList<>();
        sis.setPaseos(lstPaseos);
        assertTrue(sis.getPaseos().isEmpty());
    }
    
    @Test
    public void testSetAlimentaciones() {
        ArrayList<Alimentacion> lstAlims = new ArrayList<>();
        Alimentacion alim = new Alimentacion();
        lstAlims.add(alim);
        sis.setAlimentaciones(lstAlims);
        assertTrue(sis.getAlimentaciones().contains(alim));
    }

    @Test
    public void testSetAlimentacionesVacio() {
        ArrayList<Alimentacion> lstAlims = new ArrayList<>();
        sis.setAlimentaciones(lstAlims);
        assertTrue(sis.getAlimentaciones().isEmpty());
    }
    
    @Test
    public void testSetVisitas() {
        ArrayList<VisitaVeterinaria> lstVisitas = new ArrayList<>();
        VisitaVeterinaria visita = new VisitaVeterinaria();
        lstVisitas.add(visita);
        sis.setVisitas(lstVisitas);
        assertTrue(sis.getVisitas().contains(visita));
    }

    @Test
    public void testSetVisitasVacio() {
        ArrayList<VisitaVeterinaria> lstVisitas = new ArrayList<>();
        sis.setVisitas(lstVisitas);
        assertTrue(sis.getVisitas().isEmpty());
    }
    
    
    @Test
    public void testBuscarFuncionario(){
        Funcionario func = new Funcionario("PabloP","Pablito123","pabloperez23@gmail.com");
        sis.agregarFuncionario(func);
        Funcionario f = sis.buscarFuncionario(func);
        assertEquals(f,func);
    }
    
    @Test
    public void testBuscarFuncionarioNoExistente(){
        Funcionario func = new Funcionario("PabloP","Pablito123","pabloperez23@gmail.com");
        Funcionario f = sis.buscarFuncionario(func);
        assertEquals(null, f);
    }
    
    @Test
    public void testAgregarTipoAnimal(){
        String tipo = "serpiente";
        sis.agregarTipo(tipo);
        assertEquals(true, sis.getListaTipoAnimales().contains(tipo));
    }
    
    
    @Test
    public void testAgregarTipoAnimalRepetido(){
        String tipo = "serpiente";
        sis.agregarTipo(tipo);
        String t = "serpiente";
        sis.agregarTipo(t);
        assertEquals(true, sis.getListaTipoAnimales().contains(tipo));
    }
    
    
    @Test
    public void testAgregarPadrino(){
        Padrino p = new Padrino("Pablo","Perez",26597312,"p.perez23@gmail","Montevideo","Uruguay",5000,"Tarjeta de credito","Dolares","una vez");
        sis.agregarPadrino(p);
        assertEquals(true, sis.getListaPadrinos().contains(p));
    }
    
    @Test
    public void testAgregarAdopcion(){
        Animal a = new Animal("Lola", "Perro", 0.20, 2.5, "");
        Adopcion adopcion = new Adopcion("Pablo","Perez", 42229467,a);
        sis.agregarAdopcion(adopcion);
        assertEquals(true, sis.getListaAdopciones().contains(adopcion));
    }
    
    @Test
    public void testExisteFuncionario(){
        Funcionario f = new Funcionario("PabloP","Pablito123","pabloperez23@gmail.com");
        sis.agregarFuncionario(f);
        assertEquals(true, sis.existeFuncionario(f));
    }
    
    @Test
    public void testExisteFuncionarioNoExistente(){
        Funcionario f = new Funcionario("PabloP","Pablito123","pabloperez23@gmail.com");
        assertEquals(false, sis.existeFuncionario(f));
    }
    
    @Test
    public void testExisteAnimal(){
        Animal a = new Animal("Lola", "Perro", 0.20, 2.5, "");
        sis.agregarAnimal(a);
        assertEquals(true, sis.existeAnimal(a));
    }
    
    @Test
    public void testExisteAnimalNoExistente(){
        Animal a = new Animal("Lola", "Perro", 0.20, 2.5, "");
        assertEquals(false, sis.existeAnimal(a));
    }
    
    @Test
    public void testGetFuncionario(){
        Funcionario f = new Funcionario("PabloP","Pablito123","pabloperez23@gmail.com");
        sis.agregarFuncionario(f);
        ArrayList <Funcionario> funcs = new ArrayList<>();
        funcs.add(f);
        assertEquals(funcs, sis.getListaFuncionarios());
    }
    
    
}
