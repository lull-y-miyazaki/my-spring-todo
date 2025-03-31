package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class TaskController {

	@Autowired
	public CategoryRepository categoryRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public Account account;

	// タスク一覧画面の表示
	@GetMapping("/tasks")
	public String index(
			@RequestParam(defaultValue = "") Integer categoryId,
			Model model) {

		// 全カテゴリーの取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		// 全てのユーザーのタスクの一覧情報を取得
		List<Task> taskList = null;
		if (categoryId == null) {
			taskList = taskRepository.findAll();
		} else {
			taskList = taskRepository.findByCategoryId(categoryId);
		}

		// 取得した記事一覧をテンプレートに渡す
		model.addAttribute("tasks", taskList);

		return "task/tasks";
	}

	// タスクの新規登録画面の表示
	@GetMapping("/tasks/add")
	public String create(Model model) {

		// 全カテゴリーの取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		return "task/addTask";
	}

	// タスクの新規登録処理
	@PostMapping("/tasks/add")
	public String add(
			@RequestParam Integer categoryId,
			@RequestParam String title,
			@RequestParam LocalDate closingDate,
			@RequestParam Integer progress,
			@RequestParam String memo,
			Model model) {

		// カテゴリー情報の取得
		// orElseThrow()：中身が「ある」なら取り出して、「ない」なら例外を投げる
		Category category = categoryRepository.findById(categoryId).orElseThrow();

		// ログインしているユーザー情報の取得
		User user = userRepository.findById(account.getId()).orElseThrow();

		// ブログ新規作成用のインスタンスを生成
		Task task = new Task(category, user, title, closingDate, progress, memo);

		// 引数のエンティティをDBに保存
		taskRepository.save(task);

		return "redirect:/tasks";
	}

	// タスクの編集画面の表示
	@GetMapping("/tasks/edit")
	public String edit(
			@RequestParam Integer taskId,
			Model model) {

		// 全カテゴリーの取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		// ID（主キー）で検索してタスク情報を取得
		Task task = taskRepository.findById(taskId).get();

		// Map.of()の簡易Mapで複数のデータをまとめて送る
		model.addAllAttributes(Map.of(
				"categories", categoryList,
				"task", task));

		return "task/editTask";
	}

	// タスク更新処理
	@PostMapping("/tasks/update")
	public String update(
			@RequestParam Integer taskId,
			@RequestParam Integer categoryId,
			@RequestParam String title,
			@RequestParam LocalDate closingDate,
			@RequestParam Integer progress,
			@RequestParam String memo,
			Model model) {

		// カテゴリー情報の取得
		// orElseThrow()：中身が「ある」なら取り出して、「ない」なら例外を投げる
		Category category = categoryRepository.findById(categoryId).orElseThrow();

		// ログインしているユーザー情報の取得
		User user = userRepository.findById(account.getId()).orElseThrow();

		// タスク更新用インスタンスを生成
		Task task = new Task(taskId, category, user, title, closingDate, progress, memo);

		// 引数のエンティティをDBに保存
		taskRepository.save(task);

		return "redirect:/tasks";
	}

}
