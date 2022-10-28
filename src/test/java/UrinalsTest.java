import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @org.junit.jupiter.api.Test
    void readFile() throws Exception {
        String filename = "urinals.dat";
        ArrayList<String> inputs = new ArrayList<>();

        System.out.println("readFile() Test:");

        System.out.println("Akshat Nambiar - TEST ONE EXECUTED - FileNotFoundException");
        assertEquals(inputs, Urinals.readFile("diffile.dat"));

        System.out.println("Akshat Nambiar - TEST TWO EXECUTED - Empty File");
        assertEquals(inputs, Urinals.readFile("urinals_test.dat"));

        inputs.add("101");
        inputs.add("1011");

        System.out.println("Akshat Nambiar - TEST THREE EXECUTED - Successful File Read");
        assertEquals(inputs, Urinals.readFile(filename));
    }


    @Test
    void checkString() {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(2);
        ans.add(3);
        ans.add(2);

        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("000");
        inputs.add("00000");
        inputs.add("0001010001");

        System.out.println("\n\nreadFile() Test:");

        System.out.println("Akshat Nambiar - TEST ONE EXECUTED - Check Value Correct");
        assertEquals(ans, Urinals.checkString(inputs));
    }
}