-- INSERT DEFAULT ROLES --
INSERT INTO role (name) values
    ('ADMIN'),          -- ACCESS and RIGHTS to everything --
    ('USER');            -- ACCESS to see courses --

INSERT INTO app_user (first_name, last_name, email, password, ins_date) values
    ('Popescu', 'Maria', 'popescu_maria@gmail.com', 'Maria123', NOW()),
    ('Tanase', 'Andrei', 'tanase_andrei@gmail.com', 'Andrei123', NOW());

INSERT INTO user_role (app_user_id, role_id) values
    (1, 1),
    (2, 2);

INSERT INTO course (name, description, is_enabled, type, owner, ins_date) values
    ('Java', 'Learning Java', true, 'Programming language', 1, NOW());

INSERT INTO user_course (user_id, course_id, is_favourite, is_subscribed, is_done, ins_date) values
    (2, 1, true, true, false, NOW())