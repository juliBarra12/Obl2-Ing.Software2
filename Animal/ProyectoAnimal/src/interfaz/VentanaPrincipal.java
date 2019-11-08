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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

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
        this.tipoAnimal = "";      
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            PerroLblFoto.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("images/perroPorDefecto.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        AnimalBtnEditar.setVisible(false);
        AnimalBtnGuardar.setVisible(false);
        CalPanHoraPersonalizada.setVisible(false);
        CalPanVeterinaria.setVisible(false);
        CalComboVeterinaria.setVisible(false);
        CalBtnVerRuta.setVisible(false);
        CalBtnGroupVeterinaria.clearSelection();
        CalBtnVeterinariaNo.setSelected(true);
        CalBtnGroupRepetir.clearSelection();
        CalBtnGroupRealizada.clearSelection();
        CalBtnRealizadaNo.setSelected(true);
        CalTxtTipoAlimento.setVisible(false);
        CalLblTipoAlimento.setVisible(false);
        CalPanVeterinaria.setVisible(false);
        CalBtnEditar.setVisible(false);
        CalLblHorarios.setVisible(false);
        rutaImagenAgregar = "";
        rutaImagenRuta = "";
        agregarPerroSeleccionado = true;
        agregarUsuarioSeleccionado = true;
        arrayDiasEnMes = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        CalPanRuta.setVisible(false);
        this.setSize(940, 582);
        this.cbTipoAnimal.setModel(new DefaultComboBoxModel(this.sistema.getListaTipoAnimales().toArray()));
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sistema.serializar(sistema);
                System.exit(0);
            }
        });
        
    }
    
 
    public void resetearPestanaPerros() {
        setearListaPerros();
        if (AnimalComboPerros.getItemCount() != 0) {
            Animal perroSeleccionado = sistema.buscarPerroPorNombre(AnimalComboPerros.getSelectedItem().toString());
            AnimalLblNombre.setText(perroSeleccionado.getNombre().toUpperCase());
            AnimalLblPeso.setText("Pesa:       " + perroSeleccionado.getPeso());
            AnimalLblAltura.setText("Mide:       " + perroSeleccionado.getAltura());
            AnimalLblComentarios.setText("" + perroSeleccionado.getComentarios());
            PerroLblFoto.setIcon(perroSeleccionado.getFoto());
            AnimalBtnEditar.setVisible(true);
        } else {
            AnimalLblNombre.setText("Nombre:");
            AnimalLblPeso.setText("Peso:");
            AnimalLblAltura.setText("Altura:");
            AnimalLblComentarios.setText("Comentarios:");
            PerroLblFoto.setIcon(crearIcono("/images/perroPorDefecto.png", 100));
            AnimalBtnEditar.setVisible(false);
        }
        ocultarAgregarPerro();
        rutaImagenAgregar = "";
    }

    public void inicializarPestanaUsuarios() {

        resetearListaUsuarios();
        if (UsuarioComboUsuarios.getItemCount() != 0) {
            Usuario usuarioSeleccionado = sistema.buscarUsuarioPorNombre(UsuarioComboUsuarios.getSelectedItem().toString());
            UsuarioLblNombre.setText("Nombre: " + usuarioSeleccionado.getNombre());
            UsuarioLblMail.setText("Mail: " + usuarioSeleccionado.getMail());
        } else {
            UsuarioLblNombre.setText("Nombre: ");
            UsuarioLblMail.setText("Mail: ");
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

        CalBtnGroupRepetir = new javax.swing.ButtonGroup();
        CalBtnGroupVeterinaria = new javax.swing.ButtonGroup();
        CalBtnGroupRealizada = new javax.swing.ButtonGroup();
        CalBtnGroupMetodoPago = new javax.swing.ButtonGroup();
        CalBtnGroupMoneda = new javax.swing.ButtonGroup();
        Panel = new javax.swing.JTabbedPane();
        panCalendario = new javax.swing.JPanel();
        CalDayChooser = new com.toedter.calendar.JDayChooser();
        CalMonthChooser = new com.toedter.calendar.JMonthChooser();
        CalYearChooser = new com.toedter.calendar.JYearChooser();
        CalScrollActividades = new javax.swing.JScrollPane();
        CalLstActividades = new javax.swing.JList<>();
        CalBtnAgregar = new javax.swing.JButton();
        CalLblTipo = new javax.swing.JLabel();
        CalLblUsuario = new javax.swing.JLabel();
        CalLblPerro = new javax.swing.JLabel();
        CalLblFecha = new javax.swing.JLabel();
        CalComboTipo = new javax.swing.JComboBox<>();
        CalComboUsuario = new javax.swing.JComboBox<>();
        CalComboAnimal = new javax.swing.JComboBox<>();
        CalComboHora = new javax.swing.JComboBox<>();
        CalLblHora = new javax.swing.JLabel();
        CalPanHoraPersonalizada = new javax.swing.JPanel();
        CalPanLblMinutos = new javax.swing.JLabel();
        CalPanSpinMinutos = new javax.swing.JSpinner();
        CalPanSpinHora = new javax.swing.JSpinner();
        CalPanLblHora = new javax.swing.JLabel();
        CalLblFechaResp = new javax.swing.JLabel();
        CalLblTituloFecha = new javax.swing.JLabel();
        CalLblTituloActividad = new javax.swing.JLabel();
        CalLblNombre = new javax.swing.JLabel();
        CalTxtNombreResp = new javax.swing.JTextField();
        CalPanVeterinaria = new javax.swing.JPanel();
        CalLblVeterinaria = new javax.swing.JLabel();
        CalBtnVeterinariaSi = new javax.swing.JRadioButton();
        CalBtnVeterinariaNo = new javax.swing.JRadioButton();
        CalComboVeterinaria = new javax.swing.JComboBox<>();
        CalLblMotivo = new javax.swing.JLabel();
        CalComboMotivo = new javax.swing.JComboBox<>();
        CalLblHorarios = new javax.swing.JLabel();
        CalTxtTipoAlimento = new javax.swing.JTextField();
        CalLblTipoAlimento = new javax.swing.JLabel();
        CalLblActividadesDelDia = new javax.swing.JLabel();
        CalScrollInfoAct = new javax.swing.JScrollPane();
        CalTxtAreaInfoAct = new javax.swing.JTextArea();
        CalLblInfoActividad = new javax.swing.JLabel();
        CalBtnEditar = new javax.swing.JButton();
        CalLblRealizada = new javax.swing.JLabel();
        CalBtnRealizadaSi = new javax.swing.JRadioButton();
        CalBtnRealizadaNo = new javax.swing.JRadioButton();
        CalPanRuta = new javax.swing.JPanel();
        CalSpinDistancia = new javax.swing.JSpinner();
        CalLblKilometros = new javax.swing.JLabel();
        CalBtnRuta = new javax.swing.JButton();
        CalLblRuta = new javax.swing.JLabel();
        CalLblDistancia = new javax.swing.JLabel();
        CalBtnAgregarDatos = new javax.swing.JButton();
        CalLblAdvertencia = new javax.swing.JLabel();
        CalBtnVerRuta = new javax.swing.JButton();
        panUsuarios = new javax.swing.JPanel();
        UsuarioLblUsuarios = new javax.swing.JLabel();
        UsuarioComboUsuarios = new javax.swing.JComboBox<>();
        UsuarioLblNombre = new javax.swing.JLabel();
        UsuarioLblMail = new javax.swing.JLabel();
        UsuarioTxtNombre = new javax.swing.JTextField();
        UsuarioTxtMail = new javax.swing.JTextField();
        UsuarioBtnAgregar = new javax.swing.JButton();
        UsuarioLblActividades = new javax.swing.JLabel();
        UsuarioScrollActividades = new javax.swing.JScrollPane();
        UsuarioLstActividades = new javax.swing.JList<>();
        UsuarioLblActividad = new javax.swing.JLabel();
        UsuarioLblFecha = new javax.swing.JLabel();
        UsuarioScrollFechas = new javax.swing.JScrollPane();
        UsuarioLstFechas = new javax.swing.JList<>();
        UsuarioLblAdvertencia = new javax.swing.JLabel();
        panAnimales = new javax.swing.JPanel();
        AnimalBtnAgregar = new javax.swing.JButton();
        AnimalLblAnimales = new javax.swing.JLabel();
        AnimalPanInformacion = new javax.swing.JPanel();
        AnimalPanFoto = new javax.swing.JPanel();
        PerroLblFoto = new javax.swing.JLabel();
        AnimalLblAltura = new javax.swing.JLabel();
        AnimalLblComentarios = new javax.swing.JLabel();
        AnimalLblNombre = new javax.swing.JLabel();
        AnimalLblPeso = new javax.swing.JLabel();
        AnimalTxtNombre = new javax.swing.JTextField();
        AnimaltxtComentarios = new javax.swing.JTextField();
        AnimalBtnExaminar = new javax.swing.JButton();
        AnimalLblFotoBoton = new javax.swing.JLabel();
        AnimalSpinAltura = new javax.swing.JSpinner();
        AnimalSpinPeso = new javax.swing.JSpinner();
        CalLblCentimetros = new javax.swing.JLabel();
        CalLblKilogramos = new javax.swing.JLabel();
        AnimalComboPerros = new javax.swing.JComboBox<>();
        AnimalBtnEditar = new javax.swing.JButton();
        AnimalBtnGuardar = new javax.swing.JButton();
        AnimalLblAdvertencia = new javax.swing.JLabel();
        cbTipoAnimal = new javax.swing.JComboBox<>();
        lblTipoAnimal = new javax.swing.JLabel();
        btnOtro = new javax.swing.JButton();
        panPadrinos = new javax.swing.JPanel();
        panelContenedor = new javax.swing.JPanel();
        PanelRegistro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Pets");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelMouseClicked(evt);
            }
        });

        CalDayChooser.setBorder(new javax.swing.border.MatteBorder(null));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, CalMonthChooser, org.jdesktop.beansbinding.ELProperty.create("${month}"), CalDayChooser, org.jdesktop.beansbinding.BeanProperty.create("month"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, CalYearChooser, org.jdesktop.beansbinding.ELProperty.create("${year}"), CalDayChooser, org.jdesktop.beansbinding.BeanProperty.create("year"));
        bindingGroup.addBinding(binding);

        CalDayChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CalDayChooserPropertyChange(evt);
            }
        });

        CalMonthChooser.setBorder(new javax.swing.border.MatteBorder(null));
        CalMonthChooser.setToolTipText("");

        CalYearChooser.setBorder(new javax.swing.border.MatteBorder(null));

        CalLstActividades.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                CalLstActividadesValueChanged(evt);
            }
        });
        CalScrollActividades.setViewportView(CalLstActividades);

        CalBtnAgregar.setText("Agregar");
        CalBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnAgregarActionPerformed(evt);
            }
        });

        CalLblTipo.setText("Tipo de actividad:");

        CalLblUsuario.setText("Usuario:");

        CalLblPerro.setText("Perro:");

        CalLblFecha.setText("Fecha:");

        CalComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paseo", "Alimentación", "Otra" }));
        CalComboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalComboTipoActionPerformed(evt);
            }
        });

        CalComboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahora", "Personalizado" }));
        CalComboHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalComboHoraActionPerformed(evt);
            }
        });

        CalLblHora.setText("Hora");

        CalPanLblMinutos.setText("Minutos");

        CalPanSpinMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 55, 5));

        CalPanSpinHora.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));

        CalPanLblHora.setText("Hora");

        javax.swing.GroupLayout CalPanHoraPersonalizadaLayout = new javax.swing.GroupLayout(CalPanHoraPersonalizada);
        CalPanHoraPersonalizada.setLayout(CalPanHoraPersonalizadaLayout);
        CalPanHoraPersonalizadaLayout.setHorizontalGroup(
            CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalPanHoraPersonalizadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CalPanLblHora)
                    .addComponent(CalPanLblMinutos))
                .addGap(18, 18, 18)
                .addGroup(CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CalPanSpinMinutos)
                    .addComponent(CalPanSpinHora))
                .addContainerGap())
        );
        CalPanHoraPersonalizadaLayout.setVerticalGroup(
            CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalPanHoraPersonalizadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalPanLblHora)
                    .addComponent(CalPanSpinHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CalPanHoraPersonalizadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CalPanLblMinutos)
                    .addComponent(CalPanSpinMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        CalLblTituloFecha.setText("Fecha");

        CalLblTituloActividad.setText("Actividad");

        CalLblNombre.setText("Nombre:");

        CalTxtNombreResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalTxtNombreRespActionPerformed(evt);
            }
        });

        CalLblVeterinaria.setText("Veterinaria:");

        CalBtnGroupVeterinaria.add(CalBtnVeterinariaSi);
        CalBtnVeterinariaSi.setText("Si");
        CalBtnVeterinariaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnVeterinariaSiActionPerformed(evt);
            }
        });

        CalBtnGroupVeterinaria.add(CalBtnVeterinariaNo);
        CalBtnVeterinariaNo.setText("No");
        CalBtnVeterinariaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnVeterinariaNoActionPerformed(evt);
            }
        });

        CalComboVeterinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalComboVeterinariaActionPerformed(evt);
            }
        });

        CalLblMotivo.setText("Motivo:");

        CalComboMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corte de Pelo", "Corte de Uñas", "Visita Médica", "Otro" }));

        javax.swing.GroupLayout CalPanVeterinariaLayout = new javax.swing.GroupLayout(CalPanVeterinaria);
        CalPanVeterinaria.setLayout(CalPanVeterinariaLayout);
        CalPanVeterinariaLayout.setHorizontalGroup(
            CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalPanVeterinariaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CalLblHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(CalPanVeterinariaLayout.createSequentialGroup()
                        .addGroup(CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalLblVeterinaria)
                            .addComponent(CalLblMotivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CalComboVeterinaria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CalComboMotivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(CalPanVeterinariaLayout.createSequentialGroup()
                                .addComponent(CalBtnVeterinariaSi)
                                .addGap(18, 18, 18)
                                .addComponent(CalBtnVeterinariaNo)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        CalPanVeterinariaLayout.setVerticalGroup(
            CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalPanVeterinariaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalLblVeterinaria)
                    .addComponent(CalBtnVeterinariaSi)
                    .addComponent(CalBtnVeterinariaNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalComboVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CalPanVeterinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalComboMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalLblMotivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalLblHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CalTxtTipoAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalTxtTipoAlimentoActionPerformed(evt);
            }
        });

        CalLblTipoAlimento.setText("Tipo Alimento:");

        CalLblActividadesDelDia.setText("Actividades del Día:");

        CalTxtAreaInfoAct.setColumns(20);
        CalTxtAreaInfoAct.setRows(5);
        CalScrollInfoAct.setViewportView(CalTxtAreaInfoAct);

        CalLblInfoActividad.setText("Información de la Actividad: ");

        CalBtnEditar.setText("Editar");
        CalBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnEditarActionPerformed(evt);
            }
        });

        CalLblRealizada.setText("Fue realizada:");

        CalBtnGroupRealizada.add(CalBtnRealizadaSi);
        CalBtnRealizadaSi.setText("Si");
        CalBtnRealizadaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnRealizadaSiActionPerformed(evt);
            }
        });

        CalBtnGroupRealizada.add(CalBtnRealizadaNo);
        CalBtnRealizadaNo.setText("No");
        CalBtnRealizadaNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnRealizadaNoActionPerformed(evt);
            }
        });

        CalSpinDistancia.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));

        CalLblKilometros.setText("Kilómetros");

        CalBtnRuta.setText("Agregar Ruta");
        CalBtnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnRutaActionPerformed(evt);
            }
        });

        CalLblRuta.setText("Ruta:");

        CalLblDistancia.setText("Distancia:");

        javax.swing.GroupLayout CalPanRutaLayout = new javax.swing.GroupLayout(CalPanRuta);
        CalPanRuta.setLayout(CalPanRutaLayout);
        CalPanRutaLayout.setHorizontalGroup(
            CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalPanRutaLayout.createSequentialGroup()
                .addGroup(CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CalLblRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CalLblDistancia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGroup(CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CalPanRutaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(CalSpinDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalLblKilometros))
                    .addGroup(CalPanRutaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(CalBtnRuta)))
                .addContainerGap())
        );
        CalPanRutaLayout.setVerticalGroup(
            CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CalPanRutaLayout.createSequentialGroup()
                .addGroup(CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalBtnRuta)
                    .addComponent(CalLblRuta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CalPanRutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalSpinDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalLblKilometros)
                    .addComponent(CalLblDistancia))
                .addGap(49, 49, 49))
        );

        CalBtnAgregarDatos.setText("Agregar Datos Precargados");
        CalBtnAgregarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnAgregarDatosActionPerformed(evt);
            }
        });

        CalBtnVerRuta.setText("Ver Ruta");
        CalBtnVerRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalBtnVerRutaActionPerformed(evt);
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
                            .addComponent(CalDayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addComponent(CalLblActividadesDelDia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCalendarioLayout.createSequentialGroup()
                                        .addComponent(CalScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CalLblInfoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CalScrollInfoAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addComponent(CalMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CalYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(CalLblTituloFecha)))
                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(CalBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CalLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CalBtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(CalBtnAgregarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addComponent(CalPanRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CalBtnVerRuta))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(CalTxtTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panCalendarioLayout.createSequentialGroup()
                                            .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(CalLblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(CalLblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(CalLblPerro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(CalLblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(CalLblHora))
                                                .addComponent(CalLblNombre))
                                            .addGap(18, 18, 18)
                                            .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(CalComboTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CalComboUsuario, javax.swing.GroupLayout.Alignment.LEADING, 0, 134, Short.MAX_VALUE)
                                                .addComponent(CalComboAnimal, javax.swing.GroupLayout.Alignment.LEADING, 0, 134, Short.MAX_VALUE)
                                                .addComponent(CalLblFechaResp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CalTxtNombreResp)
                                                .addComponent(CalComboHora, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CalLblRealizada)
                                            .addComponent(CalLblTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addComponent(CalBtnRealizadaSi)
                                        .addGap(18, 18, 18)
                                        .addComponent(CalBtnRealizadaNo)))
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CalPanVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panCalendarioLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CalPanHoraPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCalendarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalLblTituloActividad)
                        .addGap(40, 40, 40))))
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
                                    .addComponent(CalLblTipo)
                                    .addComponent(CalComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CalLblNombre)
                                    .addComponent(CalTxtNombreResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CalLblUsuario)
                                    .addComponent(CalComboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(CalPanVeterinaria, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CalLblPerro)
                            .addComponent(CalComboAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panCalendarioLayout.createSequentialGroup()
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(CalLblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CalLblFechaResp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CalLblHora)
                                    .addComponent(CalComboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CalLblRealizada)
                                    .addComponent(CalBtnRealizadaSi)
                                    .addComponent(CalBtnRealizadaNo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CalLblTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CalTxtTipoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(CalPanHoraPersonalizada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalPanRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CalBtnVerRuta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CalBtnEditar)
                        .addGap(12, 12, 12)
                        .addComponent(CalLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalBtnAgregar)
                        .addGap(32, 32, 32)
                        .addComponent(CalBtnAgregarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCalendarioLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CalLblTituloFecha)
                            .addComponent(CalLblTituloActividad))
                        .addGap(3, 3, 3)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalMonthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CalYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CalDayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CalLblActividadesDelDia)
                            .addComponent(CalLblInfoActividad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CalScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CalScrollInfoAct))))
                .addGap(2000, 2000, 2000))
        );

        Panel.addTab("Calendario", panCalendario);

        UsuarioLblUsuarios.setText("Usuario");

        UsuarioComboUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioComboUsuariosActionPerformed(evt);
            }
        });

        UsuarioLblNombre.setText("Nombre:");

        UsuarioLblMail.setText("Mail:");

        UsuarioTxtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioTxtMailActionPerformed(evt);
            }
        });

        UsuarioBtnAgregar.setText("Agregar Usuario");
        UsuarioBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioBtnAgregarActionPerformed(evt);
            }
        });

        UsuarioLblActividades.setText("Próximas Actividades");

        UsuarioScrollActividades.setViewportView(UsuarioLstActividades);

        UsuarioLblActividad.setText("Activiad:");

        UsuarioLblFecha.setText("Fecha");

        UsuarioScrollFechas.setViewportView(UsuarioLstFechas);

        javax.swing.GroupLayout panUsuariosLayout = new javax.swing.GroupLayout(panUsuarios);
        panUsuarios.setLayout(panUsuariosLayout);
        panUsuariosLayout.setHorizontalGroup(
            panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsuarioLblUsuarios)
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addComponent(UsuarioComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panUsuariosLayout.createSequentialGroup()
                                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(UsuarioLblNombre)
                                            .addComponent(UsuarioLblMail))
                                        .addGap(31, 31, 31)
                                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(UsuarioTxtMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(UsuarioTxtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(UsuarioLblAdvertencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(52, 52, 52))
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(UsuarioBtnAgregar)
                        .addGap(102, 102, 102)))
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsuarioLblActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsuarioLblActividad)
                            .addComponent(UsuarioScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsuarioLblFecha)
                            .addComponent(UsuarioScrollFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(446, 446, 446))
        );
        panUsuariosLayout.setVerticalGroup(
            panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUsuariosLayout.createSequentialGroup()
                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UsuarioLblNombre)
                            .addComponent(UsuarioTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UsuarioTxtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsuarioLblMail))
                        .addGap(18, 18, 18)
                        .addComponent(UsuarioLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsuarioBtnAgregar))
                    .addGroup(panUsuariosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addComponent(UsuarioLblActividades)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(UsuarioLblActividad)
                                    .addComponent(UsuarioLblFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(UsuarioScrollFechas)
                                    .addComponent(UsuarioScrollActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panUsuariosLayout.createSequentialGroup()
                                .addComponent(UsuarioLblUsuarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(UsuarioComboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(2254, Short.MAX_VALUE))
        );

        Panel.addTab("Usuarios", panUsuarios);

        AnimalBtnAgregar.setText("Ingresar Animal");
        AnimalBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimalBtnAgregarActionPerformed(evt);
            }
        });

        AnimalLblAnimales.setText("Animal");

        javax.swing.GroupLayout AnimalPanFotoLayout = new javax.swing.GroupLayout(AnimalPanFoto);
        AnimalPanFoto.setLayout(AnimalPanFotoLayout);
        AnimalPanFotoLayout.setHorizontalGroup(
            AnimalPanFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnimalPanFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PerroLblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AnimalPanFotoLayout.setVerticalGroup(
            AnimalPanFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnimalPanFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PerroLblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        AnimalLblAltura.setText("Altura");

        AnimalLblComentarios.setText("Comentarios");

        AnimalLblNombre.setText("Nombre");

        AnimalLblPeso.setText("Peso");

        AnimalTxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimalTxtNombreActionPerformed(evt);
            }
        });

        AnimalBtnExaminar.setText("Examinar");
        AnimalBtnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimalBtnExaminarActionPerformed(evt);
            }
        });

        AnimalLblFotoBoton.setText("Foto:");

        AnimalSpinAltura.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        AnimalSpinPeso.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.1d));

        CalLblCentimetros.setText("Centímetros");

        CalLblKilogramos.setText("Kilogramos");

        javax.swing.GroupLayout AnimalPanInformacionLayout = new javax.swing.GroupLayout(AnimalPanInformacion);
        AnimalPanInformacion.setLayout(AnimalPanInformacionLayout);
        AnimalPanInformacionLayout.setHorizontalGroup(
            AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AnimalPanInformacionLayout.createSequentialGroup()
                .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AnimalPanInformacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AnimaltxtComentarios))
                    .addGroup(AnimalPanInformacionLayout.createSequentialGroup()
                        .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AnimalPanFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AnimalPanInformacionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(AnimalLblComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(7, 7, 7)))
                        .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AnimalPanInformacionLayout.createSequentialGroup()
                                .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AnimalLblNombre)
                                    .addComponent(AnimalLblAltura))
                                .addGap(26, 26, 26)
                                .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AnimalTxtNombre)
                                    .addGroup(AnimalPanInformacionLayout.createSequentialGroup()
                                        .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(AnimalSpinPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(AnimalSpinAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CalLblCentimetros)
                                            .addComponent(CalLblKilogramos))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(AnimalPanInformacionLayout.createSequentialGroup()
                                .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AnimalLblPeso)
                                    .addComponent(AnimalLblFotoBoton))
                                .addGap(42, 42, 42)
                                .addComponent(AnimalBtnExaminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        AnimalPanInformacionLayout.setVerticalGroup(
            AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnimalPanInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AnimalPanInformacionLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AnimalLblNombre)
                            .addComponent(AnimalTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AnimalLblAltura)
                            .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(AnimalSpinAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CalLblCentimetros)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AnimalLblPeso)
                            .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(AnimalSpinPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CalLblKilogramos)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AnimalPanInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AnimalBtnExaminar)
                            .addComponent(AnimalLblFotoBoton)))
                    .addGroup(AnimalPanInformacionLayout.createSequentialGroup()
                        .addComponent(AnimalPanFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AnimalLblComentarios)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnimaltxtComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AnimalComboPerros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnimalComboPerrosMouseClicked(evt);
            }
        });
        AnimalComboPerros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimalComboPerrosActionPerformed(evt);
            }
        });

        AnimalBtnEditar.setText("Editar");
        AnimalBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimalBtnEditarActionPerformed(evt);
            }
        });

        AnimalBtnGuardar.setText("Guardar");
        AnimalBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnimalBtnGuardarActionPerformed(evt);
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
                            .addComponent(AnimalLblAnimales)
                            .addComponent(AnimalComboPerros, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAnimalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AnimalBtnEditar)
                        .addGap(22, 22, 22)))
                .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAnimalesLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AnimalBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AnimalBtnAgregar)))
                    .addGroup(panAnimalesLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panAnimalesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(AnimalLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panAnimalesLayout.createSequentialGroup()
                                .addComponent(AnimalPanInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panAnimalesLayout.createSequentialGroup()
                                        .addComponent(lblTipoAnimal)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbTipoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnOtro))))))
                .addContainerGap(457, Short.MAX_VALUE))
        );
        panAnimalesLayout.setVerticalGroup(
            panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAnimalesLayout.createSequentialGroup()
                .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panAnimalesLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(AnimalLblAnimales)
                        .addGap(18, 18, 18)
                        .addComponent(AnimalComboPerros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AnimalBtnEditar))
                    .addGroup(panAnimalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AnimalPanInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panAnimalesLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panAnimalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoAnimal)
                            .addComponent(cbTipoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOtro)))
                .addGap(15, 15, 15)
                .addComponent(AnimalLblAdvertencia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnimalBtnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnimalBtnAgregar)
                .addContainerGap(2243, Short.MAX_VALUE))
        );

        Panel.addTab("Animales", panAnimales);

        panelContenedor.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setText("Registro Padrino");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jTextField1.setText("Ingrese nombre...");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Valor de donacion:");

        jTextField2.setText("Ingrese monto...");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Frecuencia de la donacion:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Metodo de pago:");

        CalBtnGroupMetodoPago.add(jRadioButton1);
        jRadioButton1.setText("Tarjeta de credito");

        CalBtnGroupMetodoPago.add(jRadioButton2);
        jRadioButton2.setText("Transferencia bancaria");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("Moneda:");

        CalBtnGroupMoneda.add(jRadioButton3);
        jRadioButton3.setText("Dolares");

        CalBtnGroupMoneda.add(jRadioButton4);
        jRadioButton4.setText("Pesos Uruguayos");

        javax.swing.GroupLayout PanelRegistroLayout = new javax.swing.GroupLayout(PanelRegistro);
        PanelRegistro.setLayout(PanelRegistroLayout);
        PanelRegistroLayout.setHorizontalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                .addContainerGap(382, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(358, 358, 358))
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel2)
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(65, 65, 65))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(106, 106, 106)))))
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3))
                        .addGap(18, 18, 18)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelRegistroLayout.setVerticalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addContainerGap(1157, Short.MAX_VALUE))
        );

        panelContenedor.add(PanelRegistro, "card2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1005, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1576, Short.MAX_VALUE)
        );

        panelContenedor.add(jPanel1, "card3");

        javax.swing.GroupLayout panPadrinosLayout = new javax.swing.GroupLayout(panPadrinos);
        panPadrinos.setLayout(panPadrinosLayout);
        panPadrinosLayout.setHorizontalGroup(
            panPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPadrinosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );
        panPadrinosLayout.setVerticalGroup(
            panPadrinosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPadrinosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(949, Short.MAX_VALUE))
        );

        Panel.addTab("Padrinos", panPadrinos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnimalBtnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimalBtnExaminarActionPerformed
        JFileChooser elegirImagen = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        elegirImagen.setFileFilter(filter);
        int result = elegirImagen.showDialog(this, "Elija una imagen");
        if (result == JFileChooser.APPROVE_OPTION) {
            File imgSeleccionada = elegirImagen.getSelectedFile();
            rutaImagenAgregar = imgSeleccionada.getAbsolutePath();
            PerroLblFoto.setIcon(crearIcono(imgSeleccionada, 100));
        } else {
            AnimalLblAdvertencia.setText("No se ha podido ingresar la imágen de forma correcta");
        }
    }//GEN-LAST:event_AnimalBtnExaminarActionPerformed

    private void AnimalTxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimalTxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnimalTxtNombreActionPerformed

    private void AnimalBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimalBtnAgregarActionPerformed
        if (agregarPerroSeleccionado == false) {
            mostrarAgregarPerro();
        } else {
            if (AnimalTxtNombre.getText().equals("")) {
                AnimalLblAdvertencia.setText("Por favor ingrese un nombre");
            } else if (AnimalSpinAltura.getValue().equals(0)) {
                AnimalLblAdvertencia.setText("Por favor ingrese una altura válida");
            } else if (AnimalSpinPeso.getValue().equals(0.0)) {
                AnimalLblAdvertencia.setText("Por favor ingrese un peso válido");
            }else if (this.cbTipoAnimal.getSelectedItem() == null){
                this.AnimalLblAdvertencia.setText("Por favor, ingrese un tipo de animal");
                
            } else {
                Animal animal = new Animal(AnimalTxtNombre.getText(),this.tipoAnimal, Integer.parseInt(AnimalSpinAltura.getValue().toString()), Double.parseDouble(AnimalSpinPeso.getValue().toString()), AnimaltxtComentarios.getText());
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
                AnimalTxtNombre.setText("");
                AnimalSpinPeso.setValue((Object) 0.0);
                AnimalSpinAltura.setValue((Object) 0.0);
                AnimaltxtComentarios.setText("");
                AnimalLblAdvertencia.setText("");
                ocultarAgregarPerro();
                setearListaPerros();
            }
        }
    }//GEN-LAST:event_AnimalBtnAgregarActionPerformed

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
    private void UsuarioBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioBtnAgregarActionPerformed
        if (agregarUsuarioSeleccionado == false) {
            mostrarAgregarUsuario();
        } else {
            if (UsuarioTxtNombre.getText().equals("")) {
                UsuarioLblAdvertencia.setText("Por favor ingrese un nombre para el usuario");
            } else if (UsuarioTxtMail.getText().equals("")) {
                UsuarioLblAdvertencia.setText("Por favor ingrese un email para el usuario");
            } else if (!isValidEmailAddress(UsuarioTxtMail.getText())) {
                UsuarioLblAdvertencia.setText("Por favor ingrese un email correcto");
            } else {
                Usuario usuarioAgregar = new Usuario(UsuarioTxtNombre.getText(), UsuarioTxtMail.getText());
                sistema.AnadirUsuario(usuarioAgregar);
                UsuarioTxtNombre.setText("");
                UsuarioTxtMail.setText("");
                ocultarAgregarUsuario();
                resetearListaUsuarios();
                UsuarioLblAdvertencia.setText("");
            }
        }
    }//GEN-LAST:event_UsuarioBtnAgregarActionPerformed

    private void UsuarioComboUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioComboUsuariosActionPerformed
        ocultarAgregarUsuario();
        if (UsuarioComboUsuarios.getItemCount() > 0) {
            Usuario usuarioSeleccionado = sistema.buscarUsuarioPorNombre(UsuarioComboUsuarios.getSelectedItem().toString());
            UsuarioLblNombre.setText("Nombre: " + usuarioSeleccionado.getNombre());
            UsuarioLblMail.setText("Mail: " + usuarioSeleccionado.getMail());
            String[] arrayActividades = new String[5];
            String[] arrayFechas = new String[5];
            int cantidadActividades = usuarioSeleccionado.getActividades().size();
            for (int i = 0; i < cantidadActividades; i++) {
                arrayActividades[i] = usuarioSeleccionado.getActividades().get(i).getNombre();
                Fecha fechaActividad = usuarioSeleccionado.getActividades().get(i).getFecha();
                arrayFechas[i] = fechaActividad.getDia() + "/" + fechaActividad.getMes() + "/" + fechaActividad.getAno();
            }
            UsuarioLstActividades.setListData(arrayActividades);
            UsuarioLstFechas.setListData(arrayFechas);
        } else {
            UsuarioLblNombre.setText("Nombre: ");
            UsuarioLblMail.setText("Mail: ");
            String[] arrayVacio = new String[0];
            UsuarioLstActividades.setListData(arrayVacio);
            UsuarioLstFechas.setListData(arrayVacio);
        }
    }//GEN-LAST:event_UsuarioComboUsuariosActionPerformed

    private void setearListaDeVeterinarias() {
        if (CalComboVeterinaria.getItemCount() > 0) {
            CalComboVeterinaria.removeAllItems();
        }
        for (int i = 0; i < sistema.getVeterinarias().size(); i++) {
            CalComboVeterinaria.addItem(sistema.getVeterinarias().get(i).getNombre());
        }
    }

    private void mostrarAgregarPerro() {
        agregarPerroSeleccionado = true;
        AnimalLblNombre.setText("Nombre:");
        AnimalLblPeso.setText("Peso:");
        AnimalLblAltura.setText("Altura:");
        AnimalLblComentarios.setText("Comentarios:");
        PerroLblFoto.setIcon(crearIcono("/images/perroPorDefecto.png", 100));
        AnimalTxtNombre.setVisible(true);
        AnimalSpinPeso.setVisible(true);
        AnimalSpinAltura.setVisible(true);
        AnimaltxtComentarios.setVisible(true);
        AnimalLblFotoBoton.setVisible(true);
        AnimalBtnExaminar.setVisible(true);
    }

    private void ocultarAgregarPerro() {
        AnimalTxtNombre.setVisible(false);
        AnimalTxtNombre.setText("");
        AnimalSpinPeso.setVisible(false);
        AnimalSpinPeso.setValue((Object) 0.0);
        AnimalSpinAltura.setVisible(false);
        AnimalSpinAltura.setValue((Object) 0.0);
        AnimaltxtComentarios.setVisible(false);
        AnimaltxtComentarios.setText("");
        AnimalLblFotoBoton.setVisible(false);
        AnimalBtnExaminar.setVisible(false);
        agregarPerroSeleccionado = false;
        this.AnimalBtnAgregar.setVisible(false);
    }

    private void mostrarEditarPerro() {
        AnimalBtnGuardar.setVisible(true);
        AnimalBtnAgregar.setVisible(false);
        agregarPerroSeleccionado = true;
        AnimalLblNombre.setText("Nombre:");
        AnimalLblPeso.setText("Peso:");
        AnimalLblAltura.setText("Altura:");
        AnimalLblComentarios.setText("Comentarios:");
        Animal perroSeleccionado = sistema.buscarPerroPorNombre(AnimalComboPerros.getSelectedItem().toString());
        PerroLblFoto.setIcon(perroSeleccionado.getFoto());
        AnimalTxtNombre.setText(perroSeleccionado.getNombre());
        AnimalSpinPeso.setValue(perroSeleccionado.getPeso());
        AnimalSpinAltura.setValue(perroSeleccionado.getAltura());
        AnimaltxtComentarios.setText("" + perroSeleccionado.getComentarios());
        AnimalTxtNombre.setVisible(true);
        AnimalSpinPeso.setVisible(true);
        AnimalSpinAltura.setVisible(true);
        AnimaltxtComentarios.setVisible(true);
        AnimalLblFotoBoton.setVisible(true);
        AnimalBtnExaminar.setVisible(true);
    }

    private void setearListaPerros() {
        if (AnimalComboPerros.getItemCount() > 0) {
            AnimalComboPerros.removeAllItems();
        }
        if (CalComboAnimal.getItemCount() > 0) {
            CalComboAnimal.removeAllItems();
        }
        for (int i = 0; i < sistema.getPerros().size(); i++) {
            AnimalComboPerros.addItem(sistema.getPerros().get(i).getNombre());
            CalComboAnimal.addItem(sistema.getPerros().get(i).getNombre());
        }

    }

    private void mostrarAgregarUsuario() {
        agregarUsuarioSeleccionado = true;
        UsuarioLblNombre.setText("Nombre:");
        UsuarioLblMail.setText("Mail:");
        UsuarioTxtNombre.setVisible(true);
        UsuarioTxtMail.setVisible(true);
    }

    private void ocultarAgregarUsuario() {
        UsuarioTxtNombre.setVisible(false);
        UsuarioTxtMail.setVisible(false);
        agregarUsuarioSeleccionado = false;
    }

    private void resetearListaUsuarios() {
        if (UsuarioComboUsuarios.getItemCount() > 0) {
            UsuarioComboUsuarios.removeAllItems();
        }
        if (CalComboUsuario.getItemCount() > 0) {
            CalComboUsuario.removeAllItems();
        }
        for (int i = 0; i < sistema.getUsuarios().size(); i++) {
            UsuarioComboUsuarios.addItem(sistema.getUsuarios().get(i).getNombre());
            CalComboUsuario.addItem(sistema.getUsuarios().get(i).getNombre());
        }
    }

    private void UsuarioTxtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioTxtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioTxtMailActionPerformed

    private void PanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelMouseClicked

    private void AnimalComboPerrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnimalComboPerrosMouseClicked

    }//GEN-LAST:event_AnimalComboPerrosMouseClicked

    private void AnimalComboPerrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimalComboPerrosActionPerformed
        ocultarAgregarPerro();
        if (AnimalComboPerros.getItemCount() > 0) {
            Animal perroSeleccionado = sistema.buscarPerroPorNombre(AnimalComboPerros.getSelectedItem().toString());
            AnimalLblNombre.setText(perroSeleccionado.getNombre().toUpperCase());
            AnimalLblPeso.setText("Pesa:       " + perroSeleccionado.getPeso());
            AnimalLblAltura.setText("Mide:       " + perroSeleccionado.getAltura());
            AnimalLblComentarios.setText("" + perroSeleccionado.getComentarios());
            PerroLblFoto.setIcon(perroSeleccionado.getFoto());
            AnimalBtnGuardar.setVisible(false);
            AnimalBtnEditar.setVisible(true);
            AnimalBtnAgregar.setVisible(true);
        } else {
            AnimalLblNombre.setText("Nombre: ");
            AnimalLblPeso.setText("Peso ");
            AnimalLblAltura.setText("Altura: ");
            AnimalLblComentarios.setText("Comentarios: ");
            try {
                PerroLblFoto.setIcon(new ImageIcon(ImageIO.read(this.getClass().getResource("images/perroPorDefecto.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_AnimalComboPerrosActionPerformed

    private void AnimalBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimalBtnEditarActionPerformed
        mostrarEditarPerro();
    }//GEN-LAST:event_AnimalBtnEditarActionPerformed

    private void AnimalBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnimalBtnGuardarActionPerformed
        Animal perroSeleccionado = sistema.buscarPerroPorNombre(AnimalComboPerros.getSelectedItem().toString());
        String valor = AnimalSpinAltura.getValue() + "";
        double altura = Double.parseDouble(valor);
        perroSeleccionado.setAltura(altura);
        perroSeleccionado.setComentarios(AnimaltxtComentarios.getText());
        perroSeleccionado.setNombre(AnimalTxtNombre.getText());
        valor = AnimalSpinPeso.getValue() + "";
        double peso = Double.parseDouble(valor);
        perroSeleccionado.setPeso(peso);
        if (!rutaImagenAgregar.equals("")) {
            File imagen = new File(rutaImagenAgregar);
            perroSeleccionado.setFoto(crearIcono(imagen, 100));
            rutaImagenAgregar = "";
        }
        ocultarAgregarPerro();
        int pos = AnimalComboPerros.getSelectedIndex();
        setearListaPerros();
        AnimalComboPerros.setSelectedIndex(pos);
    }//GEN-LAST:event_AnimalBtnGuardarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtroActionPerformed
        String tipo = JOptionPane.showInputDialog(this, "Ingrese un tipo de animal", "Tipo De Animal", JOptionPane.QUESTION_MESSAGE);
        if(tipo != null){
            this.tipoAnimal = tipo;
            this.sistema.agregarTipo(tipo);
            this.cbTipoAnimal.setModel(new DefaultComboBoxModel(this.sistema.getListaTipoAnimales().toArray()));
            this.cbTipoAnimal.setSelectedIndex(this.sistema.getListaTipoAnimales().size()-1);
        }
    }//GEN-LAST:event_btnOtroActionPerformed
    
    private void cbTipoAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoAnimalActionPerformed

    private void CalBtnVerRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnVerRutaActionPerformed
        String nombreAct = CalLstActividades.getSelectedValue();
        Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
        if (paseo != null) {
            if (paseo.getRuta() != null) {
                try {
                    new VentanaFotoRuta(paseo).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                CalLblAdvertencia.setText("No hay ruta agregada a este paseo");
            }
        }
    }//GEN-LAST:event_CalBtnVerRutaActionPerformed

    private void CalBtnAgregarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnAgregarDatosActionPerformed
        try {
            Usuario persona = new Usuario("Alex", "alexkmass@gmail.com");
            sistema.AnadirUsuario(persona);
            Animal rasta = new Animal("Rasta","Perro", 50, 23, "Es un buen perro, le gusta comer");
            rasta.setFoto(new ImageIcon(ImageIO.read(this.getClass().getResource("images/perroPorDefecto.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            sistema.agregarAnimal(rasta);
            Usuario persona2 = new Usuario("Marcelo", "marcelo@gmail.com");
            sistema.AnadirUsuario(persona2);
            Animal ori = new Animal("Ori","Gato", 50, 23, "Es un buen gato");
            ori.setFoto(new ImageIcon(ImageIO.read(this.getClass().getResource("images/perroFoto.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
            sistema.agregarAnimal(ori);
            Fecha fecha = new Fecha(22, 11, 2018);
            sistema.AnadirFecha(fecha);
            LocalTime hora = LocalTime.now();
            Paseo act = new Paseo("Paseo Rasta", persona, rasta, 0.0, false, hora, fecha);
            act.setRuta(new ImageIcon(ImageIO.read(this.getClass().getResource("images/rutaPorDefecto.png")).getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH)));
            sistema.AnadirActividad(act);
            sistema.getPaseos().add(act);
            hora = LocalTime.now();
            Alimentacion act2 = new Alimentacion("Alimentación de Ori", persona, ori, "DogChow", false, hora, fecha);
            sistema.AnadirActividad(act2);
            sistema.getAlimentaciones().add(act2);
            ActividadCualquiera act3 = new ActividadCualquiera("Ir a una cita con Rasta", persona, rasta, true, hora, fecha);
            sistema.AnadirActividad(act3);
            sistema.getActsCualquieras().add(act3);
            Veterinaria vet1 = new Veterinaria("Pocitos", new ArrayList<>(), 8, 16);
            sistema.getVeterinarias().add(vet1);
            Veterinaria vet2 = new Veterinaria("Carrasco", new ArrayList<>(), 10, 15);
            sistema.getVeterinarias().add(vet2);
            Veterinaria vet3 = new Veterinaria("Cordon", new ArrayList<>(), 8, 23);
            sistema.getVeterinarias().add(vet3);
            VisitaVeterinaria visita = new VisitaVeterinaria("Visita a VetCordon", hora, persona, rasta, false, fecha, vet3, "Rasta tiene fiebre");
            sistema.AnadirActividad(visita);
            sistema.getVisitas().add(visita);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        resetearPestanaPerros();
        inicializarPestanaUsuarios();
        setearListaDeVeterinarias();
        CalBtnAgregarDatos.setVisible(false);
        int dia = CalDayChooser.getDay();
        int mes = CalMonthChooser.getMonth() + 1;
        int ano = CalYearChooser.getYear();
        ArrayList<Actividad> listaActividades = sistema.listaActividadesPorFecha(dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        CalLstActividades.setListData(arrActividades);

        CalLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_CalBtnAgregarDatosActionPerformed

    private void CalBtnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnRutaActionPerformed
        JFileChooser elegirImagen = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        elegirImagen.setFileFilter(filter);
        int result = elegirImagen.showDialog(this, "Elija una imagen");
        if (result == JFileChooser.APPROVE_OPTION) {
            File imgSeleccionada = elegirImagen.getSelectedFile();
            rutaImagenRuta = imgSeleccionada.getAbsolutePath();
        } else {
            CalLblAdvertencia.setText("No se pudo ingresar la ruta correctamente");
        }
    }//GEN-LAST:event_CalBtnRutaActionPerformed

    private void CalBtnRealizadaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnRealizadaNoActionPerformed
        CalPanRuta.setVisible(false);
    }//GEN-LAST:event_CalBtnRealizadaNoActionPerformed

    private void CalBtnRealizadaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnRealizadaSiActionPerformed
        if (CalComboTipo.getSelectedIndex() == 0) {
            CalPanRuta.setVisible(true);
        } else {
            CalPanRuta.setVisible(false);
        }
    }//GEN-LAST:event_CalBtnRealizadaSiActionPerformed

    private void CalBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnEditarActionPerformed
        CalLstActividades.setEnabled(false);
        String nombreAct = CalLstActividades.getSelectedValue();
        Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
        CalBtnVeterinariaNo.setSelected(true);
        CalBtnVeterinariaNoActionPerformed(evt);
        CalBtnGroupRealizada.clearSelection();
        CalBtnRealizadaNo.setSelected(true);
        if (paseo != null) {
            if (paseo.getFueRealizado()) {
                CalBtnRealizadaSi.setSelected(true);
            }
            CalPanRuta.setVisible(true);
            CalComboTipo.setSelectedIndex(0);
            if (paseo.getFueRealizado()) {
                CalPanRuta.setVisible(true);
            }
            if (paseo.getRuta() == null) {
                CalBtnVerRuta.setVisible(false);
            }
            CalTxtNombreResp.setText(nombreAct);
            CalComboUsuario.setSelectedItem(paseo.getUsuario().getNombre());
            CalComboAnimal.setSelectedItem(paseo.getMascota().getNombre());
            CalLblFechaResp.setText(paseo.getFecha().getDia() + "/" + paseo.getFecha().getMes() + "/" + paseo.getFecha().getAno());
            CalComboHora.setSelectedIndex(1);
            int hora = paseo.getHora().getHour();
            String horaString = "" + hora;
            if (hora < 10) {
                horaString = "0" + horaString;
            }
            CalPanSpinHora.setValue((Object) horaString);
            CalPanSpinMinutos.setValue(paseo.getHora().getMinute());
            sistema.EliminarActividad(paseo);
            sistema.getPaseos().remove(paseo);
        } else {
            Alimentacion alim = sistema.buscarAlimentacionPorNombre(nombreAct);
            if (alim != null) {
                if (alim.getFueRealizado()) {
                    CalBtnRealizadaSi.setSelected(true);
                }
                CalComboTipo.setSelectedIndex(1);
                CalTxtNombreResp.setText(nombreAct);
                CalComboUsuario.setSelectedItem(alim.getUsuario().getNombre());
                CalComboAnimal.setSelectedItem(alim.getMascota().getNombre());
                CalLblFechaResp.setText(alim.getFecha().getDia() + "/" + alim.getFecha().getMes() + "/" + alim.getFecha().getAno());
                CalComboHora.setSelectedIndex(1);
                int hora = alim.getHora().getHour();
                String horaString = "" + hora;
                if (hora < 10) {
                    horaString = "0" + horaString;
                }
                CalPanSpinHora.setValue((Object) horaString);
                CalPanSpinMinutos.setValue(alim.getHora().getMinute());
                CalTxtTipoAlimento.setText(alim.getTipoAlimento());
                CalTxtTipoAlimento.setVisible(true);
                sistema.EliminarActividad(alim);
                sistema.getAlimentaciones().remove(alim);
            } else {
                VisitaVeterinaria visita = sistema.buscarVisitaPorNombre(nombreAct);
                if (visita != null) {
                    if (visita.getFueRealizado()) {
                        CalBtnRealizadaSi.setSelected(true);
                    }
                    CalComboTipo.setSelectedIndex(2);
                    CalTxtNombreResp.setText(nombreAct);
                    CalComboUsuario.setSelectedItem(visita.getUsuario().getNombre());
                    CalComboAnimal.setSelectedItem(visita.getMascota().getNombre());
                    CalLblFechaResp.setText(visita.getFecha().getDia() + "/" + visita.getFecha().getMes() + "/" + visita.getFecha().getAno());
                    CalComboHora.setSelectedIndex(1);
                    int hora = visita.getHora().getHour();
                    String horaString = "" + hora;
                    if (hora < 10) {
                        horaString = "0" + horaString;
                    }
                    CalPanSpinHora.setValue((Object) horaString);
                    CalPanSpinMinutos.setValue(visita.getHora().getMinute());
                    CalBtnVeterinariaSi.setSelected(true);
                    CalComboVeterinaria.setSelectedItem(visita.getVeterinaria().getNombre());
                    CalComboMotivo.setSelectedItem(visita.getMotivo());
                    CalPanVeterinaria.setVisible(true);
                    CalLblHorarios.setVisible(true);
                    visita.getVeterinaria().getActividadesAgendadas().remove(visita);
                    sistema.EliminarActividad(visita);
                    sistema.getVisitas().remove(visita);
                } else {
                    ActividadCualquiera actividad = sistema.buscarActCualquieraPorNombre(nombreAct);
                    if (actividad.getFueRealizado()) {
                        CalBtnRealizadaSi.setSelected(true);
                    }
                    CalComboTipo.setSelectedIndex(2);
                    CalTxtNombreResp.setText(nombreAct);
                    CalComboUsuario.setSelectedItem(actividad.getUsuario().getNombre());
                    CalComboAnimal.setSelectedItem(actividad.getMascota().getNombre());
                    CalLblFechaResp.setText(actividad.getFecha().getDia() + "/" + actividad.getFecha().getMes() + "/" + actividad.getFecha().getAno());
                    CalComboHora.setSelectedIndex(1);
                    int hora = actividad.getHora().getHour();
                    String horaString = "" + hora;
                    if (hora < 10) {
                        horaString = "0" + horaString;
                    }
                    CalPanSpinHora.setValue((Object) horaString);
                    CalPanSpinMinutos.setValue(actividad.getHora().getMinute());
                    CalTxtTipoAlimento.setVisible(true);
                    sistema.EliminarActividad(actividad);
                    sistema.getActsCualquieras().remove(actividad);
                }
            }
        }
        CalLblAdvertencia.setText("Edite la actividad y agreguela");
        CalBtnEditar.setVisible(false);
    }//GEN-LAST:event_CalBtnEditarActionPerformed

    private void CalTxtTipoAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalTxtTipoAlimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CalTxtTipoAlimentoActionPerformed

    private void CalComboVeterinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalComboVeterinariaActionPerformed
        Veterinaria vet = sistema.buscarVetPorNombre((String) CalComboVeterinaria.getSelectedItem());
        CalLblHorarios.setVisible(true);
        CalLblHorarios.setText("Horarios: " + vet.getHoraInicial() + " - " + vet.getHoraFinal());
    }//GEN-LAST:event_CalComboVeterinariaActionPerformed

    private void CalBtnVeterinariaNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnVeterinariaNoActionPerformed
        CalComboVeterinaria.setVisible(false);
        CalComboMotivo.setVisible(false);
        CalLblMotivo.setVisible(false);
        CalLblHorarios.setVisible(false);
    }//GEN-LAST:event_CalBtnVeterinariaNoActionPerformed

    private void CalBtnVeterinariaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnVeterinariaSiActionPerformed
        CalComboVeterinaria.setVisible(true);
        CalComboMotivo.setVisible(true);
        CalLblMotivo.setVisible(true);
        CalLblHorarios.setVisible(true);
    }//GEN-LAST:event_CalBtnVeterinariaSiActionPerformed

    private void CalTxtNombreRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalTxtNombreRespActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CalTxtNombreRespActionPerformed

    private void CalComboHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalComboHoraActionPerformed
        if (CalComboHora.getSelectedIndex() == 0) {
            CalPanHoraPersonalizada.setVisible(false);
        } else {
            CalPanHoraPersonalizada.setVisible(true);
        }
    }//GEN-LAST:event_CalComboHoraActionPerformed

    private void CalComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalComboTipoActionPerformed
        if (CalComboTipo.getSelectedIndex() == 2) {
            if (CalBtnVeterinariaSi.isSelected()) {
                cambiarVisibilidadVeterinaria(true, true);
            } else {
                cambiarVisibilidadVeterinaria(true, false);
            }
        } else {
            cambiarVisibilidadVeterinaria(false, false);
        }
        if (CalComboTipo.getSelectedIndex() == 1) {
            CalLblTipoAlimento.setVisible(true);
            CalTxtTipoAlimento.setVisible(true);
        } else {
            CalLblTipoAlimento.setVisible(false);
            CalTxtTipoAlimento.setVisible(false);
            CalTxtTipoAlimento.setText("");
        }
        if (CalComboTipo.getSelectedIndex() == 0 && CalBtnRealizadaSi.isSelected()) {
            CalPanRuta.setVisible(true);
        } else {
            CalPanRuta.setVisible(false);
        }
    }//GEN-LAST:event_CalComboTipoActionPerformed

    private void CalBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalBtnAgregarActionPerformed
        String nombreAct = CalTxtNombreResp.getText();
        boolean fueRealizada = true;
        if (CalBtnRealizadaNo.isSelected()) {
            fueRealizada = false;
        }
        if (nombreAct.equals("")) {
            CalLblAdvertencia.setText("No se ingresó un nombre, ingrese el nombre de la actividad.");
        } else if (CalComboUsuario.getItemCount() == 0) {
            CalLblAdvertencia.setText("Por favor, ingrese un usuario para agregar una actividad.");
        } else if (CalComboAnimal.getItemCount() == 0) {
            CalLblAdvertencia.setText("Por favor, ingrese un perro para agregar una actividad.");
        } else {
            Usuario usuario = sistema.buscarUsuarioPorNombre((String) CalComboUsuario.getSelectedItem());
            Animal perro = sistema.buscarPerroPorNombre((String) CalComboAnimal.getSelectedItem());
            LocalTime time;
            if (((String) CalComboHora.getSelectedItem()).equals("Ahora")) {
                time = LocalTime.now();
            } else {
                String hora = CalPanSpinHora.getValue() + "";
                String min = CalPanSpinMinutos.getValue() + "";
                time = LocalTime.of(Integer.parseInt(hora), Integer.parseInt(min));
            }
            if (CalBtnVeterinariaSi.isSelected()) {
                Veterinaria vet = sistema.buscarVetPorNombre((String) CalComboVeterinaria.getSelectedItem());
                String motivo = (String) CalComboMotivo.getSelectedItem();
                VisitaVeterinaria visita = new VisitaVeterinaria(nombreAct, time, usuario, perro, fueRealizada, fechaSeleccionada, vet, motivo);
                if (vet.AgendarActividad(visita)) {
                    sistema.AnadirActividad(visita);
                    sistema.getVisitas().add(visita);
                    if (CalComboHora.getSelectedIndex() != 0) {
                        timerNuevo(visita);
                    }
                    CalLblAdvertencia.setText("Se agrego la visita a la veterinaria con éxito");
                    CalLstActividades.setEnabled(true);
                    CalBtnEditar.setVisible(false);
                    CalTxtNombreResp.setText("");
                    CalPanVeterinaria.setVisible(false);
                    CalLblHorarios.setVisible(false);
                } else {
                    CalLblAdvertencia.setText("La veterinaria no tiene horarios disponibles en ese horario, por favor ingrse una "
                        + "hora distinta entre las " + vet.getHoraInicial() + " y las " + vet.getHoraFinal());
                }
            } else {
                String tipoAct = (String) CalComboTipo.getSelectedItem();
                if (tipoAct.equals("Paseo")) {
                    Paseo paseo = new Paseo(nombreAct, usuario, perro, 0, fueRealizada, time, fechaSeleccionada);
                    double distanciaPaseo = Double.parseDouble(CalSpinDistancia.getValue().toString());
                    if (distanciaPaseo != 0.0) {
                        paseo.setDistancia(distanciaPaseo);
                    }
                    sistema.AnadirActividad(paseo);
                    sistema.getPaseos().add(paseo);
                    if (CalComboHora.getSelectedIndex() != 0) {
                        timerNuevo(paseo);
                    }
                    if (!rutaImagenRuta.equals("")) {
                        File imagen = new File(rutaImagenRuta);
                        paseo.setRuta(crearIcono(imagen, 500));
                        rutaImagenRuta = "";
                    }
                    CalLblAdvertencia.setText("Se añadió el paseo correctamente al calendario");
                    CalLstActividades.setEnabled(true);
                    CalTxtNombreResp.setText("");
                    CalBtnEditar.setVisible(false);
                    CalPanRuta.setVisible(false);
                } else {
                    if (tipoAct.equals("Alimentación")) {
                        String tipoAlimento = CalTxtTipoAlimento.getText();
                        if (tipoAlimento.equals("")) {
                            CalLblAdvertencia.setText("No se ingresó el tipo del alimento, ingrse el tipo del alimento");
                        } else {
                            Alimentacion alim = new Alimentacion(nombreAct, usuario, perro, tipoAlimento, fueRealizada, time, fechaSeleccionada);
                            sistema.AnadirActividad(alim);
                            sistema.getAlimentaciones().add(alim);
                            if (CalComboHora.getSelectedIndex() != 0) {
                                timerNuevo(alim);
                            }
                            CalLblAdvertencia.setText("Se añadió la alimentación correctamente al calendario");
                            CalTxtNombreResp.setText("");
                            CalTxtTipoAlimento.setText("");
                            CalBtnEditar.setVisible(false);
                            CalLstActividades.setEnabled(true);
                        }
                    } else {
                        ActividadCualquiera actividad = new ActividadCualquiera(nombreAct, usuario, perro, fueRealizada, time, fechaSeleccionada);
                        sistema.AnadirActividad(actividad);
                        sistema.getActsCualquieras().add(actividad);
                        if (CalComboHora.getSelectedIndex() != 0) {
                            timerNuevo(actividad);
                        }
                        CalLblAdvertencia.setText("Se añadió la actividad correctamente al calendario");
                        CalTxtNombreResp.setText("");
                        CalBtnEditar.setVisible(false);
                        CalLstActividades.setEnabled(true);
                    }
                }
            }
        }
        CalPanRuta.setVisible(false);
        int dia = CalDayChooser.getDay();
        int mes = CalMonthChooser.getMonth() + 1;
        int ano = CalYearChooser.getYear();
        ArrayList<Actividad> listaActividades = sistema.listaActividadesPorFecha(dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        CalLstActividades.setListData(arrActividades);

        CalLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_CalBtnAgregarActionPerformed

    private void CalLstActividadesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_CalLstActividadesValueChanged
        String nombreAct = CalLstActividades.getSelectedValue();
        String cero = "";
        CalBtnVerRuta.setVisible(false);
        if (nombreAct != null) {
            Paseo paseo = sistema.buscarPaseoPorNombre(nombreAct);
            if (paseo != null) {
                CalBtnVerRuta.setVisible(true);
                if (paseo.getHora().getMinute() < 10) {
                    cero = "0";
                }
                String fueRealizada = "No";
                if (paseo.getFueRealizado()) {
                    fueRealizada = "Si";
                }
                if (paseo.getDistancia() == 0.0) {
                    CalTxtAreaInfoAct.setText("Nombre: " + paseo.getNombre() + "\n"
                        + "Usuario responsable: " + paseo.getUsuario().getNombre() + "\n"
                        + "Perro: " + paseo.getMascota().getNombre() + "\n"
                        + "Realizada: " + fueRealizada + "\n"
                        + "Hora: " + paseo.getHora().getHour() + ":" + cero + paseo.getHora().getMinute());
                } else {
                    CalTxtAreaInfoAct.setText("Nombre: " + paseo.getNombre() + "\n"
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

                    CalTxtAreaInfoAct.setText("Nombre: " + alim.getNombre() + "\n"
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
                        CalTxtAreaInfoAct.setText("Nombre: " + visita.getNombre() + "\n"
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

                        CalTxtAreaInfoAct.setText("Nombre: " + act.getNombre() + "\n"
                            + "Usuario responsable: " + act.getUsuario().getNombre() + "\n"
                            + "Perro: " + act.getMascota().getNombre() + "\n"
                            + "Realizada: " + fueRealizada + "\n"
                            + "Hora: " + act.getHora().getHour() + ":" + cero + act.getHora().getMinute());
                    }
                }
            }
            CalBtnEditar.setVisible(true);
        } else {
            CalTxtAreaInfoAct.setText("Seleccione un paseo para" + "\n"
                + "poder ver su información");
        }
    }//GEN-LAST:event_CalLstActividadesValueChanged

    private void CalDayChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalDayChooserPropertyChange
        int dia = CalDayChooser.getDay();
        int mes = CalMonthChooser.getMonth() + 1;
        int ano = CalYearChooser.getYear();
        ArrayList<Actividad> listaActividades = sistema.listaActividadesPorFecha(dia, mes, ano);
        String[] arrActividades = new String[listaActividades.size()];
        for (int i = 0; i < listaActividades.size(); i++) {
            Actividad act = listaActividades.get(i);
            arrActividades[i] = act.getNombre();
        }
        CalLstActividades.setListData(arrActividades);

        CalLblFechaResp.setText(dia + "/" + mes + "/" + ano);
        fechaSeleccionada = new Fecha(dia, mes, ano);
    }//GEN-LAST:event_CalDayChooserPropertyChange
     
     
    private void cambiarVisibilidadVeterinaria(boolean opcionCombo, boolean usaVeterinaria) {
        CalPanVeterinaria.setVisible(opcionCombo);
        CalBtnVeterinariaSi.setSelected(usaVeterinaria);
        CalBtnVeterinariaNo.setSelected(!usaVeterinaria);
        CalComboVeterinaria.setVisible(usaVeterinaria);
        CalComboMotivo.setVisible(usaVeterinaria);
        CalLblMotivo.setVisible(usaVeterinaria);
        CalLblHorarios.setVisible(opcionCombo);
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
    private javax.swing.JButton AnimalBtnAgregar;
    private javax.swing.JButton AnimalBtnEditar;
    private javax.swing.JButton AnimalBtnExaminar;
    private javax.swing.JButton AnimalBtnGuardar;
    private javax.swing.JComboBox<String> AnimalComboPerros;
    private javax.swing.JLabel AnimalLblAdvertencia;
    private javax.swing.JLabel AnimalLblAltura;
    private javax.swing.JLabel AnimalLblAnimales;
    private javax.swing.JLabel AnimalLblComentarios;
    private javax.swing.JLabel AnimalLblFotoBoton;
    private javax.swing.JLabel AnimalLblNombre;
    private javax.swing.JLabel AnimalLblPeso;
    private javax.swing.JPanel AnimalPanFoto;
    private javax.swing.JPanel AnimalPanInformacion;
    private javax.swing.JSpinner AnimalSpinAltura;
    private javax.swing.JSpinner AnimalSpinPeso;
    private javax.swing.JTextField AnimalTxtNombre;
    private javax.swing.JTextField AnimaltxtComentarios;
    private javax.swing.JButton CalBtnAgregar;
    private javax.swing.JButton CalBtnAgregarDatos;
    private javax.swing.JButton CalBtnEditar;
    private javax.swing.ButtonGroup CalBtnGroupMetodoPago;
    private javax.swing.ButtonGroup CalBtnGroupMoneda;
    private javax.swing.ButtonGroup CalBtnGroupRealizada;
    private javax.swing.ButtonGroup CalBtnGroupRepetir;
    private javax.swing.ButtonGroup CalBtnGroupVeterinaria;
    private javax.swing.JRadioButton CalBtnRealizadaNo;
    private javax.swing.JRadioButton CalBtnRealizadaSi;
    private javax.swing.JButton CalBtnRuta;
    private javax.swing.JButton CalBtnVerRuta;
    private javax.swing.JRadioButton CalBtnVeterinariaNo;
    private javax.swing.JRadioButton CalBtnVeterinariaSi;
    private javax.swing.JComboBox<String> CalComboAnimal;
    private javax.swing.JComboBox<String> CalComboHora;
    private javax.swing.JComboBox<String> CalComboMotivo;
    private javax.swing.JComboBox<String> CalComboTipo;
    private javax.swing.JComboBox<String> CalComboUsuario;
    private javax.swing.JComboBox<String> CalComboVeterinaria;
    private com.toedter.calendar.JDayChooser CalDayChooser;
    private javax.swing.JLabel CalLblActividadesDelDia;
    private javax.swing.JLabel CalLblAdvertencia;
    private javax.swing.JLabel CalLblCentimetros;
    private javax.swing.JLabel CalLblDistancia;
    private javax.swing.JLabel CalLblFecha;
    private javax.swing.JLabel CalLblFechaResp;
    private javax.swing.JLabel CalLblHora;
    private javax.swing.JLabel CalLblHorarios;
    private javax.swing.JLabel CalLblInfoActividad;
    private javax.swing.JLabel CalLblKilogramos;
    private javax.swing.JLabel CalLblKilometros;
    private javax.swing.JLabel CalLblMotivo;
    private javax.swing.JLabel CalLblNombre;
    private javax.swing.JLabel CalLblPerro;
    private javax.swing.JLabel CalLblRealizada;
    private javax.swing.JLabel CalLblRuta;
    private javax.swing.JLabel CalLblTipo;
    private javax.swing.JLabel CalLblTipoAlimento;
    private javax.swing.JLabel CalLblTituloActividad;
    private javax.swing.JLabel CalLblTituloFecha;
    private javax.swing.JLabel CalLblUsuario;
    private javax.swing.JLabel CalLblVeterinaria;
    private javax.swing.JList<String> CalLstActividades;
    private com.toedter.calendar.JMonthChooser CalMonthChooser;
    private javax.swing.JPanel CalPanHoraPersonalizada;
    private javax.swing.JLabel CalPanLblHora;
    private javax.swing.JLabel CalPanLblMinutos;
    private javax.swing.JPanel CalPanRuta;
    private javax.swing.JSpinner CalPanSpinHora;
    private javax.swing.JSpinner CalPanSpinMinutos;
    private javax.swing.JPanel CalPanVeterinaria;
    private javax.swing.JScrollPane CalScrollActividades;
    private javax.swing.JScrollPane CalScrollInfoAct;
    private javax.swing.JSpinner CalSpinDistancia;
    private javax.swing.JTextArea CalTxtAreaInfoAct;
    private javax.swing.JTextField CalTxtNombreResp;
    private javax.swing.JTextField CalTxtTipoAlimento;
    private com.toedter.calendar.JYearChooser CalYearChooser;
    private javax.swing.JTabbedPane Panel;
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JLabel PerroLblFoto;
    private javax.swing.JButton UsuarioBtnAgregar;
    private javax.swing.JComboBox<String> UsuarioComboUsuarios;
    private javax.swing.JLabel UsuarioLblActividad;
    private javax.swing.JLabel UsuarioLblActividades;
    private javax.swing.JLabel UsuarioLblAdvertencia;
    private javax.swing.JLabel UsuarioLblFecha;
    private javax.swing.JLabel UsuarioLblMail;
    private javax.swing.JLabel UsuarioLblNombre;
    private javax.swing.JLabel UsuarioLblUsuarios;
    private javax.swing.JList<String> UsuarioLstActividades;
    private javax.swing.JList<String> UsuarioLstFechas;
    private javax.swing.JScrollPane UsuarioScrollActividades;
    private javax.swing.JScrollPane UsuarioScrollFechas;
    private javax.swing.JTextField UsuarioTxtMail;
    private javax.swing.JTextField UsuarioTxtNombre;
    private javax.swing.JButton btnOtro;
    private javax.swing.JComboBox<String> cbTipoAnimal;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblTipoAnimal;
    private javax.swing.JPanel panAnimales;
    private javax.swing.JPanel panCalendario;
    private javax.swing.JPanel panPadrinos;
    private javax.swing.JPanel panUsuarios;
    private javax.swing.JPanel panelContenedor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
