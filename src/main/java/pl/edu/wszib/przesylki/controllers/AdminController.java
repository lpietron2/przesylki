package pl.edu.wszib.przesylki.controllers;


import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.przesylki.model.User;
import pl.edu.wszib.przesylki.model.UserAdmin;
import pl.edu.wszib.przesylki.services.IPackageService;
import pl.edu.wszib.przesylki.model.Package;
import pl.edu.wszib.przesylki.services.IUserAdminService;
import pl.edu.wszib.przesylki.services.IUserService;
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

    @Autowired
    IUserService userService;


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
        Package packagesNew = this.packageService.getPackageById(packages.getId());
        packagesNew.setStatus(packages.getStatus());

        this.packageService.editPackageInfo(packagesNew);
        return "redirect:/showpackage/" + packagesNew.getCode();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        model.addAttribute("packages", new Package());
        model.addAttribute("userFrom", new User());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Package packages, @ModelAttribute User userFrom){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }

        System.out.println("userFrom: " + userFrom);
        this.packageService.addPackage(packages);
        this.packageService.addUserFromToPackage(userFrom, packages);
        System.out.println("packege w add1 post: " + packages);

        //return "redirect:/main";
        return "redirect:/addUserTo/" + packages.getId();
    }


    @RequestMapping(value = "/addUserTo/{id}", method = RequestMethod.GET)
    public String add2From(@PathVariable int id, Model model){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }

        model.addAttribute("userTo", new User());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "/addUserTo";
    }

    @RequestMapping(value = "/addUserTo/{id}", method = RequestMethod.POST)
    public String add2(@PathVariable int id, @ModelAttribute User userTo){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        Package packages = this.packageService.getPackageById(id);
        System.out.println("Paczka z 2 add: " + packages);
        System.out.println("userTo: " + userTo);
        this.packageService.addUserToToPackage(userTo, packages);


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
}
