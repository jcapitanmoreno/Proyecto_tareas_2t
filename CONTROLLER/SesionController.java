package CONTROLLER;

import INTERFACES.ISesionController;
import IO.Teclado;
import MODEL.RepoUsers;
import MODEL.User;
import VIEW.*;

import java.security.NoSuchAlgorithmException;

public class SesionController implements ISesionController {

    SesionView sesionView = new SesionView();
    LogInView login = new LogInView();
    WelcomeByeView welcomeByeView = new WelcomeByeView();
    CreateUser createUser = new CreateUser();
    RepoUsers repoUsers = RepoUsers.getInstance();
    LogInView logInView = new LogInView();
    Controller controller = new Controller();
    CreateUserView createUserView = new CreateUserView();
    Teclado teclado = new Teclado();

    /**
     * Método para iniciar la sesión del usuario.
     * Muestra el mensaje de bienvenida y llama al método para elegir una opción.
     *
     * @throws NoSuchAlgorithmException Si ocurre un error relacionado con el algoritmo de hash.
     */
    public void start() throws NoSuchAlgorithmException {
        welcomeByeView.welcomeProgram();
        teclado.pressEnter();
        chooseoption();
    }

    /**
     * Método para elegir una opción del menú de inicio de sesión.
     * Llama al método chooseoption() de la vista de sesión.
     *
     * @return La opción elegida.
     * @throws NoSuchAlgorithmException Si ocurre un error relacionado con el algoritmo de hash.
     */
    @Override
    public int chooseoption() throws NoSuchAlgorithmException {
        int opcion = -1;
        do {
            opcion = sesionView.chooseoption();
            manejarOpcionMenu(opcion);
        } while (opcion != 3);
        return opcion;
    }

    /**
     * Método para manejar la opción seleccionada del menú de inicio de sesión.
     *
     * @param opcion La opción seleccionada.
     * @throws NoSuchAlgorithmException Si ocurre un error relacionado con el algoritmo de hash.
     */
    // Método para manejar la opción seleccionada del menú
    public void manejarOpcionMenu(int opcion) throws NoSuchAlgorithmException {
        switch (opcion) {
            case 1:
                chooseToLogIn();
                break;
            case 2:
                chooseToCreate();
                break;
            case 3:
                welcomeByeView.byeProgram();
                System.exit(0);
                break;
            default:
                sesionView.errorOption();
        }
    }

    /**
     * Método para elegir iniciar sesión.
     * Ejecuta un bucle que solicita al usuario que elija una opción de inicio de sesión.
     * Llama al método switchToLogIn() para manejar la opción seleccionada.
     *
     * @throws NoSuchAlgorithmException Si ocurre un error relacionado con el algoritmo de hash.
     */
    public void chooseToLogIn() throws NoSuchAlgorithmException {
        boolean continueLoop = true;
        do {
            int opcionMenu = login.chooseLogIn();
            if (opcionMenu == 2) {
                continueLoop = false;
            } else {
                switchToLogIn(opcionMenu);
            }
        } while (continueLoop);
    }

    /**
     * Método para manejar la opción de inicio de sesión seleccionada.
     *
     * @param opcionMenu La opción de inicio de sesión seleccionada.
     * @throws NoSuchAlgorithmException Si ocurre un error relacionado con el algoritmo de hash.
     */
    public void switchToLogIn(int opcionMenu) throws NoSuchAlgorithmException {
        switch (opcionMenu) {
            case 1:
                User user = logInView.solicitateUser();
                if (repoUsers.login(user)) {
                    repoUsers.setUserLogin(user);
                    sesionView.printMsg1();
                    controller.start();
                } else {
                    login.usernamePasswordError();
                }
                break;
            case 2:
                break;
            default:
                sesionView.errorOption();
        }
    }

    /**
     * Método para elegir crear una cuenta.
     * Ejecuta un bucle que solicita al usuario que elija una opción para crear una cuenta.
     * Llama al método switchToCreate() para manejar la opción seleccionada.
     *
     * @throws NoSuchAlgorithmException Si ocurre un error relacionado con el algoritmo de hash.
     */
    public void chooseToCreate() throws NoSuchAlgorithmException {
        boolean continueLoopCreate = true;
        do {
            int opcionMenuCreate = createUserView.wantToCreate();
            if (opcionMenuCreate == 2) {
                continueLoopCreate = false;
            } else {
                switchToCreate(opcionMenuCreate);
            }
        } while (continueLoopCreate);
    }

    /**
     * Método para manejar la opción de crear una cuenta seleccionada.
     *
     * @param opcionMenu La opción seleccionada para crear una cuenta.
     * @throws NoSuchAlgorithmException Si ocurre un error relacionado con el algoritmo de hash.
     */
    public void switchToCreate(int opcionMenu) throws NoSuchAlgorithmException {
        switch (opcionMenu) {
            case 1:
                createUser.createUser();
                chooseoption();
                break;
            case 2:
                break;
            default:
                sesionView.errorOption();
        }
    }
}
