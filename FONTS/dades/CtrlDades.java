package dades;

import domain.kakuro.Kakuro;
import domain.usuari.Perfil;

public class CtrlDades {
    private final CtrlDataPerfil perfil = CtrlDataPerfil.getInstance();
    private final CtrlDataAventura aventura = CtrlDataAventura.getInstance();
    private final CtrlDataPartida partida = CtrlDataPartida.getInstance();
    private final CtrlDataKakuro kakuro = CtrlDataKakuro.getInstance();
    private final CtrlDataUsuaris usuaris = CtrlDataUsuaris.getInstance();
    private final CtrlDataRanking ranking = CtrlDataRanking.getInstance();

    public CtrlDades() {


    }

    public void guardar_kakuro(int id, Kakuro k) {
    kakuro.guardarKakuro(id, k);

    }

    public void guardar_perfil(Perfil p, String nom) {

        perfil.guardarPerfil(p,nom);

    }

    public void leer_perfil(String nom) {

        perfil.getPerfil(nom);

    }

    public void leer_kakuro(String archivo) {
        kakuro.getData(archivo);


    }

    public void leer_estadisticas() {

        ranking.obtenirRanking();
        
    }

    public void guardar_estadisticas() {

      //  ranking.guardarRanking();
    }







}
