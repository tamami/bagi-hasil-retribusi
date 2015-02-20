--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2015-02-07 21:57:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 177 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1996 (class 0 OID 0)
-- Dependencies: 177
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 75744)
-- Name: ref_jenis_retribusi; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE ref_jenis_retribusi (
    kode_retribusi character(2) NOT NULL,
    nama_retribusi character varying(250)
);


ALTER TABLE public.ref_jenis_retribusi OWNER TO perimbangan;

--
-- TOC entry 170 (class 1259 OID 75729)
-- Name: ref_kecamatan; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE ref_kecamatan (
    kode_kecamatan character(3) NOT NULL,
    nama_kecamatan character varying(50)
);


ALTER TABLE public.ref_kecamatan OWNER TO perimbangan;

--
-- TOC entry 171 (class 1259 OID 75734)
-- Name: ref_kelurahan; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE ref_kelurahan (
    kode_kecamatan character(3) NOT NULL,
    kode_kelurahan character(3) NOT NULL,
    nama_kelurahan character varying(30)
);


ALTER TABLE public.ref_kelurahan OWNER TO perimbangan;

--
-- TOC entry 175 (class 1259 OID 83933)
-- Name: ref_skpd; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE ref_skpd (
    kode_skpd character(2) NOT NULL,
    nama_skpd character varying(100)
);


ALTER TABLE public.ref_skpd OWNER TO perimbangan;

--
-- TOC entry 173 (class 1259 OID 75749)
-- Name: ref_user; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE ref_user (
    nip character(18) NOT NULL,
    nama character varying(40),
    login character varying(20) NOT NULL,
    password character varying(250),
    menu character varying NOT NULL,
    kode_skpd character(2) NOT NULL
);


ALTER TABLE public.ref_user OWNER TO perimbangan;

--
-- TOC entry 174 (class 1259 OID 83918)
-- Name: tr_potensi; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE tr_potensi (
    kode_retribusi character(2) NOT NULL,
    kode_kecamatan character(3) NOT NULL,
    kode_kelurahan character(3) NOT NULL,
    tahun_potensi character(4) NOT NULL,
    nilai_potensi numeric,
    bulan_potensi numeric DEFAULT 1 NOT NULL
);


ALTER TABLE public.tr_potensi OWNER TO perimbangan;

--
-- TOC entry 176 (class 1259 OID 83938)
-- Name: tr_realisasi; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE tr_realisasi (
    nomor numeric NOT NULL,
    tanggal_realisasi date NOT NULL,
    kode_retribusi character(2) NOT NULL,
    thn_retribusi character(4) NOT NULL,
    nilai_realisasi numeric DEFAULT 0,
    kode_skpd character(2) NOT NULL
);


ALTER TABLE public.tr_realisasi OWNER TO perimbangan;

--
-- TOC entry 1984 (class 0 OID 75744)
-- Dependencies: 172
-- Data for Name: ref_jenis_retribusi; Type: TABLE DATA; Schema: public; Owner: perimbangan
--

COPY ref_jenis_retribusi (kode_retribusi, nama_retribusi) FROM stdin;
01	RETRIBUSI PERSAMPAHAN/KEBERSIHAN
02	RETRIBUSI PARKIR TEPI JALAN
03	RETRIBUSI PASAR
04	RETRIBUSI PKB
05	RETRIBUSI PEMAKAIAN KEKAYAAN DAERAH
06	RETRIBUSI TEMPAT PELELANGAN
07	RETRIBUSI TERMINAL
08	RETRIBUSI TEMPAT PENGINAPAN / VILLA
09	RETRIBUSI RPH
10	RETRIBUSI RETRIBUSI PELAYANAN KEPELABUHAN
11	RETRIBUSI TEMPAT REKREASI DAN OLAH RAGA
12	RETRIBUSI PENGGUNAAN RUAS JALAN
13	RETRIBUSI IMB
14	RETRIBUSI IZIN GANGGUAN / KERAMAIAN
15	RETRIBUSI IZIN TRAYEK
16	RETRIBUSI MENARA TELEKOMUNIKASI
\.


--
-- TOC entry 1982 (class 0 OID 75729)
-- Dependencies: 170
-- Data for Name: ref_kecamatan; Type: TABLE DATA; Schema: public; Owner: perimbangan
--

