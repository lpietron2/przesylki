package pl.edu.wszib.controllers;

import com.sun.xml.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.model.Package;
import pl.edu.wszib.services.IPackageService;
import pl.edu.wszib.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommonController {

    @Autowired
    IPackageService packageService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingPage(){
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "/main";
    }

    @RequestMapping(value = "/showpackage/{id}", method = RequestMethod.GET)
    public String showPackageForm(@PathVariable int id, Model model){
        Package packages = this.packageService.getPackageById(id);
        model.addAttribute("packages", packages);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "/showpackage/{id}";
    }

    @RequestMapping(value = "/showpackage", method = RequestMethod.GET)
    public String showPackageLandingPage(){
        return "redirect:/main";
    }

@RequestMapping(value = "/showpackage/{id}", method = RequestMethod.POST)
    public String packageShow(@ModelAttribute Package packages){
        if(!this.sessionObject.isLogged()){
            return "redirect:/main";
        }
        this.packageService.updatePackageInfo(packages);
        return "redirect:/showpackage";
    }


}
