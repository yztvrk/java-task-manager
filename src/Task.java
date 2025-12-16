import java.util.UUID; // Benzersiz ID oluşturmak için

/**
 * Temel görev sınıfıdır. Tüm görevlerin ortak özelliklerini taşır.
 * OOP Prensibi: Base Class (Temel Sınıf)
 */
public class Task implements Completable {

    // Protected yaparak alt sınıfların (TimedTask) erişmesini sağladık
    protected String id;
    protected String title;
    protected String description;
    protected boolean isCompleted;
    protected String priority; // DÜŞÜK, ORTA, YÜKSEK

    // Yapıcı Metot
    public Task(String title, String description, String priority) {
        // Her göreve rastgele benzersiz bir kod atar (örn: a1b2-c3d4)
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.isCompleted = false;
    }

    // --- Interface Metotlarının Uygulanması (Implementation) ---

    @Override
    public void complete() {
        if (!isCompleted) {
            this.isCompleted = true;
            System.out.println(">>> BİLGİ: '" + title + "' görevi başarıyla tamamlandı.");
        } else {
            System.out.println(">>> UYARI: Bu görev zaten daha önce tamamlanmış!");
        }
    }

    @Override
    public boolean isCompleted() {
        return this.isCompleted;
    }

    @Override
    public String getStatusSummary() {
        return isCompleted ? "TAMAMLANDI" : "DEVAM EDİYOR";
    }

    // --- Getter Metotları ---

    public String getId() { return id; }
    public String getTitle() { return title; }

    // Nesnenin string temsili (Listeleme yaparken güzel görünsün diye)
    @Override
    public String toString() {
        String checkMark = isCompleted ? "[X]" : "[ ]";
        return String.format("%s %s (Öncelik: %s) - ID: %s", checkMark, title, priority, id);
    }
}