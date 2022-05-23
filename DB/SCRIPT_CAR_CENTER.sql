-- DOCUMENT TYPE TABLE --
CREATE TABLE tb_document_type
(
    id_document_type INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    name VARCHAR2(30) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- CLIENT TABLE --
CREATE TABLE tb_client
(
    id_client INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    first_name VARCHAR2(30) NOT NULL,
    last_name VARCHAR2(30),
    first_surname VARCHAR2(30) NOT NULL,
    second_surname VARCHAR2(30),
    id_document_type INT NOT NULL REFERENCES tb_document_type(id_document_type),
    document_number INT NOT NULL,
    cellphone INT,
    address VARCHAR2(50),
    email VARCHAR2(50) NOT NULL,
    status NUMBER(1) DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- CAR TABLE --
CREATE TABLE tb_car
(
    id_car INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    id_client INT NOT NULL,
    CONSTRAINT fk_client FOREIGN KEY(id_client) REFERENCES tb_client(id_client),
    placa VARCHAR2(10) NOT  NULL,
    brand VARCHAR2(20) NOT NULL,
    status NUMBER(1) DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- INCIDENCE TABLE --
CREATE TABLE tb_incidence
(
    id_incidence INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    id_car INT NOT NULL REFERENCES tb_car(id_car),
    photo VARCHAR2(30) NOT  NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- MECHANIC TABLE --
CREATE TABLE tb_mechanic
(
    id_mechanic INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    first_name VARCHAR2(30) NOT NULL,
    last_name VARCHAR2(30),
    first_surname VARCHAR2(30) NOT NULL,
    second_surname VARCHAR2(30),
    id_document_type INT NOT NULL REFERENCES tb_document_type(id_document_type),
    document_number INT NOT NULL,
    cellphone INT,
    address VARCHAR2(50),
    email VARCHAR2(50) NOT NULL,
    status NUMBER(1) DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- MECHANIC AND SERVICE TABLE --
CREATE TABLE tb_mechanic_service
(
    id_mechanic_service INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    id_mechanic INT NOT NULL,
    CONSTRAINT fk_mechanic FOREIGN KEY(id_mechanic) REFERENCES tb_mechanic(id_mechanic),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- SERVICE TABLE --
CREATE TABLE tb_service
(
    id_service INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    id_car INT NOT NULL,
    CONSTRAINT fk_car FOREIGN KEY(id_car) REFERENCES tb_car(id_car),
    id_mechanic_service INT NOT NULL,
    CONSTRAINT fk_mechanic_service FOREIGN KEY(id_mechanic_service) REFERENCES tb_mechanic_service(id_mechanic_service),
    -- Service description --
    descpt VARCHAR2(70) NOT NULL,
    status NUMBER(1) DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- STORE TABLE --
CREATE TABLE tb_site
(
    id_site INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    name VARCHAR2(20) NOT NULL,
    status NUMBER(1) DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- REPLACEMENT TABLE --
CREATE TABLE tb_replacement
(
    id_replacement INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    name VARCHAR2(20) NOT NULL,
    price INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    status NUMBER(1) DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- REPLACEMENT AND SITE TABLE --
CREATE TABLE tb_replacement_site
(
    id_replacement_site INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    id_replacement INT NOT NULL,
    CONSTRAINT fk_replacement FOREIGN KEY(id_replacement) REFERENCES tb_replacement(id_replacement),
    id_site INT NOT NULL,
    CONSTRAINT fk_site FOREIGN KEY(id_site) REFERENCES tb_site(id_site),
    quantity INTEGER NOT NULL,
    -- Status of the operation, whether it is addition or subtraction --
    status_operation NUMBER(1) DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- BILL WITH REPLACEMENT AND SITE TABLE --
CREATE TABLE tb_bill_replacement_site
(
    id_bill_replacement_site INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    id_replacement_site INT NOT NULL,
    CONSTRAINT fk_replacement_site FOREIGN KEY(id_replacement_site) REFERENCES tb_replacement_site(id_replacement_site),
    quantity INTEGER NOT NULL,
    status NUMBER(1) DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);

-- BILL TABLE --
CREATE TABLE tb_bill
(
    id_bill INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    id_service INT NOT NULL,
    CONSTRAINT fk_service FOREIGN KEY(id_service) REFERENCES tb_service(id_service),
    id_bill_replacement_site INT NOT NULL,
    CONSTRAINT fk_bill_replacement_site FOREIGN KEY(id_bill_replacement_site) REFERENCES tb_bill_replacement_site(id_bill_replacement_site),
    quantity INTEGER NOT NULL,
    status NUMBER(1) DEFAULT 1 NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);
