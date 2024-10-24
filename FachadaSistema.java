public class FachadaSistema {
    private SubsistemaAutenticacion autenticacion;
    private SubsistemaInventario inventario;
    private SubsistemaNotificacion notificacion;

    public FachadaSistema() {
        autenticacion = new SubsistemaAutenticacion();
        inventario = new SubsistemaInventario();
        notificacion = new SubsistemaNotificacion();
    }

    public String procesarPedido(String usuario, String password, String producto, int cantidad) {
        if (autenticacion.verificarCredenciales(usuario, password)) {
            if (inventario.verificarDisponibilidad(producto, cantidad)) {
                inventario.reducirInventario(producto, cantidad);
                notificacion.enviarConfirmacion(usuario, producto, cantidad);
                return "Pedido procesado correctamente.";
            } else {
                return "Producto no disponible en la cantidad solicitada.";
            }
        } else {
            return "Credenciales incorrectas.";
        }
    }
}
