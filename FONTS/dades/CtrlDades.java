package dades;

import domain.kakuro.Kakuro;
import domain.usuari.Perfil;

import java.io.IOException;

public class CtrlDades {
    private final CtrlDataPerfil perfil = CtrlDataPerfil.getInstance();
    private final CtrlDataAventura aventura = CtrlDataAventura.getInstance();
    private final CtrlDataPartida partida = CtrlDataPartida.getInstance();
    private final CtrlDataKakuro kakuro = CtrlDataKakuro.getInstance();
    private final CtrlDataUsuaris usuaris = CtrlDataUsuaris.getInstance();
    private final CtrlDataRanking ranking = CtrlDataRanking.getInstance();

    public CtrlDades() {
    }

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







}
