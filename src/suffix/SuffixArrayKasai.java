package suffix;

import java.util.*;

class Suffix implements Comparable<Suffix> {
    int index;
    String suffix;

    Suffix(int index, String suffix) {
        this.index = index;
        this.suffix = suffix;
    }

    public int compareTo(Suffix other) {
        return this.suffix.compareTo(other.suffix);
    }
}

public class SuffixArrayKasai {

    // Build Suffix Array
    static int[] buildSuffixArray(String text) {

        int n = text.length();
        Suffix[] suffixes = new Suffix[n];

        for (int i = 0; i < n; i++) {
            suffixes[i] = new Suffix(i, text.substring(i));
        }

        Arrays.sort(suffixes);

        int[] sa = new int[n];

        for (int i = 0; i < n; i++) {
            sa[i] = suffixes[i].index;
        }

        return sa;
    }

    // Kasai Algorithm
    static int[] buildLCP(String text, int[] sa) {

        int n = text.length();

        int[] rank = new int[n];
        int[] lcp = new int[n];

        // Build Rank Array
        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
            System.out.println("Array element is :" + text.substring(sa[i]));
        }

        int k = 0;

        for (int i = 0; i < n; i++) {

            if (rank[i] == 0) {
                k = 0;
                continue;
            }

            int j = sa[rank[i] - 1];

            while (i + k < n &&
                   j + k < n &&
                   text.charAt(i + k) == text.charAt(j + k)) {
                k++;
            }

            lcp[rank[i]] = k;

            if (k > 0)
                k--;
        }

        return lcp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String text = sc.nextLine();

        int[] sa = buildSuffixArray(text);
        int[] lcp = buildLCP(text, sa);

        System.out.println("\nSuffix Array:");

        System.out.println("Pos\tSA\tSuffix\t\tLCP");

        for (int i = 0; i < sa.length; i++) {
            System.out.println(i + "\t" + sa[i] + "\t" +
                    text.substring(sa[i]) + "\t\t" + lcp[i]);
        }

        System.out.print("\nSA  : ");
        for (int x : sa)
            System.out.print(x + " ");

        System.out.print("\nLCP : ");
        for (int x : lcp)
            System.out.print(x + " ");

        sc.close();
    }
}
