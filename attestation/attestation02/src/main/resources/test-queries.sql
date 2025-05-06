-- Запросы на чтение данных

-- 1. Получить все товары дороже 500
SELECT * FROM product WHERE price > 500;

-- 2. Получить всех покупателей с фамилией на "С"
SELECT * FROM customer WHERE last_name LIKE 'С%';

-- 3. Получить заказы за январь 2023
SELECT o.id, c.first_name, c.last_name, p.name, o.quantity, o.order_date
FROM order_table o
         JOIN customer c ON o.customer_id = c.id
         JOIN product p ON o.product_id = p.id
WHERE o.order_date BETWEEN '2023-01-01' AND '2023-01-31';

-- 4. Получить топ-5 самых популярных товаров
SELECT p.name, SUM(o.quantity) as total_ordered
FROM order_table o
         JOIN product p ON o.product_id = p.id
GROUP BY p.name
ORDER BY total_ordered DESC
LIMIT 5;

-- 5. Получить общую сумму продаж
SELECT SUM(p.price * o.quantity) as total_sales
FROM order_table o
         JOIN product p ON o.product_id = p.id;


-- Запросы на изменение данных

-- 6. Обновить цену товара с id=1
UPDATE product SET price = 1099.99 WHERE id = 1;

-- 7. Обновить email покупателя с id=5
UPDATE customer SET email = 'new_email@example.com' WHERE id = 5;


-- Запросы на удаление данных

-- Безопасное удаление покупателя
BEGIN;
-- Сначала удаляем все заказы покупателя
DELETE FROM order_table WHERE customer_id = 8;
-- Затем удаляем самого покупателя
DELETE FROM customer WHERE id = 8;
COMMIT;

-- Безопасное удаление товара
BEGIN;
-- Сначала удаляем все заказы с этим товаром
DELETE FROM order_table WHERE product_id = 10;
-- Затем удаляем сам товар
DELETE FROM product WHERE id = 10;
COMMIT;

-- 10. Удалить покупателя с id=8 (если нет связанных заказов)
DELETE FROM customer WHERE id = 8;