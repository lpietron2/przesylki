package pl.edu.wszib.przesylki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.przesylki.services.IPackageService;
import pl.edu.wszib.przesylki.model.Package;
import pl.edu.wszib.przesylki.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommonController2 {
    @Autowired
    IPackageService packageService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingPage(){
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainForm(Model model){
        Package packages = new Package();
        model.addAttribute("packages", packages);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String main(@ModelAttribute String code){
        this.packageService.getPackageByCode(code);

        return "redirect:/showpackage/{code}";
    }

    @RequestMapping(value = "/showpackage/{code}", method = RequestMethod.GET)
    public String showPackageForm(@PathVariable String code, Model model){
        Package packages = this.packageService.getPackageByCode(code);
        model.addAttribute("packages", packages);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "/showpackage/{code}";
    }

  /*  @RequestMapping(value = "/showpackage", method = RequestMethod.GET)
    public String showPackageLandingPage(){
        return "redirect:/main";
    }*/

   /* @RequestMapping(value = "/showpackage/{id}", method = RequestMethod.POST)
    public String packageShow(@ModelAttribute Package packages){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        this.packageService.updatePackageInfo(packages);
        return "redirect:/showpackage";
    }*/


}
