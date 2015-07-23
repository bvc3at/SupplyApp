
public class EnrolleeData {
    final static public int INT_DATA_ERROR = 0;
    final static public String COURSE_FIZ = "Физика";
    final static public String COURSE_INF = "Информатика";


    final private String name;
    final private String surname;
    final private String patronymic;
    final private int scoresSum;
    final private int scoresPriority1;
    final private int scoresPriority2;
    final private int scoresPriority3;
    final private int scoresIA; //Individual Achievement
    final private boolean isHostelRequire;
    final private boolean isBringOriginal;

    private int id;

    public void setId(int id) {
        this.id = id;
    }
    EnrolleeData(final EnrolleeDataBuilder enrolleeDataBuilder) {
        this.id = enrolleeDataBuilder.getId();
        this.name = enrolleeDataBuilder.getName();
        this.surname = enrolleeDataBuilder.getSurname();
        this.patronymic = enrolleeDataBuilder.getPatronymic();
        this.scoresSum = enrolleeDataBuilder.getScoresSum();
        this.scoresPriority1 = enrolleeDataBuilder.getScoresPriority1();
        this.scoresPriority2 = enrolleeDataBuilder.getScoresPriority2();
        this.scoresPriority3 = enrolleeDataBuilder.getScoresPriority3();
        this.scoresIA = enrolleeDataBuilder.getScoresIA();
        this.isHostelRequire = enrolleeDataBuilder.isHostelRequire();
        this.isBringOriginal = enrolleeDataBuilder.isBringOriginal();
    }
     EnrolleeData(int id, String name, String surname, String patronymic, int scoresSum, int scoresPriority1, int scoresPriority2, int scoresPriority3, int scoresIA, boolean isHostelRequire, boolean isBringOriginal) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.scoresSum = scoresSum;
        this.scoresPriority1 = scoresPriority1;
        this.scoresPriority2 = scoresPriority2;
        this.scoresPriority3 = scoresPriority3;
        this.scoresIA = scoresIA;
        this.isHostelRequire = isHostelRequire;
        this.isBringOriginal = isBringOriginal;
    }

    EnrolleeData(int id, int scoresSum, boolean isBringOriginal) {
        this(id, null, null, null, scoresSum, INT_DATA_ERROR, INT_DATA_ERROR, INT_DATA_ERROR, 0, false, isBringOriginal);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getScoresSum() {
        return scoresSum;
    }

    public int getScoresPriority1() {
        return scoresPriority1;
    }

    public int getScoresPriority2() {
        return scoresPriority2;
    }

    public int getScoresPriority3() {
        return scoresPriority3;
    }

    public int getScoresIA() {
        return scoresIA;
    }

    public boolean isHostelRequire() {
        return isHostelRequire;
    }

    public boolean isBringOriginal() {
        return isBringOriginal;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode()) + ":" +
                String.format("#: %d; Name: %s; Surname: %s; Patronymic: %s; Scores sum: %d; Score1: %d, Score2: %d; Score3: %d; AI: %d " +
                                "Hostel? - " + isHostelRequire() + " Original? - " + isBringOriginal() +  " \n",
                        getId(), getName(), getSurname(), getPatronymic(), getScoresSum(), getScoresPriority1(), getScoresPriority2(),
                        getScoresPriority3(), getScoresIA());
    }
    static public class EnrolleeDataBuilder {
        private String name = null;
        private String surname  = null;
        private String patronymic = null;
        private int scoresSum = 0;
        private int scoresPriority1 = 0;
        private int scoresPriority2 = 0;
        private int scoresPriority3 = 0;
        private int scoresIA = 0; //Individual Achievement
        private boolean isHostelRequire = true;
        private boolean isBringOriginal = true;
        private int id = -1;

        public EnrolleeDataBuilder name(String name) {
            assert name != null;
            this.name = name;
            return this;
        }
        public EnrolleeDataBuilder surName(String surName) {
            assert name != null;
            this.surname = surName;
            return this;
        }
        public EnrolleeDataBuilder patronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }
        public EnrolleeDataBuilder scoresSum(int scoresSum) {
            assert scoresSum != 0;
            this.scoresSum = scoresSum;
            return this;
        }
        public EnrolleeDataBuilder scoresPriority1(int scoresPriority1) {
            this.scoresPriority1 = scoresPriority1;
            return this;
        }
        public EnrolleeDataBuilder scoresPriority2(int scoresPriority2) {
            this.scoresPriority2 = scoresPriority2;
            return this;
        }
        public EnrolleeDataBuilder scoresPriority3(int scoresPriority3) {
            this.scoresPriority3 = scoresPriority3;
            return this;
        }
        public EnrolleeDataBuilder scoresIA(int scoresIA) {
            this.scoresIA = scoresIA;
            return this;
        }
        public EnrolleeDataBuilder isHostelRequire(boolean isHostelRequire) {
            this.isHostelRequire = isHostelRequire;
            return this;
        }
        public EnrolleeDataBuilder isBringOriginal(boolean isBringOriginal) {
            this.isBringOriginal = isBringOriginal;
            return this;
        }
        public EnrolleeDataBuilder id(int id) {
            this.id = id;
            return this;
        }

        String getName() {
            return name;
        }

        String getSurname() {
            return surname;
        }

        String getPatronymic() {
            return patronymic;
        }

        int getScoresSum() {
            return scoresSum;
        }

        int getScoresPriority1() {
            return scoresPriority1;
        }

        int getScoresPriority2() {
            return scoresPriority2;
        }

        int getScoresPriority3() {
            return scoresPriority3;
        }

        int getScoresIA() {
            return scoresIA;
        }
        boolean isHostelRequire() {
            return isHostelRequire;
        }

        boolean isBringOriginal() {
            return isBringOriginal;
        }
        int getId() {
            return id;
        }
        public EnrolleeData build() {
            return new EnrolleeData(this);
        }

    }
}
