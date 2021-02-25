package pl.edu.wszib.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.model.Package;
import pl.edu.wszib.services.IPackageService;
import pl.edu.wszib.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class AdminController {
    @Resource
    SessionObject sessionObject;

    @Autowired
    IPackageService packageService;

@RequestMapping(value = "/showpackage/{id}", method = RequestMethod.POST)
    public String packageShow(@ModelAttribute Package packages){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        this.packageService.updatePackageInfo(packages);
        return "redirect:/showpackage";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable int id, Model model){
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
        this.packageService.updatePackageInfo(packages);
        return "redirect:/showpackage/{id}";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }

        model.addAttribute("packages", new Package());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute Package packages){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        this.packageService.addPackage(packages);
        return "redirect:/showpackage/{id}";
    }

    //TODO controller do wyszukiwania dla adminow
    @RequestMapping(value = "/findPackage", method = RequestMethod.GET)
    public String findPackageForm(Model model){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        //TODO hmmm?
        //Package packages = this.packageService.getPackageById();
        //model.addAttribute("packages", packages);
        model.addAttribute("isLogged", this.sessionObject.isLogged());

        return "/findPackage";
    }

}
