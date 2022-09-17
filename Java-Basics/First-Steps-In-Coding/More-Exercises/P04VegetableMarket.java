vegetables_price = float(input())
fruits_price = float(input())
vegetables_kg = int(input())
fruits_kg = int(input())

vegetables_sold = vegetables_price * vegetables_kg
fruits_sold = fruits_price * fruits_kg

income_in_eur = (vegetables_sold + fruits_sold) / 1.94

print('{:.2f}'.format(income_in_eur))
