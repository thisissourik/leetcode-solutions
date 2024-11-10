/*
 * 
You are given a string s and an array of strings words. All the strings of words are of the same length.
A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

 

Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation:
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Explanation:
There is no concatenated substring.

Example 3:
orange Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
Explanation:
The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].

 
 */

import java.util.ArrayList;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String words[] = { "word", "good", "best", "good" };
        String s = "wordgoodgoodgoodbestword";

        ArrayList<Integer> positions = positions(s, words);
        System.out.println(positions);

    }

    // Returns positions
    public static ArrayList<Integer> positions(String s, String words[]) {

        ArrayList<Integer> positions = new ArrayList<Integer>();

        ArrayList<String> listOfWords = permute("", arr2str(words), words[0].length(), new ArrayList<String>());
        int windowLength = words.length * words[0].length();

        for (int i = 0; i <= s.length() - windowLength; i++) {
            String windowString = s.substring(i, i + windowLength);
            for (String permuteWord : listOfWords) {
                if (windowString.equals(permuteWord))
                    positions.add(i);
            }
        }
        return positions.size() == 0 ? new ArrayList<>() : positions;
    }

    // Converting String array to string
    public static String arr2str(String[] words) {
        String res = "";
        for (String word : words) {
            res += word;
        }
        return res;
    }

    // Returns list of all permutations of the words
    public static ArrayList<String> permute(String res, String s, int wl, ArrayList<String> list) {
        if (s.isEmpty()) {
            list.add(res);
            return list;
        }
        for (int i = 0; i < s.length(); i += wl) {
            String ch = s.substring(i, i + wl);
            String rem = s.substring(0, i) + s.substring(i + wl);

            permute(res + ch, rem, wl, list);
        }
        return list;
    }

}