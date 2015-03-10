--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: getjmlkelurahan(); Type: FUNCTION; Schema: public; Owner: perimbangan
--

CREATE FUNCTION getjmlkelurahan() RETURNS numeric
    LANGUAGE plpgsql
    AS $$
declare result numeric;
begin
select count(kode_kelurahan) into result 
  from ref_kelurahan;
return result;
end; $$;


ALTER FUNCTION public.getjmlkelurahan() OWNER TO perimbangan;

--
-- Name: jmlbagirata(character, character, character); Type: FUNCTION; Schema: public; Owner: perimbangan
--

CREATE FUNCTION jmlbagirata(tahun character, bulan character, kd_retribusi character) RETURNS numeric
    LANGUAGE plpgsql
    AS $$
declare result numeric;
begin
  select (sum(nilai_realisasi)*0.1*0.6/getjmlkelurahan()) into result from tr_realisasi where to_char(tanggal_realisasi,'YYYY') = tahun and to_char(tanggal_realisasi,'MM') = bulan and kode_retribusi = kd_retribusi;
return result;
end $$;


ALTER FUNCTION public.jmlbagirata(tahun character, bulan character, kd_retribusi character) OWNER TO perimbangan;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: ref_jenis_retribusi; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE ref_jenis_retribusi (
    kode_retribusi character(2) NOT NULL,
    nama_retribusi character varying(250)
);


ALTER TABLE public.ref_jenis_retribusi OWNER TO perimbangan;

--
-- Name: ref_kecamatan; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE ref_kecamatan (
    kode_kecamatan character(3) NOT NULL,
    nama_kecamatan character varying(50)
);


ALTER TABLE public.ref_kecamatan OWNER TO perimbangan;

--
-- Name: ref_kelurahan; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE ref_kelurahan (
    kode_kecamatan character(3) NOT NULL,
    kode_kelurahan character(3) NOT NULL,
    nama_kelurahan character varying(30)
);


ALTER TABLE public.ref_kelurahan OWNER TO perimbangan;

--
-- Name: ref_skpd; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE ref_skpd (
    kode_skpd character(2) NOT NULL,
    nama_skpd character varying(100)
);


ALTER TABLE public.ref_skpd OWNER TO perimbangan;

--
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
-- Name: tr_realisasi; Type: TABLE; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE TABLE tr_realisasi (
    nomor numeric NOT NULL,
    kode_retribusi character(2) NOT NULL,
    kode_kecamatan character(3) NOT NULL,
    kode_kelurahan character(3) NOT NULL,
    kode_skpd character(2) NOT NULL,
    tanggal_realisasi date NOT NULL,
    nilai_realisasi numeric DEFAULT 0
);


ALTER TABLE public.tr_realisasi OWNER TO perimbangan;

--
-- Name: v_real_per_jenis; Type: VIEW; Schema: public; Owner: perimbangan
--

CREATE VIEW v_real_per_jenis AS
 SELECT "real".kode_retribusi,
    kel.nama_kelurahan,
    kec.nama_kecamatan,
    to_char(("real".tanggal_realisasi)::timestamp with time zone, 'MM'::text) AS bulan,
    to_char(("real".tanggal_realisasi)::timestamp with time zone, 'YYYY'::text) AS tahun,
    sum("real".nilai_realisasi) AS realisasi,
    (sum("real".nilai_realisasi) * 0.1) AS sepuluh_persen,
    jmlbagirata((to_char(("real".tanggal_realisasi)::timestamp with time zone, 'YYYY'::text))::bpchar, (to_char(("real".tanggal_realisasi)::timestamp with time zone, 'MM'::text))::bpchar, "real".kode_retribusi) AS enam_puluh_persen,
    ((sum("real".nilai_realisasi) * 0.1) * 0.4) AS empat_puluh_persen,
    (jmlbagirata((to_char(("real".tanggal_realisasi)::timestamp with time zone, 'YYYY'::text))::bpchar, (to_char(("real".tanggal_realisasi)::timestamp with time zone, 'MM'::text))::bpchar, "real".kode_retribusi) + ((sum("real".nilai_realisasi) * 0.1) * 0.4)) AS jumlah_bagihasil
   FROM ((ref_kelurahan kel
   JOIN ref_kecamatan kec ON ((kel.kode_kecamatan = kec.kode_kecamatan)))
   LEFT JOIN tr_realisasi "real" ON (((kel.kode_kecamatan = "real".kode_kecamatan) AND (kel.kode_kelurahan = "real".kode_kelurahan))))
  GROUP BY "real".kode_retribusi, kel.kode_kelurahan, kel.nama_kelurahan, kel.kode_kecamatan, kec.nama_kecamatan, to_char(("real".tanggal_realisasi)::timestamp with time zone, 'MM'::text), to_char(("real".tanggal_realisasi)::timestamp with time zone, 'YYYY'::text)
  ORDER BY kel.kode_kecamatan, kel.kode_kelurahan;


