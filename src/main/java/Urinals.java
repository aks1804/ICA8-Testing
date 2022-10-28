/*  ICA-8 Assignment - SER 515 - Fall 2022
    Akshat Nambiar
    ASU ID: 1225484000
 */

import java.util.*;
import java.io.*;

public class Urinals {

    static ArrayList<String> readFile(String filename){
        File reader;
        Scanner myReader;
        ArrayList<String> inputs = new ArrayList<>();
        try {
            reader = new File(filename);
            myReader = new Scanner(reader);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                inputs.add(data);
            }
            myReader.close();
        }
        catch (Exception e) {
            System.out.println("File does not exist");
            return inputs;
        }

        if(inputs.isEmpty()){
            System.out.println("File is empty");
            return inputs;
        }

        return inputs;
    }

    public static void main(String args[]){
    }

}
