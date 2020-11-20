package domain.usuari;

class UserException extends Exception {
    public String username;

    public UserException(String s) {
        super("Error en el usuario " + s + ", username es null");
        username = s;
    }

    public String toString() {
        return "Expeción de usuario: " + username;
    }
}
