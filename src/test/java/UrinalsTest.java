import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @org.junit.jupiter.api.Test
    void readFile() throws Exception {
        String filename = "urinals.dat";
        ArrayList<String> inputs = new ArrayList<>();

        System.out.println("====== Akshat Nambiar == TEST ONE EXECUTED == FileNotFoundException =======");
        assertEquals(inputs, Urinals.readFile(filename));
    }
}