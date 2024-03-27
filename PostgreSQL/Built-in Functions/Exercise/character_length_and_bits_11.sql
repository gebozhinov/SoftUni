SELECT concat(m.mountain_range, ' ', p.peak_name) as mountain_information,
       length(concat(m.mountain_range, ' ', p.peak_name)) as characters_length,
       bit_length(concat(m.mountain_range, ' ', p.peak_name)) as bits_of_a_tring
FROM mountains m
JOIN peaks p on p.mountain_id = m.id
