package org.example.Designs;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args)
    {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = obj.minWindow(s, t);
        System.out.println(ans + " is the minimum window substring ");
    }
        static public String minWindow(String s, String t) {

            Map<Character, Integer> mapT = new HashMap<>();
            for(char ch: t.toCharArray())
            {
                mapT.put(ch, mapT.getOrDefault(ch, 0)+1);
            }

            int[] len = new int[]{-1,-1};
            Map<Character, Integer> mapS = new HashMap<>();

            int need = mapT.size(), have = 0;
            int l =0;
            for(int r = 0; r < s.length(); r++)
            {

                char ch = s.charAt(r);
                mapS.put(ch, mapS.getOrDefault(ch, 0)+1);
                if(mapT.containsKey(ch) && mapS.get(ch) == mapT.get(ch))
                    have++;

                while(need == have)
                {
                    if(len[0] == -1 || (r-l) < len[1]-len[0])
                    {
                        len[0] = l;
                        len[1] = r;
                    }

                    char left = s.charAt(l);
                    mapS.put(left, mapS.get(left)-1);

                    if(mapT.containsKey(left) && mapT.get(left)>mapS.get(left))
                        have--;

                    l++;

                }

            }


            return len[0] == -1? "": s.substring(len[0], len[1]+1);
        }
    }


