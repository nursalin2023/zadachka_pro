package spring.controller;
import org.springframework.stereotype.Controller;
import spring.model.Company;
import spring.repository.CompanyRepo;
import spring.repository.CourseRepo;
import spring.model.Course;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
    private final CourseRepo courseRepo;
    private final CompanyRepo companyRepo;

    public CourseController(CourseRepo courseRepo, CompanyRepo companyRepo) {
        this.courseRepo = courseRepo;
        this.companyRepo = companyRepo;
    }

    @GetMapping("/courses")
    public String findAll(Model model) {
        model.addAttribute("alls", courseRepo.findAll());
        return "find-all-course";
    }

    @PostMapping("/saveCourse")
    private String saveCompany(@RequestParam("courseName") String courseName, @RequestParam("duration") String duration, @RequestParam("id") Long id) {
        Company company = companyRepo.findById(id);
        Course course = new Course();
        course.setCourName(courseName);
        course.setDuration(duration);
        course.setCompany(company);
        courseRepo.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/course-save")
    public String saveCoursePage(Model model) {
        model.addAttribute("connection", companyRepo.findAll());
        return "course-save";
    }


    @GetMapping("/deleteCourse/{id}")
    public String deleteById(@PathVariable int id) {
        Course course = courseRepo.findById(id);
        courseRepo.delete(course.getId());
        return "redirect:/courses";
    }

    @GetMapping("/get/course/by/{id}")
    public String getById(Model model, @PathVariable int id) {
        Course course = courseRepo.findById(id);
        model.addAttribute("course", course);
        return "find-course";
    }

    @GetMapping("/update/course/{id}")
    public String updateCourseForm(@PathVariable("id") int id, Model model) {
        Course course = courseRepo.findById(id);
        model.addAttribute("course", course);
        return "update-course-form";
    }

    @PostMapping("/real/update/course/{id}")
    public String updateCourse(@RequestParam("courseName") String courseName, @RequestParam("duration") String duration, @PathVariable int id) {
        Course course = courseRepo.findById(id);
        course.setCourName(courseName);
        course.setDuration(duration);
        courseRepo.updateCourse(id, course);
        return "redirect:/courses";
    }

    @GetMapping("/clear/course")
    public String clear() {
        courseRepo.clear();
        return "redirect:/courses";
    }
}

