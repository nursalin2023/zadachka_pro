package spring.controller;
import spring.repository.StudentRepo;
import spring.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    private final StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping("/studentses")
    public String findAll(Model model) {
        model.addAttribute("allsss", studentRepo.findAll());
        return "studentmainpage";
    }

    @PostMapping("/saveStudent")
    private String saveStudent(@RequestParam("firstName") String first_Name, @RequestParam("lastName") String last_Name, @RequestParam("email") String email) {
        Student student = new Student();
        student.setFirst_name(first_Name);
        student.setLast_name(last_Name);
        student.setEmail(email);
        studentRepo.save(student);
        return "redirect:/studentses";
    }

    @GetMapping("/studentForm")
    public String saveStudentPage() {
        return "student-save";
    }


    @GetMapping("/deleteStudent/{id}")
    public String deleteById(@PathVariable int id) {
        Student student = studentRepo.findById(id);
        studentRepo.delete(student.getId());
        return "redirect:/studentses";
    }

    @GetMapping("/get/by/student/{id}")
    public String getById(Model model, @PathVariable int id) {
        Student student = studentRepo.findById(id);
        model.addAttribute("student", student);
        return "find";
    }

    @GetMapping("/update/student{id}")
    public String updateCourseForm(@PathVariable("id") int id, Model model) {
        Student student = studentRepo.findById(id);
        model.addAttribute("student", student);
        return "update-student-form";
    }

    @PostMapping("/real/update/student/{id}")
    public String updateStudent(@RequestParam("firstName") String first_Name,
                                @RequestParam("lastName") String last_Name, @RequestParam("email") String email, @PathVariable int id) {
        Student student = new Student();
        student.setFirst_name(first_Name);
        student.setLast_name(last_Name);
        student.setEmail(email);
        studentRepo.updateStudent(id, student);
        return "redirect:/studentses";
    }

    @GetMapping("/clear/student")
    public String clear() {
        studentRepo.clear();
        return "redirect:/studentses";
    }
}
