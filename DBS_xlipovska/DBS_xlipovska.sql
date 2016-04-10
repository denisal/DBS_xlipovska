--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-04-10 23:21:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2226 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 24774)
-- Name: alergen; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE alergen (
    id integer NOT NULL,
    nazov character varying(60) NOT NULL,
    popis character varying(150) NOT NULL
);


ALTER TABLE alergen OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 24772)
-- Name: alergen_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE alergen_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE alergen_id_seq OWNER TO postgres;

--
-- TOC entry 2227 (class 0 OID 0)
-- Dependencies: 181
-- Name: alergen_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE alergen_id_seq OWNED BY alergen.id;


--
-- TOC entry 184 (class 1259 OID 24782)
-- Name: alergen_polozky; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE alergen_polozky (
    id integer NOT NULL,
    polozka_id integer NOT NULL,
    alergen_id integer NOT NULL
);


ALTER TABLE alergen_polozky OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 24780)
-- Name: alergen_polozky_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE alergen_polozky_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE alergen_polozky_id_seq OWNER TO postgres;

--
-- TOC entry 2228 (class 0 OID 0)
-- Dependencies: 183
-- Name: alergen_polozky_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE alergen_polozky_id_seq OWNED BY alergen_polozky.id;


--
-- TOC entry 186 (class 1259 OID 24790)
-- Name: casnik; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE casnik (
    id integer NOT NULL,
    meno character varying(20) NOT NULL,
    priezvisko character varying(20) NOT NULL,
    admin boolean NOT NULL,
    datum_prijatia date NOT NULL
);


ALTER TABLE casnik OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 24788)
-- Name: casnik_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE casnik_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE casnik_id_seq OWNER TO postgres;

--
-- TOC entry 2229 (class 0 OID 0)
-- Dependencies: 185
-- Name: casnik_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE casnik_id_seq OWNED BY casnik.id;


--
-- TOC entry 188 (class 1259 OID 24798)
-- Name: objednavka; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE objednavka (
    id integer NOT NULL,
    datum date NOT NULL,
    cas time without time zone NOT NULL,
    vyplatena boolean NOT NULL,
    casnik_id integer NOT NULL,
    stol_id integer NOT NULL
);


ALTER TABLE objednavka OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 24796)
-- Name: objednavka_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE objednavka_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE objednavka_id_seq OWNER TO postgres;

--
-- TOC entry 2230 (class 0 OID 0)
-- Dependencies: 187
-- Name: objednavka_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE objednavka_id_seq OWNED BY objednavka.id;


--
-- TOC entry 202 (class 1259 OID 24915)
-- Name: polozka; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE polozka (
    id integer NOT NULL,
    nazov character varying(50) NOT NULL,
    popis character varying(100) NOT NULL,
    cena real NOT NULL,
    typ_polozky_id integer NOT NULL
);


ALTER TABLE polozka OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24913)
-- Name: polozka_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE polozka_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE polozka_id_seq OWNER TO postgres;

--
-- TOC entry 2231 (class 0 OID 0)
-- Dependencies: 201
-- Name: polozka_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE polozka_id_seq OWNED BY polozka.id;


--
-- TOC entry 190 (class 1259 OID 24814)
-- Name: polozka_objednavky; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE polozka_objednavky (
    id integer NOT NULL,
    pocet_ks integer NOT NULL,
    objednavka_id integer NOT NULL,
    polozka_id integer NOT NULL
);


ALTER TABLE polozka_objednavky OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 24812)
-- Name: polozka_objednavky_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE polozka_objednavky_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE polozka_objednavky_id_seq OWNER TO postgres;

--
-- TOC entry 2232 (class 0 OID 0)
-- Dependencies: 189
-- Name: polozka_objednavky_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE polozka_objednavky_id_seq OWNED BY polozka_objednavky.id;


--
-- TOC entry 192 (class 1259 OID 24822)
-- Name: polozka_uctu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE polozka_uctu (
    id integer NOT NULL,
    polozka_objednavky_id integer NOT NULL,
    ucet_id integer NOT NULL
);


