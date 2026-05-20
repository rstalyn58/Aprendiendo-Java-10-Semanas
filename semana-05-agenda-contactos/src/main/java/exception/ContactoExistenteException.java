package excepcion;

public class ContactoExistenteException extends Exception {

    public ContactoExistenteException() {
        super();
    }

    public ContactoExistenteException(String mensaje) {
        super(mensaje);
    }
}