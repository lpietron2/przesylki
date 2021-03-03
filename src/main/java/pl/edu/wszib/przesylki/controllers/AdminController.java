package pl.edu.wszib.przesylki.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.przesylki.model.User;
import pl.edu.wszib.przesylki.model.UserAdmin;
import pl.edu.wszib.przesylki.services.IPackageService;
import pl.edu.wszib.przesylki.model.Package;
import pl.edu.wszib.przesylki.services.IUserAdminService;
import pl.edu.wszib.przesylki.session.SessionObject;


import javax.annotation.Resource;

@Controller
public class AdminController {
    @Resource
    SessionObject sessionObject;

    @Autowired
    IPackageService packageService;

    @Autowired
    IUserAdminService userAdminService;


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable int id, Model model){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        Package packages = this.packageService.getPackageById(id);
        model.addAttribute("packages", packages);
        model.addAttribute("isLogged", this.sessionObject.isLogged());

        return "/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@ModelAttribute Package packages){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        System.out.println(packages.toString());
        this.packageService.editPackageInfo(packages);
        return "redirect:/showpackage/" + packages.getCode();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        model.addAttribute("packages", new Package());
        model.addAttribute("userFrom", new User());
        model.addAttribute("userTo", new User());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Package packages){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        this.packageService.addPackage(packages);
        return "redirect:/showpackage/" + packages.getCode();
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model){
        if(this.sessionObject.isLogged()){
            return "redirect:/main";
        }

        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("user", new UserAdmin());

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute UserAdmin userAdmin){
        this.userAdminService.authenticate(userAdmin);
        if(this.sessionObject.isLogged()){
            return "redirect:/main";
        }

        return "redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        this.userAdminService.logout();
        return "redirect:/login";
    }








    //TODO controller do wyszukiwania dla adminow
    @RequestMapping(value = "/findPackage", method = RequestMethod.GET)
    public String findPackageForm(Model model){
        if(this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        //TODO hmmm?
        //Package packages = this.packageService.getPackageById();
        //model.addAttribute("packages", packages);
        model.addAttribute("isLogged", this.sessionObject.isLogged());

        return "/findPackage";
    }

}
