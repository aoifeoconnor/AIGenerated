INSERT INTO users (username, password, role, unlocked) VALUES
                                                           ('admin', '$2a$12$rU4.Qc3m10eL4NLxbw5EzeZWPWkFuOW.iijb4f/g.Z784Y5ASaxx.', 'ADMIN', true),
                                                           ('user1', '$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu', 'USER', true),
                                                           ('user2', '$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu', 'USER', false);
-- Insert Households
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied) VALUES
                                                                                                  ('ABC1123', 5, 3, true),
                                                                                                  ('ABC2123', 4, 4, true),
                                                                                                  ('ABC3123', 1, 4, true),
                                                                                                  ('ABC4123', 5, 3, false),
                                                                                                  ('ABC5123', 5, 5, false);

-- Insert Pets
INSERT INTO pet (name, animal_type, breed, age, household_eircode) VALUES
                                                                       ('Rabbit 1', 'Rabbit', 'Lionhead', 5, 'ABC5123'),
                                                                       ('Fish 2', 'Fish', 'Goldfish', 4, 'ABC5123'),
                                                                       ('Dog 3', 'Dog', 'Bulldog', 8, 'ABC3123'),
                                                                       ('Rabbit 4', 'Rabbit', 'Lionhead', 7, 'ABC4123'),
                                                                       ('Rabbit 5', 'Rabbit', 'Lionhead', 8, 'ABC2123'),
                                                                       ('Fish 6', 'Fish', 'Goldfish', 13, 'ABC5123'),
                                                                       ('Cat 7', 'Cat', 'Maine Coon', 7, 'ABC1123'),
                                                                       ('Rabbit 8', 'Rabbit', 'Holland Lop', 15, 'ABC5123'),
                                                                       ('Rabbit 9', 'Rabbit', 'Holland Lop', 11, 'ABC4123'),
                                                                       ('Cat 10', 'Cat', 'Maine Coon', 7, 'ABC4123');

