import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ResumeBuilder {
    private String name;
    private String email;
    private String phone;
    private List<String> education;
    private List<String> experience;
    private List<String> skills;
    private Scanner scanner;

    public ResumeBuilder() {
        education = new ArrayList<>();
        experience = new ArrayList<>();
        skills = new ArrayList<>();
        scanner = new Scanner(System.in); // Single Scanner instance
    }

    public void collectBasicInfo() {
        System.out.print("Enter your name (FirstName MiddleName LastName): ");
        name = scanner.nextLine();

        // Validate email
        while (true) {
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        }

        // Validate phone number
        while (true) {
            System.out.print("Enter your phone number: ");
            phone = scanner.nextLine();
            if (isValidPhoneNumber(phone)) {
                break;
            } else {
                System.out.println("Invalid phone number. Please enter a 10-digit number.");
            }
        }
    }

    public void collectEducation() {
        String edu;

        System.out.println(
                "Enter your education details (Institute Name (StartDate - EndDate)) (type 'done' to finish):");
        while (true) {
            edu = scanner.nextLine();
            if (edu.equalsIgnoreCase("done"))
                break;
            if (!edu.trim().isEmpty()) { // Skip blank lines
                education.add(edu);
            }
        }
    }

    public void collectExperience() {
        String exp;

        System.out
                .println("Enter your experience details (Company Name (StartDate - EndDate)) (type 'done' to finish):");
        while (true) {
            exp = scanner.nextLine();
            if (exp.equalsIgnoreCase("done"))
                break;
            if (!exp.trim().isEmpty()) { // Skip blank lines
                experience.add(exp);
            }
        }
    }

    public void collectSkills() {
        String skill;

        System.out.println("Enter your skills (type 'done' to finish):");
        while (true) {
            skill = scanner.nextLine();
            if (skill.equalsIgnoreCase("done"))
                break;
            if (!skill.trim().isEmpty()) { // Skip blank lines
                skills.add(skill);
            }
        }
    }

    public void generateResume() {
        System.out.println("\n\n---------------- Resume ---------------");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);

        System.out.println("\nEducation:");
        for (String edu : education) {
            System.out.println("- " + edu);
        }

        System.out.println("\nExperience:");
        for (String exp : experience) {
            System.out.println("- " + exp);
        }

        System.out.println("\nSkills:");
        for (String skill : skills) {
            System.out.println("- " + skill);
        }
    }

    // Email validation method using regex
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Phone number validation method (assuming a 10-digit number)
    private boolean isValidPhoneNumber(String phone) {
        String phoneRegex = "\\d{10}";
        return phone.matches(phoneRegex);
    }

    public static void main(String[] args) {
        ResumeBuilder builder = new ResumeBuilder();
        builder.collectBasicInfo();
        builder.collectEducation();
        builder.collectExperience();
        builder.collectSkills();
        builder.generateResume();
    }
}
