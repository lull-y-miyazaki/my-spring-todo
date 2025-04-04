-- 各種テーブル削除
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS tasks;

-- カテゴリーテーブル
CREATE TABLE categories
(
   id SERIAL PRIMARY KEY,
   name TEXT
);
-- users テーブルを作成するクエリ
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255),
    name VARCHAR(20),
    password VARCHAR(50)
);

-- tasks テーブルを作成するクエリ
CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    category_id INTEGER,
    user_id INTEGER,
    title VARCHAR(255),
    closing_date DATE,
--  今回は未着手・進行中・完了の3つだけの要件で今後変更もないため外部キーにはしない
    progress INTEGER,
    memo TEXT
);
