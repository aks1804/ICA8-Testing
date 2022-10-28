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

        System.out.println("Successful File Read");
        return inputs;
    }

    static ArrayList<Integer> checkString(ArrayList<String> inputs){
        ArrayList<Integer> ans = new ArrayList<>();

        for(String s: inputs) {
            int cnt = 0;
            for (int i = 1; i < s.length()-1; i++) {
                if(s.charAt(i)=='0'){
                    if (s.charAt(i - 1) == '0' && s.charAt(i) == '0' && s.charAt(i + 1) == '0') { // If in the middle
                        cnt++;
                        s = s.substring(0, i) + "1" + s.substring(i + 1);
                    }
                }
            }
            ans.add(cnt);
            cnt=0;
        }
        return ans;
    }

    public static void main(String args[]){
    }

}
