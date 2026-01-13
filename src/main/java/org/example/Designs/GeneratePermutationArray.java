package org.example.Designs;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutationArray {

    public static void main(String[] args) {
        GeneratePermutationArray obj = new GeneratePermutationArray();

        int[] nums = {1,2,3};
        List<List<Integer>> ans = obj.permute(nums);
        System.out.println("All permutations: ");
        for(List<Integer> perm : ans) {
            System.out.println(perm);
        }
    }

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            //List<Integer> lst = new ArrayList(Arrays.asList(nums));
            createSubLists(nums, 0, new boolean[nums.length], new ArrayList<>(), result);
            return result;
        }

        void createSubLists(int[] nums, int ind, boolean[] visited, List<Integer> curr, List<List<Integer>> result)
        {
            if(curr.size() == nums.length)
            {
                result.add(new ArrayList<>(curr));
                return;
            }

            for(int i=0; i<nums.length; i++)
            {
                if(!visited[i])
                {
                    curr.add(nums[i]);
                    visited[i] = true;
                    createSubLists(nums, i+1, visited, curr, result);
                    curr.remove(curr.size()-1);
                    visited[i] = false;
                }
            }



        }


    }

