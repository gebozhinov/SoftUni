SELECT peak_name, right(peak_name, 4) as positive_right, right(peak_name, -4) as negative_right
FROM peaks
