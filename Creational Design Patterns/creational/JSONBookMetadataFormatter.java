package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject jsonObject;
    private JSONArray jsonArray;

    public JSONBookMetadataFormatter() throws IOException{
        reset();
    }


    @Override
    public BookMetadataFormatter reset() {
        jsonObject = new JSONObject();
        jsonArray = new JSONArray();

        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {

        String authors = String.join("|", b.getAuthors());
        jsonObject.put((String)Book.Metadata.ISBN.value,b.getISBN());
        jsonObject.put((String)Book.Metadata.TITLE.value,b.getTitle());
        jsonObject.put((String)Book.Metadata.PUBLISHER.value,b.getPublisher());
        jsonObject.put((String)Book.Metadata.AUTHORS.value,authors);

        jsonArray.add(jsonObject);

        jsonObject = new JSONObject();
    
        return this;
    }

    @Override
    public String getMetadataString() {
        return jsonArray.toString();
    }
}
