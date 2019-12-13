package hibernate.controller;

import hibernate.service.AccountServiceImpl;
import hibernate.service.serv.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import hibernate.model.Account;


import java.util.List;

@Controller
public class AccountController {

    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView allAccounts(){
        List<Account> accounts = accountService.getAllAccounts();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        modelAndView.addObject("accountsList", accounts);
        return modelAndView;
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public ModelAndView account(@PathVariable("id") int id){
        Account account = accountService.getAccountById(1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        modelAndView.addObject("oneAccount", account);
        return modelAndView;
    }


    @RequestMapping(value = "/user/richest", method = RequestMethod.GET)
    public ModelAndView user(){
        List<Account> accounts = accountService.getAllAccounts();
        accounts.sort((o1, o2) -> o1.getAccountNumber() - o2.getAccountNumber());
        Account richest = accounts.get(accounts.size() - 1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        modelAndView.addObject("usersAc", richest);
        return modelAndView;
    }

    @RequestMapping(value = "/user/sum", method = RequestMethod.GET)
    public ModelAndView summ(){
        List<Account> accounts = accountService.getAllAccounts();
        int accountSum = accounts.stream().mapToInt(x -> x.getAccountNumber()).sum();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        modelAndView.addObject("summOfAccs", accountSum);
        return modelAndView;
    }
}
