INSERT INTO categories(name)
VALUES (0),
       (1),
       (2),
       (3)
ON CONFLICT (name) DO NOTHING;