PGDMP     9                    z           usuarios    14.2    14.2 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16435    usuarios    DATABASE     d   CREATE DATABASE usuarios WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE usuarios;
                postgres    false            �            1259    16436    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    "Nombre" text NOT NULL,
    "Email" text NOT NULL,
    "Contrasena" text NOT NULL,
    "Telefono" numeric,
    "ID" integer NOT NULL
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false            �            1259    16443    usuarios_id_seq    SEQUENCE     �   ALTER TABLE public.usuarios ALTER COLUMN "ID" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.usuarios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    209            �          0    16436    usuarios 
   TABLE DATA           U   COPY public.usuarios ("Nombre", "Email", "Contrasena", "Telefono", "ID") FROM stdin;
    public          postgres    false    209   �       �           0    0    usuarios_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.usuarios_id_seq', 48, true);
          public          postgres    false    210            ]           2606    16442    usuarios usuarios_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY ("Email");
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    209            �     x�eQ�r� <�|�� >nR9�r� &�P����ÀYq���M�0���<�ȸ��i��?��_n_h��vK�]������-T�j�J��`:>O�f��jE���g���d�:	��.�L�F5���;�1fF�O&l@��4`�ٴ��]��p{�6H�r QGD�ٍ��ed�y����
��@M�n %�7+YH�L��Ɲ�N�"����2z���W��ݰ�/�����Ek�˘|�;�:�&<A*�,������C&�6�)�K|/�K��`     