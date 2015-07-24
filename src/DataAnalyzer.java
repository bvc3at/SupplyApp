import java.util.*;

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
    public static class ListOfEnrolleeDataWorker {

        public void sortBySum(ArrayList<EnrolleeData> listOfEnrollsData) {
            //Sort by bubble method:
            for (int i = 0; i < listOfEnrollsData.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if (listOfEnrollsData.get(j).getScoresSum() < listOfEnrollsData.get(j+1).getScoresSum()) {
                        Collections.swap(listOfEnrollsData, j, j+1);
                    }
                }
            }
        }
        public void fixIds(ArrayList<EnrolleeData> listOfEnrollsData) {
            int counter = 0;
            for (EnrolleeData aListOfEnrollsData : listOfEnrollsData) {
                aListOfEnrollsData.setId(counter++);
            }
        }
        public void clearAllCopies(ArrayList<EnrolleeData> listOfEnrolleeData) {
            for (int i = 0; i < listOfEnrolleeData.size(); i++) {
                if (!listOfEnrolleeData.get(i).isBringOriginal()) {
                    listOfEnrolleeData.remove(i);
                }
            }
        }


    }


}
