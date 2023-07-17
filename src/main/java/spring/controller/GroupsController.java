package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.model.Groups;
import spring.repository.GroupsRepo;

@Controller
public class GroupsController {
    private final GroupsRepo groupsRepo;

    public GroupsController(GroupsRepo groupsRepo) {
        this.groupsRepo = groupsRepo;
    }

    @GetMapping("/groups")
    public String findAll(Model model) {
        model.addAttribute("allss", groupsRepo.findAll());
        return "find-all-groups";
    }

    @PostMapping("/saveGroups")
    private String saveGroups(@RequestParam("groupsName") String groupsName, @RequestParam("dateStart") String dateStart, @RequestParam("dateFinish") String dateFinish) {
        Groups groups = new Groups();
        groups.setGroupName(groupsName);
        groups.setDataStart(dateStart);
        groups.setDataFinish(dateFinish);
        groupsRepo.save(groups);
        return "redirect:/groups";
    }

    @GetMapping("/groupsForm")
    public String saveGroupsPage() {
        return "groups-save";
    }


    @GetMapping("/deleteGroups/{id}")
    public String deleteById(@PathVariable int id) {
        Groups groups = groupsRepo.findById(id);
        groupsRepo.delete(groups.getId());
        return "redirect:/w";
    }

    @GetMapping("/get/by/groups/{id}")
    public String getById(Model model, @PathVariable int id) {
        Groups groups = groupsRepo.findById(id);
        model.addAttribute("groups", groups);
        return "find-groups";
    }

    @GetMapping("/update/groups/{id}")
    public String updateCourseForm(@PathVariable("id") int id, Model model) {
        Groups groups = groupsRepo.findById(id);
        model.addAttribute("groups", groups);
        return "update-groups-form";
    }

    @PostMapping("/real/update/groups/{id}")
    public String updateGroups(@RequestParam("groupsName") String groupsName, @RequestParam("dateOfStart") String dateStart, @RequestParam("DateFinish") String dateFinish, @PathVariable int id) {
        Groups groups = groupsRepo.findById(id);
        groups.setGroupName(groupsName);
        groups.setDataStart(dateStart);
        groups.setDataFinish(dateFinish);
        groupsRepo.updateGroups(id, groups);
        return "redirect:/w";
    }

    @GetMapping("/clear/groups")
    public String clear() {
        groupsRepo.clear();
        return "redirect:/";
    }
}
