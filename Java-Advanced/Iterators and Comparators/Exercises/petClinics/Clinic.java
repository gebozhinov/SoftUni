package iteratorsAndComparators.exercises.petClinics;

import java.util.Arrays;
import java.util.Objects;

public class Clinic {
    private String name;
    private Pet[] rooms;

    public Clinic(String name, int rooms) {
        this.name = name;
        this.rooms = new Pet[rooms];

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rooms.length; i++) {
            Pet currentPet = rooms[i];
            if (currentPet == null) {
                sb.append(String.format("Room empty%n"));
            } else {
                String name = currentPet.getName();
                int age = currentPet.getAge();
                String kind = currentPet.getKind();
                sb.append(String.format("%s %d %s%n", name, age, kind));
            }
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet(int index) {
        return rooms[index];
    }

    public boolean addPet(Pet pet) {
        int middleRoom = rooms.length / 2;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = middleRoom + i; j < rooms.length; ) {
                Pet current = rooms[j];
                if (current == null) {
                    rooms[j] = pet;
                    return true;
                }
                break;
            }
            for (int j = middleRoom - 1 - i; j >= 0; ) {
                Pet current = rooms[j];
                if (current == null) {
                    rooms[j] = pet;
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public boolean release() {
        int middleRoom = rooms.length / 2;
        for (int i = middleRoom; i < rooms.length; i++) {
            Pet currentPet = rooms[i];
            if (currentPet != null) {
                rooms[i] = null;
                return true;
            }
        }
        for (int i = 0; i < middleRoom; i++) {
            Pet currentPet = rooms[i];
            if (currentPet != null) {
                rooms[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        int count = (int) Arrays.stream(rooms).filter(Objects::isNull).count();
        return count > 0;
    }
}
