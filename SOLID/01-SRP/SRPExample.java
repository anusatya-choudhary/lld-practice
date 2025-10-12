// Single Responsibility Principle
// A class should have only one reason to change => it should have only reason to change

// BAD example : Violating SRP
class UserBad {
    private String name;
    private String email;

    public UserBad(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Many functions in this class
    // Email validation, Save to database, Send email, etc.

    public boolean validateEmail() {
        return email.contains("@");
    }

    public void saveToDatabase(){
        System.out.println("Saving user to database : " + name);
    }

    public void sendEmail(String message){
        System.out.println("Sending email to " + email + " with message: " + message);
    }
}

//GOOD example : Following SRP
class UserGood {
    private String name;
    private String email;

    public UserGood(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }  
}

class EmailValidator {
    public static boolean validateEmail(String email){
        return email != null && email.contains("@");
    }
}

class DatabaseManager {
    public void saveToDatabase(UserGood user){
        System.out.println("Saving user to database : " + user.getName());
    }
}

class EmailSender {
    public void sendEmail(UserGood user, String message){
        System.out.println("Sending email to " + user.getEmail() + " with message: " + message);
    }
}

public class SRPExample {
    public static void main(String[] args) {
        UserGood user = new UserGood("Anusatya", "anusatya.choudhary@gmail.com");

        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.saveToDatabase(user);

        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(user, "Welcome to the platform");
    }
}