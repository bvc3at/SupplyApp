
public enum Courses {
    c090301("09.03.01"), c090302("09.03.02"), c090303("09.03.03"), c090304("09.03.04"), c010302("01.03.02");
    final String course;
    Courses(final String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return course;
    }


}
