PGDMP     0                    z           restore    14.2    14.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16419    restore    DATABASE     c   CREATE DATABASE restore WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE restore;
                postgres    false            �            1259    16420    hola    TABLE     B   CREATE TABLE public.hola (
    "1" text NOT NULL,
    "2" text
);
    DROP TABLE public.hola;
       public         heap    postgres    false            �          0    16420    hola 
   TABLE DATA           (   COPY public.hola ("1", "2") FROM stdin;
    public          postgres    false    209   �       \           2606    16426    hola hola_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY public.hola
    ADD CONSTRAINT hola_pkey PRIMARY KEY ("1");
 8   ALTER TABLE ONLY public.hola DROP CONSTRAINT hola_pkey;
       public            postgres    false    209            �      x������ � �     