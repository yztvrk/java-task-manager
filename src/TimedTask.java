import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Süreli görevleri temsil eder. Task sınıfından türetilmiştir.
 * OOP Prensibi: Inheritance (Kalıtım)
 */
public class TimedTask extends Task {

    private LocalDate deadline; // Son teslim tarihi

    public TimedTask(String title, String description, String priority, LocalDate deadline) {
        super(title, description, priority); // Ata sınıfın (Task) yapıcısını çağır
        this.deadline = deadline;
    }

    /**
     * Kalan gün sayısını hesaplayan yardımcı metot.
     * @return Kalan gün (Eksi değer dönerse süresi geçmiş demektir)
     */
    public long getDaysRemaining() {
        return ChronoUnit.DAYS.between(LocalDate.now(), deadline);
    }

    // OOP Prensibi: Polymorphism (Çok Biçimlilik)
    // toString metodunu ezerek bu sınıfa özel bir çıktı üretiyoruz.
    @Override
    public String toString() {
        long daysLeft = getDaysRemaining();
        String timeStatus;

        if (isCompleted) {
            timeStatus = "Tamamlandı";
        } else if (daysLeft < 0) {
            timeStatus = "SÜRESİ GEÇTİ! (" + Math.abs(daysLeft) + " gün gecikmeli)";
        } else if (daysLeft == 0) {
            timeStatus = "BUGÜN SON GÜN!";
        } else {
            timeStatus = daysLeft + " gün kaldı";
        }

        return super.toString() + " | Son Tarih: " + deadline + " [" + timeStatus + "]";
    }
}