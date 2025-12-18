import java.util.ArrayList;
import java.util.List;

/**
 * Bir projeyi ve içindeki görevleri yöneten sınıf.
 * Görev listesi (ArrayList) barındırır.
 */
public class Project {
    private String projectName;
    private String projectDescription;
    private List<Task> taskList; // Polymorphism: List içinde hem Task hem TimedTask tutabiliriz

    public Project(String projectName, String projectDescription) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (task != null) {
            taskList.add(task);
            System.out.println(">> Görev eklendi: " + task.getTitle());
        }
    }

    // ID'ye göre görevi bulup tamamlayan metot
    public void completeTaskById(String id) {
        boolean found = false;
        for (Task t : taskList) {
            if (t.getId().equals(id)) {
                t.complete();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("HATA: " + id + " numaralı ID'ye sahip görev bulunamadı!");
        }
    }

    public void printProjectStatus() {
        System.out.println("\n#################################################");
        System.out.println("PROJE: " + projectName.toUpperCase());
        System.out.println("Açıklama: " + projectDescription);
        System.out.println("Toplam Görev Sayısı: " + taskList.size());
        System.out.println("#################################################");

        if (taskList.isEmpty()) {
            System.out.println("   (Henüz görev eklenmemiş)");
        } else {
            for (Task t : taskList) {
                System.out.println(t.toString());
                System.out.println("-------------------------------------------------");
            }
        }
        System.out.println("\n");
    }
}