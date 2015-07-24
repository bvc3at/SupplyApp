/**
 * Created by Dmitry on 27.06.2015. 18
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MAMIReader extends AbstractReaderFromUrl{

    private static final String URL_MAMI = "http://mami.ru/index.php?id=2340";
    public static final int NUM_OF_TABLE_090301 = 18;
    public static final int NUM_OF_TABLE_090302 = 20;
    private Elements tables;
    public static final HashMap MAP_OF_PLAN_FOR_ACCEPTANCE = new HashMap<String, Integer>()
        {{put(Courses.c090301.toString(), 19);}{put(Courses.c090302.toString(),45);}};
    public static final HashMap MAP_OF_REQUIRED_EXAMS = new HashMap<String, String>()
    {{put(Courses.c090301.toString(), EnrolleeData.COURSE_FIZ);}{put(Courses.c090302.toString(), EnrolleeData.COURSE_INF);}};

    @Override
    public void readData() throws IOException {
        Document doc =  Jsoup.connect(URL_MAMI).get();
        tables = doc.select("table");
    }
    private ArrayList<EnrolleeData> getCourseData(int numOfTable) {
        ArrayList<EnrolleeData> dataOfCourse = new ArrayList<>();
        Elements tableOfCourse  = tables.get(numOfTable).select("tr");    //Таблица поступающих на перпеданное направление
        tableOfCourse.remove(0);        // Удаляем заголовок таблицы
        for (Element userArr : tableOfCourse) {
            userArr.getElementsByTag("td");
            dataOfCourse.add(new EnrolleeData.EnrolleeDataBuilder()
                            .id(getIntFromStr(userArr.getElementsByTag("td").get(0).text()))
                            .name(userArr.getElementsByTag("td").get(2).text())
                            .surName(userArr.getElementsByTag("td").get(1).text())
                            .patronymic(userArr.getElementsByTag("td").get(3).text())
                            .scoresSum(getIntFromStr(userArr.getElementsByTag("td").get(10).text()))
                            .scoresPriority1(getIntFromStr(userArr.getElementsByTag("td").get(5).text()))
                            .scoresPriority2(getIntFromStr(userArr.getElementsByTag("td").get(6).text()))
                            .scoresPriority3(getIntFromStr(userArr.getElementsByTag("td").get(7).text()))
                            .scoresIA(getIntFromStr(userArr.getElementsByTag("td").get(9).text()))
                            .isBringOriginal(isAnswerYesOnRussian(userArr.getElementsByTag("td").get(11).text()))
                            .isHostelRequire(isAnswerYesOnRussian(userArr.getElementsByTag("td").get(12).text()))
                            .build());
        }
        return dataOfCourse;
    }

    @Override
    public Map<String ,ArrayList<EnrolleeData>> getData() {
        Map<String, ArrayList<EnrolleeData>>  dataResultMapOfUniversity = new HashMap<>();
        dataResultMapOfUniversity.put(Courses.c090301.toString(), getCourseData(NUM_OF_TABLE_090301));
        dataResultMapOfUniversity.put(Courses.c090302.toString(), getCourseData(NUM_OF_TABLE_090302));
        return dataResultMapOfUniversity;
    }

}
