package com.example.TodoList.Repository;

import com.example.TodoList.Entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository  extends JpaRepository<TodoList, Long> {
    TodoList findByLoginId(String loginId);
}
