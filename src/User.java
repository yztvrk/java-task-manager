/**
 * Sistemi kullanan kullanıcı bilgilerini tutan sınıf.
 * OOP Prensibi: Encapsulation (Kapsülleme)
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String role; // Öğrenci, Yönetici vb.

    // Kurucu Metot (Constructor)
    public User(String firstName, String lastName, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    // --- Getter ve Setter Metotları ---

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    // Kullanıcı kartını ekrana basmak için yardımcı metot
    public void printUserInfo() {
        System.out.println("========================================");
        System.out.println("KULLANICI PROFİLİ");
        System.out.println("========================================");
        System.out.println("Ad Soyad : " + getFullName());
        System.out.println("E-posta  : " + email);
        System.out.println("Rol      : " + role);
        System.out.println("========================================\n");
    }
}// TODO: Add roles
