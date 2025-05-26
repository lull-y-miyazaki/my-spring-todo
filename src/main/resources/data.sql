-- カテゴリーテーブルにデータを挿入するクエリ
INSERT INTO categories(name) VALUES('仕事');
INSERT INTO categories(name) VALUES('個人');
INSERT INTO categories(name) VALUES('その他');

-- 上記のようにidを指定してデータを挿入すると、idが重複エラーとなるため下記に修正
INSERT INTO users (email, name, password, icon) VALUES
('tanaka@aaa.com', '田中太郎', 'test123', 'user_icon.png'),
('suzuki@aaa.com', '鈴木一郎', 'test456', 'user_icon.png'),
('testuser@com', 'テストユーザー', 'testuser', 'user_icon.png'),
('test@com', 'テスト', 'testuser', 'user_icon.png');

INSERT INTO tasks (category_id, user_id, title, closing_date, progress, memo, image)
VALUES
(1, 1, '見積もり', '2025-12-31', 0, '案件に適した見積もりを取る', 'task_icon.png'),
(2, 1, 'ゲームの作り方', '2025-12-31', 1, 'ゲームの作り方を明日までに考える', 'task_image.jpeg'),
(3, 1, 'コーヒー豆の煎り方', '2025-12-31', 2, 'コーヒー豆の煎り方を明日までにマスターする', 'task_icon.png'),
(1, 2, '請求', '2025-12-31', 0, '請求金額を明日までに提出', 'task_image.jpeg'),
(2, 2, '漫画の描き方', '2025-12-31', 1, '漫画の描き方を明日までにマスターする', 'task_icon.png'),
(3, 3, 'リマインド', '2025-12-31', 2, '明日までにリマインドをする', 'task_image.jpeg');