
    create table ecommerceapi.categories (
       id integer not null comment '',
        name varchar(100) not null comment '',
        description varchar(255) comment '',
        primary key (id)
    ) comment='' engine=InnoDB;

    create table ecommerceapi.customers (
       id integer not null comment '',
        name varchar(255) not null comment '',
        email varchar(150) not null comment '',
        password varchar(100) not null comment '',
        authtoken varchar(36) comment '',
        gender varchar(10) not null comment '',
        primary key (id)
    ) comment='' engine=InnoDB;

    create table ecommerceapi.employees (
       id integer not null comment '',
        email varchar(150) not null comment '',
        name varchar(255) not null comment '',
        password varchar(100) not null comment '',
        role varchar(45) not null comment '',
        authtoken varchar(36) comment '',
        birthdate datetime(6) not null comment '',
        primary key (id)
    ) comment='' engine=InnoDB;

    create table ecommerceapi.order_details (
       order_id integer not null comment '',
        product_id integer not null comment '',
        quantity integer comment '',
        primary key (order_id, product_id)
    ) comment='' engine=InnoDB;

    create table ecommerceapi.orders (
       id integer not null comment '',
        date datetime(6) comment '',
        user_id integer comment '',
        primary key (id)
    ) comment='' engine=InnoDB;

    create table ecommerceapi.products (
       id integer not null comment '',
        description varchar(255) comment '',
        image varchar(255) not null comment '',
        name varchar(100) not null comment '',
        price bigint not null comment '',
        quantity integer not null comment '',
        category_id integer comment '',
        primary key (id)
    ) comment='' engine=InnoDB;

    alter table ecommerceapi.employees 
       add constraint UKj9xgmd0ya5jmus09o0b8pqrpb unique (email);
create index FK4q98utpd73imf4yhttm3w0eax on ecommerceapi.order_details (product_id);
create index FKf31jqtsy70cb3p4nqysbv8s2v on ecommerceapi.orders (user_id);
create index products_FK on ecommerceapi.products (category_id);

    alter table ecommerceapi.order_details 
       add constraint FKjyu2qbqt8gnvno9oe9j2s2ldk 
       foreign key (order_id) 
       references ecommerceapi.orders (id);

    alter table ecommerceapi.order_details 
       add constraint FK4q98utpd73imf4yhttm3w0eax 
       foreign key (product_id) 
       references ecommerceapi.products (id);

    alter table ecommerceapi.orders 
       add constraint FKf31jqtsy70cb3p4nqysbv8s2v 
       foreign key (user_id) 
       references ecommerceapi.customers (id);

    alter table ecommerceapi.products 
       add constraint products_FK 
       foreign key (category_id) 
       references ecommerceapi.categories (id);
