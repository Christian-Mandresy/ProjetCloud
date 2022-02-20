package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.service.SignalementService;
import com.cloudproject.backoffice.service.StatusService;
import com.cloudproject.backoffice.service.TypeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

@Controller
public class AssignementController {

    private SignalementService signalementService;
    private TypeService typeService;
    private StatusService statusService;

    @Autowired
    public void setSignalementService(SignalementService signalementService) {
        this.signalementService = signalementService;
    }

    @Autowired
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @RequestMapping("/FormAssign")
    public String list(Map<String, Object> modelMap, HttpServletRequest request) {
        HttpSession sess = request.getSession();
        String nomAdmin = (String) sess.getAttribute("nomAdmin");
        modelMap.put("nomAdmin", nomAdmin);
        modelMap.put("ListSign", signalementService.getNonAssigner());
        modelMap.put("ListType", typeService.geType());
        modelMap.put("ListStatus", statusService.getStatus());
        return "Assigner";
    }

    @RequestMapping(value = "/Assign", method = RequestMethod.GET)
    public String Assignement(Model model, HttpServletRequest request) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<>();

        vars.put("Long", request.getParameter("Long"));
        vars.put("Lat", request.getParameter("Lat"));

        int Id = Integer.parseInt(request.getParameter("Id"));

        String result = restTemplate
                .getForObject(
                        "https://api.geoapify.com/v1/geocode/reverse?lat={Lat}&lon={Long}&type=state&format=json&apiKey=0ffb5ea7d4164bb28ea3e65e4f417062",
                        String.class, vars);

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(result);
            String region = node.get("results").get(0).get("state").asText();
            model.addAttribute("region", region);
            model.addAttribute("Signalement", signalementService.getSign(Id));
            model.addAttribute("ListType", typeService.geType());
            model.addAttribute("ListStatus", statusService.getStatus());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        int inty = 0;
        return "AssignSignalement";
    }

}
