package org;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class InputParser {

    public static Set<String> readFileLineByLine(String path){
        Set<String> output = new HashSet<>();

        //read file line by line
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.filter(Objects::nonNull)
                    .forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //create file for results
        try{
            new FileWriter(buildResultPath(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static void saveLineToFile(String path, String line) {
        try{
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(line);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String buildResultPath(String path){
        return path.substring(0, path.length()-4) + "_result.txt";
    }

}
