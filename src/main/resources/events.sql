create table EVENTS (
    EVENT_ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    EVENT_DATE DATE NOT NULL,
    TITLE  VARCHAR(50) NOT NULL
);

insert into EVENTS (EVENT_DATE, TITLE) values (NOW(), 'Event 1');
insert into EVENTS (EVENT_DATE, TITLE) values (NOW(), 'Event 2');
insert into EVENTS (EVENT_DATE, TITLE) values (NOW(), 'Event 3');
insert into EVENTS (EVENT_DATE, TITLE) values (NOW(), 'Event 4');
insert into EVENTS (EVENT_DATE, TITLE) values (NOW(), 'Event 5');
commit;