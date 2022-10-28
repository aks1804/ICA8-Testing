import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @org.junit.jupiter.api.Test
    void readFile() throws Exception {
        String filename = "urinals.dat";
        ArrayList<String> inputs = new ArrayList<>();

        System.out.println("Akshat Nambiar - TEST ONE EXECUTED - FileNotFoundException");
        assertEquals(inputs, Urinals.readFile("diffile.dat"));

        System.out.println("Akshat Nambiar - TEST TWO EXECUTED - Empty File");
        assertEquals(inputs, Urinals.readFile("urinals_test.dat"));

        inputs.add("101");
        inputs.add("1011");

        System.out.println("Akshat Nambiar - TEST THREE EXECUTED - Successful File Read");
        assertEquals(inputs, Urinals.readFile(filename));
    }
}