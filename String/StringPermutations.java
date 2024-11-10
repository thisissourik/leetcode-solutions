import java.util.ArrayList;

public class StringPermutations {

    public static void main(String[] args) {
        String words[] = { "foo", "the", "bar" };
        String res = arr2str(words);
        ArrayList<String> lst = permute("", res, words[0].length(), new ArrayList<>());
        System.out.println(lst);
    }

    public static String arr2str(String[] words) {
        String res = "";
        for (String word : words) {
            res += word;
        }
        return res;
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
}
