-- Создание таблицы Товар
CREATE TABLE IF NOT EXISTS product (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(100) NOT NULL,
                                       price DECIMAL(10, 2) NOT NULL,
                                       description TEXT
);

COMMENT ON TABLE product IS 'Таблица для хранения информации о товарах';
COMMENT ON COLUMN product.id IS 'Уникальный идентификатор товара';
COMMENT ON COLUMN product.name IS 'Наименование товара';
COMMENT ON COLUMN product.price IS 'Цена товара';
COMMENT ON COLUMN product.description IS 'Описание товара';

-- Создание таблицы Покупатель
CREATE TABLE IF NOT EXISTS customer (
                                        id SERIAL PRIMARY KEY,
                                        first_name VARCHAR(50) NOT NULL,
                                        last_name VARCHAR(50) NOT NULL,
                                        email VARCHAR(100) UNIQUE
);

COMMENT ON TABLE customer IS 'Таблица для хранения информации о покупателях';
COMMENT ON COLUMN customer.id IS 'Уникальный идентификатор покупателя';
COMMENT ON COLUMN customer.first_name IS 'Имя покупателя';
COMMENT ON COLUMN customer.last_name IS 'Фамилия покупателя';
COMMENT ON COLUMN customer.email IS 'Электронная почта покупателя';

-- Создание таблицы Заказ
CREATE TABLE IF NOT EXISTS order_table (
                                           id SERIAL PRIMARY KEY,
                                           product_id INTEGER REFERENCES product(id),
                                           customer_id INTEGER REFERENCES customer(id),
                                           order_date DATE NOT NULL DEFAULT CURRENT_DATE,
                                           quantity INTEGER NOT NULL CHECK (quantity > 0)
);

COMMENT ON TABLE order_table IS 'Таблица для хранения информации о заказах';
COMMENT ON COLUMN order_table.id IS 'Уникальный идентификатор заказа';
COMMENT ON COLUMN order_table.product_id IS 'Идентификатор товара (внешний ключ)';
COMMENT ON COLUMN order_table.customer_id IS 'Идентификатор покупателя (внешний ключ)';
COMMENT ON COLUMN order_table.order_date IS 'Дата заказа';
COMMENT ON COLUMN order_table.quantity IS 'Количество товаров в заказе';

-- Заполнение таблицы Товар
INSERT INTO product (name, price, description) VALUES
                                                   ('Ноутбук', 999.99, 'Мощный ноутбук для работы и игр'),
                                                   ('Смартфон', 699.99, 'Флагманский смартфон'),
                                                   ('Наушники', 199.99, 'Беспроводные наушники с шумоподавлением'),
                                                   ('Клавиатура', 89.99, 'Механическая клавиатура'),
                                                   ('Мышь', 49.99, 'Беспроводная мышь'),
                                                   ('Монитор', 299.99, '27-дюймовый 4K монитор'),
                                                   ('Принтер', 199.99, 'Лазерный принтер'),
                                                   ('Флешка', 19.99, 'USB флешка 64GB'),
                                                   ('Внешний HDD', 129.99, 'Жесткий диск 1TB'),
                                                   ('Роутер', 79.99, 'Wi-Fi роутер')
ON CONFLICT DO NOTHING;

-- Заполнение таблицы Покупатель
INSERT INTO customer (first_name, last_name, email) VALUES
                                                        ('Иван', 'Иванов', 'ivanov@example.com'),
                                                        ('Петр', 'Петров', 'petrov@example.com'),
                                                        ('Сергей', 'Сергеев', 'sergeev@example.com'),
                                                        ('Анна', 'Сидорова', 'sidorova@example.com'),
                                                        ('Мария', 'Кузнецова', 'kuznetsova@example.com'),
                                                        ('Алексей', 'Васильев', 'vasiliev@example.com'),
                                                        ('Елена', 'Павлова', 'pavlova@example.com'),
                                                        ('Дмитрий', 'Семенов', 'semenov@example.com'),
                                                        ('Ольга', 'Федорова', 'fedorova@example.com'),
                                                        ('Николай', 'Николаев', 'nikolaev@example.com')
ON CONFLICT DO NOTHING;

-- Заполнение таблицы Заказ
INSERT INTO order_table (product_id, customer_id, order_date, quantity) VALUES
                                                                            (1, 1, '2023-01-15', 1),
                                                                            (2, 2, '2023-01-16', 1),
                                                                            (3, 3, '2023-01-17', 2),
                                                                            (4, 4, '2023-01-18', 1),
                                                                            (5, 5, '2023-01-19', 1),
                                                                            (6, 6, '2023-01-20', 1),
                                                                            (7, 7, '2023-01-21', 1),
                                                                            (8, 8, '2023-01-22', 3),
                                                                            (9, 9, '2023-01-23', 1),
                                                                            (10, 10, '2023-01-24', 1)
ON CONFLICT DO NOTHING;