-- Table Alergen
CREATE TABLE Alergen (
    id SERIAL UNIQUE,
    nazov varchar(60)  NOT NULL,
    popis varchar(150)  NOT NULL,
    CONSTRAINT Alergen_pk PRIMARY KEY (id)
);

-- Table Alergen_polozky
CREATE TABLE Alergen_polozky (
    id SERIAL UNIQUE,
    Polozka_id int  NOT NULL,
    Alergen_id int  NOT NULL,
    CONSTRAINT Alergen_polozky_pk PRIMARY KEY (id)
);

-- Table Casnik
CREATE TABLE Casnik (
    id SERIAL UNIQUE,
    meno varchar(20)  NOT NULL,
    priezvisko varchar(20)  NOT NULL,
    admin bool  NOT NULL,
    CONSTRAINT Casnik_pk PRIMARY KEY (id)
);

-- Table Objednavka
CREATE TABLE Objednavka (
    id SERIAL UNIQUE,
    datum date  NOT NULL,
    cas time  NOT NULL,
    vyplatena bool  NOT NULL,
    Casnik_id int  NOT NULL,
    Stol_id int  NOT NULL,
    CONSTRAINT objednavka_id PRIMARY KEY (id)
);

-- Table Polozka
CREATE TABLE Polozka (
    id SERIAL UNIQUE,
	nazov varchar(50) NOT NULL,
    popis varchar(100)  NOT NULL,
    cena real  NOT NULL,
    Typ_polozky_id int  NOT NULL,
    CONSTRAINT Polozka_pk PRIMARY KEY (id)
);

-- Table Polozka_objednavky
CREATE TABLE Polozka_objednavky (
    id SERIAL UNIQUE,
    pocet_ks int  NOT NULL,
    Objednavka_id int  NOT NULL,
    Polozka_id int  NOT NULL,
    CONSTRAINT Polozka_objednavky_pk PRIMARY KEY (id)
);

-- Table Polozka_uctu
CREATE TABLE Polozka_uctu (
    id SERIAL UNIQUE,
    Polozka_objednavky_id int  NOT NULL,
    Ucet_id int  NOT NULL,
    CONSTRAINT Polozka_uctu_pk PRIMARY KEY (id)
);

-- Table Rezervacia
CREATE TABLE Rezervacia (
    id SERIAL UNIQUE,
    datum date  NOT NULL,
    cas time  NOT NULL,
    poc_osob int  NOT NULL,
    Stol_id int  NOT NULL,
    CONSTRAINT Rezervacia_pk PRIMARY KEY (id)
);

-- Table Stol
CREATE TABLE Stol (
    id SERIAL UNIQUE,
    kapacita int  NOT NULL,
    CONSTRAINT Stol_pk PRIMARY KEY (id)
);

-- Table Typ_polozky
CREATE TABLE Typ_polozky (
    id SERIAL UNIQUE,
    nazov varchar(10)  NOT NULL,
    CONSTRAINT Typ_polozky_pk PRIMARY KEY (id)
);

-- Table Ucet
CREATE TABLE Ucet (
    id SERIAL UNIQUE,
    CONSTRAINT Ucet_pk PRIMARY KEY (id)
);
 
ALTER TABLE public.alergen_polozky
  ADD CONSTRAINT alergen_polozky_alergen_id_fk FOREIGN KEY (alergen_id)
      REFERENCES public.alergen (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
ALTER TABLE public.alergen_polozky
  ADD CONSTRAINT alergen_polozky_polozka_id_fk FOREIGN KEY (polozka_id)
      REFERENCES public.polozka (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE;
	  
ALTER TABLE public.objednavka
  ADD CONSTRAINT objednavka_casnik_id_fk FOREIGN KEY (casnik_id)
      REFERENCES public.casnik (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE;

ALTER TABLE public.objednavka
  ADD CONSTRAINT objednavka_stol_id_fk FOREIGN KEY (stol_id)
      REFERENCES public.stol (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE;

ALTER TABLE public.polozka
  ADD CONSTRAINT polozka_typ_polozky_id_fk FOREIGN KEY (typ_polozky_id)
      REFERENCES public.typ_polozky (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE public.polozka_objednavky
  ADD CONSTRAINT polozka_objednavky_objednavka_id_fk FOREIGN KEY (objednavka_id)
      REFERENCES public.objednavka (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE;
	  
ALTER TABLE public.polozka_uctu
  ADD CONSTRAINT polozka_uctu_ucet_id_fk FOREIGN KEY (ucet_id)
      REFERENCES public.ucet (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
ALTER TABLE public.polozka_uctu
  ADD CONSTRAINT ucet_polozka_objednavky_id_fk FOREIGN KEY (polozka_objednavky_id)
      REFERENCES public.polozka_objednavky (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
ALTER TABLE public.rezervacia
  ADD CONSTRAINT rezervacia_stol_id_fk FOREIGN KEY (stol_id)
      REFERENCES public.stol (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

