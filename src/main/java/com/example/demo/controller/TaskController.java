package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Task;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TaskRepository;

@Controller
public class TaskController {

	@Autowired
	public CategoryRepository categoryRepository;

	@Autowired
	private TaskRepository taskRepository;

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

}
