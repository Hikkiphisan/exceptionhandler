package org.example.exceptionhandler.controller;


import org.example.exceptionhandler.exception.DuplicateEmailException;
import org.example.exceptionhandler.model.Customer;
import org.example.exceptionhandler.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.List;


@Controller
@RequestMapping("/customers")
public class CustomerController {
   @Autowired
    private ICustomerService customerService;


   @GetMapping("")
    public String index(Model model) {
       List<Customer> customerList = customerService.findAll();
       model.addAttribute("customers", customerList);
       return "/index";
   }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }


   @PostMapping("/save")
    public String save(Customer customer) throws DuplicateEmailException {
       customerService.save(customer);
       return "redirect:/customers";
   }

   @GetMapping("/{id}/edit")   //gửi yêu cầu
    public String update(@PathVariable Long id, Model model) {
       model.addAttribute("customer", customerService.findById(id));
       return "/update";
   }


   @PostMapping("/update")
   public String update(Customer customer) throws DuplicateEmailException {
       customerService.save(customer);
       return "redirect:/customers";
   }

   @GetMapping("/{id}/delete")
   public String delete(Customer customer, RedirectAttributes redirect) {
       customerService.remove(customer.getId());
       redirect.addFlashAttribute("success","Removed customer sucessfully");
       return "redirect:/customers";
   }


   @GetMapping("/{ìd}/view")
   public String view(@PathVariable Long id, Model model) {
       model.addAttribute("customer", customerService.findById(id));
       return "/view";
   }

   @ExceptionHandler(DuplicateEmailException.class)
   public ModelAndView showInputNotAcceptable() {
       return new ModelAndView("/inputs-not-acceptable");
   }














}

