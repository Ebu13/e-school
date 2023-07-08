package Operation;

import Persons.Student;

public class ManagerOperation {
    /**
     * Adds a student to the system.
     * Creates a text file for the student and writes their information.
     *
     * @param student The student object to be added.
     */
    public static void addStudent(Student student) {
        FileOperation.createTextFile("students/" + student.getSchoolNumber() + ".txt");
        StringBuilder info = new StringBuilder(student.getNameSurname() + ";");
        for (int i = 0; i < 5; i++) {
            info.append(student.getGrades()[i]).append(",");
        }
        info = new StringBuilder(info.substring(0, info.length() - 1));
        FileOperation.writeTextToFile("students/" + student.getSchoolNumber() + ".txt", info.toString());
    }

    /**
     * Removes a student from the system.
     * Deletes the text file associated with the student.
     *
     * @param schoolNumber The school number of the student to be removed.
     */
    public static void removeStudent(String schoolNumber) {
        FileOperation.deleteTextFile("students/" + schoolNumber + ".txt");
    }

    /**
     * Checks if the given credentials correspond to a manager/admin.
     *
     * @param adminName The admin name to be checked.
     * @param pass      The password to be checked.
     * @return True if the credentials belong to a manager, False otherwise.
     */
    public static boolean isManager(String adminName, String pass) {
        String fileInfo = FileOperation.readDataFromTextFile("managers/" + adminName + ".txt");
        if (fileInfo.length() > 0) {
            fileInfo = fileInfo.substring(0, fileInfo.length() - 1);
        }
        return fileInfo.equals(pass);
    }
}