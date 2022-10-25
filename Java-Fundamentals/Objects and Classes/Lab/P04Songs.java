import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Songs {
    static class Songs {
        String typeList;
        String name;
        String time;

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getTypeList() {
            return this.typeList;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTime() {
            return this.time;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Songs> songsList = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            Songs currentSong = new Songs();
            String[] songData = scanner.nextLine().split("_");
            String songType = songData[0];
            String songName = songData[1];
            String songTime = songData[2];
            currentSong.setTypeList(songType);
            currentSong.setName(songName);
            currentSong.setTime(songTime);
            songsList.add(currentSong);


        }
        String command = scanner.nextLine();
        if (command.equals("all")) {
            for (Songs song : songsList) {
                System.out.println(song.getName());
            }
        } else {
            for (Songs song : songsList) {
                if (song.typeList.equals(command)) {
                    System.out.println(song.getName());
                }
            }
        }

    }
}
