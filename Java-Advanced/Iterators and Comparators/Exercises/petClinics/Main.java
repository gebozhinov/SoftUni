package iteratorsAndComparators.exercises.petClinics;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Clinic> clinics = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            switch (command) {
                case "Create":
                    String name = input[2];
                    if (input[1].equals("iteratorsAndComparators.exercises.petClinics.Pet")) {
                        int age = Integer.parseInt(input[3]);
                        String kind = input[4];
                        Pet pet = new Pet(name, age, kind);
                        pets.add(pet);
                    } else {
                        int rooms = Integer.parseInt(input[3]);
                        if (rooms % 2 != 0) {
                            Clinic clinic = new Clinic(name, rooms);
                            clinics.add(clinic);
                        } else {
                            System.out.println("Invalid Operation!");
                        }
                    }
                    break;
                case "Add":
                    String petName = input[1];
                    String clinicName = input[2];
                    int petIndex = getPetIndex(pets, petName);
                    int clinicIndex = getClinicIndex(clinics, clinicName);
                    if (petIndex != -1 && clinicIndex != -1) {
                        System.out.println(clinics.get(clinicIndex).addPet(pets.get(petIndex)));
                    } else {
                        System.out.println("false");
                    }
                    break;
                case "Release":
                    String clinic = input[1];
                    int clinicInd = getClinicIndex(clinics, clinic);
                    System.out.println(clinics.get(clinicInd).release());
                    break;
                case "HasEmptyRooms":
                    String cl = input[1];
                    int clIndex = getClinicIndex(clinics, cl);
                    System.out.println(clinics.get(clIndex).hasEmptyRooms());
                    break;
                case "Print":
                    String clinicN = input[1];
                    int getIndex = getClinicIndex(clinics, clinicN);
                    if (input.length == 2) {
                        System.out.print(clinics.get(getIndex));
                    } else {
                        int room = Integer.parseInt(input[2]);
                        if (clinics.get(getIndex).getPet(room - 1) != null) {
                            System.out.println(clinics.get(getIndex).getPet(room - 1));
                        } else {
                            System.out.println("Room empty");
                        }

                    }
                    break;
            }
        }
    }
    public static int getPetIndex(List<Pet> pets, String petName) {
        int index = -1;
        for (int i = 0; i < pets.size(); i++) {
            String currentPet = pets.get(i).getName();
            if (currentPet.equals(petName)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static int getClinicIndex(List<Clinic> clinics, String petName) {
        int index = -1;
        for (int i = 0; i < clinics.size(); i++) {
            String currentClinic = clinics.get(i).getName();
            if (currentClinic.equals(petName)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
