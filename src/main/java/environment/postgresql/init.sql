\c library-app;
CREATE TABLE if not exist article
(
    id  serial PRIMARY KEY,
    slug VARCHAR(50) UNIQUE NOT NULL,
    title VARCHAR(50) NOT NULL,
    content VARCHAR(255) UNIQUE NOT NULL,
    published_on TIMESTAMP NOT NULL
);

INSERT INTO article (id, slug, title, content, published_on)
values (1, 'hello-world', 'hello world', 'randomrandomrandom', '2023-09-07 1:00:00.000000')
values (2, 'hello-world2', 'hello world2', 'randomrandomrandom', '2023-09-07 1:01:00.000000')