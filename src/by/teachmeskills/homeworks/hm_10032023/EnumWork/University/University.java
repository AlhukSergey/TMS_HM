package by.teachmeskills.homeworks.hm_10032023.EnumWork.University;

public class University {
    private String schoolNumber;
    private int studentsNumber;
    private String season;

    public enum Season {
        WINTER("winter"),
        SPRING("spring"),
        SUMMER("summer"),
        AUTUMN("autumn");

        final String seasonName;

        Season(String seasonName) {
            this.seasonName = seasonName;
        }
    }

    public University(String schoolNumber, int studentsNumber, String season) {
        this.schoolNumber = schoolNumber;
        this.studentsNumber = studentsNumber;
        this.season = season;
    }

    public void showInfo() {
            System.out.println("It's the school " + this.schoolNumber +
                    ", the number of students is " + this.studentsNumber +
                    ", and it's " + this.season +
                    " now, so we're" + (this.season.equals(Season.SUMMER.seasonName) ? " relaxing!" : " studying.."));
    }
}
