package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	// TaskエンティティでcategoryIdが一致する全てを取得する
	// 複数の結果が返ってくるので戻り値はList<Task>
	// SELECT * FROM task WHERE category_id = ?;
	List<Task> findByCategoryId(Integer categoryId);

}