COPY ref_kecamatan (kode_kecamatan, nama_kecamatan) FROM stdin;
010	SALEM
020	BANTARKAWUNG
030	BUMIAYU
040	PAGUYANGAN
050	SIRAMPOG
060	TONJONG
070	LARANGAN
080	KETANGGUNGAN
090	BANJARHARJO
100	LOSARI
110	TANJUNG
120	KERSANA
130	BULAKAMBA
140	WANASARI
150	JATIBARANG
170	SONGGOM
160	BREBES
\.


--
-- TOC entry 1983 (class 0 OID 75734)
-- Dependencies: 171
-- Data for Name: ref_kelurahan; Type: TABLE DATA; Schema: public; Owner: perimbangan
--

COPY ref_kelurahan (kode_kecamatan, kode_kelurahan, nama_kelurahan) FROM stdin;
010	001	GUNUNGJAYA
010	002	INDRAJAYA
010	003	BANJARAN
010	004	SALEM
010	005	GUNUNGLARANG
010	006	GUNUNGSUGIH
010	007	GANGGAWANG
010	008	CITIMBANG
010	009	KADUMANIS
010	010	GENDOWANG
010	011	CIPUTIH
010	012	BENTARSARI
010	013	BENTAR
010	014	PABUARAN
010	015	TEMBONGRAJA
010	016	GUNUNGTAJEM
010	017	WINDUSAKTI
010	018	WINDUASRI
010	019	CAPAR
010	020	WANOJA
010	021	PASIRPANJANG
020	001	CINANAS
020	002	BANJARSARI
020	003	CIBENTANG
020	004	TLAGA
020	005	KARANGPARI
020	006	WARU
020	007	PANGEBATAN
020	008	CIOMAS
020	009	TAMBAKSERANG
020	010	LEGOK
020	011	TERLAYA
020	012	JIPANG
020	013	BANTARKAWUNG
020	014	BANGBAYANG
020	015	BANTARWARU
020	016	SINDANGWANGI
020	017	PENGARASAN
020	018	KEBANDUNGAN
030	001	PRUWATAN
030	002	LAREN
030	003	JATISAWIT
030	004	NEGARADAHA
030	005	KALIERANG
030	006	LANGKAP
030	007	ADISANA
030	008	PENGGARUTAN
030	009	DUKUHTURI
030	010	BUMIAYU
030	011	KALIWADAS
030	012	PAMIJEN
030	013	KALISUMUR
030	014	KALILANGKAP
030	015	KALINUSU
\.


--
-- TOC entry 1987 (class 0 OID 83933)
-- Dependencies: 175
-- Data for Name: ref_skpd; Type: TABLE DATA; Schema: public; Owner: perimbangan
--

COPY ref_skpd (kode_skpd, nama_skpd) FROM stdin;
01	DPPK
02	DINAS KESEHATAN
03	DINAS PENDIDIKAN
04	DINAS PERHUBUNGAN
\.


--
-- TOC entry 1985 (class 0 OID 75749)
-- Dependencies: 173
-- Data for Name: ref_user; Type: TABLE DATA; Schema: public; Owner: perimbangan
--

COPY ref_user (nip, nama, login, password, menu, kode_skpd) FROM stdin;
198404092010011025	ADMIN	ADMIN	êä‹\v$Ýï¨	1111111111111	01
\.


--
-- TOC entry 1986 (class 0 OID 83918)
-- Dependencies: 174
-- Data for Name: tr_potensi; Type: TABLE DATA; Schema: public; Owner: perimbangan
--

COPY tr_potensi (kode_retribusi, kode_kecamatan, kode_kelurahan, tahun_potensi, nilai_potensi, bulan_potensi) FROM stdin;
\.


--
-- TOC entry 1988 (class 0 OID 83938)
-- Dependencies: 176
-- Data for Name: tr_realisasi; Type: TABLE DATA; Schema: public; Owner: perimbangan
--

COPY tr_realisasi (nomor, tanggal_realisasi, kode_retribusi, thn_retribusi, nilai_realisasi, kode_skpd) FROM stdin;
1	2015-02-04	02	2015	11000	01
2	2015-02-04	02	2015	20000	01
3	2015-02-04	02	2015	25000	01
\.


--
-- TOC entry 1855 (class 2606 OID 75748)
-- Name: ref_jenis_retribusi_fk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY ref_jenis_retribusi
    ADD CONSTRAINT ref_jenis_retribusi_fk PRIMARY KEY (kode_retribusi);


