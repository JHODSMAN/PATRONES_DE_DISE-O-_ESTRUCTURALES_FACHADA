public class SubsistemaNotificacion {
    public void enviarConfirmacion(String usuario, String producto, int cantidad) {
        System.out.println("Confirmación enviada a " + usuario + " por la compra de " + cantidad + " unidades de " + producto);
    }
}
