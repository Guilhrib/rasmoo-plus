CREATE TABLE IF NOT EXISTS subscriptions_type (
    subscriptions_type_id SERIAL PRIMARY KEY,
    name CHAR(255) NOT NULL,
    access_months INT,
    price DECIMAL(10,2) NOT NULL,
    product_key CHAR(255) UNIQUE
);

CREATE TABLE IF NOT EXISTS user_type (
    user_type_id SERIAL PRIMARY KEY,
    name CHAR(255) NOT NULL,
    description CHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    users_id SERIAL PRIMARY KEY,
    name CHAR(255) NOT NULL,
    email CHAR(255) NOT NULL UNIQUE,
    phone CHAR(255) NOT NULL UNIQUE,
    cpf CHAR(255) NOT NULL UNIQUE,
    dt_subscription DATE NOT NULL,
    dt_expiration DATE NOT NULL,
    user_type_id INT REFERENCES user_type(user_type_id),
    subscriptions_type_id INT REFERENCES subscriptions_type(subscriptions_type_id)
);

CREATE TABLE IF NOT EXISTS user_payment_info (
    user_payment_info_id SERIAL PRIMARY KEY,
    card_number CHAR(255) NOT NULL UNIQUE,
    card_expiration_month INT NOT NULL,
    card_expiration_year INT NOT NULL,
    card_security_code CHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    instalments INT NOT NULL,
    dt_payment DATE NOT NULL,
    user_id INT REFERENCES users(users_id)
);

INSERT INTO subscriptions_type (name, access_months, price, product_key) VALUES ('PLANO MENSAL', 1, 75.00, 'MONTH22');
INSERT INTO subscriptions_type (name, access_months, price, product_key) VALUES ('PLANO ANUAL', 12, 697.00, 'YEAR22');
INSERT INTO subscriptions_type (name, access_months, price, product_key) VALUES ('PLANO VITALICIO', NULL, 1497.00, 'PERPETUAL22');

INSERT INTO user_type (name, description) VALUES ('PROFESSOR', 'Professores da plataforma - cadastro administrativo');
INSERT INTO user_type (name, description) VALUES ('ADMINISTRADOR', 'Administrado da plataforma - cadastro administrativo');
INSERT INTO user_type (name, description) VALUES ('ALUNO', 'Aluno da plataforma - cadastro via fluxo normal');
