PGDMP         ;        
        z           usuarios    14.2    14.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16394    usuarios    DATABASE     d   CREATE DATABASE usuarios WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE usuarios;
                postgres    false            �            1259    16402    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    nombre text NOT NULL,
    correo text NOT NULL,
    contrasena text NOT NULL,
    telefono numeric
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false            �          0    16402    usuarios 
   TABLE DATA           H   COPY public.usuarios (nombre, correo, contrasena, telefono) FROM stdin;
    public          postgres    false    209   \       [           2606    16408    usuarios usuarios_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (correo);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    209            �   P   x�sI,�L�L���ə��ɉEI�Y��%���9z���iN3K##Scs.������\0�[#D�3Ə+F��� ��%J     