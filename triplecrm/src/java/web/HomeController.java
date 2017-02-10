/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import crm.clients;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author xulix
 */
@Controller
public class HomeController {
    
      @RequestMapping("/")
    public ModelAndView viewclients(){
        return new ModelAndView("index");
    }
}

   
