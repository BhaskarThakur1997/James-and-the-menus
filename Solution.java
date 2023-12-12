import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TestClass {

    public static void main(String args[]) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input: number of items (n) and number of menus (m)
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // Input: menu details
        int[][] menus = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] menuPrices = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                menus[i][j] = Integer.parseInt(menuPrices[j]);
            }
        }

        // Find and print the most updated menu
        int result = findMostUpdatedMenu(n, m, menus);
        System.out.println(result);
    }

    private static int findMostUpdatedMenu(int n, int m, int[][] menus) {
        int[] maxPrices = new int[m];
        int[] goodPricesCount = new int[n];
        int[] totalPrices = new int[n];

        // Finding maximum prices for each item and updating total prices
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalPrices[j] += menus[j][i];
                maxPrices[i] = Math.max(maxPrices[i], menus[j][i]);
            }
        }

        // Counting good prices for each menu
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (menus[i][j] == maxPrices[j]) {
                    goodPricesCount[i]++;
                }
            }
        }

        // Finding the most updated menu based on criteria
        int maxGoodPrices = 0;
        int mostUpdatedMenu = 0;

        for (int i = 0; i < n; i++) {
            if (goodPricesCount[i] > maxGoodPrices ||
                    (goodPricesCount[i] == maxGoodPrices && calculateAverage(menus[i]) > calculateAverage(menus[mostUpdatedMenu]))) {
                mostUpdatedMenu = i;
                maxGoodPrices = goodPricesCount[i];
            }
        }

        // Returning the index of the most updated menu (1-indexed)
        return mostUpdatedMenu + 1;
    }

    private static double calculateAverage(int[] menu) {
        return Arrays.stream(menu).average().orElse(0);
    }
}
