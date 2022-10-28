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
            if(s.length()==1){
                if(s.charAt(0)=='0')
                    ans.add(1);
                else
                    ans.add(-1);
                continue;
            }

            if(s.length()==2){
                if(s.charAt(0)=='0' && s.charAt(1)=='0')
                    ans.add(1);
                else
                    ans.add(-1);
                continue;
            }

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

    static int writeFile(ArrayList<Integer> ans){
        int i=0;
        while(true) {
            int j=i;
            String filename = new String();
            if(j==0)
                filename = "rule.txt";
            else
                filename = "rule" + String.valueOf(i) + ".txt";

            try {
                File create = new File(filename);
                if (create.createNewFile()) {
                    System.out.println("File created: " + create.getName());
                    if(!ans.isEmpty()) {
                        try {
                            FileWriter writer = new FileWriter(filename);
                            for (int val : ans) {
                                writer.write(val + "\n");
                            }
                            writer.close();
                            System.out.println("Successfully wrote to the file.");
                        } catch (IOException e) {
                            System.out.println("An error occurred.");
                        }
                    }
                    return 1;
                } else {
                    i++;
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                return -1;
            }
        }


    }

    public static void main(String args[]){
        String filename = "urinals.dat";
        ArrayList<String> inputs = readFile(filename);
        ArrayList<Integer> ans = checkString(inputs);
        writeFile(ans);
    }
}
