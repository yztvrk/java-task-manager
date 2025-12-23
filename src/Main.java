import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Uygulamanın giriş noktası.
 * Kullanıcı ile etkileşime giren konsol arayüzünü (Menu) barındırır.
 */
public class Main {

    // Konsoldan veri okumak için Scanner nesnesi
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Sistem başlatılıyor...");

        // 1. Örnek Kullanıcı Oluştur
        User currentUser = new User("Can", "Öztürk", "can@arel.edu.tr", "Yazılım Kulübü Üyesi");

        // 2. Örnek Proje Oluştur
        Project myProject = new Project("Görev Yönetim Aracı V1", "Java ile OOP Prensipleri Kullanılarak Geliştirilen Proje");

        // 3. Başlangıç için birkaç dummy (hazır) veri ekleyelim ki liste boş görünmesin
        myProject.addTask(new Task("Gereksinim Analizi", "Proje dosyasının okunması", "Yüksek"));
        myProject.addTask(new TimedTask("Veritabanı Tasarımı", "SQL tablolarının çizilmesi", "Orta", LocalDate.now().plusDays(2)));
        myProject.addTask(new TimedTask("Arayüz Kodlaması", "Swing veya JavaFX araştırması", "Düşük", LocalDate.now().minusDays(1))); // Süresi geçmiş görev örneği

        // --- MENÜ DÖNGÜSÜ ---
        boolean isRunning = true;

        while (isRunning) {
            printMenu();
            System.out.print("Seçiminiz (1-5): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    currentUser.printUserInfo();
                    break;
                case "2":
                    myProject.printProjectStatus();
                    break;
                case "3":
                    addNewTaskInteractive(myProject);
                    break;
                case "4":
                    completeTaskInteractive(myProject);
                    break;
                case "5":
                    System.out.println("Sistemden çıkış yapılıyor. İyi günler!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("HATA: Geçersiz seçim! Lütfen tekrar deneyin.");
            }

            // Kullanıcı enter'a basana kadar bekle (Ekran hemen akmasın diye)
            if (isRunning) {
                System.out.println("\nDevam etmek için ENTER tuşuna basın...");
                scanner.nextLine();
            }
        }
    }

    // Menü seçeneklerini ekrana basan yardımcı metot
    private static void printMenu() {
        System.out.println("\n==========================================");
        System.out.println("   AREL GÖREV YÖNETİM SİSTEMİ (V1.0)");
        System.out.println("==========================================");
        System.out.println("1. Kullanıcı Bilgilerini Göster");
        System.out.println("2. Proje Durumunu ve Görevleri Listele");
        System.out.println("3. Yeni Görev Ekle");
        System.out.println("4. Görev Tamamla (ID ile)");
        System.out.println("5. Çıkış");
        System.out.println("==========================================");
    }

    // Kullanıcıdan bilgi alarak görev ekleme metodu
    private static void addNewTaskInteractive(Project project) {
        System.out.println("\n--- YENİ GÖREV EKLEME SİHİRBAZI ---");

        System.out.print("Görev Başlığı: ");
        String title = scanner.nextLine();

        System.out.print("Açıklama: ");
        String desc = scanner.nextLine();

        System.out.print("Öncelik (Düşük/Orta/Yüksek): ");
        String prio = scanner.nextLine();

        System.out.print("Bu görev süreli mi? (E/H): ");
        String isTimed = scanner.nextLine();

        if (isTimed.equalsIgnoreCase("E")) {
            System.out.print("Son Tarih (Yıl-Ay-Gün formatında, örn: 2025-12-31): ");
            String dateStr = scanner.nextLine();
            try {
                LocalDate date = LocalDate.parse(dateStr);
                // Polymorphism: TimedTask nesnesi oluşturup Task listesine atıyoruz
                project.addTask(new TimedTask(title, desc, prio, date));
            } catch (DateTimeParseException e) {
                System.out.println("HATA: Tarih formatı yanlış girildi! Görev eklenemedi.");
            }
        } else {
            project.addTask(new Task(title, desc, prio));
        }
    }

    // ID sorarak görev tamamlama metodu
    private static void completeTaskInteractive(Project project) {
        System.out.println("\n--- GÖREV TAMAMLAMA ---");
        System.out.print("Tamamlanacak görevin ID'sini girin (Listeden bakabilirsiniz): ");
        String id = scanner.nextLine();
        project.completeTaskById(id);
    }
}