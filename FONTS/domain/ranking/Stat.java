package domain.ranking;

import java.util.UUID;

public class Stat {
    UUID perfil;
    Double puntuacio;

    Stat() {
        perfil = UUID.randomUUID();
        puntuacio = 0.0;
    }

    Stat(UUID nom, Double punt) {
        perfil = nom;
        puntuacio = punt;
    }

    public Double getPuntuacio() {return puntuacio;}
    public UUID getPerfil() {return perfil;}
    public void setPuntuacio(Double p) {
        puntuacio = p;
    }
}
