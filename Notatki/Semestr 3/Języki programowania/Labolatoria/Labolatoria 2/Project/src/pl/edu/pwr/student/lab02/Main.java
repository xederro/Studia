package pl.edu.pwr.student.lab02;

import pl.edu.pwr.student.lab02.UI.CLI.CLI;
import pl.edu.pwr.student.lab02.UI.GUI.GUI;

/**
 * Entrypoint Of Application
 */
public class Main {
    /**
     * Selects GUI or CLI accordingly
     *
     * @param args the args
     */
    public static void main(String[] args){
        if (args == null || args.length == 0) {
            GUI.start();
        } else {
            CLI.start(args);
        }
    }
}