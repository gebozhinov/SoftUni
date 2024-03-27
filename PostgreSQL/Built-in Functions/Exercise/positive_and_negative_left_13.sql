SELECT peak_name, left(peak_name, 4) as positive_left, left(peak_name, - 4) as negative_left
FROM peaks
