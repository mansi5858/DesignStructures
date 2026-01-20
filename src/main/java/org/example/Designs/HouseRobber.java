package org.example.Designs;

import java.util.logging.Logger;

public class HouseRobber {

        //static Logger logger = Logger.getLogger("logger");
        public static void main(String[] args)
        {
            HouseRobber houseRobber = new HouseRobber();
            System.out.println("House Robber max profit:"+  houseRobber.rob(new int[]{2,7,9,3,1}) );
        }

        public int rob(int[] nums) {

            if(nums.length == 0)
                return 0;
            if(nums.length == 1)
                return nums[0];

            int[] dp = new int[nums.length];

            dp[0] = nums[0];
            dp[1] = nums[1];

            for(int i=2; i<nums.length; i++)
            {
                dp[i] = Math.max(dp[i-1], nums[i]+ dp[i-2]);
                dp[i-1] = Math.max(dp[i-1], dp[i-2]);
            }

            return Math.max(dp[nums.length-2], dp[nums.length-1]);


        }
    }

