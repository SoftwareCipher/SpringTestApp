CREATE TABLE person
(
    id   BIGSERIAL,
    name VARCHAR(100) NOT NULL,
    CONSTRAINT pk_person PRIMARY KEY (id)
);


CREATE TABLE phone
(
    id           BIGSERIAL,
    phone_number VARCHAR(50),
    person_id    BIGSERIAL UNIQUE,
    CONSTRAINT pk_phone PRIMARY KEY (id),
    CONSTRAINT fk_phone_person FOREIGN KEY (person_id)
        REFERENCES person (id) ON DELETE CASCADE
);