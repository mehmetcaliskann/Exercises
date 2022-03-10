SELECT * 
FROM country
WHERE country LIKE 'A%a';

SELECT * 
FROM country
WHERE country LIKE '______%n';

SELECT title 
FROM film
WHERE LEN(title) > 4 AND title ILIKE '%t%';

SELECT * 
FROM film
WHERE title LIKE 'C%' AND length > 90 AND rental_rate = 2.99;