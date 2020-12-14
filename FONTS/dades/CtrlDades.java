package dades;

import domain.kakuro.Kakuro;
import domain.usuari.Perfil;

public class CtrlDades {
     private CtrlDataPerfil  perfil = new CtrlDataPerfil();
    private CtrlDataAventura  aventura = new CtrlDataAventura();
    private CtrlDataPartida  partida = new CtrlDataPartida();
    private CtrlDataKakuro  kakuro = new CtrlDataKakuro();
    private CtrlDataUsuaris usuaris = new CtrlDataUsuaris();
    private CtrlDataRanking ranking = new CtrlDataRanking();


    public CtrlDades() {


    }

    public void guardar_kakuro(int id, Kakuro k) {
    kakuro.guardarKakuro(id,k);

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
