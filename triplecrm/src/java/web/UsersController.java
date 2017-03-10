/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import crm.Message;
import crm.users;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import repository.usersDAO;
import validation.usersvalidator;

/**
 *
 * @author xulix
 */
@Controller
public class UsersController {
      @Autowired
    usersDAO dao;
    
    @Autowired
    private usersvalidator usersValidator;
    
    private static final Logger logger = Logger.getLogger(UsersController.class.getName());

    @RequestMapping("/users/usersform")
    public ModelAndView showform(){
        users users = new users();

        return new ModelAndView("usersform","command",users);
    }
    
    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user") @Valid users users, BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return new ModelAndView("usersform", "users", users);
        }
        
        int r = dao.save(users);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "User has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New user creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        // this needs to go to the user list view, but i am not providing one.
        return new ModelAndView("redirect:/users/viewusers");
    }
     @RequestMapping("/users/viewusers")
    public ModelAndView viewusers(HttpServletRequest request){
     
        
        return this.viewusers(1, request);
    }
    
    @RequestMapping("/users/viewusers/{pageid}")
    public ModelAndView viewusers(@PathVariable int pageid, HttpServletRequest request){
        int total = 25;
        int start = 1;
        
        if(pageid != 1) {
            start = (pageid-1) * total + 1;  
        }  
        
        List<users> list = dao.getusersByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);
        
        int count = dao.getusersCount();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }
       
        return new ModelAndView("viewusers", context);
    }

    @RequestMapping(value = "/users/editusers/{idusers}")
    public ModelAndView edit(@PathVariable int id){
       users users = dao.getusersById(id);
        
        
        
        return new ModelAndView("userseditform","users",users);
    }
    
    @RequestMapping(value = "/users/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("users") users users, HttpServletRequest request){
        int r = dao.update(users);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "user has been successfully saved");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Edit user failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/users/viewusers");
    }

    @RequestMapping(value = "/users/deleteusers/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request){
        int r = dao.delete(id);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "users has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Delete users failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/users/viewusers");
    }

  

    
    
    @InitBinder("users")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(usersValidator);
    }
    
    public usersvalidator getUserValidator() {
        return usersValidator;
    }
 
    public void setclientsvalidator(usersvalidator clientsValidator) {
        this.usersValidator = clientsValidator;
    }

   
    
}