ALTER TABLE polozka_uctu OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 24820)
-- Name: polozka_uctu_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE polozka_uctu_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE polozka_uctu_id_seq OWNER TO postgres;

--
-- TOC entry 2233 (class 0 OID 0)
-- Dependencies: 191
-- Name: polozka_uctu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE polozka_uctu_id_seq OWNED BY polozka_uctu.id;


--
-- TOC entry 194 (class 1259 OID 24830)
-- Name: rezervacia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE rezervacia (
    id integer NOT NULL,
    datum date NOT NULL,
    cas time without time zone NOT NULL,
    poc_osob integer NOT NULL,
    stol_id integer NOT NULL
);


ALTER TABLE rezervacia OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 24828)
-- Name: rezervacia_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE rezervacia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rezervacia_id_seq OWNER TO postgres;

--
-- TOC entry 2234 (class 0 OID 0)
-- Dependencies: 193
-- Name: rezervacia_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE rezervacia_id_seq OWNED BY rezervacia.id;


--
-- TOC entry 196 (class 1259 OID 24838)
-- Name: stol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE stol (
    id integer NOT NULL,
    kapacita integer NOT NULL
);


ALTER TABLE stol OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 24836)
-- Name: stol_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE stol_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stol_id_seq OWNER TO postgres;

--
-- TOC entry 2235 (class 0 OID 0)
-- Dependencies: 195
-- Name: stol_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE stol_id_seq OWNED BY stol.id;


--
-- TOC entry 198 (class 1259 OID 24846)
-- Name: typ_polozky; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE typ_polozky (
    id integer NOT NULL,
    nazov character varying(10) NOT NULL
);


ALTER TABLE typ_polozky OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 24844)
-- Name: typ_polozky_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE typ_polozky_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE typ_polozky_id_seq OWNER TO postgres;

--
-- TOC entry 2236 (class 0 OID 0)
-- Dependencies: 197
-- Name: typ_polozky_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE typ_polozky_id_seq OWNED BY typ_polozky.id;


--
-- TOC entry 200 (class 1259 OID 24854)
-- Name: ucet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE ucet (
    id integer NOT NULL
);


ALTER TABLE ucet OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 24852)
-- Name: ucet_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ucet_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ucet_id_seq OWNER TO postgres;

--
-- TOC entry 2237 (class 0 OID 0)
-- Dependencies: 199
-- Name: ucet_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ucet_id_seq OWNED BY ucet.id;


--
-- TOC entry 2041 (class 2604 OID 24777)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY alergen ALTER COLUMN id SET DEFAULT nextval('alergen_id_seq'::regclass);


--
-- TOC entry 2042 (class 2604 OID 24785)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY alergen_polozky ALTER COLUMN id SET DEFAULT nextval('alergen_polozky_id_seq'::regclass);


--
-- TOC entry 2043 (class 2604 OID 24793)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY casnik ALTER COLUMN id SET DEFAULT nextval('casnik_id_seq'::regclass);


--
-- TOC entry 2044 (class 2604 OID 24801)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY objednavka ALTER COLUMN id SET DEFAULT nextval('objednavka_id_seq'::regclass);


--
-- TOC entry 2051 (class 2604 OID 24918)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY polozka ALTER COLUMN id SET DEFAULT nextval('polozka_id_seq'::regclass);


--
-- TOC entry 2045 (class 2604 OID 24817)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY polozka_objednavky ALTER COLUMN id SET DEFAULT nextval('polozka_objednavky_id_seq'::regclass);


--
-- TOC entry 2046 (class 2604 OID 24825)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY polozka_uctu ALTER COLUMN id SET DEFAULT nextval('polozka_uctu_id_seq'::regclass);


--
-- TOC entry 2047 (class 2604 OID 24833)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rezervacia ALTER COLUMN id SET DEFAULT nextval('rezervacia_id_seq'::regclass);


--
-- TOC entry 2048 (class 2604 OID 24841)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stol ALTER COLUMN id SET DEFAULT nextval('stol_id_seq'::regclass);


