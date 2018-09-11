package kg.edu.iaau.admin.controller;

import kg.edu.iaau.core.entity.Company;
import kg.edu.iaau.core.entity.Person;
import kg.edu.iaau.core.service.CompanyService;
import kg.edu.iaau.core.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/companies")
public class CompanyController
{
    @Autowired
    private PersonService personService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public String getCompanies(Model model, Principal principal)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return "accessDenied";
        }

        List<Company> companyList = companyService.getAll();
        model.addAttribute("companies", companyList);

        return "admin/company-list";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/new")
    public String addCompany(Model model, Principal principal)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return "accessDenied";
        }

        model.addAttribute("company", new Company());
        model.addAttribute("isNew", "true");


        return "admin/company-form";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String saveCompany(Principal principal, RedirectAttributes redAttrs,
                             @Valid @ModelAttribute("company") Company company,
                             BindingResult result, Model model)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return "accessDenied";

        }

        if(result.hasErrors()) {
            redAttrs.addFlashAttribute("result", "fail");
            return "redirect:/admin/companies";
        }

        companyService.save(company);
        redAttrs.addFlashAttribute("result", "success");
        return "redirect:/admin/companies";
    }

    @RequestMapping(
            value = {"/update/{id}"},
            method = {RequestMethod.GET})
    public String updateCompany(Model model, Principal principal,
                               @PathVariable("id") int id)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return "accessDenied";
        }

        Company company = companyService.getById(id);
        model.addAttribute("isNew", "false");
        model.addAttribute("company", company);

        return "admin/company-form";
    }

    @RequestMapping(
            value = {"/delete/{id}"},
            method = {RequestMethod.GET})
    public String deleteCompany(Model model, @PathVariable("id") int id,
                             RedirectAttributes redAttrs, Principal principal)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return "accessDenied";
        }

        try {
            companyService.delete(companyService.getById(id));
        } catch (Exception ex) {
            redAttrs.addFlashAttribute("result", "fail");
            return "redirect:/admin/companies";
        }

        redAttrs.addFlashAttribute("result", "success");
        return "redirect:/admin/companies";
    }
}