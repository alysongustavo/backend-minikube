CREATE SEQUENCE public.seq_category;

CREATE TABLE public.category (
    id bigint NOT NULL DEFAULT nextval('public.seq_category'::regclass),
    name character varying(255) NOT NULL,
    PRIMARY KEY (id)
);