--
-- TOC entry 2049 (class 2604 OID 24849)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY typ_polozky ALTER COLUMN id SET DEFAULT nextval('typ_polozky_id_seq'::regclass);


--
-- TOC entry 2050 (class 2604 OID 24857)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ucet ALTER COLUMN id SET DEFAULT nextval('ucet_id_seq'::regclass);


--
-- TOC entry 2198 (class 0 OID 24774)
-- Dependencies: 182
-- Data for Name: alergen; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY alergen (id, nazov, popis) FROM stdin;
1	﻿obilniny obsahujúce lepok	pšenica, raž, jačmeň, ovos, špalda, kamut alebo ich hybridné odrody a výrobky z nich
2	kôrovce	a výrobky z nich
3	vajcia	a výrobky z nich
4	ryby	a výrobky z nich
5	podzemnica olejná (arašidy)	a výrobky z nej
6	sójové bôby (sója)	a výrobky z nich
7	mlieko	a výrobky z neho
8	škrupinové plody	mandle, lieskové orechy, vlašské orechy, kešu orechy, pekanové orechy, para orechy, pistácie, makadamiové orechy a výrobky z nich
9	zeler	a výrobky z neho
10	horčica	a výrobky z nej
11	sezamové semená (sezam)	a výrobky z nich
12	oxid siričitý a siričitany	v koncentráciách vyšších ako 10 mg, ml/kg, l vyjadrené SO2
13	vlčí bôb (lupina)	a výrobky z neho
14	mäkkýše	a výrobky z nich
\.


--
-- TOC entry 2238 (class 0 OID 0)
-- Dependencies: 181
-- Name: alergen_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('alergen_id_seq', 14, true);


--
-- TOC entry 2200 (class 0 OID 24782)
-- Dependencies: 184
-- Data for Name: alergen_polozky; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY alergen_polozky (id, polozka_id, alergen_id) FROM stdin;
11	10	2
12	10	8
13	11	4
14	11	6
15	12	1
16	12	2
17	12	3
18	12	6
19	12	11
20	12	12
21	13	4
22	14	4
23	15	6
24	15	7
25	16	1
26	16	6
27	17	1
28	17	6
\.


--
-- TOC entry 2239 (class 0 OID 0)
-- Dependencies: 183
-- Name: alergen_polozky_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('alergen_polozky_id_seq', 28, true);


--
-- TOC entry 2202 (class 0 OID 24790)
-- Dependencies: 186
-- Data for Name: casnik; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY casnik (id, meno, priezvisko, admin, datum_prijatia) FROM stdin;
1	casnik	cislojeden	f	2016-04-02
\.


--
-- TOC entry 2240 (class 0 OID 0)
-- Dependencies: 185
-- Name: casnik_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('casnik_id_seq', 1, true);


--
-- TOC entry 2204 (class 0 OID 24798)
-- Dependencies: 188
-- Data for Name: objednavka; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY objednavka (id, datum, cas, vyplatena, casnik_id, stol_id) FROM stdin;
14	2016-04-10	22:46:50.10815	f	1	1
\.


--
-- TOC entry 2241 (class 0 OID 0)
-- Dependencies: 187
-- Name: objednavka_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('objednavka_id_seq', 14, true);


--
-- TOC entry 2218 (class 0 OID 24915)
-- Dependencies: 202
-- Data for Name: polozka; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY polozka (id, nazov, popis, cena, typ_polozky_id) FROM stdin;
10	﻿Tom Yum krevetová	Jemne pikantná polievka s krevetami a rezancami	3.25	1
11	Miso	Polievka zo sójových bôbov, tofu, shitake hríbami a wakame rias	1.45000005	1
12	Uramaki ebi tempura	Rolka obalená v sezame, plnená smaženou krevetou, oshinkom-nakladanou reďkovkou 4ks	4.1500001	1
13	Nigiri losos	Losos, ryža	1.45000005	1
14	Maki tuniak	Tuniak, ryža, morská riasa 6ks	4.55000019	1
15	Kuracia Hogayaka	Kuracie restované kúsky, shitake hríby, miso omáčka, ryža	8.94999981	1
16	Domáce udon kuracie	Udon rezance s kuracím mäsom, teriyaki omáčkou a zeleninou	5.94999981	1
17	Spring roll	Rolky plnené ryžou a zeleninou vlastnej výroby	1.95000005	1
18	Pepsi	0.25l	1.38999999	2
19	Mirinda	0.25l	1.38999999	2
20	7UP	0.25l	1.38999999	2
21	Zlatý Bažant 10° - tankový	0.3l	0.850000024	2
22	Zlatý Bažant 10° - tankový	0.5l	1.25	2
23	Cuba libre	0.25l hnedý rum Captain Morgan, Pepsi cola, limetka	3.54999995	2
24	Mojito	0.25l hnedy cukor, mäta, limetka, biely rum Bacardi superior, soda	3.99000001	2
\.


