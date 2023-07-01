package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FeaturesCalculator {
    private ArrayList<ArrayList<Integer>> binary_mask;
    private Integer[] mass_center;
    private String filename;

    public FeaturesCalculator(String filename) {
        this.filename = filename;
        binary_mask = new ArrayList<>();
        mass_center = new Integer[2];
    }

    public void read_data() throws FileNotFoundException {
        File f = new File(filename);

        if (!f.exists()){
            throw new FileNotFoundException();
        }

        Scanner scanFile = new Scanner(f);
        while (scanFile.hasNextLine()){
            ArrayList<Integer> line = new ArrayList<>();
            Scanner scanLine = new Scanner(scanFile.nextLine());
            while (scanLine.hasNextInt()){
                line.add(scanLine.nextInt());
            }
            binary_mask.add(line);
        }
    }

    public void calculate_mass_center() {
        int ny = binary_mask.size();
        int nx = binary_mask.get(0).size();
        int count = 0;
        int y = 0;
        int x = 0;

        for (int i = 0; i < ny; i++){
            for (int j = 0; j < nx; j++){
                if (binary_mask.get(i).get(j) == 1){
                    y+=i;
                    x+=j;
                    count++;
                }
            }
        }

        mass_center[0] = x/count;
        mass_center[1] = y/count;
    }

    public void save_results() throws IOException {
        File f = new File(filename);
        FileWriter fw = new FileWriter(f+".out");

        int ny = binary_mask.size();
        int nx = binary_mask.get(0).size();

        for (int i = 0; i < ny; i++){
            for (int j = 0; j < nx; j++){
                if(i == mass_center[1] && j == mass_center[0]){
                    fw.write("P ");
                } else {
                    fw.write(binary_mask.get(i).get(j).toString());
                    fw.write(" ");
                }
            }
            fw.write("\n");
        }

        fw.close();
    }

    public static void main(String[] args) throws IOException {
        for (String fp : args){
            FeaturesCalculator fc = new FeaturesCalculator(fp);
            fc.read_data();
            fc.calculate_mass_center();
            fc.save_results();
        }
    }
}
