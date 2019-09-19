CREATE SCHEMA app
    AUTHORIZATION postgres;

CREATE TABLE app.empresa
(
    id serial not null,
    razao_social character varying(100) NOT NULL,
    cnpj character varying(14) NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    data_atualizacao timestamp without time zone NOT NULL,
    CONSTRAINT empresa_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE app.empresa
    OWNER to postgres;