ALTER TABLE public.v_real_per_jenis OWNER TO perimbangan;

--
-- Name: v_rekom; Type: VIEW; Schema: public; Owner: perimbangan
--

CREATE VIEW v_rekom AS
 SELECT "real".bulan,
    "real".tahun,
    kec.nama_kecamatan,
    kel.nama_kelurahan,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '01'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_sampah,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '02'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_parkir,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '03'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_pasar,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '04'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_pkb,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '05'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_pkd,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '06'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_lelang,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '07'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_terminal,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '08'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_villa,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '09'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_rph,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '10'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_pelabuhan,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '11'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_or,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '12'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_ruas_jalan,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '13'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_imb,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '14'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_gangguan,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '15'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_trayek,
    ( SELECT v_real_per_jenis.jumlah_bagihasil
           FROM v_real_per_jenis
          WHERE (((((v_real_per_jenis.kode_retribusi = '16'::bpchar) AND ((v_real_per_jenis.nama_kecamatan)::text = (kec.nama_kecamatan)::text)) AND ((v_real_per_jenis.nama_kelurahan)::text = (kel.nama_kelurahan)::text)) AND (v_real_per_jenis.bulan = "real".bulan)) AND (v_real_per_jenis.tahun = "real".tahun))) AS real_telkom
   FROM ((ref_kecamatan kec
   JOIN ref_kelurahan kel ON ((kec.kode_kecamatan = kel.kode_kecamatan)))
   JOIN v_real_per_jenis "real" ON (((("real".nama_kecamatan)::text = (kec.nama_kecamatan)::text) AND (("real".nama_kelurahan)::text = (kel.nama_kelurahan)::text))));


ALTER TABLE public.v_rekom OWNER TO perimbangan;

--
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
-- Data for Name: ref_skpd; Type: TABLE DATA; Schema: public; Owner: perimbangan
--

COPY ref_skpd (kode_skpd, nama_skpd) FROM stdin;
01	DPPK
02	DINAS KESEHATAN
03	DINAS PENDIDIKAN
04	DINAS PERHUBUNGAN
\.


--
-- Data for Name: ref_user; Type: TABLE DATA; Schema: public; Owner: perimbangan
--

COPY ref_user (nip, nama, login, password, menu, kode_skpd) FROM stdin;
198404092010011025	ADMIN	ADMIN	ÃªÃ¤â€¹\v$ÃÃ¯Â¨	1111111111111	01
\.


--
-- Data for Name: tr_potensi; Type: TABLE DATA; Schema: public; Owner: perimbangan
--

COPY tr_potensi (kode_retribusi, kode_kecamatan, kode_kelurahan, tahun_potensi, nilai_potensi, bulan_potensi) FROM stdin;
01	020	001	2014	23000	0
02	020	004	2014	50000	0
\.


--
-- Data for Name: tr_realisasi; Type: TABLE DATA; Schema: public; Owner: perimbangan
--

COPY tr_realisasi (nomor, kode_retribusi, kode_kecamatan, kode_kelurahan, kode_skpd, tanggal_realisasi, nilai_realisasi) FROM stdin;
1	02	010	002	01	2015-02-15	13000
1	01	020	001	01	2015-02-15	10000
2	02	010	005	01	2015-01-16	30000
3	02	020	003	01	2015-02-15	12000
2	01	010	002	01	2015-01-15	24000
\.


--
-- Name: ref_jenis_retribusi_fk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY ref_jenis_retribusi
    ADD CONSTRAINT ref_jenis_retribusi_fk PRIMARY KEY (kode_retribusi);


--
-- Name: ref_kecamatan_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY ref_kecamatan
    ADD CONSTRAINT ref_kecamatan_pk PRIMARY KEY (kode_kecamatan);


--
-- Name: ref_kelurahan_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY ref_kelurahan
    ADD CONSTRAINT ref_kelurahan_pk PRIMARY KEY (kode_kecamatan, kode_kelurahan);


