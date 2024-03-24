package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotToLoginPage(){
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotToWelcomePage(@RequestParam("name") String name,
                                   @RequestParam("password") String password,
                                   ModelMap modelMap){

        if(authenticationService.authenticate(name, password)){
            modelMap.put("name", name);
            return "welcome";
        }
        modelMap.put("errorMessage", "Invalid Credentials! Please try again.");
        return "login";
    }
}