--
-- TOC entry 2242 (class 0 OID 0)
-- Dependencies: 201
-- Name: polozka_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('polozka_id_seq', 24, true);


--
-- TOC entry 2206 (class 0 OID 24814)
-- Dependencies: 190
-- Data for Name: polozka_objednavky; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY polozka_objednavky (id, pocet_ks, objednavka_id, polozka_id) FROM stdin;
10	2	14	11
11	3	14	18
\.


--
-- TOC entry 2243 (class 0 OID 0)
-- Dependencies: 189
-- Name: polozka_objednavky_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('polozka_objednavky_id_seq', 11, true);


--
-- TOC entry 2208 (class 0 OID 24822)
-- Dependencies: 192
-- Data for Name: polozka_uctu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY polozka_uctu (id, polozka_objednavky_id, ucet_id) FROM stdin;
\.


--
-- TOC entry 2244 (class 0 OID 0)
-- Dependencies: 191
-- Name: polozka_uctu_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('polozka_uctu_id_seq', 1, false);


--
-- TOC entry 2210 (class 0 OID 24830)
-- Dependencies: 194
-- Data for Name: rezervacia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY rezervacia (id, datum, cas, poc_osob, stol_id) FROM stdin;
\.


--
-- TOC entry 2245 (class 0 OID 0)
-- Dependencies: 193
-- Name: rezervacia_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('rezervacia_id_seq', 1, false);


--
-- TOC entry 2212 (class 0 OID 24838)
-- Dependencies: 196
-- Data for Name: stol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY stol (id, kapacita) FROM stdin;
1	5
2	2
3	2
4	4
\.


--
-- TOC entry 2246 (class 0 OID 0)
-- Dependencies: 195
-- Name: stol_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('stol_id_seq', 4, true);


--
-- TOC entry 2214 (class 0 OID 24846)
-- Dependencies: 198
-- Data for Name: typ_polozky; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY typ_polozky (id, nazov) FROM stdin;
1	jedlo
2	pitie
\.


--
-- TOC entry 2247 (class 0 OID 0)
-- Dependencies: 197
-- Name: typ_polozky_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('typ_polozky_id_seq', 3, true);


--
-- TOC entry 2216 (class 0 OID 24854)
-- Dependencies: 200
-- Data for Name: ucet; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ucet (id) FROM stdin;
\.


--
-- TOC entry 2248 (class 0 OID 0)
-- Dependencies: 199
-- Name: ucet_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ucet_id_seq', 1, false);


--
-- TOC entry 2053 (class 2606 OID 24779)
-- Name: alergen_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY alergen
    ADD CONSTRAINT alergen_pk PRIMARY KEY (id);


--
-- TOC entry 2055 (class 2606 OID 24787)
-- Name: alergen_polozky_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY alergen_polozky
    ADD CONSTRAINT alergen_polozky_pk PRIMARY KEY (id);


--
-- TOC entry 2057 (class 2606 OID 24795)
-- Name: casnik_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY casnik
    ADD CONSTRAINT casnik_pk PRIMARY KEY (id);


--
-- TOC entry 2059 (class 2606 OID 24803)
-- Name: objednavka_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY objednavka
    ADD CONSTRAINT objednavka_id PRIMARY KEY (id);


