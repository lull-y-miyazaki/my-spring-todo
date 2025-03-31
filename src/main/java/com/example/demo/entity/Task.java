package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // タスクID(tasksテーブルのid)

	@ManyToOne // 多対１のリレーション
	@JoinColumn(name = "category_id") // tasksテーブルの外部キー（category_id）
	private Category category; // リレーション先のエンティティを指定

	@ManyToOne
	@JoinColumn(name = "user_id") // tasksテーブルの外部キー（user_id）
	private User user;

	private String title;

	@Column(name = "closing_date")
	private LocalDate closingDate;

	private Integer progress;

	private String memo;

	// 引数なしのコンストラクタ
	public Task() {
	}

	// 新規登録用のコンストラクタ
	public Task(Category category, User user, String title, LocalDate closingDate, Integer progress, String memo) {
		this.category = category;
		this.user = user;
		this.title = title;
		this.closingDate = closingDate;
		this.progress = progress;
		this.memo = memo;
	}

	// 更新用のコンストラクタ
	public Task(Integer id, Category category, User user, String title, LocalDate closingDate, Integer progress,
			String memo) {
		this.id = id;
		this.category = category;
		this.user = user;
		this.title = title;
		this.closingDate = closingDate;
		this.progress = progress;
		this.memo = memo;
	}

	// ゲッター
	public Integer getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public User getUser() {
		return user;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public Integer getProgress() {
		return progress;
	}

	public String getTitle() {
		return title;
	}

	public String getMemo() {
		return memo;
	}

}
