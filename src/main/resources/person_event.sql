create table PERSON_EVENT (
    EVENT_ID BIGINT NOT NULL,
    PERSON_ID BIGINT NOT NULL,
    foreign key (EVENT_ID) references EVENTS(EVENT_ID),
    foreign key (PERSON_ID) references PERSON(PERSON_ID)
);

insert into PERSON_EVENT value (1,1);
insert into PERSON_EVENT value (1,2);
insert into PERSON_EVENT value (1,3);
insert into PERSON_EVENT value (3,1);
insert into PERSON_EVENT value (2,1);
insert into PERSON_EVENT value (2,2);
commit;