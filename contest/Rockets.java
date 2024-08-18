package contest;

import java.util.*;

public class Rockets {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        var rockets = new HashMap<Integer, int[]>();
        var logs = new ArrayList<int[]>();

        for (int i = 0; i < n; i++) {
            var write = scanner.nextLine().split(" ");

            int time = Integer.parseInt(write[0]) * 24 * 60 + Integer.parseInt(write[1]) * 60 + Integer.parseInt(write[2]);

            logs.add(new int[] {time, Integer.parseInt(write[3]), write[4].charAt(0)});
        }

        Collections.sort(logs, Comparator.comparingInt(value -> value[0]));

        for (var log : logs) {
            if (!rockets.containsKey(log[1]))
                rockets.put(log[1], new int[2]);

            var curr = rockets.get(log[1]);
            if (log[2] == 'A')
                curr[1] = log[0];
            else if (log[2] == 'S' || log[2] == 'C') {
                curr[0] += log[0] - curr[1];
            }
        }

        var mins = rockets.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .mapToInt(entry -> entry.getValue()[0])
                .toArray();

        for (var min : mins)
            System.out.print(min + " ");
    }
}
