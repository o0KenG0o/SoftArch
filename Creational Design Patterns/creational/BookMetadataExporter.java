package creational;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import java.io.PrintStream;
import java.util.*;

public class BookMetadataExporter extends BookCollection {
    private BookMetadataFormatter file;

    public BookMetadataExporter(String format) throws IOException, ParserConfigurationException{
        switch(format){
            case "CSV":
                file = new CSVBookMetadataFormatter();
                break;
            case "XML":
                file = new XMLBookMetadataFormatter();
                break;
            case "JSON":
                file = new JSONBookMetadataFormatter();
                break;
        }      
    }

    @Override
    public void add(Book book){
        super.add(book);
    }

    public void export(PrintStream stream) {
        List<Book> books = new ArrayList<Book>(super.books);
        for(Book book : books)
        {
            file.append(book);
        }
        stream.println(file.getMetadataString());
    }
}
