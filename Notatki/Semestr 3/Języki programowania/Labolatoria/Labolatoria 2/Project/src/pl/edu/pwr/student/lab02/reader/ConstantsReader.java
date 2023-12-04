package pl.edu.pwr.student.lab02.reader;

import pl.edu.pwr.student.lab02.data.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * The type Constants reader.
 */
abstract public class ConstantsReader {
    /**
     * Init constants.
     *
     * @param personPath         the person path
     * @param assortmentPath     the assortment path
     * @param discountsPath      the discounts path
     * @param skiCost            the ski cost
     * @param skiLenDiffPenalty  the ski len diff penalty
     * @param skiTypeDiffPenalty the ski type diff penalty
     * @param noSkiPenalty       the no ski penalty
     * @throws IOException the io exception
     */
    public static void initConstants(String personPath, String assortmentPath, String discountsPath, int skiCost, int skiLenDiffPenalty, int skiTypeDiffPenalty, int noSkiPenalty) throws IOException {
        List<Person> LPerson;
        Map<Ski, Integer> MAssortment;
        Map<PersonKind, Integer> MDiscounts;

        try{
            LPerson = readPersons(personPath);
            if (LPerson.isEmpty()){
                throw new EmptyFileException("Preferences");
            }
            MAssortment = readAssortment(assortmentPath);
            if (MAssortment.isEmpty()){
                throw new EmptyFileException("Assortment");
            }
            MDiscounts = readDiscounts(discountsPath);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        Constants.initConstants(
                LPerson,
                MAssortment,
                MDiscounts,
                skiCost,
                skiLenDiffPenalty,
                skiTypeDiffPenalty,
                noSkiPenalty
        );
    }

    /**
     * Init constants.
     *
     * @param personPath     the person path
     * @param assortmentPath the assortment path
     * @param discountsPath  the discounts path
     * @throws IOException the io exception
     */
    public static void initConstants(String personPath, String assortmentPath, String discountsPath) throws IOException {
        List<Person> LPerson;
        Map<Ski, Integer> MAssortment;
        Map<PersonKind, Integer> MDiscounts;

        try{
            LPerson = readPersons(personPath);
            if (LPerson.isEmpty()){
                throw new EmptyFileException("Preferences");
            }
            MAssortment = readAssortment(assortmentPath);
            if (MAssortment.isEmpty()){
                throw new EmptyFileException("Assortment");
            }
            MDiscounts = readDiscounts(discountsPath);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        Constants.initConstants(
            LPerson,
            MAssortment,
            MDiscounts
        );
    }

    /**
     * Reads persons.
     *
     * @param path  path to file with persons
     * @throws IOException the io exception
     */
    private static List<Person> readPersons(String path) throws IOException {
        List<Person> LPerson = new ArrayList<>();
        Path p = Paths.get(path);

        //reads data from file
        //data: id,person_type,ski_type:ski_length;ski_type:ski_length;...
        try(BufferedReader reader = Files.newBufferedReader(p)) {
            String line = reader.readLine();
            if (line != null && !line.isEmpty()){
                if (line.equals("id,group,skis")){
                    line = reader.readLine();
                }
                for (; line != null && !line.isEmpty(); line = reader.readLine()) {
                    String[] data = line.split(",");
                    Person person = new Person(
                            Integer.parseInt(data[0]),
                            PersonKind.valueOf(data[1])
                    );
                    LPerson.add(person);

                    if (data.length == 3){
                        String[] skiData = data[2].split(";");

                        for (String ski : skiData) {
                            String[] skiEntryData = ski.split(":");
                            Ski skiEntry = new Ski(
                                    Math.abs(Integer.parseInt(skiEntryData[1])),
                                    SkiType.valueOf(skiEntryData[0])
                            );
                            person.addSki(skiEntry);
                        }
                    } else {
                        //if no ski is given then adds no ski as ski
                        Ski skiEntry = new Ski(
                                0,
                                SkiType.noski
                        );
                        person.addSki(skiEntry);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return LPerson;
    }


    /**
     * Reads Assortment.
     *
     * @param path  path to file with assortment
     * @throws IOException the io exception
     */
    private static Map<Ski, Integer> readAssortment(String path) throws IOException {
        Map<Ski, Integer> MSki = new HashMap<Ski, Integer>();
        Path p = Paths.get(path);

        //reads data from file
        //data: count,ski_type:ski_length
        try(BufferedReader reader = Files.newBufferedReader(p)) {
            String line = reader.readLine();
            if (line.equals("quantity,ski")){
                line = reader.readLine();
            }
            for (; line != null && !line.isEmpty(); line = reader.readLine()) {
                String[] data = line.split(",");

                String[] skiData = data[1].split(":");

                MSki.put(new Ski(
                        Integer.parseInt(skiData[1]),
                        SkiType.valueOf(skiData[0])
                ), Integer.parseInt(data[0]));
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        return MSki;
    }


    /**
     * Reads discounts.
     *
     * @param path  path to file with discounts
     * @throws IOException the io exception
     */
    private static Map<PersonKind, Integer> readDiscounts(String path) throws IOException {
        EnumMap<PersonKind, Integer> MPersonKind = new EnumMap<>(PersonKind.class);
        Path p = Paths.get(path);

        //reads data from file
        //data: person_type,discount
        try(BufferedReader reader = Files.newBufferedReader(p)) {
            String line = reader.readLine();
            if (line.equals("group,discount")){
                line = reader.readLine();
            }
            for (; line != null && !line.isEmpty(); line = reader.readLine()) {
                String[] data = line.split(",");

                MPersonKind.put(PersonKind.valueOf(data[0]), Integer.parseInt(data[1]));
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        return MPersonKind;
    }
}
