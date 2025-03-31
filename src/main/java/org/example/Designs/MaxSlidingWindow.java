package org.example.Designs;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxSlidingWindow {

    public static void main(String[] args)
    {
        int[] ans = window(new int[]{5,-1,-2,-3,4,5}, 3);
        for(int i=0; i<ans.length; i++)
        {
            System.out.print(ans[i]+",");
        }
        System.out.println(" is Sliding Max Window");


    }


    static int[] window(int[] nums, int k)
    {

        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];

        for(int i=0; i<nums.length; i++)
        {
            while(!deque.isEmpty() && deque.peekFirst() <= i-k)
                deque.pollFirst();
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
            {
                deque.pollLast();
            }

            deque.add(i);
            if(i-k+1>=0)
                ans[i-k+1] = nums[deque.peekFirst()];
        }

        return ans;


    }


}
