import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        MAMIReader mamiReader = new MAMIReader();
        try {
            mamiReader.readData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(DataAnalyzer.isAmIInFirstWave(mamiReader.getData().get(Courses.c090301.toString()), (int) MAMIReader.MAP_OF_PLAN_FOR_ACCEPTANCE.get(Courses.c090301.toString()), EnrolleeData.COURSE_INF));
        System.out.println(DataAnalyzer.getListWithMyEnrolleeData(mamiReader.getData().get(Courses.c090301.toString()), MyEnrolleeData.myEnrolleDataInf));
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println(DataAnalyzer.isAmIInFirstWave(mamiReader.getData().get(Courses.c090302.toString()), (int) MAMIReader.MAP_OF_PLAN_FOR_ACCEPTANCE.get(Courses.c090302.toString()), EnrolleeData.COURSE_INF));
        System.out.println(DataAnalyzer.getListWithMyEnrolleeData(mamiReader.getData().get(Courses.c090302.toString()), MyEnrolleeData.myEnrolleDataInf));

    }

}
