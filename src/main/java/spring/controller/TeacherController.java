package spring.controller;
import spring.model.Teacher;
import spring.repository.TeacherRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class TeacherController {
    private final TeacherRepo teacherRepo;

    public TeacherController(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @GetMapping("/teachers")
    public String findAll(Model model) {
        model.addAttribute("bo", teacherRepo.findAll());
        return "find-all-teacher";
    }

    @PostMapping("/saveTeacher")
    private String saveTeacher(@RequestParam("first_Name") String first_Name, @RequestParam("last_Name") String last_Name, @RequestParam("email") String email) {
        Teacher teacher = new Teacher();
        teacher.setFirst_name(first_Name);
        teacher.setLast_name(last_Name);
        teacher.setEmail(email);
        teacherRepo.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teacherForm")
    public String saveTeacherPage() {
        return "teacher-save";
    }


    @GetMapping("/deleteTeacher/{id}")
    public String deleteById(@PathVariable int id) {
        Teacher teacher = teacherRepo.findById(id);
        teacherRepo.delete(teacher.getId());
        return "redirect:/teachers";
    }

    @GetMapping("/get/by/teacher/{id}")
    public String getById(Model model, @PathVariable int id) {
        Teacher teacher = teacherRepo.findById(id);
        model.addAttribute("teacher", teacher);
        return "find";
    }

    @GetMapping("/update/teacher/{id}")
    public String updateTeacherForm(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherRepo.findById(id);
        model.addAttribute("teacher", teacher);
        return "update-teacher-form";
    }

    @PostMapping("/real/update/teacher/{id}")
    public String updateTeacher(@RequestParam("first_Name") String first_Name, @RequestParam("last_Name") String last_Name,@RequestParam("email") String email, @PathVariable int id) {
        Teacher teacher = new Teacher();
        teacher.setFirst_name(first_Name);
        teacher.setLast_name(last_Name);
        teacher.setEmail(email);
        teacherRepo.updateTeacher(id, teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/clear/teacher")
    public String clear() {
        teacherRepo.clear();
        return "redirect:/teachers";
    }
}
