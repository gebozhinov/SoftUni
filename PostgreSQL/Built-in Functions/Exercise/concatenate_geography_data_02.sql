CREATE VIEW view_continents_countries_currencies_details AS
    SELECT concat(ct.continent_name, ': ', ct.continent_code) AS continent_details,
           concat_ws(' - ', cn.country_name, cn.capital, cn.area_in_sq_km, 'km2') AS country_information,
           concat(cr.description, ' (', cr.currency_code, ')') AS currencies
    FROM continents ct
    JOIN countries cn on cn.continent_code = ct.continent_code
    JOIN currencies cr on cr.currency_code = cn.currency_code
    ORDER BY country_information, currencies;
