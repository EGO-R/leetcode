package other.medium.maximize_distance_to_closest_person;

public class Solution {
    public static int maxDistToClosest(int[] seats) {
        var maxDistance = 0;
        var dist = 0;
        var i = 0;
        while (i < seats.length && seats[i] != 1) {
            dist++;
            i++;
        }
        maxDistance = dist;
        dist = 0;
        while (i < seats.length) {
            if (seats[i] == 1) {
                maxDistance = Integer.max(maxDistance, dist / 2 + dist % 2);
                dist = 0;
            }
            else
                dist++;
            i++;
        }

        return Integer.max(maxDistance, dist);
    }

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[] {1, 0, 0, 0}));
    }
}
