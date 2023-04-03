CREATE DATABASE shop_service;
USE shop_service;

create table brand (
    id CHAR(32) not null,
    created_at date,
    description varchar(255),
    name varchar(255),
    updated_at date,
    primary key (id));

create table brand_image (
    id CHAR(32) not null,
    created_at date,
    image_name varchar(255),
    updated_at date,
    url varchar(255),
    brand_id CHAR(32),
    primary key (id));

create table cart (
    id CHAR(32) not null,
    created_at date,
    updated_at date,
    user_id CHAR(32),
    primary key (id));

create table category (
    id CHAR(32) not null,
    created_at date,
    description varchar(255),
    name varchar(255),
    updated_at date,
    primary key (id));

create table category_image (
    id CHAR(32) not null,
    created_at date,
    image_name varchar(255),
    updated_at date,
    url varchar(255),
    category_id CHAR(32),
    primary key (id));

create table comment (
    id CHAR(32) not null,
    content varchar(255),
    created_at date,
    updated_at date,
    post_id CHAR(32),
    user_id CHAR(32),
    primary key (id));

create table comment_image (
    id CHAR(32) not null,
    created_at date,
    image_name varchar(255),
    updated_at date,
    url varchar(255),
    comment_id CHAR(32),
    primary key (id));

create table order_items (
    id CHAR(32) not null,
    created_at date,
    quantity integer,
    updated_at date,
    cart_id CHAR(32),
    order_id CHAR(32),
    product_id CHAR(32),
    primary key (id));

create table orders (
    id CHAR(32) not null,
    created_at date,
    order_status varchar(255),
    total_amount decimal(38,2),
    updated_at date,
    user_id CHAR(32),
    primary key (id));

create table otp (
    id CHAR(32) not null,
    is_verify bit,
    otp_code varchar(255),
    phone_number varchar(255),
    time_send bigint,
    primary key (id));

create table payment (
    id CHAR(32) not null,
    created_at date,
    payment_status varchar(255),
    updated_at date,
    order_id CHAR(32),
    primary key (id));

create table post (
    id CHAR(32) not null,
    content TEXT,
    created_at date,
    title varchar(255),
    updated_at date,
    user_id CHAR(32),
    primary key (id));

create table post_image (
    id CHAR(32) not null,
    created_at date,
    image_name varchar(255),
    updated_at date,
    url varchar(255),
    post_id CHAR(32),
    primary key (id));

create table product (
    id CHAR(32) not null,
    color varchar(255),
    created_at date,
    description TEXT,
    name varchar(255),
    price decimal(38,2),
    price_sold decimal(38,2),
    quantity integer,
    size varchar(255),
    updated_at date,
    brand_id CHAR(32),
    category_id CHAR(32),
    sale_event_id varchar(255),
    primary key (id));

create table product_image (
    id CHAR(32) not null,
    created_at date,
    image_name varchar(255),
    updated_at date,
    url varchar(255),
    product_id CHAR(32),
    primary key (id));

create table profile (
    id CHAR(32) not null,
    address1 varchar(255),
    address2 varchar(255),
    address3 varchar(255),
    created_at date,
    date_of_birth date,
    email varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    telephone_number varchar(255) not null,
    updated_at date,
    user_id CHAR(32),
    primary key (id));

create table profile_image (
    id CHAR(32) not null,
    created_at date,
    image_name varchar(255),
    updated_at date,
    url varchar(255),
    profile_id CHAR(32),
    primary key (id));

create table receive_location (
    id CHAR(32) not null,
    created_at date,
    location varchar(255),
    updated_at date,
    user_id CHAR(32),
    primary key (id));

create table review (
    id CHAR(32) not null,
    content varchar(255),
    created_at date,
    updated_at date,
    product_id CHAR(32),
    user_id CHAR(32),
    primary key (id));

create table review_image (
    id CHAR(32) not null,
    created_at date,
    image_name varchar(255),
    updated_at date,
    url varchar(255),
    review_id CHAR(32),
    primary key (id));

create table sale_event (
    id varchar(255) not null,
    created_at date,
    end_date date,
    event_name varchar(255),
    start_date date,
    updated_at date,
    primary key (id));

create table user (
    id CHAR(32) not null,
    created_at date,
    email varchar(255),
    password varchar(255),
    role varchar(10),
    status varchar(10),
    updated_at date,
    user_name varchar(255),
    primary key (id));

alter table otp drop index UK_hljtoknd2h3ytqqnm2gi97o2l;

alter table otp add constraint UK_hljtoknd2h3ytqqnm2gi97o2l unique (phone_number);

alter table brand_image add constraint FKi05r0j8hbym8vyl54k41fiooq foreign key (brand_id) references brand (id);

alter table cart add constraint FKl70asp4l4w0jmbm1tqyofho4o foreign key (user_id) references user (id);

alter table category_image add constraint FKiwoibuaavknpakpi5c9e85oin foreign key (category_id) references category (id);

alter table comment add constraint FKs1slvnkuemjsq2kj4h3vhx7i1 foreign key (post_id) references post (id);

alter table comment add constraint FK8kcum44fvpupyw6f5baccx25c foreign key (user_id) references user (id);

alter table comment_image add constraint FKs1et2hjm1b13mvs63acb8wgi8 foreign key (comment_id) references comment (id);

alter table order_items add constraint FKrsts10uv0muhucsb6wnkxohi7 foreign key (cart_id) references cart (id);

alter table order_items add constraint FKbioxgbv59vetrxe0ejfubep1w foreign key (order_id) references orders (id);

alter table order_items add constraint FKlf6f9q956mt144wiv6p1yko16 foreign key (product_id) references product (id);

alter table orders add constraint FKel9kyl84ego2otj2accfd8mr7 foreign key (user_id) references user (id);

alter table payment add constraint FKlouu98csyullos9k25tbpk4va foreign key (order_id) references orders (id);

alter table post add constraint FK72mt33dhhs48hf9gcqrq4fxte foreign key (user_id) references user (id);

alter table post_image add constraint FKsip7qv57jw2fw50g97t16nrjr foreign key (post_id) references post (id);

alter table product add constraint FKs6cydsualtsrprvlf2bb3lcam foreign key (brand_id) references brand (id);

alter table product add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category (id);

alter table product add constraint FKk2lt61uajkbd6eimkhvbxgpcd foreign key (sale_event_id) references sale_event (id);

alter table product_image add constraint FK6oo0cvcdtb6qmwsga468uuukk foreign key (product_id) references product (id);

alter table profile add constraint FKawh070wpue34wqvytjqr4hj5e foreign key (user_id) references user (id);

alter table profile_image add constraint FK7499uukxrqn9c6ue4g8uox6ao foreign key (profile_id) references profile (id);

alter table receive_location add constraint FKc8846jkn2eyqk0ebb500m5pnr foreign key (user_id) references user (id);

alter table review add constraint FKiyof1sindb9qiqr9o8npj8klt foreign key (product_id) references product (id);

alter table review add constraint FKiyf57dy48lyiftdrf7y87rnxi foreign key (user_id) references user (id);

alter table review_image add constraint FK16wp089tx9nm0obc217gvdd6l foreign key (review_id) references review (id);
