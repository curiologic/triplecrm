/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import crm.Message;
import crm.clients;
import crm.interactions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import repository.clientsDAO;
import repository.interactionsDAO;

/**
 *
 * @author xulix
 */
@Controller
public class InteractionsController {
     @Autowired
    interactionsDAO dao;
    
    @Autowired
    clientsDAO cdao = new clientsDAO();
    
    private static final Logger logger = Logger.getLogger(InteractionsController.class.getName());

    @RequestMapping("/interactions/interactionsform")
    public ModelAndView showform(){
        interactions interactions = new interactions();
        interactions.setClients(dao.getclientsMap());
        
        return new ModelAndView("interactionsform","command",interactions);
    }
    
    @RequestMapping("/interactions/interactionsform/{id}")
    public ModelAndView showformWithClient(@PathVariable int id){
        clients client = cdao.getclientsById(id);
        
        interactions interactions = new interactions();
        interactions.setIdclient(id);
        interactions.setClient( client);
        
       interactions.setClients(dao.getclientsMap());
        
        return new ModelAndView("interactionsform","command",interactions);
    }

    @RequestMapping(value = "/interactions/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("interactions") interactions interactions, HttpServletRequest request){
        int r = dao.save(interactions);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New interaction creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @RequestMapping("/interactions/viewinteractions")
    public ModelAndView viewalbum(HttpServletRequest request){
        //List<Album> list = dao.getAlbumsList();
        //return new ModelAndView("viewalbum","list",list);
        
        return this.viewinteractions(1, request);
    }
    
    @RequestMapping("/interactions/viewinteractions/{pageid}")
    public ModelAndView viewalbum(@PathVariable int pageid, HttpServletRequest request){
        int total = 25;
        int start = 1;
        
        if(pageid != 1) {
            start = (pageid-1) * total + 1;  
        }  
        
        List<interactions> list = dao.getinteractionsByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);
        
        int count = dao.getinteractionsCount();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");

        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }
       
        return new ModelAndView("viewinteractions", context);
    }

    @RequestMapping(value = "/interactiions/editinteracions/{id}")
    public ModelAndView edit(@PathVariable int id){
       interactions interactions = dao.getinteractionsById(id);
        
        interactions.setClients(dao.getclientsMap());
        
        return new ModelAndView("interactionseditform","command",interactions);
    }
    
    @RequestMapping(value = "/interactions/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("interactions") interactions album, HttpServletRequest request){
        int r = dao.update(album);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interactions has been successfully saved");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Edit interactions failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    @RequestMapping(value = "/interactions/deleteinteraction/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, HttpServletRequest request){
        int r = dao.delete(id);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.INFO, "Interaction has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Delete interactionfailed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }

    private ModelAndView viewinteractions(int i, HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


