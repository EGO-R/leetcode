package neetcode.medium.koko_eating_bananas;

import java.util.Arrays;

/*
https://leetcode.com/problems/koko-eating-bananas/

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k.
Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more
bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for (int pile : piles) {
            if (pile > right)
                right = pile;
        }

        return binSearch(piles, h, 1, right);
    }

    private int binSearch(int[] piles, int h, int left, int right) {
        int medium = left + (right - left) / 2;

        if (!valid(piles, h, medium))
            return binSearch(piles, h, medium + 1, right);
        else if (valid(piles, h, medium - 1))
            return binSearch(piles, h, left, medium - 1);
        else
            return medium;

    }

    private boolean valid(int[] piles, int h, int k) {
        if (k == 0)
            return false;
        int counter = 0;
        for (int pile : piles) {
            counter += pile / k;
            if (pile % k > 0)
                counter++;
            if (counter > h)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.minEatingSpeed(new int[] {3,6,7,11}, 8));
    }
}