--
-- TOC entry 1851 (class 2606 OID 75733)
-- Name: ref_kecamatan_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY ref_kecamatan
    ADD CONSTRAINT ref_kecamatan_pk PRIMARY KEY (kode_kecamatan);


--
-- TOC entry 1853 (class 2606 OID 75738)
-- Name: ref_kelurahan_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY ref_kelurahan
    ADD CONSTRAINT ref_kelurahan_pk PRIMARY KEY (kode_kecamatan, kode_kelurahan);


--
-- TOC entry 1864 (class 2606 OID 83937)
-- Name: ref_skpd_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY ref_skpd
    ADD CONSTRAINT ref_skpd_pk PRIMARY KEY (kode_skpd);


--
-- TOC entry 1858 (class 2606 OID 75756)
-- Name: ref_user_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY ref_user
    ADD CONSTRAINT ref_user_pk PRIMARY KEY (nip);


--
-- TOC entry 1862 (class 2606 OID 84031)
-- Name: tr_potensi_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY tr_potensi
    ADD CONSTRAINT tr_potensi_pk PRIMARY KEY (kode_retribusi, kode_kecamatan, kode_kelurahan, tahun_potensi, bulan_potensi);


--
-- TOC entry 1867 (class 2606 OID 83946)
-- Name: tr_realisasi_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY tr_realisasi
    ADD CONSTRAINT tr_realisasi_pk PRIMARY KEY (nomor, tanggal_realisasi);


--
-- TOC entry 1859 (class 1259 OID 83969)
-- Name: fki_kelurahan_fk; Type: INDEX; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE INDEX fki_kelurahan_fk ON tr_potensi USING btree (kode_kelurahan, kode_kecamatan);


--
-- TOC entry 1860 (class 1259 OID 83963)
-- Name: fki_ref_kecamatan_fk; Type: INDEX; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE INDEX fki_ref_kecamatan_fk ON tr_potensi USING btree (kode_kecamatan);


--
-- TOC entry 1856 (class 1259 OID 83952)
-- Name: fki_ref_skpd_fk; Type: INDEX; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE INDEX fki_ref_skpd_fk ON ref_user USING btree (kode_skpd);


--
-- TOC entry 1865 (class 1259 OID 83975)
-- Name: fki_retribusi_fk; Type: INDEX; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE INDEX fki_retribusi_fk ON tr_realisasi USING btree (kode_retribusi);


--
-- TOC entry 1872 (class 2606 OID 83964)
-- Name: kelurahan_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_potensi
    ADD CONSTRAINT kelurahan_fk FOREIGN KEY (kode_kelurahan, kode_kecamatan) REFERENCES ref_kelurahan(kode_kelurahan, kode_kecamatan);


--
-- TOC entry 1871 (class 2606 OID 83958)
-- Name: ref_kecamatan_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_potensi
    ADD CONSTRAINT ref_kecamatan_fk FOREIGN KEY (kode_kecamatan) REFERENCES ref_kecamatan(kode_kecamatan);


--
-- TOC entry 1868 (class 2606 OID 75739)
-- Name: ref_kelurahan_ref_kecamatan; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY ref_kelurahan
    ADD CONSTRAINT ref_kelurahan_ref_kecamatan FOREIGN KEY (kode_kecamatan) REFERENCES ref_kecamatan(kode_kecamatan);


--
-- TOC entry 1870 (class 2606 OID 83953)
-- Name: ref_retribusi_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_potensi
    ADD CONSTRAINT ref_retribusi_fk FOREIGN KEY (kode_retribusi) REFERENCES ref_jenis_retribusi(kode_retribusi);


--
-- TOC entry 1869 (class 2606 OID 83947)
-- Name: ref_skpd_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY ref_user
    ADD CONSTRAINT ref_skpd_fk FOREIGN KEY (kode_skpd) REFERENCES ref_skpd(kode_skpd);


--
-- TOC entry 1873 (class 2606 OID 83970)
-- Name: retribusi_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_realisasi
    ADD CONSTRAINT retribusi_fk FOREIGN KEY (kode_retribusi) REFERENCES ref_jenis_retribusi(kode_retribusi);


--
-- TOC entry 1874 (class 2606 OID 84015)
-- Name: retribusi_fk_skpd; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_realisasi
    ADD CONSTRAINT retribusi_fk_skpd FOREIGN KEY (kode_skpd) REFERENCES ref_skpd(kode_skpd);


--
-- TOC entry 1995 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-02-07 21:57:47

--
-- PostgreSQL database dump complete
--

