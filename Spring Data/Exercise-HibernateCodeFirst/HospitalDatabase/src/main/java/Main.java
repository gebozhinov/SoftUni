import entities.Diagnose;
import entities.Medicament;
import entities.Patient;
import entities.Visitation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("relations");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        System.out.print("Enter patient first name: ");
        String patientFirstName = scanner.nextLine();
        System.out.print("Enter patient last name: ");
        String patientLastName = scanner.nextLine();
        System.out.print("Enter patient birthdate in format \"dd-MM-yyyy\": ");
        String patientBirthDate = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse(patientBirthDate);

        List<Patient> patients = entityManager.createQuery("SELECT p FROM Patient p " +
                        "WHERE p.firstName = :fn AND p.lastName = :ln", Patient.class)
                .setParameter("fn", patientFirstName)
                .setParameter("ln", patientLastName)
                .getResultList();

        Patient patient = null;
        if (patients.isEmpty()) {
            patient = new Patient(patientFirstName, patientLastName,
                    date);
            System.out.println("New patient created!");
        } else {
            patient = patients.get(0);
            System.out.printf("%s %s is back!%n", patientFirstName, patientLastName);
        }
        System.out.println();

        System.out.print("Enter patient visit date in format \"dd-MM-yyyy\": ");
        String patientVisitDate = scanner.nextLine();
        Date visitDate = dateFormat.parse(patientVisitDate);
        patient.getVisitations().add(new Visitation(visitDate));

        System.out.print("Enter diagnose name: ");
        String diagnoseName = scanner.nextLine();
        List<Diagnose> diagnose = entityManager.createQuery("SELECT d FROM Diagnose d WHERE d.name = :d", Diagnose.class)
                .setParameter("d", diagnoseName).getResultList();
        if (diagnose.isEmpty()) {
            patient.getDiagnoses().add(new Diagnose(diagnoseName));
        } else {
            patient.getDiagnoses().add(diagnose.get(0));
        }


        System.out.print("Enter medicament name: ");
        String medicamentName = scanner.nextLine();
        List<Medicament> medicament = entityManager.createQuery("SELECT m FROM Medicament m WHERE m.name = :m", Medicament.class)
                .setParameter("m", medicamentName).getResultList();
        if (medicament.isEmpty()) {
            patient.getMedicament().add(new Medicament(medicamentName));
        } else {
            patient.getMedicament().add(medicament.get(0));
        }

        Patient finalPatient = patient;
        patient.getVisitations()
                        .forEach(visitation -> visitation.setPatient(finalPatient));

        entityManager.persist(patient);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}