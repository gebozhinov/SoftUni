from math import floor

length_in_centimetres = float(input()) * 100
width_in_centimetres = float(input()) * 100

desks = floor((width_in_centimetres - 100) / 70)
rows = floor(length_in_centimetres / 120)

workplaces = floor(desks * rows) - 3

print(workplaces)
