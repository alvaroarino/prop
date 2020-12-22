package domain.usuari;

import domain.aventura.Aventura;
import domain.partida.CjtPartida;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Perfil {
    private String _idPerfil;
    private String _nom;
    private CjtPartida _cjtPartidas;
    private Aventura _av;
    private Set<String> _kakurosPuntuats;

    public Perfil() {
        _idPerfil = UUID.randomUUID().toString();
        _nom = "";
        _kakurosPuntuats = new HashSet<>();
    }

    public Perfil(String nom) {
        this._idPerfil = UUID.randomUUID().toString();
        this._nom = nom;
        _kakurosPuntuats = new HashSet<>();
    }

    public Perfil(String id, String nom) {
        this._idPerfil = id;
        this._nom = nom;
        _kakurosPuntuats = new HashSet<>();
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

    public void addKakuro(String id) {
        if(!_kakurosPuntuats.contains(id)){
            _kakurosPuntuats.add(id);
        }
    }
    public boolean conteKakuro(String id) {
        return _kakurosPuntuats.contains(id);
    }


}
