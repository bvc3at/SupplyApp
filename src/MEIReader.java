import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MEIReader extends AbstractReaderFromUrl{

    private final static String MEI_URL_010302 = "http://www.pkmpei.ru/inform/entrants_list16.html";
    private final static String MEI_URL_090301 = "http://www.pkmpei.ru/inform/entrants_list14.html";
    private static final String TABLE_SELECTIVE = "table .competitive-group-table";

    private Elements tables_010302;
    private Elements tables_090301;

    @Override
    public void readData() throws IOException {

        //Get 01.03.02
        Document doc =  Jsoup.connect(MEI_URL_010302).get();
        tables_010302 = doc.select(TABLE_SELECTIVE);

        //Get 09.03.01:
        doc = Jsoup.connect(MEI_URL_090301).get();
        tables_090301 = doc.select(TABLE_SELECTIVE);
    }

    public ArrayList<EnrolleeData> getCourseData(Elements table) {
        ArrayList<EnrolleeData> dataOfCourse = new ArrayList<>();
        int counterOfIds = 0;
        String[] fullName;
        Elements tableOfCourse  = table.get(table.size() - 1).select("tr");    //table of enrollees is the last one

        // Delete table's title:
        tableOfCourse.remove(0);
        tableOfCourse.remove(0);

        for (Element userArr : tableOfCourse) {
            fullName = (userArr.getElementsByTag("td").get(0).text() + " NULL").split(" "); // duct tape for people with no patronic
            dataOfCourse.add(new EnrolleeData.EnrolleeDataBuilder()
                            .id(counterOfIds++) //MEI don't have their ids
                            .surName(fullName[0])
                            .name(fullName[1])
                            .patronymic(fullName[2])
                            .scoresPriority1(getIntFromStr(userArr.getElementsByTag("td").get(2).text()))
                            .scoresPriority2(getIntFromStr(userArr.getElementsByTag("td").get(3).text()))
                            .scoresPriority3(getIntFromStr(userArr.getElementsByTag("td").get(4).text()))
                            .scoresIA(getIntFromStr(userArr.getElementsByTag("td").get(5).text()))
                            .scoresSum(getIntFromStr(userArr.getElementsByTag("td").get(6).text()))
                            .isBringOriginal(isBringOriginal(userArr.getElementsByTag("td").get(7).text()))
                            .build()
            );
        }
        return dataOfCourse;
    }
    @Override
    public Map<String ,ArrayList<EnrolleeData>> getData() {
        Map<String, ArrayList<EnrolleeData>>  dataResultMapOfUniversity = new HashMap<>();
        dataResultMapOfUniversity.put(Courses.c090301.toString(), getCourseData(tables_010302));
        dataResultMapOfUniversity.put(Courses.c090302.toString(), getCourseData(tables_090301));
        return dataResultMapOfUniversity;
    }

    private boolean isBringOriginal(String str) {
        return str.length() == 8;
    }


}
