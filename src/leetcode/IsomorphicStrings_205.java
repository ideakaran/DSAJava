package leetcode;

/** https://leetcode.com/problems/isomorphic-strings/
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Approach
 * 1. find the total number of distinct character in both word.
 * If they are equal then we have some possibility
 * FInd the pattern in t and apply to s. If s satisfies the pattern then isomorphic.
 * To find the pattern of t, just go through each char and create a map of that char
 * to the position.
 *
 */
public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Integer, Character> tMap = new HashMap<>();
        int i = 0;
        for (Character cr : t.toCharArray()) {
            tMap.put(i, cr);
            i++;
        }
        Map<Character, Character> charMap = new HashMap<>();
        String copy = s;
        System.out.println("Initial Copy is::"+copy);


        int j = 0;

        for(Character cr : s.toCharArray()) {
            Character c = charMap.get(cr);
            if(c == null) {
                Character ch = tMap.get(j);
                copy = copy.replaceAll(cr.toString(), ch.toString());
                charMap.put(c, ch);
            }
            j++;
        }
        System.out.println("Copy has become::"+copy);
        return copy.equalsIgnoreCase(t);
    }

    public static void main(String[] args) {
        IsomorphicStrings_205 is = new IsomorphicStrings_205();
        boolean flag = is.isIsomorphic("badc", "baba");
        System.out.println("IsIsoMorphic = " + flag);
    }

}
