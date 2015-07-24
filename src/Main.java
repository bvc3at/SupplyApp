import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        //MAMI LOGIC:
//        MAMIReader mamiReader = new MAMIReader();
//        try {
//            mamiReader.readData();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(DataAnalyzer.isAmIInFirstWave(mamiReader.getData().get(Courses.c090301.toString()), (int) MAMIReader.MAP_OF_PLAN_FOR_ACCEPTANCE.get(Courses.c090301.toString()), EnrolleeData.COURSE_INF));
//        System.out.println(DataAnalyzer.getListWithMyEnrolleeData(mamiReader.getData().get(Courses.c090301.toString()), MyEnrolleeData.myEnrolleDataInf));
//        System.out.println("-----------------------------------------------------------------------------------------------------------");
//        System.out.println();
//        System.out.println("-----------------------------------------------------------------------------------------------------------");
//        System.out.println(DataAnalyzer.isAmIInFirstWave(mamiReader.getData().get(Courses.c090302.toString()), (int) MAMIReader.MAP_OF_PLAN_FOR_ACCEPTANCE.get(Courses.c090302.toString()), EnrolleeData.COURSE_INF));
//        System.out.println(DataAnalyzer.getListWithMyEnrolleeData(mamiReader.getData().get(Courses.c090302.toString()), MyEnrolleeData.myEnrolleDataInf));


        MEIReader meiReader = new MEIReader();
        try {
            meiReader.readData();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        Map<String, ArrayList<EnrolleeData>> mapOfMei = meiReader.getData();

        DataAnalyzer.ListOfEnrolleeDataWorker listOfEnrolleeDataWorker = new DataAnalyzer.ListOfEnrolleeDataWorker();

        listOfEnrolleeDataWorker.sortBySum(mapOfMei.get(Courses.c010302.toString()));
        listOfEnrolleeDataWorker.clearAllCopies(mapOfMei.get(Courses.c010302.toString()));
        listOfEnrolleeDataWorker.fixIds(mapOfMei.get(Courses.c010302.toString()));
        System.out.println(mapOfMei.get(Courses.c010302.toString()));

    }

}
