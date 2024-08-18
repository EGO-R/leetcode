package neetcode.medium.car_fleet;

import java.util.Arrays;
import java.util.Comparator;

/*
https://leetcode.com/problems/car-fleet/

There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.

You are given two integer array position and speed, both of length n, where position[i] is the starting
mile of the ith car and speed[i] is the speed of the ith car in miles per hour.

A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.

A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of
any car in the fleet.

If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.

Return the number of car fleets that will arrive at the destination.
 */
public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        var pairs = new double[n][];
        for (int i = 0; i < n; i++) {
            pairs[i] = new double[] {position[i], (target - position[i]) * 1.0 / speed[i]};
        }

        Arrays.sort(pairs, Comparator.comparingDouble(pair -> pair[0]));

        int counter = n;
        int previous = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (pairs[previous][1] >= pairs[i][1]) {
                counter--;
            }
            else
                previous = i;
        }

        return counter;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.carFleet(12, new int[] {10,8,0,5,3}, new int[] {2,4,1,1,3}));
    }

}
