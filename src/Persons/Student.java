package Persons;

public class Student {
    private String nameSurname;
    private String schoolNumber;
    private int[] grades;

    public Student(String nameSurname, String schoolNumber, int[] grades) {
        this.nameSurname = nameSurname;
        this.schoolNumber = schoolNumber;
        this.grades = grades;
    }

    // Getter for nameSurname
    public String getNameSurname() {
        return nameSurname;
    }

    // Setter for nameSurname
    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    // Getter for schoolNumber
    public String getSchoolNumber() {
        return schoolNumber;
    }

    // Setter for schoolNumber
    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    // Getter for grades
    public int[] getGrades() {
        return grades;
    }

    // Setter for grades
    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    // Calculate the average grade
    public double calculateAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }
}