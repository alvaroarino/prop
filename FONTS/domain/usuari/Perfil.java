package domain.usuari;

import domain.aventura.Aventura;
import domain.partida.CjtPartida;

import java.util.UUID;

public class Perfil {
    private String _idPerfil;
    private String _nom;
    private CjtPartida _cjtPartidas;
    private Aventura _av;

    public Perfil() {
        _idPerfil = UUID.randomUUID().toString();
        _nom = "";
    }

    public Perfil(String nom) {
        this._idPerfil = UUID.randomUUID().toString();
        this._nom = nom;
        this._cjtPartidas = new CjtPartida();
        this._av = new Aventura();
    }

    public Perfil(String id, String nom) {
        this._idPerfil = id;
        this._nom = nom;
        this._cjtPartidas = new CjtPartida();
        this._av = new Aventura();
    }

    public void setID(String id) {this._idPerfil = id;}
    public void setNom(String n) {
        this._nom = n;
    }
    public void setCjt(CjtPartida par) { _cjtPartidas = par; }
    public void setAventura(Aventura v) { _av = v; }

    public String getId() { return this._idPerfil;}
    public String getNom() {
        return this._nom;
    }
    public CjtPartida getCjt() { return _cjtPartidas; }
    public Aventura getAventura() { return _av; }


}
