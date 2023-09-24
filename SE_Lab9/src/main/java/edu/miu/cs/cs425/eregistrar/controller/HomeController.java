package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.dto.StudentFilter;
import edu.miu.cs.cs425.eregistrar.model.entity.Student;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final StudentService service;

    @RequestMapping("/")
    public String index(Model model, StudentFilter filter) {
        model.addAttribute("students", service.getAllStudent());
       // System.out.println(filter.getKeyword());
        return "index";
    }

    @GetMapping("/add")
    public String requestAddStudent(Student student, Model model) {
        model.addAttribute("student", student);
        return "add-student";
    }

    @GetMapping("/update/{id}")
    public String requestUpdateStudent(@PathVariable Long id, Model model) {
        Student stu = service.getStudentById(id);
        model.addAttribute("student", stu);
        return "update-student";
    }

    @GetMapping("/delete/{id}")
    public String requestDeleteStudent(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(Student student, Model model) {
        service.addStudent(student);
        model.addAttribute("students", service.getAllStudent());
        return "redirect:/";
    }
}
