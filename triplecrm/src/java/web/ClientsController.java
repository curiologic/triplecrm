/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import crm.Message;
import crm.clients;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import repository.clientsDAO;
import validation.clientsvalidator;

/**
 *
 * @author xulix
 */
  @Controller
public class ClientsController {  
    @Autowired
    clientsDAO dao;

   private static final Logger logger = Logger.getLogger(ClientsController.class.getName());
   
    private clientsvalidator clientsvalidator;
   
    @RequestMapping("/clients/clientsform")
    public ModelAndView showform(){
        return new ModelAndView("clientsform","command",new clients());
    }

    @RequestMapping(value = "/clients/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("clients") clients clients, HttpServletRequest request){
        int r = dao.save(clients);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "client has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New client creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/clients/viewclients");
    }

   @RequestMapping("/clients/viewclients")
    public ModelAndView viewclients(HttpServletRequest request){
      
        return this.viewclients(1, request);
    }
    
    @RequestMapping("/clients/viewclients/{pageid}")
    public ModelAndView viewclients(@PathVariable int pageid, HttpServletRequest request){
        int total = 25;
        int start = 1;
         
        if(pageid != 1) {
            start = (pageid-1) * total + 1;  
        }  
        
        List<clients> list = dao.getclientsByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);
        
        int count = dao.getclientsCount();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }
       
        return new ModelAndView("viewclients", context);
    }

    @RequestMapping(value = "/clients/editclients/{idclient}")
    public ModelAndView edit(@PathVariable int idclient){
        clients clients = dao.getclientsById(idclient);
        return new ModelAndView("clientseditform","command",clients);
    }
    
    @RequestMapping(value = "/clients/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("clients") clients clients, HttpServletRequest request){
        int r = dao.update(clients);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "client has been successfully saved");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Edit client failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/clients/viewclients");
    }

    @RequestMapping(value = "/clients/deleteclients/{idclient}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int idclient, HttpServletRequest request){
        int r = dao.delete(idclient);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "client has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Delete client failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/clients/viewclients");
    }

   @InitBinder("clients")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(clientsvalidator);
    }
    
    public clientsvalidator getclientsValidator() {
        return clientsvalidator;
    }
 
    public void setclientsValidator(clientsvalidator clientsValidator) {
        this.clientsvalidator = clientsValidator;
    }

   
    

   
  }



       

