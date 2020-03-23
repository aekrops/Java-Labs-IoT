package ua.lviv.iot.lawFirm.writer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import ua.lviv.iot.lawFirm.model.Lawyer;

public class LawFirmWriter {

    public Writer csvWriter = new StringWriter();

    public Writer getCsvWriter() {
        return csvWriter;
    }

    public void setCsvWriter(Writer csvWriter) {
        this.csvWriter = csvWriter;
    }

    @Override
    public String toString() {
        return csvWriter.toString();
    }

    public void writeToFile(List<Lawyer> lawyers) throws IOException {
        csvWriter.write(lawyers.get(0).getHeaders());
        csvWriter.write("\n");
        for (Lawyer lawyer : lawyers) {
            csvWriter.write(lawyer.toCSV());
            csvWriter.write("\n");
        }
        csvWriter.flush();
    }
}
