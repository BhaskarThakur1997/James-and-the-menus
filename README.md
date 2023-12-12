# James-and-the-menus

# Problem

James visits a restaurant, looks at the menu, and realizes that there is no price on it. Since he wanted to know the prices before he orders, he looked up the restaurant online and found **n** different versions of the menu. He knew from experience that usually the menu which has the maximum number of items that have the maximum price on that item between the menus is the most updated one and if there are multiple menus with that condition the one with the maximum average price is the most updated one. Help him find the most updated menu.

In other words, a price on an item is good if it is the maximum price on that item among all menus, and a menu is the most updated one if it has the maximum number of good prices on it.
If there are multiple menus with the maximum number of good prices, the menu with the higher price average is the most updated one.

# Input format

- The first line contains integers **n** and **m** that denote the number of menus and the number of items on each menu respectively.
- The next **n** line each contains **m** integers represented as **Aij**, the **jith** price on the **ith** menu.

# Output format

Print a single number denoting the number of the most updated menu.

It is guaranteed that the answer is unique.

# Constraints
1 ≤ n,m ≤ 10^3

1 ≤ Aij ≤ 10^9

# Sample Input

3 4

1 2 1 10

3 2 3 4

1 3 3 2

# Sample Output

2

# Explanation

There are 4 items in this example. The maximum price for the first three items is 3 and for the last item is 10.

First menu has only one good price which is the last one, Second menu has 2 good prices on it, which are first and third items and the last menu, has 2 good prices too.

Se between second and third menus, we have to compare averages. Average of second menu is 3+2+3+4/4 = 3 and average of third menu is 1+3+3+2/4 = 2.25, so the second menu would be the answer.
