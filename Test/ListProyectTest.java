package Test;

import IO.Teclado;
import MODEL.Project;
import MODEL.Task;
import MODEL.User;
import VIEW.ListProyect;

import java.util.ArrayList;
import java.util.List;

public class ListProyectTest {
    private static List<MODEL.User> User;
    private static List<MODEL.Task> Task;
    static ListProyect listProyect = new ListProyect();
    static Project project = new Project("Proyecto_2a_Evaluación",
            "Proyecto de la 3a evaluación del módulo de Programación",
            (MODEL.User) User,
            User,
            Task);


    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1(){
        System.out.println(project.toString());
        List<Project> projects = new ArrayList<>();
        listProyect.listProyects(projects);
        Teclado.pressEnter();
    }
    public static void test2(){
        // Aquí puedes agregar proyectos a la lista
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Proyecto_2a_Evaluación",
                "Proyecto de la 3a evaluación del módulo de Programación",
                (MODEL.User) User,
                User,
                Task));
        projects.add(new Project("Proyecto_2a_Evaluación",
                "Proyecto de la 3a evaluación del módulo de Programación",
                (MODEL.User) User,
                User,
                Task));

        listProyect.listProyects(projects);
    }
}
