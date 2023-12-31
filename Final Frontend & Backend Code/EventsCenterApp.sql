PGDMP  -                    {            EventsCenterApp    16.1    16.1     "           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            #           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            $           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            %           1262    41089    EventsCenterApp    DATABASE     s   CREATE DATABASE "EventsCenterApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
 !   DROP DATABASE "EventsCenterApp";
                postgres    false            �            1259    41090    booth_requests    TABLE     d   CREATE TABLE public.booth_requests (
    user_id integer NOT NULL,
    event_id integer NOT NULL
);
 "   DROP TABLE public.booth_requests;
       public         heap    postgres    false            �            1259    41094    event    TABLE     �   CREATE TABLE public.event (
    event_id integer NOT NULL,
    image_url character varying(255),
    info character varying(1500),
    name character varying(255),
    price bigint,
    status integer
);
    DROP TABLE public.event;
       public         heap    postgres    false            �            1259    41093    event_event_id_seq    SEQUENCE     �   CREATE SEQUENCE public.event_event_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.event_event_id_seq;
       public          postgres    false    217            &           0    0    event_event_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.event_event_id_seq OWNED BY public.event.event_id;
          public          postgres    false    216            �            1259    41102    tickets    TABLE     ]   CREATE TABLE public.tickets (
    user_id integer NOT NULL,
    event_id integer NOT NULL
);
    DROP TABLE public.tickets;
       public         heap    postgres    false            �            1259    41105    users    TABLE     �   CREATE TABLE public.users (
    user_id integer NOT NULL,
    email character varying(255),
    password character varying(255),
    role character varying(255),
    status integer,
    username character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    41112 	   users_seq    SEQUENCE     s   CREATE SEQUENCE public.users_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.users_seq;
       public          postgres    false            �           2604    41097    event event_id    DEFAULT     p   ALTER TABLE ONLY public.event ALTER COLUMN event_id SET DEFAULT nextval('public.event_event_id_seq'::regclass);
 =   ALTER TABLE public.event ALTER COLUMN event_id DROP DEFAULT;
       public          postgres    false    217    216    217                      0    41090    booth_requests 
   TABLE DATA           ;   COPY public.booth_requests (user_id, event_id) FROM stdin;
    public          postgres    false    215   c                 0    41094    event 
   TABLE DATA           O   COPY public.event (event_id, image_url, info, name, price, status) FROM stdin;
    public          postgres    false    217   �                 0    41102    tickets 
   TABLE DATA           4   COPY public.tickets (user_id, event_id) FROM stdin;
    public          postgres    false    218   `                 0    41105    users 
   TABLE DATA           Q   COPY public.users (user_id, email, password, role, status, username) FROM stdin;
    public          postgres    false    219   �       '           0    0    event_event_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.event_event_id_seq', 2, true);
          public          postgres    false    216            (           0    0 	   users_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.users_seq', 101, true);
          public          postgres    false    220            �           2606    41101    event event_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.event
    ADD CONSTRAINT event_pkey PRIMARY KEY (event_id);
 :   ALTER TABLE ONLY public.event DROP CONSTRAINT event_pkey;
       public            postgres    false    217            �           2606    41111    users users_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    219            �           2606    41128 #   tickets fk4eqsebpimnjen0q46ja6fl2hl    FK CONSTRAINT     �   ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT fk4eqsebpimnjen0q46ja6fl2hl FOREIGN KEY (user_id) REFERENCES public.users(user_id);
 M   ALTER TABLE ONLY public.tickets DROP CONSTRAINT fk4eqsebpimnjen0q46ja6fl2hl;
       public          postgres    false    3462    219    218            �           2606    41113 *   booth_requests fkaxvkhit2h195qm5l1j7b6wvwh    FK CONSTRAINT     �   ALTER TABLE ONLY public.booth_requests
    ADD CONSTRAINT fkaxvkhit2h195qm5l1j7b6wvwh FOREIGN KEY (event_id) REFERENCES public.event(event_id);
 T   ALTER TABLE ONLY public.booth_requests DROP CONSTRAINT fkaxvkhit2h195qm5l1j7b6wvwh;
       public          postgres    false    215    3460    217            �           2606    41123 #   tickets fkd3j95nwp01kk5igkvuu5xshsr    FK CONSTRAINT     �   ALTER TABLE ONLY public.tickets
    ADD CONSTRAINT fkd3j95nwp01kk5igkvuu5xshsr FOREIGN KEY (event_id) REFERENCES public.event(event_id);
 M   ALTER TABLE ONLY public.tickets DROP CONSTRAINT fkd3j95nwp01kk5igkvuu5xshsr;
       public          postgres    false    3460    218    217            �           2606    41118 *   booth_requests fkltck4coasn19p9h0qg01qo63e    FK CONSTRAINT     �   ALTER TABLE ONLY public.booth_requests
    ADD CONSTRAINT fkltck4coasn19p9h0qg01qo63e FOREIGN KEY (user_id) REFERENCES public.users(user_id);
 T   ALTER TABLE ONLY public.booth_requests DROP CONSTRAINT fkltck4coasn19p9h0qg01qo63e;
       public          postgres    false    3462    219    215                  x�3�4�2�=... +�         �  x��V�n�6];_qw��z8�Ǚ��m���;�3@
Z��8�H��쨫~K?�_�C:� ��(��-�u���@����νOӢԉމ�0m�Y�.U\�bH��iB�'�.uҳ{}��w���l�])S��sW�6��?�����,>N�g}\m�Vo<�Yӣ�5[Z�����%�0}d��V�ֻ������5cZ/��EYJ/���ue���eo%���e�c��^n�8z����� �A*E;�β�K�q�'-��$�@��������FI-hS4ƨ0�\$<}�1	G�鼱��ƴL���x�{=b���a=)���^��em�"�O�/e0!��R9���f6G$;���������^��K�D����DiG�Ɛ���� w�;���D X����Z`�K�\4��&�����SQfpt,����yCJV�н�`~��=�:`s!�eS[�5���A �,Yɺ	>���4�S5��nvVE�8�L�SXZp�t'�u�DP�����a����
ր�(UpC8�;]�U�������؈���_E�8�},!���=�MpU]�c�N�*4�S�g������;;>J>~��K{/�`�R��.�ҨW6/%�ݨ��`zK1q>�!��+�J('*T�4���u`k�J��� ������n��n4�F����RK|,7����5�]�#�y��;G�y�����Wot9Ez]����"ޞ�U�L�����}>0��蝟�S�I���?�f�	n�|��خB��o�m1�1�.�;ϲ��b�/W9��9�ϡ}��	�y��)���]�,���n��P�/+k�O4{|c�[<?��ur���uQ�`-�$f�lCۤ�,���4�o��7�������z�|H�T>�o���,���Cz���5�F_b:�>�Q�B|Z���=�Q���,8�������|>�����_0��z            x�3�4�2�=... +�         �   x�3�LL���sH�M���K���,H,..�/J�tt����4�(�2��M�KLO-¦������5���˘�����`�B�4�	�2"�̈�Ԙ3;+/;+���JS.S#�C���LM8�S�S�&�"�fn����� �f]u     