#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

int findMostUpdatedMenu(int n, int m, const vector<vector<int>>& menus) {
    vector<int> maxPrices(m, 0);
    vector<int> goodPricesCount(n, 0);
    vector<int> totalPrices(n, 0);

    // Finding maximum prices for each item and updating total prices
    for (const auto& menu : menus) {
        for (int j = 0; j < m; j++) {
            totalPrices[j] += menu[j];
            maxPrices[j] = max(maxPrices[j], menu[j]);
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
            (goodPricesCount[i] == maxGoodPrices && static_cast<double>(accumulate(menus[i].begin(), menus[i].end(), 0)) / m >
                                                    static_cast<double>(accumulate(menus[mostUpdatedMenu].begin(), menus[mostUpdatedMenu].end(), 0)) / m)) {
            mostUpdatedMenu = i;
            maxGoodPrices = goodPricesCount[i];
        }
    }

    // Returning the index of the most updated menu (1-indexed)
    return mostUpdatedMenu + 1;
}

int main() {
    // Input: number of items (n) and number of menus (m)
    int n, m;
    cin >> n >> m;

    // Input: menu details
    vector<vector<int>> menus(n, vector<int>(m));
    for (auto& menu : menus) {
        for (int j = 0; j < m; j++) {
            cin >> menu[j];
        }
    }

    // Find and print the most updated menu
    int result = findMostUpdatedMenu(n, m, menus);
    cout << result << '\n';

    return 0;
}
