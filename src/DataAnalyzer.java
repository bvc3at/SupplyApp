import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Dmitry on 28.06.2015.
 */
public class DataAnalyzer {
    public static boolean isAmIInFirstWave(ArrayList<EnrolleeData> listOfMembers, int numOfPlanForAcceptance, String course) {
        int numIAmInList = -1;
        EnrolleeData myEnrolleeData =
                course.equals(EnrolleeData.COURSE_FIZ ) ? MyEnrolleeData.myEnrolleDataFiz : MyEnrolleeData.myEnrolleDataInf;
        for (EnrolleeData memberEmrolleData : listOfMembers) {
            if (memberEmrolleData.getScoresIA()+memberEmrolleData.getScoresSum() < myEnrolleeData.getScoresSum()+myEnrolleeData.getScoresIA()
                    && memberEmrolleData.getId() < numOfPlanForAcceptance) {
                return true;
            }
        }
        return false;
    }
    public static ArrayList<EnrolleeData> getListWithMyEnrolleeData(ArrayList<EnrolleeData> membersList, EnrolleeData myEnrolleeData) {
        for (int i = 0; i < membersList.size(); i++) {
            if (membersList.get(i).getScoresIA()+membersList.get(i).getScoresSum() < myEnrolleeData.getScoresIA()+myEnrolleeData.getScoresSum()) {
                EnrolleeData newMyEnrolleeData = myEnrolleeData;
                newMyEnrolleeData.setId(i);
                membersList.add(i, newMyEnrolleeData);
                for (int j = i; j < membersList.size(); j++) {
                    membersList.get(j).setId(membersList.get(j).getId()+1);
                }
                break;
            }
        }
        return membersList;
    }



}
