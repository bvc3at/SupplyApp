

public abstract class AbstractReaderFromUrl implements IReaderData{
    final static char[] ARR_OF_DIGIT = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final int NUM_OF_E_CHAR = 1077;
    public static final int NUM_OF_H_CHAR = 1085;

    protected static int getIntFromStr(String str){ //Нет Integer.parseInt(str.trim()); и все похожее не работает. Не знаю почему.
        int startFrom = 0;
        int endAt = str.length()-1;
        searchForStart:for (int i = 0; i < str.length(); i++) {
            for (char anArrOfDigit : ARR_OF_DIGIT) {
                if (str.charAt(i) == anArrOfDigit) {
                    startFrom = i;
                    break searchForStart;
                }
            }
        }
        searchForEnd:for (int i = startFrom; i < str.length(); i++) {
            for (char anArrOfDigit : ARR_OF_DIGIT) {
                if (str.charAt(i) == anArrOfDigit) {
                    continue searchForEnd;
                }
            }
            endAt = i;
            break;
        }
        if (str.substring(startFrom, endAt).length() == 0) {
            return 0;
        }
        return Integer.parseInt(str.substring(startFrom, endAt));
    }
    protected static   boolean isAnswerYesOnRussian(String str) { //По другому не работает. Да, точно.
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == NUM_OF_E_CHAR && str.charAt(i-1) == NUM_OF_H_CHAR) { // Если в слове встречается последовательность "не".
                return false;
            }
        }

        return true ;
    }
}
