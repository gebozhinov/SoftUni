INSERT INTO moods(mood_name)
VALUES ('HAPPY'),
       ('SAD'),
       ('INSPIRED')
ON CONFLICT DO NOTHING;