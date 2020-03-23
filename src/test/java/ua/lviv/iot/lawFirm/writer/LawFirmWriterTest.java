package ua.lviv.iot.lawFirm.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.lawFirm.manager.*;

public class LawFirmWriterTest extends LawFirmManagerTest {

    LawFirmWriter lawyersWriter = new LawFirmWriter();

    @Test
    void writingAFileTest() throws IOException {

        try (Writer csvWriter = new FileWriter("LawyersWriter.csv")) {
            lawyersWriter.setCsvWriter(csvWriter);
            lawyersWriter.writeToFile(lawyers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
