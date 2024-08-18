package contest.three;

import java.util.*;
import java.util.stream.Collectors;

public class Playlists {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var songs = new HashMap<String, Integer>();
        int members = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < members; i++) {
            scanner.nextLine();
            var line = scanner.nextLine();
            for (var song : line.split(" "))
                songs.compute(song, (key, value) -> value == null ? 1 : ++value);
        }

        var list = new ArrayList<String>();

        for (var entry : songs.entrySet()) {
            if (entry.getValue() == members)
                list.add(entry.getKey());
        }


        System.out.println(list.size());
        System.out.println(list.stream().sorted().collect(Collectors.joining(" ")));
    }
}