--
-- Name: ref_skpd_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY ref_skpd
    ADD CONSTRAINT ref_skpd_pk PRIMARY KEY (kode_skpd);


--
-- Name: ref_user_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY ref_user
    ADD CONSTRAINT ref_user_pk PRIMARY KEY (nip);


--
-- Name: tr_potensi_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY tr_potensi
    ADD CONSTRAINT tr_potensi_pk PRIMARY KEY (kode_retribusi, kode_kecamatan, kode_kelurahan, tahun_potensi, bulan_potensi);


--
-- Name: tr_realisasi_pk; Type: CONSTRAINT; Schema: public; Owner: perimbangan; Tablespace: 
--

ALTER TABLE ONLY tr_realisasi
    ADD CONSTRAINT tr_realisasi_pk PRIMARY KEY (nomor, kode_retribusi, kode_kecamatan, kode_kelurahan, kode_skpd, tanggal_realisasi);


--
-- Name: fki_kelurahan_fk; Type: INDEX; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE INDEX fki_kelurahan_fk ON tr_potensi USING btree (kode_kelurahan, kode_kecamatan);


--
-- Name: fki_ref_kecamatan_fk; Type: INDEX; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE INDEX fki_ref_kecamatan_fk ON tr_potensi USING btree (kode_kecamatan);


--
-- Name: fki_ref_skpd_fk; Type: INDEX; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE INDEX fki_ref_skpd_fk ON ref_user USING btree (kode_skpd);


--
-- Name: ref_jns_on_realisasi_fk; Type: INDEX; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE INDEX ref_jns_on_realisasi_fk ON tr_realisasi USING btree (kode_retribusi);


--
-- Name: ref_kec_on_realisasi_fk; Type: INDEX; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE INDEX ref_kec_on_realisasi_fk ON tr_realisasi USING btree (kode_kecamatan);


--
-- Name: ref_kel_on_realisasi_fk; Type: INDEX; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE INDEX ref_kel_on_realisasi_fk ON tr_realisasi USING btree (kode_kelurahan, kode_kecamatan);


--
-- Name: ref_skpd_on_realisasi_fk; Type: INDEX; Schema: public; Owner: perimbangan; Tablespace: 
--

CREATE INDEX ref_skpd_on_realisasi_fk ON tr_realisasi USING btree (kode_skpd);


--
-- Name: jns_retribusi_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_realisasi
    ADD CONSTRAINT jns_retribusi_fk FOREIGN KEY (kode_retribusi) REFERENCES ref_jenis_retribusi(kode_retribusi);


--
-- Name: kecamatan_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_realisasi
    ADD CONSTRAINT kecamatan_fk FOREIGN KEY (kode_kecamatan) REFERENCES ref_kecamatan(kode_kecamatan);


--
-- Name: kelurahan_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_potensi
    ADD CONSTRAINT kelurahan_fk FOREIGN KEY (kode_kelurahan, kode_kecamatan) REFERENCES ref_kelurahan(kode_kelurahan, kode_kecamatan);


--
-- Name: kelurahan_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_realisasi
    ADD CONSTRAINT kelurahan_fk FOREIGN KEY (kode_kecamatan, kode_kelurahan) REFERENCES ref_kelurahan(kode_kecamatan, kode_kelurahan);


--
-- Name: ref_kecamatan_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_potensi
    ADD CONSTRAINT ref_kecamatan_fk FOREIGN KEY (kode_kecamatan) REFERENCES ref_kecamatan(kode_kecamatan);


--
-- Name: ref_kelurahan_ref_kecamatan; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY ref_kelurahan
    ADD CONSTRAINT ref_kelurahan_ref_kecamatan FOREIGN KEY (kode_kecamatan) REFERENCES ref_kecamatan(kode_kecamatan);


--
-- Name: ref_retribusi_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_potensi
    ADD CONSTRAINT ref_retribusi_fk FOREIGN KEY (kode_retribusi) REFERENCES ref_jenis_retribusi(kode_retribusi);


--
-- Name: ref_skpd_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY ref_user
    ADD CONSTRAINT ref_skpd_fk FOREIGN KEY (kode_skpd) REFERENCES ref_skpd(kode_skpd);


--
-- Name: skpd_fk; Type: FK CONSTRAINT; Schema: public; Owner: perimbangan
--

ALTER TABLE ONLY tr_realisasi
    ADD CONSTRAINT skpd_fk FOREIGN KEY (kode_skpd) REFERENCES ref_skpd(kode_skpd);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

