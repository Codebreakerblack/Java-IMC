package dev.mariel.eximc;

import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void calculateCorrectIMC() {

        String simulatedInput = "70\n1.75\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        App.main(new String[] {});

        String consoleOutput = outputStream.toString();

        System.out.println(consoleOutput);

        assertTrue(consoleOutput.contains("\nYour IMC is: 22.86"));
        assertTrue(consoleOutput.contains("\nClassification: Normal weight"));
    }

}
