package kg.edu.iaau.admin.controller;

import kg.edu.iaau.core.entity.Company;
import kg.edu.iaau.core.entity.Person;
import kg.edu.iaau.core.entity.Point;
import kg.edu.iaau.core.service.CompanyService;
import kg.edu.iaau.core.service.PersonService;
import kg.edu.iaau.core.service.PointService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/points")
public class PointController
{
    @Autowired
    private PersonService personService;

    @Autowired
    private PointService pointService;

    @Autowired
    private CompanyService companyService;


    @RequestMapping(method = RequestMethod.GET)
    public String getPoint(Model model, Principal principal,
                           @RequestParam(name = "companyId", required = false) Integer companyId)
    {
        Person person = personService.findByUsername(principal.getName());
        List<Point> pointList;

        if(companyId != null)
        {
            Company company = companyService.getById(companyId);

            if(!person.getIsAdmin()) {
                pointList = pointService.getByUserAndCompany(person, company);

            } else {
                pointList = pointService.getByCompany(company);
            }
        } else {

            if(!person.getIsAdmin()) {
                pointList = pointService.getByUser(person);

            } else {
                pointList = pointService.getAll();
            }
        }

        model.addAttribute("points", pointList);

        return "admin/point-list";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/new")
    public String addPoint(Model model, Principal principal)
    {
        model.addAttribute("point", new Point());
        model.addAttribute("users", personService.getAll());
        model.addAttribute("companies", companyService.getAll());
        model.addAttribute("isNew", true);

        return "admin/point-form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String savePoint(Principal principal, RedirectAttributes redAttrs,
                             @Valid @ModelAttribute("user") Point point,
                             BindingResult result, Model model)
    {
        if(result.hasErrors()) {
            redAttrs.addFlashAttribute("result", "fail");
            return "redirect:/admin/points";
        }

        Point oldPoint = pointService.getById(point.getId());
        Person person = personService.findByUsername(principal.getName());

        if(!person.getIsAdmin())
        {
            point.setPerson(person);
        }

        if(point.getCompany() == null)
        {
            point.setCompany(oldPoint.getCompany());
        }

        try {
            pointService.save(point);

        } catch (Exception ex) {
            redAttrs.addFlashAttribute("result", "fail");
            return "redirect:/admin/points";
        }

        redAttrs.addFlashAttribute("result", "success");
        return "redirect:/admin/points";
    }

    @RequestMapping(
            value = {"/update/{id}"},
            method = {RequestMethod.GET})
    public String updatePoint(Model model, Principal principal,
                               @PathVariable("id") int id)
    {
        Person person = personService.findByUsername(principal.getName());
        Point point = pointService.getById(id);

        model.addAttribute("isNew", false);
        model.addAttribute("isAdmin", person.getIsAdmin());
        model.addAttribute("companies", companyService.getAll());
        model.addAttribute("users", personService.getAll());
        model.addAttribute("point", point);

        return "admin/point-form";
    }

    @RequestMapping(
            value = {"/delete/{id}"},
            method = {RequestMethod.GET})
    public String deletePoint(Model model, @PathVariable("id") int id,
                             RedirectAttributes redAttrs, Principal principal)
    {

        Point point = pointService.getById(id);
        Person person = personService.findByUsername(principal.getName());

        if(person.getIsAdmin() || person.getId() == point.getPerson().getId())
        {
            try {
                pointService.delete(pointService.getById(id));

            } catch (Exception ex) {

                redAttrs.addFlashAttribute("result", "fail");
                return "redirect:/admin/users";
            }

            redAttrs.addFlashAttribute("result", "success");
            return "redirect:/admin/points";

        } else {
            redAttrs.addFlashAttribute("result", "fail");
            return "redirect:/admin/points";
        }

    }
}
