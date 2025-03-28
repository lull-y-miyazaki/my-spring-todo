package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HttpSession session;

	// 新規ユーザー登録画面の表示
	@GetMapping("/users/add")
	public String create() {

		return "user/addUser";
	}

	// 新規登録の処理内容
	@PostMapping("/users/add")
	public String store(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String password_confirm,
			Model model) {

		User user = new User(name, email, password);
		userRepository.save(user);

		// 登録するユーザーの確認用
		System.out.println("登録データ: " + user.toString());

		return "redirect:/login";
	}

	// ログイン画面の表示
	@GetMapping({ "/", "/login", "/logout" })
	public String index(
			@RequestParam(defaultValue = "") String error,
			Model model) {

		// セッション情報全てをクリア
		session.invalidate();

		// クエリパラメータで"notLoggedIn"を受け取った場合
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインしてください");
		}

		return "user/login";
	}

}
