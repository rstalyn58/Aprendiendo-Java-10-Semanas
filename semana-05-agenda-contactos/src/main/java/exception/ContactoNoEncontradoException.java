package excepcion;

public class ContactoNoEncontradoException extends Exception {

    public ContactoNoEncontradoException() {
        super();
    }

    public ContactoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}