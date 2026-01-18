public class ValidationUtils {

    public static boolean isValidAge(int age) {
        return age > 0 && age <= 120;
    }

    public static boolean isValidGrade(double grade) {
        return grade >= 0 && grade <= 100;
    }
}