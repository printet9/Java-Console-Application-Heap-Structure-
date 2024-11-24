import java.util.PriorityQueue;
import java.util.Scanner;

class Patient implements Comparable<Patient> {
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity); // Higher severity first
    }

    @Override
    public String toString() {
        return "Patient: " + name + " | Severity: " + severity;
    }
}

public class PatientPrioritySystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Patient Priority System ===");
            System.out.println("1. Add a new patient");
            System.out.println("2. View highest-priority patient");
            System.out.println("3. Treat highest-priority patient");
            System.out.println("4. View all patients");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter severity level (1 = low, 10 = critical): ");
                    int severity = scanner.nextInt();
                    patientQueue.add(new Patient(name, severity));
                    System.out.println("Patient added successfully!");
                    break;
                case 2:
                    if (!patientQueue.isEmpty()) {
                        System.out.println("Highest-priority patient: " + patientQueue.peek());
                    } else {
                        System.out.println("No patients in the queue.");
                    }
                    break;
                case 3:
                    if (!patientQueue.isEmpty()) {
                        System.out.println("Treating patient: " + patientQueue.poll());
                    } else {
                        System.out.println("No patients to treat.");
                    }
                    break;
                case 4:
                    if (!patientQueue.isEmpty()) {
                        System.out.println("All patients (sorted by severity):");
                        PriorityQueue<Patient> tempQueue = new PriorityQueue<>(patientQueue); // Copy to preserve order
                        while (!tempQueue.isEmpty()) {
                            System.out.println(tempQueue.poll());
                        }
                    } else {
                        System.out.println("No patients in the queue.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Patient Priority System. Stay healthy!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}