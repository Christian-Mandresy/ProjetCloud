package com.cloudproject.backoffice.controller;

import com.cloudproject.backoffice.service.SignalementService;
import com.cloudproject.backoffice.service.StatusService;
import com.cloudproject.backoffice.service.TypeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.LinkedHashMap.*;

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
    public String list(Map<String, Object> modelMap)
    {
        modelMap.put("ListSign",signalementService.getNonAssigner());
        modelMap.put("ListType",typeService.geType());
        modelMap.put("ListStatus",statusService.getStatus());
        return "Assigner";
    }


    @RequestMapping(value = "/Assign" , method = RequestMethod.GET)
    public String Assignement(Model model, HttpServletRequest request) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("Long",request.getParameter("Long"));
        vars.put("Lat",request.getParameter("Lat"));
        String Long="49.905384422883465";
        String Lat="-14.879851813636995";
        vars.put("Long",Long);
        vars.put("Lat",Lat);
        int Id=Integer.parseInt(request.getParameter("Id"));
        String result = restTemplate
                .getForObject(
                        "https://api.geoapify.com/v1/geocode/reverse?lat={Lat}&lon={Long}&type=state&format=json&apiKey=0ffb5ea7d4164bb28ea3e65e4f417062",
                        String.class, vars);

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(result);
            String region=node.get("results").get(0).get("state").asText();
            model.addAttribute("region",region);
            model.addAttribute("Signalement",signalementService.getSign(Id));
            model.addAttribute("ListType",typeService.geType());
            model.addAttribute("ListStatus",statusService.getStatus());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        int inty=0;
        return "AssignSignalement";
    }

    @RequestMapping(value = "/InsertSign" , method = RequestMethod.GET)
    public String AjoutRegion(Model model, HttpServletRequest request)
    {
        String region=request.getParameter("NomRegion");
        int IdSignalement=Integer.parseInt(request.getParameter("IdSignalement"));

        return "Assigner";
    }


}
