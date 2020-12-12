package domain.usuari;

import domain.aventura.Aventura;
import domain.partida.CjtPartida;

import java.util.UUID;

public class Perfil {
    private String _idPerfil;
    private String _nom;
    private CjtPartida cjt;
    private Aventura av;

    public Perfil() {
        _idPerfil = UUID.randomUUID().toString();
        _nom = "";
        CjtPartida cjt = new CjtPartida();
        Aventura av = new Aventura();
    }

    public Perfil(String nom) {
        this._idPerfil = UUID.randomUUID().toString();
        this._nom = nom;
        CjtPartida cjt = new CjtPartida();
        Aventura av = new Aventura();
    }

    public Perfil(String id, String nom) {
        this._idPerfil = id;
        this._nom = nom;
        CjtPartida cjt = new CjtPartida();
        Aventura av = new Aventura();
    }

    public void setNom(String n) {
        this._nom = n;
    }
    public void setCjt(CjtPartida par) { cjt = par; }
    public void setAventura(Aventura v) { av = v; }

    public String getNom() {
        return this._nom;
    }
    public CjtPartida getCjt() { return cjt; }
    public Aventura getAventura() { return av; }


}
