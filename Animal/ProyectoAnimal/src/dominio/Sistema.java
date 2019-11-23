package dominio;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;




public class Sistema implements Serializable {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Animal> animales;
    private final ArrayList<Actividad> listaActividades;
    private ArrayList<Fecha> listaFechas;
    private ArrayList<Veterinaria> listaVeterinarias;
    private ArrayList<ActividadCualquiera> listaActividadesCualquiera;
    private ArrayList<Paseo> listaPaseos;
    private ArrayList<Alimentacion> listaAlimentaciones;
    private ArrayList<VisitaVeterinaria> listaVisitas;
    //Agregamos la lista de Funcionarios al sistema
    private ArrayList<Funcionario> listafuncionarios;
    //Agregamos una lista de tipo de animales al sistema
    private ArrayList<String> listaTipoAnimales;
    //Agregamos una lista de padrinos al sistema
    private ArrayList<Padrino>listaPadrinos;
    //Agregamos una lista de adopciones al sistema
    private ArrayList<Adopcion>listaAdopciones;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.animales = new ArrayList<>();
        this.listaActividades = new ArrayList<>();
        this.listaFechas = new ArrayList<>();
        this.listaVeterinarias = new ArrayList<>();
        this.listaPaseos = new ArrayList<>();
        this.listaAlimentaciones = new ArrayList<>();
        this.listaVisitas = new ArrayList<>();
        this.listaActividadesCualquiera = new ArrayList<>();
        this.listafuncionarios = new ArrayList<>();
        this.listaTipoAnimales = new ArrayList<>();
        this.listaPadrinos = new ArrayList<>();
        this.listaAdopciones = new ArrayList<>();
    }

    public ArrayList<Actividad> listaActividadesPorFecha(int dia, int mes, int ano) {
        ArrayList<Actividad> retLista = new ArrayList<>();
        if (dia >= 1 && dia <= 31 && mes >= 0 && mes <= 12 && ano >= 1) {
            for (int i = 0; i < listaActividades.size(); i++) {
                Actividad act = listaActividades.get(i);
                if (act.getFecha().getDia() == dia && act.getFecha().getMes() == mes && act.getFecha().getAno() == ano) {
                    retLista.add(act);
                }
            }
        }
        return retLista;
    }

    public ArrayList<Veterinaria> getVeterinarias() {
        return listaVeterinarias;
    }

    public void setVeterinarias(ArrayList<Veterinaria> veterinarias) {
        this.listaVeterinarias = veterinarias;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setMascotas(ArrayList<Animal> mascotas) {
        this.animales = mascotas;
    }

    public ArrayList<Animal> getAnimales() {
        return this.animales;
    }

    public ArrayList<Actividad> getActividades() {
        return listaActividades;
    }


    public void eliminarPerro(Animal perro) {
        if (this.animales.contains(perro)) {
            this.animales.remove(perro);
        } else {
            System.out.println("No existe tal perro");
        }
    }

    public boolean añadirUsuario(Usuario personaAnadir) {
        if(!this.existeUsuario(personaAnadir)){
            usuarios.add(personaAnadir);
            return true;
        }
        return false;
    }

    public void eliminarUsuario(Usuario persona) {
        if (usuarios.contains(persona)) {
            usuarios.remove(persona);
        } else {
            System.out.println("No existe tal persona");
        }
    }

    public void anadirActividad(Actividad act) {
        listaActividades.add(act);
        act.getUsuario().agregarActividad(act);
    }

    public void eliminarActividad(Actividad act) {
        if (listaActividades.contains(act)) {
            listaActividades.remove(act);
        } else {
            System.out.println("No existe tal actividad");
        }
    }

    public void anadirFecha(Fecha fecha) {
        listaFechas.add(fecha);
    }

    public void eliminarFecha(Fecha fecha) {
        if (listaFechas.contains(fecha)) {
            listaFechas.remove(fecha);
        } else {
            System.out.println("No existe tal fecha");
        }
    }

    public Usuario buscarUsuarioPorNombre(String nombreBuscar) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (nombreBuscar.equals(usuarios.get(i).getNombre())) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    public Animal buscarPerroPorNombre(String nombreBuscar) {
        for (int i = 0; i < this.animales.size(); i++) {
            if (nombreBuscar.equals(this.animales.get(i).getNombre())) {
                return this.animales.get(i);
            }
        }
        return null;
    }

    public Veterinaria buscarVetPorNombre(String nombreBuscar) {
        for (int i = 0; i < listaVeterinarias.size(); i++) {
            if (nombreBuscar.equals(listaVeterinarias.get(i).getNombre())) {
                return listaVeterinarias.get(i);
            }
        }
        return null;
    }

    public Paseo buscarPaseoPorNombre(String nombreBuscar) {
        for (int i = 0; i < listaPaseos.size(); i++) {
            if (nombreBuscar.equals(listaPaseos.get(i).getNombre())) {
                return listaPaseos.get(i);
            }
        }
        return null;
    }

    public VisitaVeterinaria buscarVisitaPorNombre(String nombreBuscar) {
        for (int i = 0; i < listaVisitas.size(); i++) {
            if (nombreBuscar.equals(listaVisitas.get(i).getNombre())) {
                return listaVisitas.get(i);
            }
        }
        return null;
    }

    public ActividadCualquiera buscarActCualquieraPorNombre(String nombreBuscar) {
        for (int i = 0; i < listaActividadesCualquiera.size(); i++) {
            if (nombreBuscar.equals(listaActividadesCualquiera.get(i).getNombre())) {
                return listaActividadesCualquiera.get(i);
            }
        }
        return null;
    }

    public Alimentacion buscarAlimentacionPorNombre(String nombreBuscar) {
        for (int i = 0; i < listaAlimentaciones.size(); i++) {
            if (nombreBuscar.equals(listaAlimentaciones.get(i).getNombre())) {
                return listaAlimentaciones.get(i);
            }
        }
        return null;
    }

    public ArrayList<ActividadCualquiera> getActsCualquieras() {
        return listaActividadesCualquiera;
    }

    public void setActsCualquieras(ArrayList<ActividadCualquiera> actsCualquieras) {
        this.listaActividadesCualquiera = actsCualquieras;
    }

    public ArrayList<Paseo> getPaseos() {
        return listaPaseos;
    }

    public void setPaseos(ArrayList<Paseo> paseos) {
        this.listaPaseos = paseos;
    }

    public ArrayList<Alimentacion> getAlimentaciones() {
        return listaAlimentaciones;
    }

    public void setAlimentaciones(ArrayList<Alimentacion> alimentaciones) {
        this.listaAlimentaciones = alimentaciones;
    }

    public ArrayList<VisitaVeterinaria> getVisitas() {
        return listaVisitas;
    }

    public void setVisitas(ArrayList<VisitaVeterinaria> visitas) {
        this.listaVisitas = visitas;
    }

    public ArrayList<Fecha> getFechas() {
        return listaFechas;
    }

    public ArrayList<Funcionario> getListaFuncionarios(){
        return this.listafuncionarios;
    }
    
    public Funcionario buscarFuncionario(Funcionario func){
        for(Funcionario f : this.listafuncionarios){
            if (f.equals(func)) return f;
        }
        return null;
    }
    public boolean existeFuncionario(Funcionario func){
        return this.listafuncionarios.contains(func);
    }
    public void agregarFuncionario(Funcionario f){
        this.listafuncionarios.add(f);
    }
    
    public void setFechas(ArrayList<Fecha> fechas) {
        this.listaFechas = fechas;
    }

    public ArrayList<String> getListaTipoAnimales(){
        return this.listaTipoAnimales;
    }
    public void agregarAnimal(Animal a){
        if(!this.animales.contains(a)){
            this.animales.add(a);
        }
    }
    public void agregarTipo(String tipo){
        if(!this.listaTipoAnimales.contains(tipo.toLowerCase(Locale.getDefault()))){
            this.listaTipoAnimales.add(tipo.toLowerCase(Locale.getDefault()));
        }
    }
    
    public ArrayList<Padrino> getListaPadrinos(){
        return this.listaPadrinos;
    }
    
    public void agregarPadrino(Padrino p){
        this.listaPadrinos.add(p);
    }
    
    public boolean existeAnimal(Animal a){
        return this.animales.contains(a);
    }
    public boolean existeUsuario(Usuario user){
        return this.usuarios.contains(user);
    }
    
    public void agregarAdopcion(Adopcion a){
        this.listaAdopciones.add(a);
    }
    
    public ArrayList<Adopcion> getListaAdopciones(){
        return this.listaAdopciones;
    }
}
