INSERT INTO categories(name)
VALUES (0),
       (1),
       (2)
ON CONFLICT (name) DO NOTHING;