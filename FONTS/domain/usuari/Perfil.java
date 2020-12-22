package domain.usuari;

import domain.aventura.Aventura;
import domain.partida.CjtPartida;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * The type Perfil.
 */
public class Perfil {
    private String _idPerfil;
    private String _nom;
    private CjtPartida _cjtPartidas;
    private Aventura _av;
    private Set<String> _kakurosPuntuats;

    /**
     * Instantiates a new Perfil.
     */
    public Perfil() {
        _idPerfil = UUID.randomUUID().toString();
        _nom = "";
        _kakurosPuntuats = new HashSet<>();
    }

    /**
     * Instantiates a new Perfil.
     *
     * @param nom the nom
     */
    public Perfil(String nom) {
        this._idPerfil = UUID.randomUUID().toString();
        this._nom = nom;
        _kakurosPuntuats = new HashSet<>();
    }

    /**
     * Instantiates a new Perfil.
     *
     * @param id  the id
     * @param nom the nom
     */
    public Perfil(String id, String nom) {
        this._idPerfil = id;
        this._nom = nom;
        _kakurosPuntuats = new HashSet<>();
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setID(String id) {this._idPerfil = id;}

    /**
     * Sets nom.
     *
     * @param n the n
     */
    public void setNom(String n) {
        this._nom = n;
    }

    /**
     * Sets cjt.
     *
     * @param par the par
     */
    public void setCjt(CjtPartida par) { _cjtPartidas = par; }

    /**
     * Sets aventura.
     *
     * @param v the v
     */
    public void setAventura(Aventura v) { _av = v; }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() { return this._idPerfil;}

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return this._nom;
    }

    /**
     * Gets cjt.
     *
     * @return the cjt
     */
    public CjtPartida getCjt() { return _cjtPartidas; }

    /**
     * Gets aventura.
     *
     * @return the aventura
     */
    public Aventura getAventura() { return _av; }

    /**
     * Add kakuro.
     *
     * @param id the id
     */
    public void addKakuro(String id) {
        if(!_kakurosPuntuats.contains(id)){
            _kakurosPuntuats.add(id);
        }
    }

    /**
     * Conte kakuro boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean conteKakuro(String id) {
        return _kakurosPuntuats.contains(id);
    }


    /**
     * Sets puntuats.
     *
     * @param puntuats the puntuats
     */
    public void setPuntuats(Set<String> puntuats) {
        this._kakurosPuntuats = puntuats;
    }

    /**
     * Gets kakuros puntuats.
     *
     * @return the kakuros puntuats
     */
    public Set<String> getKakurosPuntuats() {
        return this._kakurosPuntuats;
    }

}
