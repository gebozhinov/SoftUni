SELECT id, concat_ws(' ', number, street) as address, city_id
FROM addresses
WHERE id >= 20;
