INSERT INTO styles(style_name)
VALUES (0),
       (1),
       (2)
ON CONFLICT DO NOTHING;