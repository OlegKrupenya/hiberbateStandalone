create table PERSON (
    PERSON_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    AGE INT NOT NULL,
    FIRSTNAME  VARCHAR(50) NOT NULL,
    LASTNAME  VARCHAR(50) NOT NULL
);

alter table person add version integer;

insert into PERSON (AGE, FIRSTNAME, LASTNAME) value (22, 'Ivan', 'Ivanov');
insert into PERSON (AGE, FIRSTNAME, LASTNAME) value (32, 'Petr', 'Petrov');
insert into PERSON (AGE, FIRSTNAME, LASTNAME) value (42, 'Semen', 'Semenov');
commit;