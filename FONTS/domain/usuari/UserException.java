package domain.usuari;

/**
 * The type User excepcion.
 */
class UserException extends Exception {
    /**
     * The Username.
     */
    public String username;

    /**
     * Instantiates a new User excepcion.
     *
     * @param s the s
     */
    public UserException(String s) {
        super("Error en el usuario " + s + ", username es null");
        username = s;
    }

    public String toString() {
        return "Expeción de usuario: " + username;
    }
}
