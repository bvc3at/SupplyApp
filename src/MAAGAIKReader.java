import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by Dmitry on 30.06.2015.
 */
public class MAAGAIKReader extends AbstractReaderFromUrl{

    private static Elements tables;
    public static final String URL_MIIGAIK = "http://priem.miigaik.ru/konkyrs/spiski/och/budzhet/20150623135902-4183.htm";

    @Override
    public void readData() throws IOException {
        Document doc =  Jsoup.connect(URL_MIIGAIK).get();
        tables = doc.select("table");
    }

    @Override
    public Map<String, ArrayList<EnrolleeData>> getData() {
        return null;
    }
    private ArrayList<EnrolleeData> getCourseData() {
        return null;
    }

    public static void main(String[] args) throws IOException {
        MAAGAIKReader maagaikReader = new MAAGAIKReader();
        maagaikReader.readData();
        for (Element temp : tables) {

        }
    }
}
