package com.stackroute;
import java.util.*;
import java.lang.*;
import java.io.*;
 class NamitaStringChallenge {
    class Node {
        int index;
        int firstRank;
        int secondRank;
    }

    class SortByRank implements Comparator<Node> {
        public int compare(Node a, Node b){
            /*your code*/
        }
    }

     int checkIt(String s , int n, int q, long K  ) {
         int ans = 0;
            SortByRank sortByRank = new SortByRank();
            Node[] suffix = new Node[n];
                for (int i = 0; i < n; i++) {
                    /*your code*/
                }
                Arrays.sort(suffix, sortByRank);
                int[] orig = new int[n];
                for (int i = 0; i < n; i++) {
                    orig[suffix[i].index] = i;
                }
                for (int k = 2; k < n; k *= 2) {
                    int rank = 0;
                    int prevRank = suffix[0].firstRank;
                    suffix[0].firstRank = 0;
                    for (int i = 1; i < n; i++) {
                        if (prevRank == suffix[i].firstRank &&
                                suffix[i - 1].secondRank == suffix[i].secondRank) {
                            prevRank = suffix[i].firstRank;
                            suffix[i].firstRank = rank;
                        } else {
                            prevRank = suffix[i].firstRank;
                            suffix[i].firstRank = ++rank;
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        /*your code here*/
                    }
                    Arrays.sort(suffix, sortByRank);
                    for (int i = 0; i < n; i++) {
                        orig[suffix[i].index] = i;
                    }
                }

                int[] lcp = new int[n];
                int k = 0;
                for (int i = 0; i < n; i++) {
                    int index = orig[i];
                    if (index == 0) {
                        k = 0;
                        lcp[index] = 0;
                        continue;
                    }
                    int j = suffix[index - 1].index;
                    while (i + k < n && j + k < n) {
                        if (s.charAt(i + k) == s.charAt(j + k)) {
                            k++;
                        } else {
                            break;
                        }
                    }
                    lcp[index] = k;
                    if (k > 0) k--;
                }

                int[][] letters = new int[n][26];
                letters[0][s.charAt(0) - 'a'] = 1;
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < 26; j++) {
                        if (s.charAt(i) == 'a' + j) {
                            letters[i][j] = letters[i - 1][j] + 1;
                        } else {
                            letters[i][j] = letters[i - 1][j];
                        }
                    }
                }

                long[] substrings = new long[n];
                substrings[0] = (long) (n - suffix[0].index);
                for (int i = 1; i < n; i++) {
                    substrings[i] = substrings[i - 1] + (long) (n - suffix[i].index) - (long) lcp[i];
                }
                while (q-- > 0) {

                    if (K > substrings[n - 1]) {
                        System.out.println(-1);
                        continue;
                    }
                    int x = 0;
                    for (int i = 0; i < n; i++) {
                        if (K <= substrings[i]) {
                            x = i;
                            break;
                        }
                    }

                    int i = suffix[x].index;
                    int j = (n - 1) - (int) (substrings[x] - K);
                    if (i == 0) {
                        for (int l = 0; l < 26; l++) {
                            if (letters[j][l] > 0) ans++;
                        }
                    } else {
                        for (int l = 0; l < 26; l++) {
                            if (letters[j][l] - letters[i - 1][l] > 0) ans++;
                        }
                    }
                    System.out.println(ans);

                } return ans;
            }
        }
