javac  -d ../EXE/DriverCella/ domain/cella/Cella.java;
javac  -d ../EXE/DriverCella/ domain/cella/CellaNegra.java;
javac  -d ../EXE/DriverCella/ domain/cella/CellaBlanca.java;
javac  -d ../EXE/DriverCella/ domain/cella/DriverCella.java;

javac  -d ../EXE/KakuroDriver domain/kakuro/Kakuro.java;
javac  -d ../EXE/KakuroDriver domain/kakuro/Tauler.java;
javac  -d ../EXE/KakuroDriver domain/kakuro/KakuroDriver.java;

javac  -d ../EXE/DriverTauler domain/kakuro/Tauler.java;
javac  -d ../EXE/DriverTauler domain/kakuro/DriverTauler.java;

javac  -d ../EXE/DriverUsuaris domain/usuari/Perfil.java;
javac  -d ../EXE/DriverUsuaris  domain/usuari/Usuari.java;
javac  -d ../EXE/DriverUsuaris  domain/usuari/DriverUsuari.java;

javac  -d ../EXE/DriverPerfil  domain/usuari/Perfil.java;
javac  -d ../EXE/DriverPerfil  domain/usuari/Usuari.java;
javac  -d ../EXE/DriverPerfil  domain/usuari/DriverPerfil.java;

javac  -d ../EXE/DriverCtrlDataUsuaris -cp lib/gson.jar dades/CtrlDataUsuaris.java;

javac  -d ../EXE/DriverCtrlDataKakuro domain/cella/Cella.java;
javac  -d ../EXE/DriverCtrlDataKakuro domain/cella/CellaNegra.java;
javac  -d ../EXE/DriverCtrlDataKakuro domain/cella/CellaBlanca.java;
javac  -d ../EXE/DriverCtrlDataKakuro dades/CtrlDataKakuro.java
javac  -d ../EXE/DriverCtrlDataKakuro dades/DriverCtrlDataKakuro.java;

jar cmf ../EXE/DriverCella/manifest.mf ../EXE/DriverCella/DriverCella.jar ../EXE/DriverCella/domain/cella/*.class;
jar cmf ../EXE/DriverCtrlDataKakuro/manifest.mf ../EXE/DriverCtrlDataKakuro/DriverCtrlDataKakuro.jar ../EXE/DriverCtrlDataKakuro/dades/*.class ../EXE/DriverCtrlDataKakuro/domain/cella/*.class ../EXE/DriverCtrlDataKakuro/domain/kakuro/*.class;
jar cmf ../EXE/DriverCtrlDataUsuaris/manifest.mf ../EXE/DriverCtrlDataUsuaris/DriverCtrlDataUsuaris.jar ../EXE/DriverCtrlDataUsuaris/dades/*.class;
jar cmf ../EXE/DriverPerfil/manifest.mf ../EXE/DriverPerfil/DriverPerfil.jar ../EXE/DriverPerfil/domain/usuari/*.class;
jar cmf ../EXE/DriverTauler/manifest.mf ../EXE/DriverTauler/DriverTauler.jar ../EXE/DriverTauler/domain/kakuro/*.class;
jar cmf ../EXE/DriverUsuaris/manifest.mf ../EXE/DriverUsuaris/DriverUsuaris.jar ../EXE/DriverUsuaris/domain/usuari/*.class;
jar cmf ../EXE/KakuroDriver/manifest.mf ../EXE/KakuroDriver/KakuroDriver.jar ../EXE/KakuroDriver/domain/kakuro/*.class;