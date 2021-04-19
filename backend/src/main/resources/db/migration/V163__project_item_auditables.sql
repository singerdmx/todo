--
-- Name: note_auditables; Type: TABLE; Schema: public; Owner: postgres
--

DROP TABLE public.note_auditables;

CREATE TABLE public.note_auditables (
    id bigint not null
        constraint note_auditables_pkey
        primary key,
    note_id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    activity character varying(512),
    originator character varying(512) NOT NULL,
    activity_time timestamp,
    action int,
    before_activity text,
    after_activity text
);

ALTER TABLE public.note_auditables OWNER TO postgres;

--
-- Name: note_auditables_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.note_auditables_sequence
    START WITH 100
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE index note_auditables_activity_time_index
	ON note_auditables (activity_time DESC);

ALTER TABLE note_auditables
    ADD CONSTRAINT note_auditables_notes_id_fk
        FOREIGN KEY (note_id) REFERENCES notes
            ON DELETE CASCADE;