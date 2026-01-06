package org.example.Designs;

public class ContainerWithMostWater {

    public static void main(String[] args)
    {
        int ans = maxArea(new int[]{5,-1,-2,-3,4,5});

        System.out.println(ans + " is the container area that can hold max Amount of Water ");


    }
    static public int maxArea(int[] heights) {

        int n= heights.length;

        int l= 0;
        int r = n-1;

        int maxAmount = 0;
        while(l<r)
        {
            int width = r-l;
            if(heights[l] <= heights[r])
            {
                maxAmount = Math.max(maxAmount, heights[l] * width);
                l++;
            }
            else
            {
                maxAmount = Math.max(maxAmount, heights[r] * width);
                r--;
            }

        }

        return maxAmount;


    }


}
