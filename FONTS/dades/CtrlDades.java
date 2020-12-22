package dades;

import domain.kakuro.Kakuro;
import domain.partida.Partida;
import domain.ranking.Stat;
import domain.usuari.Perfil;
import domain.usuari.Usuari;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * The type Ctrl dades.
 */
public class CtrlDades {
    private final CtrlDataPerfil perfil = CtrlDataPerfil.getInstance();
    private final CtrlDataAventura aventura = CtrlDataAventura.getInstance();
    private final CtrlDataPartida partida = CtrlDataPartida.getInstance();
    private final CtrlDataKakuro kakuro = CtrlDataKakuro.getInstance();
    private final CtrlDataUsuaris usuaris = CtrlDataUsuaris.getInstance();
    private final CtrlDataRanking ranking = CtrlDataRanking.getInstance();

    private static CtrlDades singletonObject;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CtrlDades getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlDades() {
            };
        return singletonObject;
    }

    private CtrlDades() {};


    /**
     * Guardar kakuro.
     *
     * @param id the id
     * @param k  the k
     * @throws IOException the io exception
     */
    public void guardar_kakuro(int id, Kakuro k) throws IOException {
        //kakuro.guardarKakuro(String.valueOf(id), k);
    }

    /**
     * Guardar perfil.
     *
     * @param p   the p
     * @param nom the nom
     * @throws IOException the io exception
     */
    public void guardar_perfil(Perfil p, String nom) throws IOException {
        perfil.guardarPerfil(p,nom);
    }

    /**
     * Leer perfil.
     *
     * @param nom the nom
     * @throws IOException the io exception
     */
    public void leer_perfil(String nom) throws IOException {
        perfil.getPerfil(nom);
    }

    /**
     * Leer kakuro.
     *
     * @param archivo the archivo
     * @return the kakuro
     * @throws IOException the io exception
     */
    public Kakuro leer_kakuro(String archivo) throws IOException {
        return kakuro.getData(archivo);
    }

    /**
     * Leer estadisticas.
     *
     * @throws IOException the io exception
     */
    public void leer_estadisticas() throws IOException {
        ranking.obtenirRanking();
    }

    /**
     * Guardar estadisticas.
     */
    public void guardar_estadisticas(Map<String, Stat> rank) throws IOException {

      ranking.guardarRanking(rank);
    }

    /**
     * Gets usuaris.
     *
     * @return the usuaris
     * @throws IOException the io exception
     */
    public ArrayList<Usuari> getUsuaris() throws IOException {
        return usuaris.getData();
    }

    /**
     * Update usuaris.
     *
     * @param cjtUsuaris the cjt usuaris
     */
    public void updateUsuaris(ArrayList<Usuari> cjtUsuaris) {
        usuaris.updateData(cjtUsuaris);
    }

}
