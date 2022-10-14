package com.example.TodoList.Controller;

import com.example.TodoList.DTO.TodoListDTO;
import com.example.TodoList.Entity.TodoList;
import com.example.TodoList.Repository.TodoListRepository;
import com.example.TodoList.Service.TodoListService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TodoListController {

    private final TodoListRepository todoListRepository;
    private final TodoListService todoListService;

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signuppro")
    public String signuppro(String loginId, String loginPw, String name, String age, String birth){
        TodoList todoList = new TodoList();

        todoListService.saveInfo(loginId, loginPw, name, age, birth);

        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/loginpro")
    public String loginpro(String loginId, String loginPw) {
        TodoList todoList = new TodoList();

        if (todoListRepository.findByLoginId(loginId).getLoginId() != null) {
            if (todoListRepository.findByLoginId(loginId).getLoginPw().equals(loginPw)) {
                System.out.println("아이디, 비밀번호 일치");
                return "listview";
            } else {
                System.out.println("비밀번호 불일치");
                return "login";
            }
        } else {
            System.out.println("아이디 불일치");
            return "login";
        }

        //return "login";
    }

    @PostMapping("/listview")
    public String listview(Model model){
        TodoListDTO todoListDTO = todoListService.listView();

        model.addAttribute("content", todoListDTO.getContent());
        model.addAttribute("title", todoListDTO.getTitle());
        model.addAttribute("date", todoListDTO.getDate());
        return "listview";
    }

    @PostMapping("/listwrite")
    public String listwrite(String title, String content, String date){
        todoListService.listWrite(title, content, date);
        return "listwrite";
    }

}
