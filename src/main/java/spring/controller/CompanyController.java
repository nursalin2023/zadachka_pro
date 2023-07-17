package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.model.Company;
import spring.repository.CompanyRepo;

@Controller
public class CompanyController {
    @Autowired
    private final CompanyRepo companyRepo;

    public CompanyController(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }


    @GetMapping("/c")
    public String findAll(Model model) {
        model.addAttribute("all", companyRepo.findAll());
        return "find-all";
    }

    @PostMapping("/saveCompany")
    private String saveCompany(@RequestParam("name") String companyName, @RequestParam("locatedCountry") String locatedCountry) {
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCountry(locatedCountry);
        companyRepo.save(company);
        return "redirect:/c";
    }

    @GetMapping("/companyForm")
    public String saveCompanyPage() {
        return "company-save";
    }


    @GetMapping("/deleteCompany/{id}")
    public String deleteById(@PathVariable Long id) {
        Company company = companyRepo.findById(id);
        companyRepo.delete(company.getId());
        return "redirect:/с";
    }

    @GetMapping("/get/by/{id}")
    public String getById(Model model, @PathVariable Long id) {
        Company company = companyRepo.findById(id);
        model.addAttribute("person", company);
        model.addAttribute("company", company);
        return "find";
    }

//    @GetMapping("/update/{id}")
//    public String updatePersonForm(@PathVariable("id") int id, Model model) {
//        public String updateCompanyForm(@PathVariable("id") int id, Model model) {
//            Company company = companyRepo.findById(id);
//            model.addAttribute("company", company);
//            return "update-company-form";
//        }
//
        @PostMapping("/real/update/{id}")
        public String updateCompany(@RequestParam("CompanyName") String companyName, @RequestParam("locatedCountry") String locatedCountry, @PathVariable Long id) {
            Company company = new Company();
            Company company1 = companyRepo.findById(id);
            company.setCompanyName(companyName);
            company.setLocatedCountry(locatedCountry);
            companyRepo.updateCompany(id, company1);
            return "redirect:/";
        }
////
////        @GetMapping("/clear")
////        public String clear() {
////            companyRepository.clear();
////            return "redirect:/";
//        }
    }
