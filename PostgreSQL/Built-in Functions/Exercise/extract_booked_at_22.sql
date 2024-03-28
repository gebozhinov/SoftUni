SELECT extract(year from booked_at) as year,
       extract(month from booked_at) as month,
       extract(day from booked_at) as day,
       extract(HOUR from booked_at) as hour,
       extract(minute from booked_at) as minute,
       ceil(extract(second from booked_at)) as second
FROM bookings;
