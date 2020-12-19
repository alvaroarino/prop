package dades;

import domain.kakuro.Kakuro;
import domain.usuari.Perfil;
import domain.usuari.Usuari;
import presentacion.CtrlPresentacion;

import java.io.IOException;
import java.util.ArrayList;

public class CtrlDades {
    private final CtrlDataPerfil perfil = CtrlDataPerfil.getInstance();
    private final CtrlDataAventura aventura = CtrlDataAventura.getInstance();
    private final CtrlDataPartida partida = CtrlDataPartida.getInstance();
    private final CtrlDataKakuro kakuro = CtrlDataKakuro.getInstance();
    private final CtrlDataUsuaris usuaris = CtrlDataUsuaris.getInstance();
    private final CtrlDataRanking ranking = CtrlDataRanking.getInstance();

    private static CtrlDades singletonObject;

    public static CtrlDades getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDades() {
            };
        return singletonObject;
    }

    private CtrlDades() {};

    public void guardar_kakuro(int id, Kakuro k) throws IOException {
        kakuro.guardarKakuro(String.valueOf(id), k);
    }

    public void guardar_perfil(Perfil p, String nom) throws IOException {
        perfil.guardarPerfil(p,nom);
    }

    public void leer_perfil(String nom) throws IOException {
        perfil.getPerfil(nom);
    }

    public void leer_kakuro(String archivo) throws IOException {
        kakuro.getData(archivo);
    }

    public void leer_estadisticas() throws IOException {
        ranking.obtenirRanking();
    }

    public void guardar_estadisticas() {

      //  ranking.guardarRanking();
    }

    public ArrayList<Usuari> getUsuaris() throws IOException {
        return usuaris.getData();
    }

    public void updateUsuaris(ArrayList<Usuari> cjtUsuaris) {
        usuaris.updateData(cjtUsuaris);
    }





}
