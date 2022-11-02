package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public enum Format {
        CSV("CSV"),
        XML("XML"),
        JSON("JSON");

        public final String value;

        private Format(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException {
        //     BookMetadataFormatterFactory will be no longer used.

        // Current usage
        // BookMetadataFormatter formatter = null;
        // try {
        //     // formatter = BookMetadataFormatterFactory.getBookMetadataFormatter(BookMetadataFormatterFactory.Format.CSV);
        //     formatter = BookMetadataFormatterFactory.getBookMetadataFormatter(BookMetadataFormatterFactory.Format.JSON);
        //     formatter.append(TestData.dragonBook);
        //     formatter.append(TestData.dinosaurBook);
        //     System.out.print(formatter.getMetadataString());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // } catch (ParserConfigurationException e) {
        //     e.printStackTrace();
        // }

        // Expected usage
       //BookMetadataExporter exporter = new BookMetadataExporter(Format.CSV.value);
       //BookMetadataExporter exporter = new BookMetadataExporter(Format.XML.value);
       BookMetadataExporter exporter = new BookMetadataExporter(Format.JSON.value);
       exporter.add(TestData.sailboatBook);
       exporter.add(TestData.GoFBook);
       exporter.export(System.out);
    }
}
