package domain;

/**
 * The type domain.Usuari.
 */
public class Usuari {
    /**
     * The Nom.
     */
    String _nom;
    /**
     * The domain.Usuari.
     */
// Imatge _fotoPerfil;
    String _usuari;
    /**
     * The Contrasenya.
     */
    String _contrasenya;

    /**
     * Instantiates a new domain.Usuari.
     *
     * @param nom         the nom
     * @param usuari      the usuari
     * @param contrasenya the contrasenya
     */
    Usuari(String nom, String usuari, String contrasenya) {
        this._nom = nom;
        this._usuari = usuari;
        this._contrasenya = contrasenya;
    }
}
