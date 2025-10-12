// Dependency Inversion Principle (DIP) Example
// High-level modules should not depend on low-level modules. Both should depend on abstractions.

// BAD EXAMPLE: Violating DIP
class EmailServiceBad {
    public void sendEmail(String message) {
        System.out.println("Sending email with message: " + message);
    }
}

class SMSServiceBad {
    public void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}

class NotificationServiceBad {
    private EmailServiceBad emailService;
    private SMSServiceBad smsService;

    public NotificationServiceBad(EmailServiceBad emailService, SMSServiceBad smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void sendNotificationBySMS(String message) {
        smsService.sendSMS(message);
    }

    public void sendNotificationByEmail(String message) {
        emailService.sendEmail(message);
    }
}

// GOOD example : Following DIP

interface NotificationChannel {
    void send(String message);
}

class EmailService implements NotificationChannel {
    @Override
    public void send(String message) {
        System.out.println("Sending email with message: " + message);
    }
}

class SMSService implements NotificationChannel {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}

class NotificationService {
    private NotificationChannel notificationChannel;

    public NotificationService(NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
    }

    public void sendNotification(String message) {
        notificationChannel.send(message);
    }
}

class DIPExample {
    public static void main(String[] args) {
        NotificationChannel emailChannel = new EmailService();
        NotificationChannel smsChannel = new SMSService();

        NotificationService notificationService = new NotificationService(emailChannel);
        notificationService.sendNotification("Hello, this is an email notification");

        notificationService = new NotificationService(smsChannel);
        notificationService.sendNotification("Hello, this is an SMS notification");
    }
}
