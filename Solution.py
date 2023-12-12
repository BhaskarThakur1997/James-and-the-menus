def find_most_updated_menu(n, m, menus):
    max_prices = [0] * m
    good_prices_count = [0] * n
    total_prices = [0] * n

    for i in range(m):
        for j in range(n):
            total_prices[j] += menus[j][i]
            max_prices[i] = max(max_prices[i], menus[j][i])

    for i in range(n):
        for j in range(m):
            if menus[i][j] == max_prices[j]:
                good_prices_count[i] += 1

    max_good_prices = max(good_prices_count)
    most_updated_menu = None

    for i in range(n):
        if good_prices_count[i] == max_good_prices:
            if most_updated_menu is None or (sum(menus[i]) / m) > (sum(most_updated_menu) / m):
                most_updated_menu = menus[i]

    return menus.index(most_updated_menu) + 1

# Sample Input
n, m = map(int, input().split())
menus = [list(map(int, input().split())) for _ in range(n)]

# Sample Output
result = find_most_updated_menu(n, m, menus)
print(result)
