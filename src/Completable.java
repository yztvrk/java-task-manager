/**
 * Bu arayüz, tamamlanabilir (Completable) nitelikteki tüm nesneler
 * için ortak metotları tanımlar.
 * OOP Prensibi: Interface (Arayüz)
 */
public interface Completable {

    // Görevi tamamlandı olarak işaretler
    void complete();

    // Görevin tamamlanıp tamamlanmadığını döner
    boolean isCompleted();

    // Görevin detaylı durumunu metin olarak döner
    String getStatusSummary();
}