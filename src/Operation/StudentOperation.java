package Operation;

import Persons.Student;

public class StudentOperation {
    /**
     * Checks if a student exists based on the student number.
     *
     * @param studentNum The student number
     * @return {@code true} if the student exists, {@code false} otherwise
     */
    public static boolean isStudent(String studentNum) {
        String fileInfo = FileOperation.readDataFromTextFile("students/" + studentNum + ".txt");
        // Modified: Should return true if the student exists.
        return !fileInfo.isEmpty(); // Modified: Should return false if the student doesn't exist.
    }

    /**
     * Retrieves a student object based on the school number.
     *
     * @param schoolNumber The school number of the student
     * @return The student object if found, or {@code null} if not found or in case of errors
     */
    public static Student getStudent(String schoolNumber) {
        String nameSurname;
        int[] grades = new int[5];
        String infos = FileOperation.readDataFromTextFile("students/" + schoolNumber + ".txt");

        if (infos.isEmpty()) {
            return null; // Modified: Should return null if the file is empty.
        }

        String[] parts = infos.split(";");
        nameSurname = parts[0].trim();

        if (parts.length < 2) {
            return null; // Modified: Should return null for invalid file format.
        }

        String[] gradeStrings = parts[1].split(",");
        if (gradeStrings.length != 5) {
            return null; // Modified: Should return null for invalid number of grades.
        }

        for (int i = 0; i < gradeStrings.length; i++) {
            try {
                grades[i] = Integer.parseInt(gradeStrings[i].trim());
            } catch (NumberFormatException e) {
                return null; // Modified: Should return null for invalid grade format.
            }
        }

        return new Student(nameSurname, schoolNumber, grades);
    }
}