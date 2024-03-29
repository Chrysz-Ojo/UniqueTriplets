package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueTriplets {
    public static List<List<Integer>> findTriplets(int[] nums, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1, right = nums.length - 1, sum = target - nums[i];
                while (left < right) {
                    int currentSum = nums[left] + nums[right];
                    if (currentSum == sum) {
                        triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (currentSum < sum) left++;
                    else right--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, -1, -4, -2};
        int target = 1;
        List<List<Integer>> result = findTriplets(nums, target);
        System.out.println("Triplets that sum up to " + target + ": ");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}

