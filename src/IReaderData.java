import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface IReaderData {
    void readData() throws IOException;
    Map<String ,ArrayList<EnrolleeData>> getData();

    public static final HashMap MAP_OF_PLAN_FOR_ACCEPTANCE = new HashMap<String, Integer>();
    public static final HashMap MAP_OF_REQUIRED_EXAMS = new HashMap<String, String>();
}
