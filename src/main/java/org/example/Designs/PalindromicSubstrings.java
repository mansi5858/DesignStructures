package org.example.Designs;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        PalindromicSubstrings obj = new PalindromicSubstrings();

        String s = "abc";
        int ans = obj.countSubstrings(s);

        System.out.println("Number of palindromic substrings: " + ans);
    }
        public int countSubstrings(String s) {

            int count = 0;

            for(int i=0; i<s.length(); i++)
            {
                //odd length
                int l = i, r =i;
                while(l>=0 && r<s.length() && l<=r)
                {
                    if(s.charAt(l) != s.charAt(r))
                        break;
                    l--;
                    r++;
                    count++;
                }

                l= i;
                r = i+1;
                while(l>=0 && r<s.length() && l<r)
                {
                    if(s.charAt(l) != s.charAt(r))
                        break;
                    l--;
                    r++;
                    count++;
                }
            }

            return count;
        }


    }


