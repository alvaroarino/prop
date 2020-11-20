javac  -d ../EXE/DriverCella/ domain/cella/Cella.java;
javac  -d ../EXE/DriverCella/ domain/cella/CellaNegra.java;
javac  -d ../EXE/DriverCella/ domain/cella/CellaBlanca.java;
javac  -d ../EXE/DriverCella/ domain/cella/DriverCella.java;

javac  -d ../EXE/KakuroDriver domain/kakuro/Kakuro.java;
javac  -d ../EXE/KakuroDriver domain/kakuro/Tauler.java;
javac  -d ../EXE/KakuroDriver domain/kakuro/KakuroDriver.java;
javac  -d ../EXE/KakuroDriver domain/kakuro/DriverTauler.java;

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

jar cmf ../EXE/DriverCella/domain/cella/manifest.mf ../EXE/DriverCella/DriverCella.jar ../EXE/DriverCella/domain/cella/*.class
jar cmf ../EXE/DriverCtrlDataKakuro/dades/manifest.mf ../EXE/DriverCtrlDataKakuro/DriverCtrlDataKakuro.jar ../EXE/DriverCtrlDataKakuro/dades/*.class
jar cmf ../EXE/DriverCtrlDataKakuro/domain/cella/manifest.mf ../EXE/DriverCtrlDataKakuro/DriverCtrlDataKakuro.jar ../EXE/DriverCtrlDataKakuro/domain/cella/*.class