package suffix;

import java.util.*;


public class SearchSuggestions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String query = sc.nextLine();

        int n = text.length();
        Integer[] suffix = new Integer[n];

        for (int i = 0; i < n; i++)
            suffix[i] = i;

        Arrays.sort(suffix, (a, b) ->
            text.substring(a).compareTo(text.substring(b)));

        int low = 0, high = n - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            String s = text.substring(suffix[mid]);

            if (s.startsWith(query)) {
                found = true;
                break;
            } else if (s.compareTo(query) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(found ? "YES" : "NO");
        sc.close();
    }
}