package com.example.TodoList.Service;

import com.example.TodoList.DTO.TodoListDTO;
import com.example.TodoList.Entity.TodoList;
import com.example.TodoList.Repository.TodoListRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.NoSuchElementException;

@Service @Setter @Getter
@RequiredArgsConstructor
public class TodoListService {

    private final TodoListRepository todoListRepository;

    public void saveInfo(String loginId, String loginPw, String name, String age, String birth) {
        TodoList todoList = new TodoList();

        todoList.setLoginId(loginId);
        todoList.setLoginPw(loginPw);
        todoList.setName(name);
        todoList.setAge(age);
        todoList.setBirth(birth);

        todoListRepository.save(todoList);
    }

//    public String saveLogin(String loginId, String loginPw) {
//        TodoList todoList = new TodoList();
//        todoList = todoListRepository.findById(Long.parseLong("0")).orElseThrow(NoSuchElementException:: new);

//        TodoList todoList = todoListRepository.findById(Long.parseLong("0")).orElseThrow(NoSuchElementException :: new);
//
//        TodoListDTO todoListDTO = new TodoListDTO();
//        todoListDTO.setLoginId(todoList.getLoginId());
//        todoListDTO.setLoginPw(todoList.getLoginPw());

//        TodoList todoList = new TodoList();
//
//        if(todoListRepository.findByLoginId(loginId).getLoginId() != null); {
//            if(todoListRepository.findByLoginId(loginId).getLoginPw().equals(loginPw)) {
//                return "todolist";
//            }
//            else{
//                return "login";
//            }
//        }
//
//    }

    public void listWrite(String title, String content, String date) {
        TodoList todoList = new TodoList();

        todoList.setTitle(title);
        todoList.setContent(content);
        todoList.setDate(date);

        todoListRepository.save(todoList);
    }

    public TodoListDTO listView(){
        TodoList todoList = todoListRepository.findById(Long.parseLong("0")).orElseThrow(NoSuchElementException :: new);

        TodoListDTO todoListDTO = new TodoListDTO();
        todoListDTO.setTitle(todoList.getTitle());
        todoListDTO.setContent(todoList.getContent());
        todoListDTO.setDate(todoList.getDate());

        return todoListDTO;
    }



}
