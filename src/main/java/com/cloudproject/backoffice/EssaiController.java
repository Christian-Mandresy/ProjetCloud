package com.cloudproject.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EssaiController {

    @GetMapping("/rehetra")
    public ModelAndView Essai(){
        String viewName = "test";

        Map<String, Object> model = new HashMap<String, Object>();

        model.put("numberOfMovies", "1234");

        return new ModelAndView(viewName , model);
    }

}