--
-- TOC entry 2061 (class 2606 OID 24819)
-- Name: polozka_objednavky_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY polozka_objednavky
    ADD CONSTRAINT polozka_objednavky_pk PRIMARY KEY (id);


--
-- TOC entry 2073 (class 2606 OID 24920)
-- Name: polozka_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY polozka
    ADD CONSTRAINT polozka_pk PRIMARY KEY (id);


--
-- TOC entry 2063 (class 2606 OID 24827)
-- Name: polozka_uctu_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY polozka_uctu
    ADD CONSTRAINT polozka_uctu_pk PRIMARY KEY (id);


--
-- TOC entry 2065 (class 2606 OID 24835)
-- Name: rezervacia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rezervacia
    ADD CONSTRAINT rezervacia_pk PRIMARY KEY (id);


--
-- TOC entry 2067 (class 2606 OID 24843)
-- Name: stol_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stol
    ADD CONSTRAINT stol_pk PRIMARY KEY (id);


--
-- TOC entry 2069 (class 2606 OID 24851)
-- Name: typ_polozky_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY typ_polozky
    ADD CONSTRAINT typ_polozky_pk PRIMARY KEY (id);


--
-- TOC entry 2071 (class 2606 OID 24859)
-- Name: ucet_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ucet
    ADD CONSTRAINT ucet_pk PRIMARY KEY (id);


--
-- TOC entry 2074 (class 2606 OID 24860)
-- Name: alergen_polozky_alergen_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY alergen_polozky
    ADD CONSTRAINT alergen_polozky_alergen_id_fk FOREIGN KEY (alergen_id) REFERENCES alergen(id);


--
-- TOC entry 2075 (class 2606 OID 24946)
-- Name: alergen_polozky_polozka_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY alergen_polozky
    ADD CONSTRAINT alergen_polozky_polozka_id_fk FOREIGN KEY (polozka_id) REFERENCES polozka(id) ON DELETE CASCADE;


--
-- TOC entry 2076 (class 2606 OID 24926)
-- Name: objednavka_casnik_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY objednavka
    ADD CONSTRAINT objednavka_casnik_id_fk FOREIGN KEY (casnik_id) REFERENCES casnik(id) ON DELETE CASCADE;


--
-- TOC entry 2077 (class 2606 OID 24931)
-- Name: objednavka_stol_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY objednavka
    ADD CONSTRAINT objednavka_stol_id_fk FOREIGN KEY (stol_id) REFERENCES stol(id) ON DELETE CASCADE;


--
-- TOC entry 2078 (class 2606 OID 24936)
-- Name: polozka_objednavky_objednavka_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY polozka_objednavky
    ADD CONSTRAINT polozka_objednavky_objednavka_id_fk FOREIGN KEY (objednavka_id) REFERENCES objednavka(id) ON DELETE CASCADE;


--
-- TOC entry 2082 (class 2606 OID 24921)
-- Name: polozka_typ_polozky_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY polozka
    ADD CONSTRAINT polozka_typ_polozky_id_fk FOREIGN KEY (typ_polozky_id) REFERENCES typ_polozky(id);


--
-- TOC entry 2079 (class 2606 OID 24895)
-- Name: polozka_uctu_ucet_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY polozka_uctu
    ADD CONSTRAINT polozka_uctu_ucet_id_fk FOREIGN KEY (ucet_id) REFERENCES ucet(id);


--
-- TOC entry 2081 (class 2606 OID 24900)
-- Name: rezervacia_stol_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rezervacia
    ADD CONSTRAINT rezervacia_stol_id_fk FOREIGN KEY (stol_id) REFERENCES stol(id);


--
-- TOC entry 2080 (class 2606 OID 24905)
-- Name: ucet_polozka_objednavky_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY polozka_uctu
    ADD CONSTRAINT ucet_polozka_objednavky_id_fk FOREIGN KEY (polozka_objednavky_id) REFERENCES polozka_objednavky(id);


--
-- TOC entry 2225 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-10 23:21:25

--
-- PostgreSQL database dump complete
--

