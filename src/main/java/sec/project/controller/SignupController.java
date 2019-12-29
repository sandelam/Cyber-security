package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Controller
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping("*")
    public String defaultMapping(Model model, HttpSeession httpSession) {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm(Model model HttpSession httpSession) {
        return "form";
    }
    
    @RequestMapping(value = "/secret", method = RequestMethod.GET)
    public String redirectURL(@RequestParam String url) throws SQLException {
        return "redirect:" + url;
    }                
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String password) throws SQLException {
        signupRepository.save(new Signup(name, password));
        return "done";
    }

}
