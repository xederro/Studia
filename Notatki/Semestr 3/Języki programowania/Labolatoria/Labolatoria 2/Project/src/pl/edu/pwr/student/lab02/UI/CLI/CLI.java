package pl.edu.pwr.student.lab02.UI.CLI;

import pl.edu.pwr.student.lab02.data.Constants;
import pl.edu.pwr.student.lab02.tactics.BruteForceMethod;
import pl.edu.pwr.student.lab02.tactics.MethodInterface;
import pl.edu.pwr.student.lab02.tactics.RandomMethod;
import pl.edu.pwr.student.lab02.reader.ConstantsReader;

/**
 * CLI class
 */
public abstract class CLI {
    /**
     * initializes constants and runs CLI
     *
     * @param args the args
     */
    public static void start(String[] args) {
        try {
            //Initializes constants
            if (args.length == 4) ConstantsReader.initConstants(
                args[1],
                args[2],
                args[3]
            );
            else if (args.length > 4) {
                int skiCost = Constants.getSkiCost();
                int skiLenDiff = Constants.getSkiLenDiffPenalty();
                int skiTypeDiff = Constants.getSkiTypeDiffPenalty();
                int noSki = Constants.getNoSkiPenalty();
                try {
                    skiCost = Integer.parseInt(args[4]);
                    skiLenDiff = Integer.parseInt(args[5]);
                    skiTypeDiff = Integer.parseInt(args[6]);
                    noSki = Integer.parseInt(args[7]);
                } catch (Exception ignored){}

                ConstantsReader.initConstants(
                    args[1],
                    args[2],
                    args[3],
                    skiCost,
                    skiLenDiff,
                    skiTypeDiff,
                    noSki
                );
            }
            else throw new IllegalArgumentException("Not enough arguments");

            //Runs only selected
            String[] runs = args[0].split("");
            for (String run : runs) {
                switch (run){
                    case "R", "r": {
                        System.out.println("\n\nRandom:");
                        MethodInterface method = new RandomMethod();
                        method.find();
                        System.out.println(method);
                        break;
                    }
                    case "B", "b": {
                        System.out.println("\n\nBrute Force:");
                        MethodInterface method = new BruteForceMethod();
                        method.find();
                        System.out.println(method);
                        break;
                    }
                    default:break;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
