CREATE TABLE public.person
(
    id numeric(19,0) NOT NULL,
    first_name character varying(80) COLLATE pg_catalog."default",
    last_name character varying(80) COLLATE pg_catalog."default",
    middle_name character varying(80) COLLATE pg_catalog."default",
    "position" character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT person_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

CREATE TABLE public.contact_type
(
    id numeric(19,0) NOT NULL,
    type character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT contact_type_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;


CREATE TABLE public.contacts
(
    id numeric(19,0) NOT NULL,
    person_id numeric(19,0),
    contact_type_id numeric(19,0),
    "number" character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT contacts_pkey PRIMARY KEY (id),
    CONSTRAINT contacts_contact_type_id_contact_type_id_fkey FOREIGN KEY (contact_type_id)
        REFERENCES public.contact_type (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT contacts_person_id_person_id_fkey FOREIGN KEY (person_id)
        REFERENCES public.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;


