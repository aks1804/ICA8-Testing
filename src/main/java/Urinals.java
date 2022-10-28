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
            System.out.println("\nYES");
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='0'){
                    if (i == 0 && s.charAt(i + 1) == '0') { // If we're at the first element
                        cnt++;
                        s = s.substring(0, i) + '1' + s.substring(i + 1);
                    }

                    else if (i == s.length() - 1 && s.charAt(i - 1) == '0') { // If we reached the last element
                        cnt++;
                        s = s.substring(0, i) + '1' + s.substring(i + 1);
                    }

                    else if (s.charAt(i + 1) == '0' && s.charAt(i - 1) == '0') {
                        cnt++;
                        s = s.substring(0, i) + "1" + s.substring(i + 1);
                    }
                }
            }
            if(cnt==0)
                cnt=-1;
            ans.add(cnt);
        }
        return ans;
    }

    public static void main(String args[]){
    }

}
