package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Account {

	// フィールド
	private Integer id;
	private String name;
	private String icon;

	// コンストラクタ
	public Account() {
	}

	public Account(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	// ゲッター
	public String getName() {

		return name;
	}

	public Integer getId() {

		return id;
	}

	// セッター
	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	// ログイン状態を確認するメソッド
	public boolean isLoggedIn() {
		return id != null;
	}

	// デバッグ・ログ出力用
	@Override
	public String toString() {
		return "Account{id = " + id + ", name = '" + name + "'}";
	}

}
