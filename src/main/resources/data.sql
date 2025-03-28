-- カテゴリーテーブルにデータを挿入するクエリ
INSERT INTO categories(name) VALUES('仕事');
INSERT INTO categories(name) VALUES('個人');
INSERT INTO categories(name) VALUES('その他');

-- users テーブルにデータを挿入するクエリ
--INSERT INTO users (id, email, name, password)
--VALUES
--(1, 'tanaka@aaa.com', '田中太郎', 'test123'),
--(2, 'suzuki@aaa.com', '鈴木一郎', 'test456'),
--(3, 'test@com', 'テストユーザー', 'testuser');

-- 上記のようにidを指定してデータを挿入すると、idが重複エラーとなるため下記に修正
INSERT INTO users (email, name, password) VALUES
('tanaka@aaa.com', '田中太郎', 'test123'),
('suzuki@aaa.com', '鈴木一郎', 'test456'),
('testuser@com', 'テストユーザー', 'testuser'),
('test@com', 'テストマン', 'testuser');

-- tasks テーブルにデータを挿入するクエリ
--INSERT INTO tasks (id, category_id, user_id, title, closing_date, progress, memo)
--VALUES
--(1, 1, 1, '見積もり', '2025-12-31', 0, '案件に適した見積もりを取る');

INSERT INTO tasks (category_id, user_id, title, closing_date, progress, memo)
VALUES
(1, 1, '見積もり', '2025-12-31', 0, '案件に適した見積もりを取る'),
(2, 1, 'ゲームの作り方', '2025-12-31', 0, 'ゲームの作り方を明日までに考える'),
(3, 1, 'コーヒー豆の煎り方', '2025-12-31', 0, 'コーヒー豆の煎り方を明日までにマスターする'),
(1, 2, '請求', '2025-12-31', 0, '請求金額を明日までに提出'),
(2, 2, '漫画の描き方', '2025-12-31', 0, '漫画の描き方を明日までにマスターする'),
(3, 3, 'リマインド', '2025-12-31', 0, '明日までにリマインドをする');