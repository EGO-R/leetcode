package contest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Code {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        int candidates = Integer.parseInt(scanner.nextLine());
        var set = new HashSet<Character>();
        var result = new LinkedList<String>();

        for (int i = 0; i < candidates; i++) {
            var info = scanner.nextLine().split(",");

            for (int j = 0; j < info[0].length(); j++)
                set.add(info[0].charAt(j));
            for (int j = 0; j < info[1].length(); j++)
                set.add(info[1].charAt(j));
            for (int j = 0; j < info[2].length(); j++)
                set.add(info[2].charAt(j));

            int dateSum = 0;
            for (int j = 0; j < info[3].length(); j++)
                dateSum += info[3].charAt(j) - 48;
            for (int j = 0; j < info[4].length(); j++)
                dateSum += info[4].charAt(j) - 48;

            int charNum = info[0].charAt(0);
            if (charNum >= 'a')
                charNum -= 'a' - 1;
            else
                charNum -= 'A' - 1;

            int code = set.size() + dateSum * 64 + charNum * 256;
            set.clear();


            var hex = Integer.toHexString(code);
            if (hex.length() > 3)
                hex = hex.substring(hex.length() - 3);
            while (hex.length() < 3)
                hex = "0" + hex;

            result.add(hex.toUpperCase());
        }

        result.forEach(code -> System.out.print(code + " "));
    }
}
