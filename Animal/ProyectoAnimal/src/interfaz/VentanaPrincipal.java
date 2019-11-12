/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author marce
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private Sistema sistema;
    private boolean agregarPerroSeleccionado;
    private boolean agregarUsuarioSeleccionado;
    private String rutaImagenAgregar;
    private Fecha fechaSeleccionada;
    private final int[] arrayDiasEnMes;
    private String rutaImagenRuta;
    private String tipoAnimal;
    

    public VentanaPrincipal(Sistema sis) {
        sistema = sis;
        fechaSeleccionada = new Fecha();
        initComponents();
        this.setSize(987, 684);
        this.tipoAnimal = "";
        this.setLocationRelativeTo(null);
        try {
            perroLblFoto.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("images/perroPorDefecto.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        animalBtnEditar.setVisible(false);
        animalBtnGuardar.setVisible(false);
        calPanHoraPersonalizada.setVisible(false);
        calPanVeterinaria.setVisible(false);
        calComboVeterinaria.setVisible(false);
        calBtnVerRuta.setVisible(false);
        calBtnGroupVeterinaria.clearSelection();
        calBtnVeterinariaNo.setSelected(true);
        calBtnGroupRepetir.clearSelection();
        calBtnGroupRealizada.clearSelection();
        calBtnRealizadaNo.setSelected(true);
        calTxtTipoAlimento.setVisible(false);
        calLblTipoAlimento.setVisible(false);
        calPanVeterinaria.setVisible(false);
        calBtnEditar.setVisible(false);
        calLblHorarios.setVisible(false);
        rutaImagenAgregar = "";
        rutaImagenRuta = "";
        agregarPerroSeleccionado = true;
        agregarUsuarioSeleccionado = true;
        arrayDiasEnMes = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        calPanRuta.setVisible(false);
        //Agregamos tipos basicos.
        this.sistema.agregarTipo("perro");
        this.sistema.agregarTipo("gato");
        this.sistema.agregarTipo("caballo");
        this.sistema.agregarTipo("vaca");
        this.cbTipoAnimal.setModel(new DefaultComboBoxModel(this.sistema.getListaTipoAnimales().toArray()));;
        this.animalesCombo.setModel(new DefaultComboBoxModel(this.sistema.getAnimales().toArray()));
        this.calComboAnimal.setModel(new DefaultComboBoxModel(this.sistema.getAnimales().toArray()));
        this.calComboUsuario.setModel(new DefaultComboBoxModel(this.sistema.getUsuarios().toArray()));
        this.listarPadrinosVista();
        this.cbAdopciones.removeAllItems();
        this.cbPadrinos.removeAllItems();
        this.listaAnimalesQueApadrina.removeAll();
        this.lstAnimalesApadrinar.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
         this.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            sistema.serializar(sistema);
            System.exit(0);
        } 
        });
    }

    public void resetearPestanaPerros() {
        setearListaPerros();
        if (animalesCombo.getItemCount() != 0) {
            Animal animal = sistema.buscarPerroPorNombre(animalesCombo.getSelectedItem().toString());
            animalLblNombre.setText(animal.getNombre().toUpperCase());
            animalLblPeso.setText("Pesa:       " + animal.getPeso());
            animalLblAltura.setText("Mide:       " + animal.getAltura());
            animalLblComentarios.setText("" + animal.getComentarios());
            perroLblFoto.setIcon(animal.getFoto());
            animalBtnEditar.setVisible(true);
            this.lblEstadoAdopcion.setText(animal.estadoAdopcion());
        } else {
            animalLblNombre.setText("Nombre:");
            animalLblPeso.setText("Peso:");
            animalLblAltura.setText("Altura:");
            animalLblComentarios.setText("Comentarios:");
            perroLblFoto.setIcon(crearIcono("/images/perroPorDefecto.png", 100));
            animalBtnEditar.setVisible(false);
            this.lblEstadoAdopcion.setVisible(false);
        }
        ocultarAgregarPerro();
        rutaImagenAgregar = "";
    }

    public void inicializarPestanaUsuarios() {

        resetearListaUsuarios();
        if (usuarioComboUsuarios.getItemCount() != 0) {
            Usuario usuarioSeleccionado = sistema.buscarUsuarioPorNombre(usuarioComboUsuarios.getSelectedItem().toString());
            usuarioLblNombre.setText("Nombre: " + usuarioSeleccionado.getNombre());
            usuarioLblMail.setText("Mail: " + usuarioSeleccionado.getMail());
        } else {
            usuarioLblNombre.setText("Nombre: ");
            usuarioLblMail.setText("Mail: ");
        }
        ocultarAgregarUsuario();
        agregarUsuarioSeleccionado = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        calBtnGroupRepetir = new javax.swing.ButtonGroup();
        calBtnGroupVeterinaria = new javax.swing.ButtonGroup();
        calBtnGroupRealizada = new javax.swing.ButtonGroup();
        calBtnGroupMetodoPago = new javax.swing.ButtonGroup();
        calBtnGroupMoneda = new javax.swing.ButtonGroup();
        panel = new javax.swing.JTabbedPane();
        panCalendario = new javax.swing.JPanel();
        calDayChooser = new com.toedter.calendar.JDayChooser();
        calMonthChooser = new com.toedter.calendar.JMonthChooser();
        calYearChooser = new com.toedter.calendar.JYearChooser();
        calScrollActividades = new javax.swing.JScrollPane();
        calLstActividades = new javax.swing.JList<>();
        calBtnAgregar = new javax.swing.JButton();
        calLblTipo = new javax.swing.JLabel();
        calLblUsuario = new javax.swing.JLabel();
        calLblPerro = new javax.swing.JLabel();
        calLblFecha = new javax.swing.JLabel();
        calComboTipo = new javax.swing.JComboBox<>();
        calComboUsuario = new javax.swing.JComboBox<>();
        calComboAnimal = new javax.swing.JComboBox<>();
        calComboHora = new javax.swing.JComboBox<>();
        calLblHora = new javax.swing.JLabel();
        calPanHoraPersonalizada = new javax.swing.JPanel();
        calPanLblMinutos = new javax.swing.JLabel();
        calPanSpinMinutos = new javax.swing.JSpinner();
        calPanSpinHora = new javax.swing.JSpinner();
        calPanLblHora = new javax.swing.JLabel();
        calLblFechaResp = new javax.swing.JLabel();
        calLblTituloFecha = new javax.swing.JLabel();
        calLblTituloActividad = new javax.swing.JLabel();
        calLblNombre = new javax.swing.JLabel();
        calTxtNombreResp = new javax.swing.JTextField();
        calPanVeterinaria = new javax.swing.JPanel();
        calLblVeterinaria = new javax.swing.JLabel();
        calBtnVeterinariaSi = new javax.swing.JRadioButton();
        calBtnVeterinariaNo = new javax.swing.JRadioButton();
        calComboVeterinaria = new javax.swing.JComboBox<>();
        calLblMotivo = new javax.swing.JLabel();
        calComboMotivo = new javax.swing.JComboBox<>();
        calLblHorarios = new javax.swing.JLabel();
        calTxtTipoAlimento = new javax.swing.JTextField();
        calLblTipoAlimento = new javax.swing.JLabel();
        calLblActividadesDelDia = new javax.swing.JLabel();
        calScrollInfoAct = new javax.swing.JScrollPane();
        calTxtAreaInfoAct = new javax.swing.JTextArea();
        calLblInfoActividad = new javax.swing.JLabel();
        calBtnEditar = new javax.swing.JButton();
        calLblRealizada = new javax.swing.JLabel();
        calBtnRealizadaSi = new javax.swing.JRadioButton();
        calBtnRealizadaNo = new javax.swing.JRadioButton();
        calPanRuta = new javax.swing.JPanel();
        calLblKilometros = new javax.swing.JLabel();
        calBtnRuta = new javax.swing.JButton();
        calLblRuta = new javax.swing.JLabel();
        calLblDistancia = new javax.swing.JLabel();
        calSpinDistancia = new javax.swing.JTextField();
        calBtnAgregarDatos = new javax.swing.JButton();
        calLblAdvertencia = new javax.swing.JLabel();
        calBtnVerRuta = new javax.swing.JButton();
        panUsuarios = new javax.swing.JPanel();
        usuarioLblUsuarios = new javax.swing.JLabel();
        usuarioComboUsuarios = new javax.swing.JComboBox<>();
        usuarioLblNombre = new javax.swing.JLabel();
        usuarioLblMail = new javax.swing.JLabel();
        usuarioTxtNombre = new javax.swing.JTextField();
        usuarioTxtMail = new javax.swing.JTextField();
        usuarioBtnAgregar = new javax.swing.JButton();
        usuarioLblActividades = new javax.swing.JLabel();
        usuarioScrollActividades = new javax.swing.JScrollPane();
        usuarioLstActividades = new javax.swing.JList<>();
        usuarioLblActividad = new javax.swing.JLabel();
        usuarioLblFecha = new javax.swing.JLabel();
        usuarioScrollFechas = new javax.swing.JScrollPane();
        usuarioLstFechas = new javax.swing.JList<>();
        usuarioLblAdvertencia = new javax.swing.JLabel();
        panAnimales = new javax.swing.JPanel();
        animalBtnAgregar = new javax.swing.JButton();
        animalLblAnimales = new javax.swing.JLabel();
        animalPanInformacion = new javax.swing.JPanel();
        animalPanFoto = new javax.swing.JPanel();
        perroLblFoto = new javax.swing.JLabel();
        animalLblAltura = new javax.swing.JLabel();
        animalLblComentarios = new javax.swing.JLabel();
        animalLblNombre = new javax.swing.JLabel();
        animalLblPeso = new javax.swing.JLabel();
        animalTxtNombre = new javax.swing.JTextField();
        animalBtnExaminar = new javax.swing.JButton();
        animalLblFotoBoton = new javax.swing.JLabel();
        animalSpinAltura = new javax.swing.JSpinner();
        animalSpinPeso = new javax.swing.JSpinner();
        calLblCentimetros = new javax.swing.JLabel();
        calLblKilogramos = new javax.swing.JLabel();
        lblEstadoAdopcion = new javax.swing.JLabel();
        animalesCombo = new javax.swing.JComboBox<>();
        animalBtnEditar = new javax.swing.JButton();
        animalBtnGuardar = new javax.swing.JButton();
        animalLblAdvertencia = new javax.swing.JLabel();
        cbTipoAnimal = new javax.swing.JComboBox<>();
        lblTipoAnimal = new javax.swing.JLabel();
        btnOtro = new javax.swing.JButton();
        animaltxtComentarios = new javax.swing.JTextField();
        panPadrinos = new javax.swing.JPanel();
        panelContenedorPadrinos = new javax.swing.JPanel();
        panelVistaPadrinos = new javax.swing.JPanel();
        lblVistaPadrinos = new javax.swing.JLabel();
        btnAgregarPadrino = new javax.swing.JButton();
        cbPadrinos = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblCiudad = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        lblDonacion = new javax.swing.JLabel();
        lblNombreDelPadrino = new javax.swing.JLabel();
        lblApellidoPadrino = new javax.swing.JLabel();
        lblTelefonoPadrino = new javax.swing.JLabel();
        lblEmailPadrino = new javax.swing.JLabel();
        lblCiudadPadrino = new javax.swing.JLabel();
        lblPaisPadrino = new javax.swing.JLabel();
        lblDonacionPadrino = new javax.swing.JLabel();
        lblMetodo = new javax.swing.JLabel();
        lblMetodoPagoPadrino = new javax.swing.JLabel();
        lblAnimalesApadrinados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAnimalesQueApadrina = new javax.swing.JList();
        panelRegistroPadrino = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFieldNombrePadrino = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFieldValorDonacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbFrecuenciaDonacion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        rbTarjetaCredito = new javax.swing.JRadioButton();
        rbTransferenciaBancaria = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        rbDolares = new javax.swing.JRadioButton();
        rbPesos = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        btnRegistroPadrino = new javax.swing.JButton();
        lblAdvertenciaRegistroPadrino = new javax.swing.JLabel();
        btnAtrasPadrino = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtFieldApellidoPadrino = new javax.swing.JTextField();
        txtFieldTelefonoPadrino = new javax.swing.JTextField();
        txtFieldEmailPadrino = new javax.swing.JTextField();
        txtFieldCiudadPadrino = new javax.swing.JTextField();
        txtFieldPaisPadrino = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAnimalesApadrinar = new javax.swing.JList();
        panAdopciones = new javax.swing.JPanel();
        panelContenedorAdopcion = new javax.swing.JPanel();
        panelVistaAdopciones = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnAgregarAdopcion = new javax.swing.JButton();
        lblNombreAdopcion = new javax.swing.JLabel();
        cbAdopciones = new javax.swing.JComboBox<>();
        lblNombreAdopcion1 = new javax.swing.JLabel();
        lblTelefonoAdopcion = new javax.swing.JLabel();
        lblAnimalAdopcion = new javax.swing.JLabel();
        lblNombreAdoptante = new javax.swing.JLabel();
        lblApellidoAdoptante = new javax.swing.JLabel();
        lblTelefonoAdoptante = new javax.swing.JLabel();
        lblAnimalAdoptado = new javax.swing.JLabel();
        panelRegistroAdopciones = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtFieldNombreAdopcion = new javax.swing.JTextField();
        txtFieldApellidoAdopcion = new javax.swing.JTextField();
        txtFieldTelefonoAdopcion = new javax.swing.JTextField();
        cbAnimalesParaAdoptar = new javax.swing.JComboBox<>();
        btnRegistrarAdopcion = new javax.swing.JButton();
        btnAtrasAdopcion = new javax.swing.JButton();
        lblAdvertenciaRegistroAdopciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Pets");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        panel.setMaximumSize(getPreferredSize());
        panel.setPreferredSize(new java.awt.Dimension(987, 684));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });

        calDayChooser.setBorder(new javax.swing.border.MatteBorder(null));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, calMonthChooser, org.jdesktop.beansbinding.ELProperty.create("${month}"), calDayChooser, org.jdesktop.beansbinding.BeanProperty.create("month"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, calYearChooser, org.jdesktop.beansbinding.ELProperty.create("${year}"), calDayChooser, org.jdesktop.beansbinding.BeanProperty.create("year"));
        bindingGroup.addBinding(binding);

        calDayChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calDayChooserPropertyChange(evt);
            }
        });

        calMonthChooser.setBorder(new javax.swing.border.MatteBorder(null));
        calMonthChooser.setToolTipText("");

        calYearChooser.setBorder(new javax.swing.border.MatteBorder(null));

        calLstActividades.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                calLstActividadesValueChanged(evt);
            }
        });
        calScrollActividades.setViewportView(calLstActividades);

        calBtnAgregar.setText("Agregar");
        calBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnAgregarActionPerformed(evt);
            }
        });

        calLblTipo.setText("Tipo de actividad:");

        calLblUsuario.setText("Usuario:");

        calLblPerro.setText("Perro:");

        calLblFecha.setText("Fecha:");

        calComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paseo", "Alimentación", "Otra" }));
        calComboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calComboTipoActionPerformed(evt);
            }
        });

        calComboUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calComboUsuarioActionPerformed(evt);
            }
        });

        calComboAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calComboAnimalActionPerformed(evt);
            }
        });

        calComboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahora", "Personalizado" }));
        calComboHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calComboHoraActionPerformed(evt);
            }
        });

        calLblHora.setText("Hora");

        calPanLblMinutos.setText("Minutos");

        calPanSpinMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 55, 5));

        calPanSpinHora.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));

        calPanLblHora.setText("Hora");

        javax.swing.GroupLayout calPanHoraPersonalizadaLayout = new javax.swing.GroupLayout(calPanHoraPersonalizada);
        calPanHoraPersonalizada.setLayout(calPanHoraPersonalizadaLayout);
        calPanHoraPersonalizadaLayout.setHorizontalGroup(
            calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calPanHoraPersonalizadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calPanLblHora)
                    .addComponent(calPanLblMinutos))
                .addGap(18, 18, 18)
                .addGroup(calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(calPanSpinMinutos)
                    .addComponent(calPanSpinHora))
                .addContainerGap())
        );
        calPanHoraPersonalizadaLayout.setVerticalGroup(
            calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calPanHoraPersonalizadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calPanLblHora)
                    .addComponent(calPanSpinHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calPanLblMinutos)
                    .addComponent(calPanSpinMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        calLblTituloFecha.setText("Fecha");

        calLblTituloActividad.setText("Actividad");

        calLblNombre.setText("Nombre:");

        calTxtNombreResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calTxtNombreRespActionPerformed(evt);
            }
        });

        calLblVeterinaria.setText("Veterinaria:");

        calBtnGroupVeterinaria.add(calBtnVeterinariaSi);
        calBtnVeterinariaSi.setText("Si");
        calBtnVeterinariaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnVeterinariaSiActionPerformed(evt);
            }
        });

        calBtnGroupVeterinaria.add(calBtnVeterinariaNo);
        calBtnVeterinariaNo.setText("No");
        calBtnVeterinariaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnVeterinariaNoActionPerformed(evt);
            }
        });

        calComboVeterinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calComboVeterinariaActionPerformed(evt);
            }
        });

        calLblMotivo.setText("Motivo:");

        calComboMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corte de Pelo", "Corte de Uñas", "Visita Médica", "Otro" }));

        javax.swing.GroupLayout calPanVeterinariaLayout = new javax.swing.GroupLayout(calPanVeterinaria);
        calPanVeterinaria.setLayout(calPanVeterinariaLayout);
        calPanVeterinariaLayout.setHorizontalGroup(
            calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calPanVeterinariaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(calLblHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(calPanVeterinariaLayout.createSequentialGroup()
                        .addGroup(calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calLblVeterinaria)
                            .addComponent(calLblMotivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(calComboVeterinaria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(calComboMotivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(calPanVeterinariaLayout.createSequentialGroup()
                                .addComponent(calBtnVeterinariaSi)
                                .addGap(18, 18, 18)
                                .addComponent(calBtnVeterinariaNo)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        calPanVeterinariaLayout.setVerticalGroup(
            calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calPanVeterinariaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calLblVeterinaria)
                    .addComponent(calBtnVeterinariaSi)
                    .addComponent(calBtnVeterinariaNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calComboVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calComboMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calLblMotivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calLblHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        calTxtTipoAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calTxtTipoAlimentoActionPerformed(evt);
            }
        });

        calLblTipoAlimento.setText("Tipo Alimento:");

        calLblActividadesDelDia.setText("Actividades del Día:");

        calTxtAreaInfoAct.setColumns(20);
        calTxtAreaInfoAct.setRows(5);
        calScrollInfoAct.setViewportView(calTxtAreaInfoAct);

        calLblInfoActividad.setText("Información de la Actividad: ");

        calBtnEditar.setText("Editar");
        calBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnEditarActionPerformed(evt);
            }
        });

        calLblRealizada.setText("Fue realizada:");

        calBtnGroupRealizada.add(calBtnRealizadaSi);
        calBtnRealizadaSi.setText("Si");
        calBtnRealizadaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnRealizadaSiActionPerformed(evt);
            }
        });

        calBtnGroupRealizada.add(calBtnRealizadaNo);
        calBtnRealizadaNo.setText("No");
        calBtnRealizadaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnRealizadaNoActionPerformed(evt);
            }
        });

        calLblKilometros.setText("Kilómetros");

        calBtnRuta.setText("Agregar Ruta");
        calBtnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnRutaActionPerformed(evt);
            }
        });

        calLblRuta.setText("Ruta:");

        calLblDistancia.setText("Distancia:");

        javax.swing.GroupLayout calPanRutaLayout = new javax.swing.GroupLayout(calPanRuta);
        calPanRuta.setLayout(calPanRutaLayout);
        calPanRutaLayout.setHorizontalGroup(
            calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calPanRutaLayout.createSequentialGroup()
                .addGroup(calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calLblRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calLblDistancia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addGroup(calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calPanRutaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(calSpinDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calLblKilometros))
                    .addGroup(calPanRutaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(calBtnRuta)))
                .addContainerGap())
        );
        calPanRutaLayout.setVerticalGroup(
            calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calPanRutaLayout.createSequentialGroup()
                .addGroup(calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calBtnRuta)
                    .addComponent(calLblRuta))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(calPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calLblKilometros)
                    .addComponent(calLblDistancia)
                    .addComponent(calSpinDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        calBtnAgregarDatos.setText("Agregar Datos Precargados");
        calBtnAgregarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnAgregarDatosActionPerformed(evt);
            }
        });

        calBtnVerRuta.setText("Ver Ruta");
        calBtnVerRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calBtnVerRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCalendarioLayout = new javax.swing.GroupLayout(panCalendario);
        panCalendario.setLayout(panCalendarioLayout);
        panCalendarioLayout.setHorizontalGroup(
            panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCalendarioLayout.createSequentialGroup()
                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calDayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addComponent(calLblActividadesDelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCalendarioLayout.createSequentialGroup()
                                        .addComponent(calScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calLblInfoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(calScrollInfoAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addComponent(calMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(calYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(calLblTituloFecha)))
                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(calBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(calLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(calBtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(calBtnAgregarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addComponent(calPanRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(calBtnVerRuta))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(calTxtTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panCalendarioLayout.createSequentialGroup()
                                            .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(calLblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(calLblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(calLblPerro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(calLblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(calLblHora))
                                                .addComponent(calLblNombre))
                                            .addGap(18, 18, 18)
                                            .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(calComboTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(calComboUsuario, javax.swing.GroupLayout.Alignment.LEADING, 0, 134, Short.MAX_VALUE)
                                                .addComponent(calComboAnimal, javax.swing.GroupLayout.Alignment.LEADING, 0, 134, Short.MAX_VALUE)
                                                .addComponent(calLblFechaResp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(calTxtNombreResp)
                                                .addComponent(calComboHora, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(calLblRealizada)
                                            .addComponent(calLblTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addComponent(calBtnRealizadaSi)
                                        .addGap(18, 18, 18)
                                        .addComponent(calBtnRealizadaNo)))
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calPanVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(calPanHoraPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calLblTituloActividad)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        panCalendarioLayout.setVerticalGroup(
            panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCalendarioLayout.createSequentialGroup()
                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblTipo)
                                    .addComponent(calComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblNombre)
                                    .addComponent(calTxtNombreResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblUsuario)
                                    .addComponent(calComboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(calPanVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calLblPerro)
                            .addComponent(calComboAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(calLblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(calLblFechaResp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblHora)
                                    .addComponent(calComboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblRealizada)
                                    .addComponent(calBtnRealizadaSi)
                                    .addComponent(calBtnRealizadaNo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(calLblTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(calTxtTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(calPanHoraPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calBtnVerRuta)
                            .addComponent(calPanRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calBtnEditar)
                        .addGap(12, 12, 12)
                        .addComponent(calLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calBtnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calBtnAgregarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calLblTituloFecha)
                            .addComponent(calLblTituloActividad))
                        .addGap(3, 3, 3)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calDayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calLblActividadesDelDia)
                            .addComponent(calLblInfoActividad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(calScrollActividades, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(calScrollInfoAct))))
                .addGap(2093, 2093, 2093))
        );

        panel.addTab("Calendario", panCalendario);

        usuarioLblUsuarios.setText("Usuario");

        usuarioComboUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioComboUsuariosActionPerformed(evt);
            }
        });

        usuarioLblNombre.setText("Nombre:");

        usuarioLblMail.setText("Mail:");

        usuarioTxtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTxtMailActionPerformed(evt);
            }
        });

        usuarioBtnAgregar.setText("Agregar Usuario");
        usuarioBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioBtnAgregarActionPerformed(evt);
            }
        });

        usuarioLblActividades.setText("Próximas Actividades");

        usuarioScrollActividades.setViewportView(usuarioLstActividades);

        usuarioLblActividad.setText("Actividad:");

        usuarioLblFecha.setText("Fecha");

        usuarioScrollFechas.setViewportView(usuarioLstFechas);

        javax.swing.GroupLayout panUsuariosLayout = new javax.swing.GroupLayout(panUsuarios);
        panUsuarios.setLayout(panUsuariosLayout);
        panUsuariosLayout.setHorizontalGroup(
            panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuarioLblUsuarios)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(usuarioBtnAgregar))
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addComponent(usuarioComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuarioLblNombre)
                                    .addComponent(usuarioLblMail))
                                .addGap(31, 31, 31)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuarioTxtMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(usuarioTxtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(usuarioLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuarioLblActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioLblActividad)
                            .addComponent(usuarioScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioLblFecha)
                            .addComponent(usuarioScrollFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(446, 446, 446))
        );
        panUsuariosLayout.setVerticalGroup(
            panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUsuariosLayout.createSequentialGroup()
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioLblNombre)
                            .addComponent(usuarioTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuarioTxtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuarioLblMail))
                        .addGap(18, 18, 18)
                        .addComponent(usuarioLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioBtnAgregar))
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addComponent(usuarioLblActividades)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(usuarioLblActividad)
                                    .addComponent(usuarioLblFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usuarioScrollFechas)
                                    .addComponent(usuarioScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addComponent(usuarioLblUsuarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(2349, Short.MAX_VALUE))
        );

        panel.addTab("Usuarios", panUsuarios);

        animalBtnAgregar.setText("Ingresar Animal");
        animalBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalBtnAgregarActionPerformed(evt);
            }
        });

        animalLblAnimales.setText("Animal");

        javax.swing.GroupLayout animalPanFotoLayout = new javax.swing.GroupLayout(animalPanFoto);
        animalPanFoto.setLayout(animalPanFotoLayout);
        animalPanFotoLayout.setHorizontalGroup(
            animalPanFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animalPanFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(perroLblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        animalPanFotoLayout.setVerticalGroup(
            animalPanFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animalPanFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(perroLblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        animalLblAltura.setText("Altura");

        animalLblComentarios.setText("Comentarios");

        animalLblNombre.setText("Nombre");

        animalLblPeso.setText("Peso");

        animalTxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalTxtNombreActionPerformed(evt);
            }
        });

        animalBtnExaminar.setText("Examinar");
        animalBtnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalBtnExaminarActionPerformed(evt);
            }
        });

        animalLblFotoBoton.setText("Foto:");

        animalSpinAltura.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        animalSpinPeso.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.1d));

        calLblCentimetros.setText("Centímetros");

        calLblKilogramos.setText("Kilogramos");

        javax.swing.GroupLayout animalPanInformacionLayout = new javax.swing.GroupLayout(animalPanInformacion);
        animalPanInformacion.setLayout(animalPanInformacionLayout);
        animalPanInformacionLayout.setHorizontalGroup(
            animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animalPanInformacionLayout.createSequentialGroup()
                .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(animalPanInformacionLayout.createSequentialGroup()
                        .addComponent(animalPanFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(animalPanInformacionLayout.createSequentialGroup()
                                .addComponent(animalLblFotoBoton)
                                .addGap(18, 18, 18)
                                .addComponent(animalBtnExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(animalLblPeso)
                            .addGroup(animalPanInformacionLayout.createSequentialGroup()
                                .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(animalLblNombre)
                                    .addComponent(animalLblAltura))
                                .addGap(26, 26, 26)
                                .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(animalPanInformacionLayout.createSequentialGroup()
                                        .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(animalSpinPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(animalSpinAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(calLblCentimetros)
                                            .addComponent(calLblKilogramos)))
                                    .addComponent(animalTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(animalPanInformacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(animalLblComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstadoAdopcion, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        animalPanInformacionLayout.setVerticalGroup(
            animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(animalPanInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(animalPanInformacionLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(animalLblNombre)
                            .addComponent(animalTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(animalLblAltura)
                            .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(animalSpinAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(calLblCentimetros)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(animalLblPeso)
                            .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(animalSpinPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(calLblKilogramos)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(animalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(animalBtnExaminar)
                            .addComponent(animalLblFotoBoton)))
                    .addComponent(animalPanFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEstadoAdopcion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(animalLblComentarios))
        );

        animalesCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                animalesComboMouseClicked(evt);
            }
        });
        animalesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalesComboActionPerformed(evt);
            }
        });

        animalBtnEditar.setText("Editar");
        animalBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalBtnEditarActionPerformed(evt);
            }
        });

        animalBtnGuardar.setText("Guardar");
        animalBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalBtnGuardarActionPerformed(evt);
            }
        });

        cbTipoAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTipoAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoAnimalActionPerformed(evt);
            }
        });

        lblTipoAnimal.setText("Animal:");

        btnOtro.setText("Otro");
        btnOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAnimalesLayout = new javax.swing.GroupLayout(panAnimales);
        panAnimales.setLayout(panAnimalesLayout);
        panAnimalesLayout.setHorizontalGroup(
            panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAnimalesLayout.createSequentialGroup()
                .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAnimalesLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(animalLblAnimales)
                            .addComponent(animalesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAnimalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(animalBtnEditar)
                        .addGap(22, 22, 22)))
                .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAnimalesLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(animalBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(animalBtnAgregar)))
                    .addGroup(panAnimalesLayout.createSequentialGroup()
                        .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panAnimalesLayout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(animaltxtComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAnimalesLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(animalPanInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOtro)
                            .addGroup(panAnimalesLayout.createSequentialGroup()
                                .addComponent(lblTipoAnimal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTipoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(animalLblAdvertencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panAnimalesLayout.setVerticalGroup(
            panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAnimalesLayout.createSequentialGroup()
                .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panAnimalesLayout.createSequentialGroup()
                        .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panAnimalesLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(animalLblAnimales)
                                .addGap(18, 18, 18)
                                .addComponent(animalesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(animalBtnEditar))
                            .addGroup(panAnimalesLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(animalPanInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(animaltxtComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panAnimalesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipoAnimal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOtro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(animalLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(animalBtnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(animalBtnAgregar)
                .addContainerGap(2300, Short.MAX_VALUE))
        );

        panel.addTab("Animales", panAnimales);

        panelContenedorPadrinos.setLayout(new java.awt.CardLayout());

        lblVistaPadrinos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblVistaPadrinos.setText("Vista Padrinos");

        btnAgregarPadrino.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarPadrino.setText("Agregar padrino");
        btnAgregarPadrino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPadrinoActionPerformed(evt);
            }
        });

        cbPadrinos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPadrinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPadrinosActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

        lblTelefono.setText("Telefono:");

        lblEmail.setText("Email:");

        lblCiudad.setText("Ciudad:");

        lblPais.setText("Pais:");

        lblDonacion.setText("Donacion:");

        lblMetodo.setText("Metodo de pago:");

        lblAnimalesApadrinados.setText("Animales de los que es padrino:");

        listaAnimalesQueApadrina.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaAnimalesQueApadrina);

        javax.swing.GroupLayout panelVistaPadrinosLayout = new javax.swing.GroupLayout(panelVistaPadrinos);
        panelVistaPadrinos.setLayout(panelVistaPadrinosLayout);
        panelVistaPadrinosLayout.setHorizontalGroup(
            panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVistaPadrinosLayout.createSequentialGroup()
                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVistaPadrinosLayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelVistaPadrinosLayout.createSequentialGroup()
                                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDonacion)
                                    .addComponent(lblMetodo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDonacionPadrino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMetodoPagoPadrino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelVistaPadrinosLayout.createSequentialGroup()
                                .addComponent(lblPais)
                                .addGap(104, 104, 104)
                                .addComponent(lblPaisPadrino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelVistaPadrinosLayout.createSequentialGroup()
                                .addComponent(lblCiudad)
                                .addGap(85, 85, 85)
                                .addComponent(lblCiudadPadrino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelVistaPadrinosLayout.createSequentialGroup()
                                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblApellido)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblEmail))
                                .addGap(74, 74, 74)
                                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEmailPadrino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTelefonoPadrino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblApellidoPadrino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNombreDelPadrino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelVistaPadrinosLayout.createSequentialGroup()
                                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAnimalesApadrinados)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelVistaPadrinosLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnAgregarPadrino)
                        .addGap(141, 141, 141)
                        .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPadrinos, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVistaPadrinos))))
                .addGap(525, 525, 525))
        );
        panelVistaPadrinosLayout.setVerticalGroup(
            panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVistaPadrinosLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarPadrino)
                    .addComponent(lblVistaPadrinos))
                .addGap(18, 18, 18)
                .addComponent(cbPadrinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblNombreDelPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellidoPadrino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido))
                .addGap(6, 6, 6)
                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefonoPadrino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmailPadrino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCiudadPadrino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPais)
                    .addComponent(lblPaisPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDonacion)
                    .addComponent(lblDonacionPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVistaPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMetodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMetodoPagoPadrino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblAnimalesApadrinados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1329, Short.MAX_VALUE))
        );

        panelContenedorPadrinos.add(panelVistaPadrinos, "card3");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Registro Padrino");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Valor de donacion:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Frecuencia de la donacion:");

        cbFrecuenciaDonacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbFrecuenciaDonacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFrecuenciaDonacionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Metodo de pago:");

        calBtnGroupMetodoPago.add(rbTarjetaCredito);
        rbTarjetaCredito.setText("Tarjeta de credito");

        calBtnGroupMetodoPago.add(rbTransferenciaBancaria);
        rbTransferenciaBancaria.setText("Transferencia bancaria");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("Moneda:");

        calBtnGroupMoneda.add(rbDolares);
        rbDolares.setText("Dolares");

        calBtnGroupMoneda.add(rbPesos);
        rbPesos.setText("Pesos Uruguayos");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("Animales a apadrinar:");

        btnRegistroPadrino.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegistroPadrino.setText("Registrar");
        btnRegistroPadrino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroPadrinoActionPerformed(evt);
            }
        });

        lblAdvertenciaRegistroPadrino.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAdvertenciaRegistroPadrino.setForeground(new java.awt.Color(255, 0, 51));

        btnAtrasPadrino.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAtrasPadrino.setText("Atras");
        btnAtrasPadrino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasPadrinoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel9.setText("Apellido:");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel10.setText("Telefono:");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel11.setText("Email:");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel12.setText("Ciudad:");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel13.setText("Pais:");

        lstAnimalesApadrinar.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstAnimalesApadrinar);

        javax.swing.GroupLayout panelRegistroPadrinoLayout = new javax.swing.GroupLayout(panelRegistroPadrino);
        panelRegistroPadrino.setLayout(panelRegistroPadrinoLayout);
        panelRegistroPadrinoLayout.setHorizontalGroup(
            panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroPadrinoLayout.createSequentialGroup()
                .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroPadrinoLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel1))
                    .addGroup(panelRegistroPadrinoLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(71, 71, 71)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegistroPadrinoLayout.createSequentialGroup()
                                .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbTarjetaCredito)
                                    .addComponent(rbDolares))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbTransferenciaBancaria)
                                    .addComponent(rbPesos)))
                            .addComponent(txtFieldApellidoPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldNombrePadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldTelefonoPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldEmailPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldCiudadPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldPaisPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFieldValorDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFrecuenciaDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRegistroPadrinoLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRegistroPadrinoLayout.createSequentialGroup()
                                .addComponent(btnRegistroPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(btnAtrasPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRegistroPadrinoLayout.createSequentialGroup()
                                .addComponent(lblAdvertenciaRegistroPadrino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)))))
                .addContainerGap(486, Short.MAX_VALUE))
        );
        panelRegistroPadrinoLayout.setVerticalGroup(
            panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroPadrinoLayout.createSequentialGroup()
                .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroPadrinoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFieldNombrePadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldApellidoPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldTelefonoPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldEmailPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldCiudadPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldPaisPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(txtFieldValorDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbFrecuenciaDonacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rbTarjetaCredito)
                            .addComponent(rbTransferenciaBancaria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(panelRegistroPadrinoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbDolares)
                            .addComponent(rbPesos))))
                .addGap(32, 32, 32)
                .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroPadrinoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(22, 22, 22)
                        .addComponent(lblAdvertenciaRegistroPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroPadrinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistroPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtrasPadrino, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1239, 1239, 1239))
        );

        panelContenedorPadrinos.add(panelRegistroPadrino, "card2");

        javax.swing.GroupLayout panPadrinosLayout = new javax.swing.GroupLayout(panPadrinos);
        panPadrinos.setLayout(panPadrinosLayout);
        panPadrinosLayout.setHorizontalGroup(
            panPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPadrinosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(panelContenedorPadrinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPadrinosLayout.setVerticalGroup(
            panPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPadrinosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panelContenedorPadrinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel.addTab("Padrinos", panPadrinos);

        panAdopciones.setLayout(null);

        panelContenedorAdopcion.setLayout(new java.awt.CardLayout());

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel8.setText("Vista Adopciones");

        btnAgregarAdopcion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarAdopcion.setText("Agregar Adopcion");
        btnAgregarAdopcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAdopcionActionPerformed(evt);
            }
        });

        lblNombreAdopcion.setText("Nombre:");

        cbAdopciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAdopciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAdopcionesActionPerformed(evt);
            }
        });

        lblNombreAdopcion1.setText("Apellido:");

        lblTelefonoAdopcion.setText("Telefono:");

        lblAnimalAdopcion.setText("Animal Adoptado:");

        javax.swing.GroupLayout panelVistaAdopcionesLayout = new javax.swing.GroupLayout(panelVistaAdopciones);
        panelVistaAdopciones.setLayout(panelVistaAdopcionesLayout);
        panelVistaAdopcionesLayout.setHorizontalGroup(
            panelVistaAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVistaAdopcionesLayout.createSequentialGroup()
                .addGroup(panelVistaAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVistaAdopcionesLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btnAgregarAdopcion)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel8))
                    .addGroup(panelVistaAdopcionesLayout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addGroup(panelVistaAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreAdopcion)
                            .addComponent(lblNombreAdopcion1)
                            .addComponent(lblTelefonoAdopcion)
                            .addComponent(lblAnimalAdopcion))
                        .addGap(87, 87, 87)
                        .addGroup(panelVistaAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAnimalAdoptado, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(lblTelefonoAdoptante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApellidoAdoptante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreAdoptante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(286, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVistaAdopcionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbAdopciones, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(384, 384, 384))
        );
        panelVistaAdopcionesLayout.setVerticalGroup(
            panelVistaAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVistaAdopcionesLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelVistaAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnAgregarAdopcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbAdopciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(panelVistaAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVistaAdopcionesLayout.createSequentialGroup()
                        .addGroup(panelVistaAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVistaAdopcionesLayout.createSequentialGroup()
                                .addGroup(panelVistaAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombreAdopcion)
                                    .addComponent(lblNombreAdoptante, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreAdopcion1))
                            .addComponent(lblApellidoAdoptante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTelefonoAdopcion))
                    .addComponent(lblTelefonoAdoptante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelVistaAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAnimalAdopcion)
                    .addComponent(lblAnimalAdoptado, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(392, Short.MAX_VALUE))
        );

        panelContenedorAdopcion.add(panelVistaAdopciones, "card2");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel14.setText("Registro Adopciones");

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel15.setText("Nombre:");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel16.setText("Apellido:");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel17.setText("Telefono:");

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel18.setText("Animal:");

        txtFieldNombreAdopcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNombreAdopcionActionPerformed(evt);
            }
        });

        txtFieldApellidoAdopcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldApellidoAdopcionActionPerformed(evt);
            }
        });

        txtFieldTelefonoAdopcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldTelefonoAdopcionActionPerformed(evt);
            }
        });

        cbAnimalesParaAdoptar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRegistrarAdopcion.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnRegistrarAdopcion.setText("Registrar adopcion");
        btnRegistrarAdopcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAdopcionActionPerformed(evt);
            }
        });

        btnAtrasAdopcion.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnAtrasAdopcion.setText("Atras");
        btnAtrasAdopcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasAdopcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegistroAdopcionesLayout = new javax.swing.GroupLayout(panelRegistroAdopciones);
        panelRegistroAdopciones.setLayout(panelRegistroAdopcionesLayout);
        panelRegistroAdopcionesLayout.setHorizontalGroup(
            panelRegistroAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroAdopcionesLayout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroAdopcionesLayout.createSequentialGroup()
                .addGroup(panelRegistroAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroAdopcionesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelRegistroAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(96, 96, 96))
                    .addGroup(panelRegistroAdopcionesLayout.createSequentialGroup()
                        .addGap(397, 397, 397)
                        .addComponent(btnAtrasAdopcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)))
                .addGroup(panelRegistroAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarAdopcion)
                    .addGroup(panelRegistroAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtFieldNombreAdopcion)
                        .addComponent(txtFieldApellidoAdopcion)
                        .addComponent(txtFieldTelefonoAdopcion)
                        .addComponent(cbAnimalesParaAdoptar, 0, 209, Short.MAX_VALUE)))
                .addGap(223, 223, 223))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroAdopcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAdvertenciaRegistroAdopciones, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
        );
        panelRegistroAdopcionesLayout.setVerticalGroup(
            panelRegistroAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroAdopcionesLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(panelRegistroAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldNombreAdopcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldApellidoAdopcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldTelefonoAdopcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAnimalesParaAdoptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(65, 65, 65)
                .addComponent(lblAdvertenciaRegistroAdopciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroAdopcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarAdopcion)
                    .addComponent(btnAtrasAdopcion))
                .addGap(220, 220, 220))
        );

        panelContenedorAdopcion.add(panelRegistroAdopciones, "card3");

        panAdopciones.add(panelContenedorAdopcion);
        panelContenedorAdopcion.setBounds(9, 26, 970, 610);

        panel.addTab("Adopciones", panAdopciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 2678, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void animalBtnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalBtnExaminarActionPerformed
        JFileChooser elegirImagen = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        elegirImagen.setFileFilter(filter);
        int result = elegirImagen.showDialog(this, "Elija una imagen");
        if (result == JFileChooser.APPROVE_OPTION) {
            File imgSeleccionada = elegirImagen.getSelectedFile();
            rutaImagenAgregar = imgSeleccionada.getAbsolutePath();
            perroLblFoto.setIcon(crearIcono(imgSeleccionada, 100));
        } else {
            animalLblAdvertencia.setText("No se ha podido ingresar la imágen de forma correcta");
        }
    }//GEN-LAST:event_animalBtnExaminarActionPerformed

    private void animalTxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalTxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_animalTxtNombreActionPerformed

    private void animalBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalBtnAgregarActionPerformed
        if(this.cbTipoAnimal.getSelectedItem() != null){
            this.tipoAnimal = this.cbTipoAnimal.getSelectedItem().toString();
        }
        if (agregarPerroSeleccionado == false) {
            mostrarAgregarPerro();
        } else {
            if (animalTxtNombre.getText().trim().isEmpty()) {
                animalLblAdvertencia.setText("Por favor ingrese un nombre");
            } else if (animalSpinAltura.getValue().equals(0)) {
                animalLblAdvertencia.setText("Por favor ingrese una altura válida");
            } else if (animalSpinPeso.getValue().equals(0.0)) {
                animalLblAdvertencia.setText("Por favor ingrese un peso válido");
            }else if (this.tipoAnimal.trim().isEmpty()){
                this.animalLblAdvertencia.setText("Por favor, ingrese un tipo de animal");
                
            } else {
                Animal animal = new Animal(animalTxtNombre.getText(),this.tipoAnimal, Integer.parseInt(animalSpinAltura.getValue().toString()), Double.parseDouble(animalSpinPeso.getValue().toString()), animaltxtComentarios.getText());
                if(!this.sistema.existeAnimal(animal)){
                if (rutaImagenAgregar.equals("")) {
                    try {
                        animal.setFoto(new ImageIcon(ImageIO.read(this.getClass().getResource("images/perroPorDefecto.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                } else {
                    File imagen = new File(rutaImagenAgregar);
                    animal.setFoto(crearIcono(imagen, 100));
                    rutaImagenAgregar = "";
                }
                sistema.agregarAnimal(animal);
                this.setearListaAnimalesAApadrinar();
                animalTxtNombre.setText("");
                animalSpinPeso.setValue((Object) 0.0);
                animalSpinAltura.setValue((Object) 0.0);
                animaltxtComentarios.setText("");
                animalLblAdvertencia.setText("");
                ocultarAgregarPerro();
                setearListaPerros();
            }else{
                    this.animalLblAdvertencia.setText("Ese nombre ya existe, por favor ingrese otro");
                }
           }
        }
    }//GEN-LAST:event_animalBtnAgregarActionPerformed
    private void mostrarAgregarPerro() {
        agregarPerroSeleccionado = true;
        animalLblNombre.setText("Nombre:");
        animalLblPeso.setText("Peso:");
        animalLblAltura.setText("Altura:");
        animalLblComentarios.setText("Comentarios:");
        //PerroLblFoto.setIcon(crearIcono("/images/perroPorDefecto.png", 100));
        animalTxtNombre.setVisible(true);
        animalSpinPeso.setVisible(true);
        animalSpinAltura.setVisible(true);
        animaltxtComentarios.setVisible(true);
        animalLblFotoBoton.setVisible(true);
        animalBtnExaminar.setVisible(true);
        this.lblEstadoAdopcion.setVisible(false);
    }

    private void ocultarAgregarPerro() {
        agregarPerroSeleccionado = false;
        animalTxtNombre.setVisible(false);
        animalTxtNombre.setText("");
        animalSpinPeso.setVisible(false);
        animalSpinPeso.setValue((Object) 0.0);
        animalSpinAltura.setVisible(false);
        animalSpinAltura.setValue((Object) 0.0);
        animaltxtComentarios.setVisible(false);
        animaltxtComentarios.setText("");
        animalLblFotoBoton.setVisible(false);
        animalBtnExaminar.setVisible(false); 
        this.lblEstadoAdopcion.setVisible(true);
    }
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
    private void setearListaDeVeterinarias() {
        if (calComboVeterinaria.getItemCount() > 0) {
            calComboVeterinaria.removeAllItems();
        }
        for (int i = 0; i < sistema.getVeterinarias().size(); i++) {
            calComboVeterinaria.addItem(sistema.getVeterinarias().get(i).getNombre());
        }
    }

    

    private void mostrarEditarPerro() {
        animalBtnGuardar.setVisible(true);
        animalBtnAgregar.setVisible(false);
        agregarPerroSeleccionado = true;
        animalLblNombre.setText("Nombre:");
        animalLblPeso.setText("Peso:");
        animalLblAltura.setText("Altura:");
        animalLblComentarios.setText("Comentarios:");
        Animal perroSeleccionado = sistema.buscarPerroPorNombre(animalesCombo.getSelectedItem().toString());
        perroLblFoto.setIcon(perroSeleccionado.getFoto());
        animalTxtNombre.setText(perroSeleccionado.getNombre());
        animalSpinPeso.setValue(perroSeleccionado.getPeso());
        animalSpinAltura.setValue(perroSeleccionado.getAltura());
        animaltxtComentarios.setText("" + perroSeleccionado.getComentarios());
        animalTxtNombre.setVisible(true);
        animalSpinPeso.setVisible(true);
        animalSpinAltura.setVisible(true);
        animaltxtComentarios.setVisible(true);
        animalLblFotoBoton.setVisible(true);
        animalBtnExaminar.setVisible(true);
        this.lblEstadoAdopcion.setVisible(true);
    }

    private void setearListaPerros() {
        if (animalesCombo.getItemCount() > 0) {
            animalesCombo.removeAllItems();
        }
        if (calComboAnimal.getItemCount() > 0) {
            calComboAnimal.removeAllItems();
        }
        for (int i = 0; i < sistema.getAnimales().size(); i++) {
            animalesCombo.addItem(sistema.getAnimales().get(i).getNombre());
            calComboAnimal.addItem(sistema.getAnimales().get(i).getNombre());
        }

    }

    private void mostrarAgregarUsuario() {
        agregarUsuarioSeleccionado = true;
        usuarioLblNombre.setText("Nombre:");
        usuarioLblMail.setText("Mail:");
        usuarioTxtNombre.setVisible(true);
        usuarioTxtMail.setVisible(true);
    }

    private void ocultarAgregarUsuario() {
        usuarioTxtNombre.setVisible(false);
        usuarioTxtMail.setVisible(false);
        agregarUsuarioSeleccionado = false;
    }

    private void resetearListaUsuarios() {
        if (usuarioComboUsuarios.getItemCount() > 0) {
            usuarioComboUsuarios.removeAllItems();
        }
        if (calComboUsuario.getItemCount() > 0) {
            calComboUsuario.removeAllItems();
        }
        for (int i = 0; i < sistema.getUsuarios().size(); i++) {
            usuarioComboUsuarios.addItem(sistema.getUsuarios().get(i).getNombre());
            calComboUsuario.addItem(sistema.getUsuarios().get(i).getNombre());
        }
    }

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelMouseClicked

    private void animalesComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_animalesComboMouseClicked

    }//GEN-LAST:event_animalesComboMouseClicked

    private void animalesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalesComboActionPerformed
        ocultarAgregarPerro();
        if (animalesCombo.getItemCount() > 0) {
            Animal animal = sistema.buscarPerroPorNombre(animalesCombo.getSelectedItem().toString());
            animalLblNombre.setText(animal.getNombre().toUpperCase());
            animalLblPeso.setText("Pesa:       " + animal.getPeso());
            animalLblAltura.setText("Mide:       " + animal.getAltura());
            animalLblComentarios.setText("" + animal.getComentarios());
            perroLblFoto.setIcon(animal.getFoto());
            animalBtnGuardar.setVisible(false);
            animalBtnEditar.setVisible(true);
            animalBtnAgregar.setVisible(true);
            this.lblEstadoAdopcion.setText(animal.estadoAdopcion());
        } else {
            animalLblNombre.setText("Nombre: ");
            animalLblPeso.setText("Peso ");
            animalLblAltura.setText("Altura: ");
            animalLblComentarios.setText("Comentarios: ");
            try {
                perroLblFoto.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("images/perroPorDefecto.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_animalesComboActionPerformed

    private void animalBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalBtnEditarActionPerformed
        mostrarEditarPerro();
    }//GEN-LAST:event_animalBtnEditarActionPerformed

    private void animalBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalBtnGuardarActionPerformed
        Animal perroSeleccionado = sistema.buscarPerroPorNombre(animalesCombo.getSelectedItem().toString());
        String valor = animalSpinAltura.getValue() + "";
        double altura = Double.parseDouble(valor);
        perroSeleccionado.setAltura(altura);
        perroSeleccionado.setComentarios(animaltxtComentarios.getText());
        perroSeleccionado.setNombre(animalTxtNombre.getText());
        valor = animalSpinPeso.getValue() + "";
        double peso = Double.parseDouble(valor);
        perroSeleccionado.setPeso(peso);
        if (!rutaImagenAgregar.equals("")) {
            File imagen = new File(rutaImagenAgregar);
            perroSeleccionado.setFoto(crearIcono(imagen, 100));
            rutaImagenAgregar = "";
        }
        ocultarAgregarPerro();
        int pos = animalesCombo.getSelectedIndex();
        setearListaPerros();
        animalesCombo.setSelectedIndex(pos);
    }//GEN-LAST:event_animalBtnGuardarActionPerformed

    private void cbFrecuenciaDonacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFrecuenciaDonacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFrecuenciaDonacionActionPerformed

    private void btnOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtroActionPerformed
        String tipo = JOptionPane.showInputDialog(this, "Ingrese un tipo de animal", "Tipo De Animal", JOptionPane.QUESTION_MESSAGE);
        if(tipo != null && !tipo.trim().isEmpty()){
            this.tipoAnimal = tipo.toLowerCase();
            this.sistema.agregarTipo(tipo);
            this.cbTipoAnimal.setModel(new DefaultComboBoxModel(this.sistema.getListaTipoAnimales().toArray()));
            this.cbTipoAnimal.setSelectedItem(tipo);
        }
    }//GEN-LAST:event_btnOtroActionPerformed

    private void cbTipoAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoAnimalActionPerformed

    private void btnRegistroPadrinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroPadrinoActionPerformed
            // TODO add your handling code here:
            if(txtFieldNombrePadrino.getText().trim().isEmpty()){
                lblAdvertenciaRegistroPadrino.setText("Se debe ingresar un nombre.");
            }
            else if(txtFieldApellidoPadrino.getText().trim().isEmpty()){
                lblAdvertenciaRegistroPadrino.setText("Se debe ingresar un apellido.");
            }
            else if(!this.esNumero(this.txtFieldTelefonoPadrino.getText())){
                lblAdvertenciaRegistroPadrino.setText("Se debe ingresar un telefono.");
            }
            else if(!isValidEmailAddress(txtFieldEmailPadrino.getText())){
                lblAdvertenciaRegistroPadrino.setText("Se debe ingresar un correo electronico.");
            }
            else if(txtFieldCiudadPadrino.getText().trim().isEmpty()){
                lblAdvertenciaRegistroPadrino.setText("Se debe ingresar una ciudad.");
            }
            else if(txtFieldPaisPadrino.getText().trim().isEmpty()){
                lblAdvertenciaRegistroPadrino.setText("Se debe ingresar un pais.");
            }
            else if(txtFieldValorDonacion.getText().trim().isEmpty()){
                lblAdvertenciaRegistroPadrino.setText("Se debe ingresar un valor de donacion.");
            }
            else if(cbFrecuenciaDonacion.getSelectedIndex() == -1){
                lblAdvertenciaRegistroPadrino.setText("Se debe seleccionar una frecuencia de donacion.");
            }
            else if(calBtnGroupMetodoPago.getSelection() == null){
                lblAdvertenciaRegistroPadrino.setText("Se debe seleccionar un metodo de pago.");
            }
            else if(calBtnGroupMoneda.getSelection() == null){
                lblAdvertenciaRegistroPadrino.setText("Se debe seleccionar una moneda de pago.");
            }
            else if(cbFrecuenciaDonacion.getSelectedIndex() == -1){
                lblAdvertenciaRegistroPadrino.setText("Se debe seleccionar un animal a apadrinar");
            }
            
            else{
                String nombrePadrino = this.txtFieldNombrePadrino.getText();
                String apellido = this.txtFieldApellidoPadrino.getText();
                int telefono = Integer.parseInt(this.txtFieldTelefonoPadrino.getText());
                String email = this.txtFieldEmailPadrino.getText();
                String ciudad = this.txtFieldCiudadPadrino.getText();
                String pais = this.txtFieldPaisPadrino.getText();
                int valorDonacion = Integer.parseInt(this.txtFieldValorDonacion.getText());
                
                String frecuencia = (String)cbFrecuenciaDonacion.getSelectedItem();
                String metodoPago;
                if(rbTarjetaCredito.isSelected()){
                    metodoPago = "Tarjeta de Credito";
                }
                else{
                    metodoPago = "Transaccion bancaria";
                }
                String moneda;
                if(rbDolares.isSelected()){
                    moneda = "dolares";
                }
                else{
                    moneda = "pesos uruguayos";
                }
                
                Padrino p = new Padrino(nombrePadrino, apellido, telefono, email,ciudad, pais, valorDonacion, metodoPago, moneda, frecuencia);
                sistema.agregarPadrino(p);
                ArrayList <Animal> seleccionados = new ArrayList<>();
                seleccionados.addAll(this.lstAnimalesApadrinar.getSelectedValuesList());
                p.setApadrinados(seleccionados);
                listarPadrinosVista();
                cambiarPanel(panelContenedorPadrinos,panelVistaPadrinos);
                this.listaAnimalesQueApadrina.setListData(p.getApadrinados().toArray());
            }
            
            
            
    }//GEN-LAST:event_btnRegistroPadrinoActionPerformed

    private void setearListaFrecuencias(){
        if(cbFrecuenciaDonacion.getItemCount() > 0){
            cbFrecuenciaDonacion.removeAllItems();
        }
        cbFrecuenciaDonacion.addItem("solo esta vez");
        cbFrecuenciaDonacion.addItem("mensual");
        cbFrecuenciaDonacion.addItem("trimestral");
        cbFrecuenciaDonacion.addItem("anual");
    }
    
    private void setearListaAnimalesAApadrinar(){
        
       this.lstAnimalesApadrinar.setListData(this.sistema.getAnimales().toArray());
    }
    
    public void cambiarPanel(JPanel contenedor, JPanel panel){
        contenedor.removeAll();
        contenedor.add(panel);
        contenedor.repaint();
        contenedor.revalidate();
    }
    
    
    private void btnAgregarPadrinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPadrinoActionPerformed
        setearListaFrecuencias();
        setearListaAnimalesAApadrinar();
        //cambiar al panel de registro
        cambiarPanel(panelContenedorPadrinos,panelRegistroPadrino);
    }//GEN-LAST:event_btnAgregarPadrinoActionPerformed

    private void listarPadrinosVista(){
        
        this.cbPadrinos.setModel(new DefaultComboBoxModel(this.sistema.getListaPadrinos().toArray()));

    }
    
    
    
    private void btnAtrasPadrinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasPadrinoActionPerformed
        listarPadrinosVista();
        cambiarPanel(panelContenedorPadrinos,panelVistaPadrinos);
    }//GEN-LAST:event_btnAtrasPadrinoActionPerformed

    private void usuarioBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioBtnAgregarActionPerformed
        if (agregarUsuarioSeleccionado == false) {
            mostrarAgregarUsuario();
        } else {
            if (usuarioTxtNombre.getText().trim().isEmpty()) {
                usuarioLblAdvertencia.setText("Por favor ingrese un nombre para el usuario");
            } else if (usuarioTxtMail.getText().trim().isEmpty()) {
                usuarioLblAdvertencia.setText("Por favor ingrese un email para el usuario");
            } else if (!isValidEmailAddress(usuarioTxtMail.getText())) {
                usuarioLblAdvertencia.setText("Por favor ingrese un email correcto");
            }
            else {
                Usuario usuarioAgregar = new Usuario(usuarioTxtNombre.getText(), usuarioTxtMail.getText());
                if(!this.sistema.existeUsuario(usuarioAgregar)){
                    sistema.anadirUsuario(usuarioAgregar);
                    usuarioTxtNombre.setText("");
                    usuarioTxtMail.setText("");
                    ocultarAgregarUsuario();
                    resetearListaUsuarios();
                    usuarioLblAdvertencia.setText("");
                }else{
                    usuarioLblAdvertencia.setText("Por favor, elija un nombre que no este registrado");
                }
            }
        }
    }//GEN-LAST:event_usuarioBtnAgregarActionPerformed

    private void usuarioTxtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTxtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTxtMailActionPerformed

    private void usuarioComboUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioComboUsuariosActionPerformed
        ocultarAgregarUsuario();
        if (usuarioComboUsuarios.getItemCount() > 0) {
            Usuario usuarioSeleccionado = sistema.buscarUsuarioPorNombre(usuarioComboUsuarios.getSelectedItem().toString());
            usuarioLblNombre.setText("Nombre: " + usuarioSeleccionado.getNombre());
            usuarioLblMail.setText("Mail: " + usuarioSeleccionado.getMail());
            String[] arrayActividades = new String[5];
            String[] arrayFechas = new String[5];
            int cantidadActividades = usuarioSeleccionado.getActividades().size();
            for (int i = 0; i < cantidadActividades; i++) {
                arrayActividades[i] = usuarioSeleccionado.getActividades().get(i).getNombre();
                Fecha fechaActividad = usuarioSeleccionado.getActividades().get(i).getFecha();
                arrayFechas[i] = fechaActividad.getDia() + "/" + fechaActividad.getMes() + "/" + fechaActividad.getAno();
            }
            usuarioLstActividades.setListData(arrayActividades);
            usuarioLstFechas.setListData(arrayFechas);
        } else {
            usuarioLblNombre.setText("Nombre: ");
            usuarioLblMail.setText("Mail: ");
            String[] arrayVacio = new String[0];
            usuarioLstActividades.setListData(arrayVacio);
            usuarioLstFechas.setListData(arrayVacio);
        }
    }//GEN-LAST:event_usuarioComboUsuariosActionPerformed

    private void calBtnVerRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnVerRutaActionPerformed
        String nombreAct = calLstActividades.getSelectedValue();
        Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
        if (paseo != null) {
            if (paseo.getRuta() != null) {
                try {
                    new VentanaFotoRuta(paseo).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                calLblAdvertencia.setText("No hay ruta agregada a este paseo");
            }
        }
    }//GEN-LAST:event_calBtnVerRutaActionPerformed

    private void calBtnAgregarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnAgregarDatosActionPerformed
        try {
            Usuario persona = new Usuario("Alex", "alexkmass@gmail.com");
            sistema.anadirUsuario(persona);
            Animal rasta = new Animal("Rasta","Perro", 50, 23, "Es un buen perro, le gusta comer");
            rasta.setFoto(new ImageIcon(ImageIO.read(this.getClass().getResource("images/perroPorDefecto.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            sistema.agregarAnimal(rasta);
            Usuario persona2 = new Usuario("Marcelo", "marcelo@gmail.com");
            sistema.anadirUsuario(persona2);
            Animal ori = new Animal("Ori","Gato", 50, 23, "Es un buen gato");
            ori.setFoto(new ImageIcon(ImageIO.read(this.getClass().getResource("images/perroFoto.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            sistema.agregarAnimal(ori);
            Fecha fecha = new Fecha(22, 11, 2018);
            sistema.anadirFecha(fecha);
            LocalTime hora = LocalTime.now();
            Paseo act = new Paseo("Paseo Rasta", persona, rasta, 0.0, false, hora, fecha);
            act.setRuta(new ImageIcon(ImageIO.read(this.getClass().getResource("images/rutaPorDefecto.png")).getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH)));
            sistema.anadirActividad(act);
            sistema.getPaseos().add(act);
            hora = LocalTime.now();
            Alimentacion act2 = new Alimentacion("Alimentación de Ori", persona, ori, "DogChow", false, hora, fecha);
            sistema.anadirActividad(act2);
            sistema.getAlimentaciones().add(act2);
            ActividadCualquiera act3 = new ActividadCualquiera("Ir a una cita con Rasta", persona, rasta, true, hora, fecha);
            sistema.anadirActividad(act3);
            sistema.getActsCualquieras().add(act3);
            Veterinaria vet1 = new Veterinaria("Pocitos", new ArrayList<>(), 8, 16);
            sistema.getVeterinarias().add(vet1);
            Veterinaria vet2 = new Veterinaria("Carrasco", new ArrayList<>(), 10, 15);
            sistema.getVeterinarias().add(vet2);
            Veterinaria vet3 = new Veterinaria("Cordon", new ArrayList<>(), 8, 23);
            sistema.getVeterinarias().add(vet3);
            VisitaVeterinaria visita = new VisitaVeterinaria("Visita a VetCordon", hora, persona, rasta, false, fecha, vet3, "Rasta tiene fiebre");
            sistema.anadirActividad(visita);
            sistema.getVisitas().add(visita);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        resetearPestanaPerros();
        inicializarPestanaUsuarios();
        setearListaDeVeterinarias();
        calBtnAgregarDatos.setVisible(false);
        int dia = calDayChooser.getDay();
        int mes = calMonthChooser.getMonth() + 1;
        int ano = calYearChooser.getYear();
        ArrayList<Actividad> listaActividades = sistema.listaActividadesPorFecha(dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        calLstActividades.setListData(arrActividades);

        calLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_calBtnAgregarDatosActionPerformed

    private void calBtnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnRutaActionPerformed
        JFileChooser elegirImagen = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        elegirImagen.setFileFilter(filter);
        int result = elegirImagen.showDialog(this, "Elija una imagen");
        if (result == JFileChooser.APPROVE_OPTION) {
            File imgSeleccionada = elegirImagen.getSelectedFile();
            rutaImagenRuta = imgSeleccionada.getAbsolutePath();
        } else {
            calLblAdvertencia.setText("No se pudo ingresar la ruta correctamente");
        }
    }//GEN-LAST:event_calBtnRutaActionPerformed

    private void calBtnRealizadaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnRealizadaNoActionPerformed
        calPanRuta.setVisible(false);
    }//GEN-LAST:event_calBtnRealizadaNoActionPerformed

    private void calBtnRealizadaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnRealizadaSiActionPerformed
        if (calComboTipo.getSelectedIndex() == 0) {
            calPanRuta.setVisible(true);
        } else {
            calPanRuta.setVisible(false);
        }
    }//GEN-LAST:event_calBtnRealizadaSiActionPerformed

    private void calBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnEditarActionPerformed
        calLstActividades.setEnabled(false);
        String nombreAct = calLstActividades.getSelectedValue();
        Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
        calBtnVeterinariaNo.setSelected(true);
        calBtnVeterinariaNoActionPerformed(evt);
        calBtnGroupRealizada.clearSelection();
        calBtnRealizadaNo.setSelected(true);
        if (paseo != null) {
            if (paseo.getFueRealizado()) {
                calBtnRealizadaSi.setSelected(true);
            }
            calPanRuta.setVisible(true);
            calComboTipo.setSelectedIndex(0);
            if (paseo.getFueRealizado()) {
                calPanRuta.setVisible(true);
            }
            if (paseo.getRuta() == null) {
                calBtnVerRuta.setVisible(false);
            }
            calTxtNombreResp.setText(nombreAct);
            calComboUsuario.setSelectedItem(paseo.getUsuario().getNombre());
            calComboAnimal.setSelectedItem(paseo.getMascota().getNombre());
            calLblFechaResp.setText(paseo.getFecha().getDia() + "/" + paseo.getFecha().getMes() + "/" + paseo.getFecha().getAno());
            calComboHora.setSelectedIndex(1);
            int hora = paseo.getHora().getHour();
            String horaString = "" + hora;
            if (hora < 10) {
                horaString = "0" + horaString;
            }
            calPanSpinHora.setValue((Object) horaString);
            calPanSpinMinutos.setValue(paseo.getHora().getMinute());
            sistema.eliminarActividad(paseo);
            sistema.getPaseos().remove(paseo);
        } else {
            Alimentacion alim = sistema.buscarAlimentacionPorNombre(nombreAct);
            if (alim != null) {
                if (alim.getFueRealizado()) {
                    calBtnRealizadaSi.setSelected(true);
                }
                calComboTipo.setSelectedIndex(1);
                calTxtNombreResp.setText(nombreAct);
                calComboUsuario.setSelectedItem(alim.getUsuario().getNombre());
                calComboAnimal.setSelectedItem(alim.getMascota().getNombre());
                calLblFechaResp.setText(alim.getFecha().getDia() + "/" + alim.getFecha().getMes() + "/" + alim.getFecha().getAno());
                calComboHora.setSelectedIndex(1);
                int hora = alim.getHora().getHour();
                String horaString = "" + hora;
                if (hora < 10) {
                    horaString = "0" + horaString;
                }
                calPanSpinHora.setValue((Object) horaString);
                calPanSpinMinutos.setValue(alim.getHora().getMinute());
                calTxtTipoAlimento.setText(alim.getTipoAlimento());
                calTxtTipoAlimento.setVisible(true);
                sistema.eliminarActividad(alim);
                sistema.getAlimentaciones().remove(alim);
            } else {
                VisitaVeterinaria visita = sistema.buscarVisitaPorNombre(nombreAct);
                if (visita != null) {
                    if (visita.getFueRealizado()) {
                        calBtnRealizadaSi.setSelected(true);
                    }
                    calComboTipo.setSelectedIndex(2);
                    calTxtNombreResp.setText(nombreAct);
                    calComboUsuario.setSelectedItem(visita.getUsuario().getNombre());
                    calComboAnimal.setSelectedItem(visita.getMascota().getNombre());
                    calLblFechaResp.setText(visita.getFecha().getDia() + "/" + visita.getFecha().getMes() + "/" + visita.getFecha().getAno());
                    calComboHora.setSelectedIndex(1);
                    int hora = visita.getHora().getHour();
                    String horaString = "" + hora;
                    if (hora < 10) {
                        horaString = "0" + horaString;
                    }
                    calPanSpinHora.setValue((Object) horaString);
                    calPanSpinMinutos.setValue(visita.getHora().getMinute());
                    calBtnVeterinariaSi.setSelected(true);
                    calComboVeterinaria.setSelectedItem(visita.getVeterinaria().getNombre());
                    calComboMotivo.setSelectedItem(visita.getMotivo());
                    calPanVeterinaria.setVisible(true);
                    calLblHorarios.setVisible(true);
                    visita.getVeterinaria().getActividadesAgendadas().remove(visita);
                    sistema.eliminarActividad(visita);
                    sistema.getVisitas().remove(visita);
                } else {
                    ActividadCualquiera actividad = sistema.buscarActCualquieraPorNombre(nombreAct);
                    if (actividad.getFueRealizado()) {
                        calBtnRealizadaSi.setSelected(true);
                    }
                    calComboTipo.setSelectedIndex(2);
                    calTxtNombreResp.setText(nombreAct);
                    calComboUsuario.setSelectedItem(actividad.getUsuario().getNombre());
                    calComboAnimal.setSelectedItem(actividad.getMascota().getNombre());
                    calLblFechaResp.setText(actividad.getFecha().getDia() + "/" + actividad.getFecha().getMes() + "/" + actividad.getFecha().getAno());
                    calComboHora.setSelectedIndex(1);
                    int hora = actividad.getHora().getHour();
                    String horaString = "" + hora;
                    if (hora < 10) {
                        horaString = "0" + horaString;
                    }
                    calPanSpinHora.setValue((Object) horaString);
                    calPanSpinMinutos.setValue(actividad.getHora().getMinute());
                    calTxtTipoAlimento.setVisible(true);
                    sistema.eliminarActividad(actividad);
                    sistema.getActsCualquieras().remove(actividad);
                }
            }
        }
        calLblAdvertencia.setText("Edite la actividad y agreguela");
        calBtnEditar.setVisible(false);
    }//GEN-LAST:event_calBtnEditarActionPerformed

    private void calTxtTipoAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calTxtTipoAlimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calTxtTipoAlimentoActionPerformed

    private void calComboVeterinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calComboVeterinariaActionPerformed
        Veterinaria vet = sistema.buscarVetPorNombre((String) calComboVeterinaria.getSelectedItem());
        calLblHorarios.setVisible(true);
        calLblHorarios.setText("Horarios: " + vet.getHoraInicial() + " - " + vet.getHoraFinal());
    }//GEN-LAST:event_calComboVeterinariaActionPerformed

    private void calBtnVeterinariaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnVeterinariaNoActionPerformed
        calComboVeterinaria.setVisible(false);
        calComboMotivo.setVisible(false);
        calLblMotivo.setVisible(false);
        calLblHorarios.setVisible(false);
    }//GEN-LAST:event_calBtnVeterinariaNoActionPerformed

    private void calBtnVeterinariaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnVeterinariaSiActionPerformed
        calComboVeterinaria.setVisible(true);
        calComboMotivo.setVisible(true);
        calLblMotivo.setVisible(true);
        calLblHorarios.setVisible(true);
    }//GEN-LAST:event_calBtnVeterinariaSiActionPerformed

    private void calTxtNombreRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calTxtNombreRespActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calTxtNombreRespActionPerformed

    private void calComboHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calComboHoraActionPerformed
        if (calComboHora.getSelectedIndex() == 0) {
            calPanHoraPersonalizada.setVisible(false);
        } else {
            calPanHoraPersonalizada.setVisible(true);
        }
    }//GEN-LAST:event_calComboHoraActionPerformed

    private void calComboAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calComboAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calComboAnimalActionPerformed

    private void calComboUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calComboUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calComboUsuarioActionPerformed

    private void calComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calComboTipoActionPerformed
        if (calComboTipo.getSelectedIndex() == 2) {
            if (calBtnVeterinariaSi.isSelected()) {
                cambiarVisibilidadVeterinaria(true, true);
            } else {
                cambiarVisibilidadVeterinaria(true, false);
            }
        } else {
            cambiarVisibilidadVeterinaria(false, false);
        }
        if (calComboTipo.getSelectedIndex() == 1) {
            calLblTipoAlimento.setVisible(true);
            calTxtTipoAlimento.setVisible(true);
        } else {
            calLblTipoAlimento.setVisible(false);
            calTxtTipoAlimento.setVisible(false);
            calTxtTipoAlimento.setText("");
        }
        if (calComboTipo.getSelectedIndex() == 0 && calBtnRealizadaSi.isSelected()) {
            calPanRuta.setVisible(true);
        } else {
            calPanRuta.setVisible(false);
        }
    }//GEN-LAST:event_calComboTipoActionPerformed

    private void calBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calBtnAgregarActionPerformed
        String nombreAct = calTxtNombreResp.getText();
        boolean fueRealizada = true;
        if (calBtnRealizadaNo.isSelected()) {
            fueRealizada = false;
        }
        if (nombreAct.equals("")) {
            calLblAdvertencia.setText("No se ingresó un nombre, ingrese el nombre de la actividad.");
        } else if (calComboUsuario.getItemCount() == 0) {
            calLblAdvertencia.setText("Por favor, ingrese un usuario para agregar una actividad.");
        } else if (calComboAnimal.getItemCount() == 0) {
            calLblAdvertencia.setText("Por favor, ingrese un perro para agregar una actividad.");
        } else {

            Usuario usuario = sistema.buscarUsuarioPorNombre(((Usuario)calComboUsuario.getSelectedItem()).getNombre());
            Animal perro = sistema.buscarPerroPorNombre(((Animal) calComboAnimal.getSelectedItem()).getNombre());
            LocalTime time;
            if (((String) calComboHora.getSelectedItem()).equals("Ahora")) {
                time = LocalTime.now();
            } else {
                String hora = calPanSpinHora.getValue() + "";
                String min = calPanSpinMinutos.getValue() + "";
                time = LocalTime.of(Integer.parseInt(hora), Integer.parseInt(min));
            }
            if (calBtnVeterinariaSi.isSelected()) {
                Veterinaria vet = sistema.buscarVetPorNombre((String) calComboVeterinaria.getSelectedItem());
                String motivo = (String) calComboMotivo.getSelectedItem();
                VisitaVeterinaria visita = new VisitaVeterinaria(nombreAct, time, usuario, perro, fueRealizada, fechaSeleccionada, vet, motivo);
                if (vet.agendarActividad(visita)) {
                    sistema.anadirActividad(visita);
                    sistema.getVisitas().add(visita);
                    if (calComboHora.getSelectedIndex() != 0) {
                        timerNuevo(visita);
                    }
                    calLblAdvertencia.setText("Se agrego la visita a la veterinaria con éxito");
                    calLstActividades.setEnabled(true);
                    calBtnEditar.setVisible(false);
                    calTxtNombreResp.setText("");
                    calPanVeterinaria.setVisible(false);
                    calLblHorarios.setVisible(false);
                } else {
                    calLblAdvertencia.setText("La veterinaria no tiene horarios disponibles en ese horario, por favor ingrse una "
                        + "hora distinta entre las " + vet.getHoraInicial() + " y las " + vet.getHoraFinal());
                }
            } else {
                String tipoAct = (String) calComboTipo.getSelectedItem();
                boolean ok = false;
                if (tipoAct.equals("Paseo")) {
                    Paseo paseo = new Paseo(nombreAct, usuario, perro, 0, fueRealizada, time, fechaSeleccionada);
                    double distanciaPaseo = 0.0;
                    try {
                        distanciaPaseo = Double.parseDouble(calSpinDistancia.getText().replaceAll(",","."));
                        ok = true;
                    }
                    catch (NumberFormatException e) {

                    }
                    if(ok){
                        if (distanciaPaseo != 0.0) {
                            paseo.setDistancia(distanciaPaseo);
                        }
                        sistema.anadirActividad(paseo);
                        sistema.getPaseos().add(paseo);
                        if (calComboHora.getSelectedIndex() != 0) {
                            timerNuevo(paseo);
                        }
                        if (!rutaImagenRuta.equals("")) {
                            File imagen = new File(rutaImagenRuta);
                            paseo.setRuta(crearIcono(imagen, 500));
                            rutaImagenRuta = "";
                        }
                        calLblAdvertencia.setText("Se añadió el paseo correctamente al calendario");
                        calLstActividades.setEnabled(true);
                        calTxtNombreResp.setText("");
                        calBtnEditar.setVisible(false);
                        calPanRuta.setVisible(false);
                    }else{
                        calLblAdvertencia.setText("La distancia ingresada es incorrecta");
                    }
                } else {
                    if (tipoAct.equals("Alimentación")) {
                        String tipoAlimento = calTxtTipoAlimento.getText();
                        if (tipoAlimento.equals("")) {
                            calLblAdvertencia.setText("No se ingresó el tipo del alimento, ingrese el tipo del alimento");
                        } else {
                            Alimentacion alim = new Alimentacion(nombreAct, usuario, perro, tipoAlimento, fueRealizada, time, fechaSeleccionada);
                            sistema.anadirActividad(alim);
                            sistema.getAlimentaciones().add(alim);
                            if (calComboHora.getSelectedIndex() != 0) {
                                timerNuevo(alim);
                            }
                            calLblAdvertencia.setText("Se añadió la alimentación correctamente al calendario");
                            calTxtNombreResp.setText("");
                            calTxtTipoAlimento.setText("");
                            calBtnEditar.setVisible(false);
                            calLstActividades.setEnabled(true);
                        }
                    } else {
                        ActividadCualquiera actividad = new ActividadCualquiera(nombreAct, usuario, perro, fueRealizada, time, fechaSeleccionada);
                        sistema.anadirActividad(actividad);
                        sistema.getActsCualquieras().add(actividad);
                        if (calComboHora.getSelectedIndex() != 0) {
                            timerNuevo(actividad);
                        }
                        calLblAdvertencia.setText("Se añadió la actividad correctamente al calendario");
                        calTxtNombreResp.setText("");
                        calBtnEditar.setVisible(false);
                        calLstActividades.setEnabled(true);
                    }
                }
            }
        }
        calPanRuta.setVisible(false);
        int dia = calDayChooser.getDay();
        int mes = calMonthChooser.getMonth() + 1;
        int ano = calYearChooser.getYear();
        ArrayList<Actividad> listaActividades = sistema.listaActividadesPorFecha(dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        calLstActividades.setListData(arrActividades);

        calLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_calBtnAgregarActionPerformed

    private void calLstActividadesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_calLstActividadesValueChanged
        String nombreAct = calLstActividades.getSelectedValue();
        String cero = "";
        calBtnVerRuta.setVisible(false);
        if (nombreAct != null) {
            Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
            if (paseo != null) {
                calBtnVerRuta.setVisible(true);
                if (paseo.getHora().getMinute() < 10) {
                    cero = "0";
                }
                String fueRealizada = "No";
                if (paseo.getFueRealizado()) {
                    fueRealizada = "Si";
                }
                if (paseo.getDistancia() == 0.0) {
                    calTxtAreaInfoAct.setText("Nombre: " + paseo.getNombre() + "\n"
                        + "Usuario responsable: " + paseo.getUsuario().getNombre() + "\n"
                        + "Perro: " + paseo.getMascota().getNombre() + "\n"
                        + "Realizada: " + fueRealizada + "\n"
                        + "Hora: " + paseo.getHora().getHour() + ":" + cero + paseo.getHora().getMinute());
                } else {
                    calTxtAreaInfoAct.setText("Nombre: " + paseo.getNombre() + "\n"
                        + "Usuario responsable: " + paseo.getUsuario().getNombre() + "\n"
                        + "Perro: " + paseo.getMascota().getNombre() + "\n"
                        + "Realizada: " + fueRealizada + "\n"
                        + "Hora: " + paseo.getHora().getHour() + ":" + cero + paseo.getHora().getMinute() + "\n"
                        + "Distancia: " + paseo.getDistancia() + "kilómetros");
                }
                if (paseo.getRuta() != null) {

                }
            } else {
                Alimentacion alim = sistema.buscarAlimentacionPorNombre(nombreAct);
                if (alim != null) {
                    if (alim.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    String fueRealizada = "No";
                    if (alim.getFueRealizado()) {
                        fueRealizada = "Si";
                    }

                    calTxtAreaInfoAct.setText("Nombre: " + alim.getNombre() + "\n"
                        + "Usuario responsable: " + alim.getUsuario().getNombre() + "\n"
                        + "Perro: " + alim.getMascota().getNombre() + "\n"
                        + "Realizada: " + fueRealizada + "\n"
                        + "Tipo Alimento: " + alim.getTipoAlimento() + "\n"
                        + "Hora: " + alim.getHora().getHour() + ":" + cero + alim.getHora().getMinute());
                } else {
                    VisitaVeterinaria visita = sistema.buscarVisitaPorNombre(nombreAct);
                    if (visita != null) {
                        if (visita.getHora().getMinute() < 10) {
                            cero = "0";
                        }
                        String fueRealizada = "No";
                        if (visita.getFueRealizado()) {
                            fueRealizada = "Si";
                        }
                        calTxtAreaInfoAct.setText("Nombre: " + visita.getNombre() + "\n"
                            + "Usuario responsable: " + visita.getUsuario().getNombre() + "\n"
                            + "Perro: " + visita.getMascota().getNombre() + "\n"
                            + "Realizada: " + fueRealizada + "\n"
                            + "Motivo: " + visita.getMotivo() + "\n"
                            + "Veterinaria: " + visita.getVeterinaria().getNombre() + "\n"
                            + "Hora: " + visita.getHora().getHour() + ":" + cero + visita.getHora().getMinute());
                    } else {
                        ActividadCualquiera act = sistema.buscarActCualquieraPorNombre(nombreAct);
                        if (act.getHora().getMinute() < 10) {
                            cero = "0";
                        }
                        String fueRealizada = "No";
                        if (act.getFueRealizado()) {
                            fueRealizada = "Si";
                        }

                        calTxtAreaInfoAct.setText("Nombre: " + act.getNombre() + "\n"
                            + "Usuario responsable: " + act.getUsuario().getNombre() + "\n"
                            + "Perro: " + act.getMascota().getNombre() + "\n"
                            + "Realizada: " + fueRealizada + "\n"
                            + "Hora: " + act.getHora().getHour() + ":" + cero + act.getHora().getMinute());
                    }
                }
            }
            calBtnEditar.setVisible(true);
        } else {
            calTxtAreaInfoAct.setText("Seleccione un paseo para" + "\n"
                + "poder ver su información");
        }
    }//GEN-LAST:event_calLstActividadesValueChanged

    private void calDayChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calDayChooserPropertyChange
        int dia = calDayChooser.getDay();
        int mes = calMonthChooser.getMonth() + 1;
        int ano = calYearChooser.getYear();
        ArrayList<Actividad> listaActividades = sistema.listaActividadesPorFecha(dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        calLstActividades.setListData(arrActividades);

        calLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_calDayChooserPropertyChange

    private void btnAgregarAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAdopcionActionPerformed
        // TODO add your handling code here:
        setearListaAnimalesNoAdoptados();
        cambiarPanel(panelContenedorAdopcion,panelRegistroAdopciones);
    }//GEN-LAST:event_btnAgregarAdopcionActionPerformed

    private void txtFieldNombreAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNombreAdopcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNombreAdopcionActionPerformed

    private void txtFieldApellidoAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldApellidoAdopcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldApellidoAdopcionActionPerformed

    private void txtFieldTelefonoAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldTelefonoAdopcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldTelefonoAdopcionActionPerformed

    
    public boolean esNumero(String s){
        try{
            int i = Integer.parseInt(s);
        }
        catch(NumberFormatException | NullPointerException nfe){
            return false;
        }
        return true;
    }
    
    private void setearListaAnimalesNoAdoptados(){
        if(cbAnimalesParaAdoptar.getItemCount() > 0){
            cbAnimalesParaAdoptar.removeAllItems();
        }
        for(int i = 0; i <sistema.getAnimales().size();i++){
            Animal a = sistema.getAnimales().get(i);
            if(!a.estaAdoptado()){
                cbAnimalesParaAdoptar.addItem(a.getNombre());
            }
        }
    }
    
    
    private void btnRegistrarAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAdopcionActionPerformed
        // TODO add your handling code here:
        String nombre = this.txtFieldNombreAdopcion.getText();
        String apellido = this.txtFieldApellidoAdopcion.getText();
        int telefono;
        
        if(nombre.trim().isEmpty()){
            this.lblAdvertenciaRegistroAdopciones.setText("Debe ingresar un nombre de adoptante.");
        }
        else if(apellido.trim().isEmpty()){
            this.lblAdvertenciaRegistroAdopciones.setText("Debe ingresar un apellido de adoptante.");
        }
        else if(!esNumero(this.txtFieldTelefonoAdopcion.getText())){
            this.lblAdvertenciaRegistroAdopciones.setText("Debe ingresar un telefono de adoptante valido.");
        }
        else if(this.cbAnimalesParaAdoptar.getSelectedIndex() < 0){
            this.lblAdvertenciaRegistroAdopciones.setText("Debe seleccionar un animal para adoptar.");
        }
        else{
            Animal animal = sistema.buscarPerroPorNombre((String)this.cbAnimalesParaAdoptar.getSelectedItem());
            telefono = Integer.parseInt(this.txtFieldTelefonoAdopcion.getText());
            Adopcion a = new Adopcion(nombre,apellido,telefono,animal);
            sistema.agregarAdopcion(a);
            setearListaAdopciones();
            cambiarPanel(panelContenedorAdopcion, panelVistaAdopciones);
            
        }
        
    }//GEN-LAST:event_btnRegistrarAdopcionActionPerformed

    private void setearListaAdopciones(){
        if(cbAdopciones.getItemCount() > 0){
            cbAdopciones.removeAllItems();
        }
        for(int i = 0; i < sistema.getListaAdopciones().size(); i++){
            cbAdopciones.addItem(sistema.getListaAdopciones().get(i).getAnimal().getNombre());
        }
    }
    
    
    
    private void btnAtrasAdopcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasAdopcionActionPerformed
        // TODO add your handling code here:
        
        cambiarPanel(panelContenedorAdopcion,panelVistaAdopciones);
        
        
    }//GEN-LAST:event_btnAtrasAdopcionActionPerformed

    private void cbPadrinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPadrinosActionPerformed
        // TODO add your handling code here:
        if(cbPadrinos.getSelectedIndex() == -1){
            this.lblNombreDelPadrino.setText("");
            this.lblApellidoPadrino.setText("");
            this.lblTelefono.setText("");
            this.lblEmailPadrino.setText("");
            this.lblCiudadPadrino.setText("");
            this.lblPaisPadrino.setText("");
            this.lblDonacionPadrino.setText("");
            this.lblMetodoPagoPadrino.setText("");
        }
        else{
            
            Padrino p = sistema.getListaPadrinos().get(cbPadrinos.getSelectedIndex());
            this.lblNombreDelPadrino.setText(p.getNombre());
            this.lblApellidoPadrino.setText(p.getApellido());
            this.lblTelefonoPadrino.setText(p.getTelefono()+"");
            this.lblEmailPadrino.setText(p.getEmail());
            this.lblCiudadPadrino.setText(p.getCiudad());
            this.lblPaisPadrino.setText(p.getPais());
            this.lblDonacionPadrino.setText(p.getMonto()+" "+p.getMoneda()+" "+p.getFrecuencia());
            this.lblMetodoPagoPadrino.setText(p.getMetodo());
            this.listaAnimalesQueApadrina.setListData(p.getApadrinados().toArray());
            
            
            
        }
    }//GEN-LAST:event_cbPadrinosActionPerformed

    private void cbAdopcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAdopcionesActionPerformed
        // TODO add your handling code here:
        if(cbAdopciones.getSelectedIndex() == -1){
            lblNombreAdoptante.setText("");
            lblApellidoAdoptante.setText("");
            lblTelefonoAdoptante.setText("");
            lblAnimalAdoptado.setText("");
        }
        else{
            Adopcion a = sistema.getListaAdopciones().get(cbAdopciones.getSelectedIndex());
            lblNombreAdoptante.setText(a.getNombreAdoptante());
            lblApellidoAdoptante.setText(a.getApellidoAdoptante());
            lblTelefonoAdoptante.setText(a.getTelefono()+"");
            lblAnimalAdoptado.setText(a.getAnimal().getNombre());
        }
    }//GEN-LAST:event_cbAdopcionesActionPerformed
     
     
    private void cambiarVisibilidadVeterinaria(boolean opcionCombo, boolean usaVeterinaria) {
        calPanVeterinaria.setVisible(opcionCombo);
        calBtnVeterinariaSi.setSelected(usaVeterinaria);
        calBtnVeterinariaNo.setSelected(!usaVeterinaria);
        calComboVeterinaria.setVisible(usaVeterinaria);
        calComboMotivo.setVisible(usaVeterinaria);
        calLblMotivo.setVisible(usaVeterinaria);
        calLblHorarios.setVisible(opcionCombo);
    }

    private ImageIcon crearIcono(String ruta, int tamano) {
        ImageIcon retorno = null;
        try {
            retorno = new ImageIcon(ImageIO.read(getClass().getResource(ruta)).getScaledInstance(tamano, -1, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            System.out.println(e);
        }
        return retorno;
    }

    private ImageIcon crearIcono(File file, int tamano) {
        ImageIcon retorno = null;
        try {
            retorno = new ImageIcon(ImageIO.read(file).getScaledInstance(tamano, -1, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            System.out.println(e);
        }
        return retorno;
    }

    private void enviarMail(Actividad actividad) {
        String nombreAct = actividad.getNombre();
        Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
        String tipoActividad;
        String cuerpo;
        String cero = "";
        if (paseo != null) {
            tipoActividad = "Paseo";
            if (actividad.getHora().getMinute() < 10) {
                cero = "0";
            }
            cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                    + "Te recordamos que debes pasear a "
                    + actividad.getMascota().getNombre() + " hoy a las "
                    + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                    + "No lo olvides!";
        } else {
            Alimentacion alimentacion = sistema.buscarAlimentacionPorNombre(nombreAct);
            if (alimentacion != null) {
                tipoActividad = "Alimentacion";
                if (actividad.getHora().getMinute() < 10) {
                    cero = "0";
                }
                cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                        + "Te recordamos que debes alimentar a "
                        + actividad.getMascota().getNombre() + " con " + alimentacion.getTipoAlimento()
                        + " hoy a las " + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                        + "No lo olvides!";
            } else {
                VisitaVeterinaria visita = sistema.buscarVisitaPorNombre(nombreAct);
                if (visita != null) {
                    tipoActividad = "Visita a Veterinaria";
                    if (actividad.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                            + "Te recordamos que debes llevar a "
                            + visita.getMascota().getNombre() + "a la veterinaria " + visita.getVeterinaria().getNombre()
                            + "para realizar un/una " + visita.getMotivo() + " hoy a las "
                            + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                            + "No lo olvides!";
                } else {
                    ActividadCualquiera actividadCualquiera = sistema.buscarActCualquieraPorNombre(nombreAct);
                    tipoActividad = "una Actividad";
                    if (actividad.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    cuerpo = "Hola " + actividadCualquiera.getUsuario().getNombre() + ",\n"
                            + "Te recordamos que debes " + actividadCualquiera.getNombre() + " con "
                            + actividadCualquiera.getMascota().getNombre() + " hoy a las "
                            + actividadCualquiera.getHora().getHour() + ":" + cero + actividadCualquiera.getHora().getMinute() + ".\n"
                            + "No lo olvides!";
                }
            }
        }
        String asunto = "Recordatorio de " + tipoActividad + " de My Pet";

        final String username = "recordatoriosmypet@gmail.com";
        final String password = "canucanualex";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("recordatoriosmismascotas@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(actividad.getUsuario().getMail()));
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
           
        }
    }

    public void timerNuevo(final Actividad act) {
        int horaActividad = act.getHora().getHour() * 60 + act.getHora().getMinute();
        int horaActual = LocalTime.now().getHour() * 60 + LocalTime.now().getMinute();
        int tiempoRestanteMinutos = horaActividad - horaActual;
        try {
            ActionListener notificacion = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    enviarMail(act);
                    mostrarNotificacion(act);
                }
            };
            int tiempoRestanteMilisegundos = tiempoRestanteMinutos * 60000;
            Timer timer = new Timer(tiempoRestanteMilisegundos, notificacion);
            timer.setRepeats(false);
            timer.start();
        } catch (ArithmeticException e) {

        }
    }

    public void mostrarNotificacion(Actividad actividad) {
        String nombreAct = actividad.getNombre();
        Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
        String cuerpo;
        String cero = "";
        if (paseo != null) {
            if (actividad.getHora().getMinute() < 10) {
                cero = "0";
            }
            cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                    + "Te recordamos que debes pasear a "
                    + actividad.getMascota().getNombre() + " hoy a las "
                    + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                    + "No lo olvides!";
        } else {
            Alimentacion alimentacion = sistema.buscarAlimentacionPorNombre(nombreAct);
            if (alimentacion != null) {
                if (actividad.getHora().getMinute() < 10) {
                    cero = "0";
                }
                cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                        + "Te recordamos que debes alimentar a "
                        + actividad.getMascota().getNombre() + " con " + alimentacion.getTipoAlimento()
                        + " hoy a las " + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                        + "No lo olvides!";
            } else {
                VisitaVeterinaria visita = sistema.buscarVisitaPorNombre(nombreAct);
                if (visita != null) {
                    if (actividad.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    cuerpo = "Hola " + actividad.getUsuario().getNombre() + ",\n"
                            + "Te recordamos que debes llevar a "
                            + visita.getMascota().getNombre() + "a la veterinaria " + visita.getVeterinaria().getNombre()
                            + "para realizar un/una " + visita.getMotivo() + " hoy a las "
                            + actividad.getHora().getHour() + ":" + cero + actividad.getHora().getMinute() + ".\n"
                            + "No lo olvides!";
                } else {
                    if (actividad.getHora().getMinute() < 10) {
                        cero = "0";
                    }
                    ActividadCualquiera actividadCualquiera = sistema.buscarActCualquieraPorNombre(nombreAct);
                    cuerpo = "Hola " + actividadCualquiera.getUsuario().getNombre() + ",\n"
                            + "Te recordamos que debes " + actividadCualquiera.getNombre() + " con "
                            + actividadCualquiera.getMascota().getNombre() + " hoy a las "
                            + actividadCualquiera.getHora().getHour() + ":" + cero + actividadCualquiera.getHora().getMinute() + ".\n"
                            + "No lo olvides!";
                }
            }
        }
        JFrame ventana = this;
        JOptionPane.showMessageDialog(ventana, cuerpo, "Notificación", 1);   
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton animalBtnAgregar;
    private javax.swing.JButton animalBtnEditar;
    private javax.swing.JButton animalBtnExaminar;
    private javax.swing.JButton animalBtnGuardar;
    private javax.swing.JLabel animalLblAdvertencia;
    private javax.swing.JLabel animalLblAltura;
    private javax.swing.JLabel animalLblAnimales;
    private javax.swing.JLabel animalLblComentarios;
    private javax.swing.JLabel animalLblFotoBoton;
    private javax.swing.JLabel animalLblNombre;
    private javax.swing.JLabel animalLblPeso;
    private javax.swing.JPanel animalPanFoto;
    private javax.swing.JPanel animalPanInformacion;
    private javax.swing.JSpinner animalSpinAltura;
    private javax.swing.JSpinner animalSpinPeso;
    private javax.swing.JTextField animalTxtNombre;
    private javax.swing.JComboBox<String> animalesCombo;
    private javax.swing.JTextField animaltxtComentarios;
    private javax.swing.JButton btnAgregarAdopcion;
    private javax.swing.JButton btnAgregarPadrino;
    private javax.swing.JButton btnAtrasAdopcion;
    private javax.swing.JButton btnAtrasPadrino;
    private javax.swing.JButton btnOtro;
    private javax.swing.JButton btnRegistrarAdopcion;
    private javax.swing.JButton btnRegistroPadrino;
    private javax.swing.JButton calBtnAgregar;
    private javax.swing.JButton calBtnAgregarDatos;
    private javax.swing.JButton calBtnEditar;
    private javax.swing.ButtonGroup calBtnGroupMetodoPago;
    private javax.swing.ButtonGroup calBtnGroupMoneda;
    private javax.swing.ButtonGroup calBtnGroupRealizada;
    private javax.swing.ButtonGroup calBtnGroupRepetir;
    private javax.swing.ButtonGroup calBtnGroupVeterinaria;
    private javax.swing.JRadioButton calBtnRealizadaNo;
    private javax.swing.JRadioButton calBtnRealizadaSi;
    private javax.swing.JButton calBtnRuta;
    private javax.swing.JButton calBtnVerRuta;
    private javax.swing.JRadioButton calBtnVeterinariaNo;
    private javax.swing.JRadioButton calBtnVeterinariaSi;
    private javax.swing.JComboBox<String> calComboAnimal;
    private javax.swing.JComboBox<String> calComboHora;
    private javax.swing.JComboBox<String> calComboMotivo;
    private javax.swing.JComboBox<String> calComboTipo;
    private javax.swing.JComboBox<String> calComboUsuario;
    private javax.swing.JComboBox<String> calComboVeterinaria;
    private com.toedter.calendar.JDayChooser calDayChooser;
    private javax.swing.JLabel calLblActividadesDelDia;
    private javax.swing.JLabel calLblAdvertencia;
    private javax.swing.JLabel calLblCentimetros;
    private javax.swing.JLabel calLblDistancia;
    private javax.swing.JLabel calLblFecha;
    private javax.swing.JLabel calLblFechaResp;
    private javax.swing.JLabel calLblHora;
    private javax.swing.JLabel calLblHorarios;
    private javax.swing.JLabel calLblInfoActividad;
    private javax.swing.JLabel calLblKilogramos;
    private javax.swing.JLabel calLblKilometros;
    private javax.swing.JLabel calLblMotivo;
    private javax.swing.JLabel calLblNombre;
    private javax.swing.JLabel calLblPerro;
    private javax.swing.JLabel calLblRealizada;
    private javax.swing.JLabel calLblRuta;
    private javax.swing.JLabel calLblTipo;
    private javax.swing.JLabel calLblTipoAlimento;
    private javax.swing.JLabel calLblTituloActividad;
    private javax.swing.JLabel calLblTituloFecha;
    private javax.swing.JLabel calLblUsuario;
    private javax.swing.JLabel calLblVeterinaria;
    private javax.swing.JList<String> calLstActividades;
    private com.toedter.calendar.JMonthChooser calMonthChooser;
    private javax.swing.JPanel calPanHoraPersonalizada;
    private javax.swing.JLabel calPanLblHora;
    private javax.swing.JLabel calPanLblMinutos;
    private javax.swing.JPanel calPanRuta;
    private javax.swing.JSpinner calPanSpinHora;
    private javax.swing.JSpinner calPanSpinMinutos;
    private javax.swing.JPanel calPanVeterinaria;
    private javax.swing.JScrollPane calScrollActividades;
    private javax.swing.JScrollPane calScrollInfoAct;
    private javax.swing.JTextField calSpinDistancia;
    private javax.swing.JTextArea calTxtAreaInfoAct;
    private javax.swing.JTextField calTxtNombreResp;
    private javax.swing.JTextField calTxtTipoAlimento;
    private com.toedter.calendar.JYearChooser calYearChooser;
    private javax.swing.JComboBox<String> cbAdopciones;
    private javax.swing.JComboBox<String> cbAnimalesParaAdoptar;
    private javax.swing.JComboBox<String> cbFrecuenciaDonacion;
    private javax.swing.JComboBox<String> cbPadrinos;
    private javax.swing.JComboBox<String> cbTipoAnimal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAdvertenciaRegistroAdopciones;
    private javax.swing.JLabel lblAdvertenciaRegistroPadrino;
    private javax.swing.JLabel lblAnimalAdopcion;
    private javax.swing.JLabel lblAnimalAdoptado;
    private javax.swing.JLabel lblAnimalesApadrinados;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellidoAdoptante;
    private javax.swing.JLabel lblApellidoPadrino;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblCiudadPadrino;
    private javax.swing.JLabel lblDonacion;
    private javax.swing.JLabel lblDonacionPadrino;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailPadrino;
    private javax.swing.JLabel lblEstadoAdopcion;
    private javax.swing.JLabel lblMetodo;
    private javax.swing.JLabel lblMetodoPagoPadrino;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreAdopcion;
    private javax.swing.JLabel lblNombreAdopcion1;
    private javax.swing.JLabel lblNombreAdoptante;
    private javax.swing.JLabel lblNombreDelPadrino;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblPaisPadrino;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoAdopcion;
    private javax.swing.JLabel lblTelefonoAdoptante;
    private javax.swing.JLabel lblTelefonoPadrino;
    private javax.swing.JLabel lblTipoAnimal;
    private javax.swing.JLabel lblVistaPadrinos;
    private javax.swing.JList listaAnimalesQueApadrina;
    private javax.swing.JList lstAnimalesApadrinar;
    private javax.swing.JPanel panAdopciones;
    private javax.swing.JPanel panAnimales;
    private javax.swing.JPanel panCalendario;
    private javax.swing.JPanel panPadrinos;
    private javax.swing.JPanel panUsuarios;
    private javax.swing.JTabbedPane panel;
    private javax.swing.JPanel panelContenedorAdopcion;
    private javax.swing.JPanel panelContenedorPadrinos;
    private javax.swing.JPanel panelRegistroAdopciones;
    private javax.swing.JPanel panelRegistroPadrino;
    private javax.swing.JPanel panelVistaAdopciones;
    private javax.swing.JPanel panelVistaPadrinos;
    private javax.swing.JLabel perroLblFoto;
    private javax.swing.JRadioButton rbDolares;
    private javax.swing.JRadioButton rbPesos;
    private javax.swing.JRadioButton rbTarjetaCredito;
    private javax.swing.JRadioButton rbTransferenciaBancaria;
    private javax.swing.JTextField txtFieldApellidoAdopcion;
    private javax.swing.JTextField txtFieldApellidoPadrino;
    private javax.swing.JTextField txtFieldCiudadPadrino;
    private javax.swing.JTextField txtFieldEmailPadrino;
    private javax.swing.JTextField txtFieldNombreAdopcion;
    private javax.swing.JTextField txtFieldNombrePadrino;
    private javax.swing.JTextField txtFieldPaisPadrino;
    private javax.swing.JTextField txtFieldTelefonoAdopcion;
    private javax.swing.JTextField txtFieldTelefonoPadrino;
    private javax.swing.JTextField txtFieldValorDonacion;
    private javax.swing.JButton usuarioBtnAgregar;
    private javax.swing.JComboBox<String> usuarioComboUsuarios;
    private javax.swing.JLabel usuarioLblActividad;
    private javax.swing.JLabel usuarioLblActividades;
    private javax.swing.JLabel usuarioLblAdvertencia;
    private javax.swing.JLabel usuarioLblFecha;
    private javax.swing.JLabel usuarioLblMail;
    private javax.swing.JLabel usuarioLblNombre;
    private javax.swing.JLabel usuarioLblUsuarios;
    private javax.swing.JList<String> usuarioLstActividades;
    private javax.swing.JList<String> usuarioLstFechas;
    private javax.swing.JScrollPane usuarioScrollActividades;
    private javax.swing.JScrollPane usuarioScrollFechas;
    private javax.swing.JTextField usuarioTxtMail;
    private javax.swing.JTextField usuarioTxtNombre;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
