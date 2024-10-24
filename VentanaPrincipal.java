import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JTextField txtProducto;
    private JTextField txtCantidad;
    private JTextArea txtResultado;
    private FachadaSistema fachada;

    public VentanaPrincipal() {
        fachada = new FachadaSistema();
        setTitle("Sistema de Pedidos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(20, 20, 100, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 20, 150, 25);
        add(txtUsuario);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(20, 60, 100, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 60, 150, 25);
        add(txtPassword);

        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(20, 100, 100, 25);
        add(lblProducto);

        txtProducto = new JTextField();
        txtProducto.setBounds(120, 100, 150, 25);
        add(txtProducto);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(20, 140, 100, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 140, 150, 25);
        add(txtCantidad);

        JButton btnProcesar = new JButton("Procesar Pedido");
        btnProcesar.setBounds(120, 180, 150, 30);
        add(btnProcesar);

        txtResultado = new JTextArea();
        txtResultado.setBounds(20, 220, 350, 50);
        txtResultado.setEditable(false);
        add(txtResultado);

        btnProcesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String password = new String(txtPassword.getPassword());
                String producto = txtProducto.getText();
                int cantidad = Integer.parseInt(txtCantidad.getText());

                String resultado = fachada.procesarPedido(usuario, password, producto, cantidad);
                txtResultado.setText(resultado);
            }
        });
    }
}
