package org.example.Designs;

import java.util.ArrayList;
import java.util.List;

public class GenerateDigitCombination {

    public static void main(String[] args) {
        GenerateDigitCombination obj = new GenerateDigitCombination();

        String digits = "23";
        List<String> ans = obj.letterCombinations(digits);

        System.out.println("All combinations: "+ ans);
    }

        public List<String> letterCombinations(String digits) {

            if(digits.isEmpty())
                return new ArrayList<>();
            char[][] map = new char[][]{
                    {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'},
                    {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
            };

            List<String> answer = new ArrayList<>();
            comb(digits, 0, new char[digits.length()], map, answer);
            return answer;
        }

        void comb(String digit, int ind, char[] curr, char[][] map, List<String> answer)
        {
            if(ind >= digit.length())
            {
                answer.add(new String(curr));
                return;
            }

            for(int i=0; i<map[digit.charAt(ind)-'2'].length; i++)
            {
                curr[ind] = map[digit.charAt(ind)-'2'][i];
                comb(digit, ind+1, curr, map, answer);
            }
        }


    }
