import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string s :");
        String s = sc.next();
        System.out.println("Enter length of word list :");
        int size = sc.nextInt();
        String words[] = new String[size];
        System.out.println("Enter word list :");
        for (int i = 0; i < size; i++) {
            words[i] = sc.next();
        }
        System.out.println("Choose which method to use :");
        System.out.println("1. Generate All Permutation + Sliding Window");
        System.out.println("2. HashMap + Sliding Window");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                permutationWithSlidingWindow(s, words);
                break;

            case 2:
                hashmapWithSlidingWindow(s, words);
                break;

            default:
                System.out.println("Wrong choice");
        }
    }

    public static void permutationWithSlidingWindow(String s, String[] words) {
        // Base cases checking
        if (words == null || s.length() < words.length * words[0].length()) {
            // return new ArrayList<Integer>();
            System.out.println("NO POSSIBLE POSITIONS");
            return;
        }
        // stp 1 : convert string arr to single string
        String res = "";
        for (String word : words) {
            res += word;
        }
        // stp 2 : generate permutation and check the string
        ArrayList<Integer> positions = new ArrayList<Integer>();

        ArrayList<String> listOfWords = permute("", res, words[0].length(), new ArrayList<String>());
        int windowLength = words.length * words[0].length();

        System.out.println("Possible Permutations are : ");
        System.out.println(listOfWords);

        for (int i = 0; i <= s.length() - windowLength; i++) {
            String windowString = s.substring(i, i + windowLength);
            for (String permuteWord : listOfWords) {
                if (windowString.equals(permuteWord)) {
                    positions.add(i);
                    System.out.println("Match found : Pos " + i + ", permutation : " + permuteWord);
                }
            }
        }
        if (positions.size() == 0)
            System.out.println("No positions found !");

    }

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

    public static void hashmapWithSlidingWindow(String s, String words[]) {
        ArrayList<Integer> positions = new ArrayList<Integer>();
        // base case 1 if - if array is empty or s < words.length * words[0].length()
        if (words == null || s.length() < words.length * words[0].length()) {
            // return new ArrayList<Integer>();
            System.out.println("NO POSSIBLE POSITIONS");
            return;
        }
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();// To keep track of frequency in words[]

        // Storing frequency of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();
        int windowLength = words.length * words[0].length();

        // Iterate through string s
        for (int i = 0; i <= s.length() - windowLength; i++) {
            HashMap<String, Integer> wordFound = new HashMap<>();

            int j = 0;
            // words.length = length of words[]
            while (j < words.length) {
                // Extract the word
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                System.out.println("word : " + word);

                // Check if word is in wordCount HashMap - if not break - this window does not
                // contain the permutation of words
                if (!wordCount.containsKey(word)) {
                    System.out.println("WINDOW REJECTED : Word not in array");
                    break;
                }
                // if found
                wordFound.put(word, wordFound.getOrDefault(word, 0) + 1);
                // if frequency does not match
                if (wordFound.get(word) > wordCount.get(word)) {
                    System.out.println("WINDOW REJECTED : Word frequency does not match");
                    break;
                }
                j++;

            }
            // check if all words are matched
            if (j == words.length) {
                System.out.println("Position found : " + i);
                positions.add(i);
            }
        }

        // return positions;
        System.out.println("Positions found :");
        System.out.println(positions);

    }
}
