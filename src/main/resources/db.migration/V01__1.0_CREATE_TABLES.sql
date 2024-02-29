
-- Create tables --

CREATE TABLE IF NOT EXISTS role
(
    id bigint NOT NULL DEFAULT nextval('role_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT role_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS app_user
(
    id bigint NOT NULL DEFAULT nextval('app_user_id_seq'::regclass),
    email character varying(255)NOT NULL,
    first_name character varying(255),
    ins_date timestamp(6) without time zone NOT NULL,
    last_name character varying(255),
    password character varying(255),
    CONSTRAINT app_user_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS course
(
    id bigint NOT NULL DEFAULT nextval('course_id_seq'::regclass),
    description character varying(255) ,
    ins_date timestamp(6) without time zone NOT NULL,
    is_enabled boolean,
    name character varying(255) ,
    type character varying(255),
    owner bigint
    CONSTRAINT course_pkey PRIMARY KEY (id)
    CONSTRAINT course_app_user_fk FOREIGN KEY (owner) REFERENCES app_user (id)
);

CREATE TABLE IF NOT EXISTS user_course
(
    id bigint NOT NULL DEFAULT nextval('user_course_id_seq'::regclass),
    ins_date timestamp(6) without time zone NOT NULL,
    is_done boolean,
    is_favourite boolean,
    is_subscribed boolean,
    user_id bigint,
    course_id bigint,
    CONSTRAINT user_course_pkey PRIMARY KEY (id),
    CONSTRAINT user_course_app_user_fk FOREIGN KEY (user_id) REFERENCES app_user (id)
    CONSTRAINT user_course_course_fk FOREIGN KEY (course_id) REFERENCES course (id)
);

CREATE TABLE IF NOT EXISTS user_role
(
    app_user_id bigint NOT NULL,
    role_id bigint NOT NULL,
    CONSTRAINT user_role_role_fk FOREIGN KEY (role_id) REFERENCES role (id)
    CONSTRAINT user_role_app_user_fk FOREIGN KEY (app_user_id) REFERENCES app_user (id)
);




