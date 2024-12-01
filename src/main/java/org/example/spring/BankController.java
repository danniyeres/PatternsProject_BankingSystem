package org.example.spring;

import org.example.pattern.facade.BankingSystemFacade;
import org.example.pattern.singletonDatabase.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bank")
public class BankController {

    private final BankingSystemFacade facade = new BankingSystemFacade();
    private User currentUser;

    @GetMapping("/")
    public String home(Model model) {
        if (currentUser == null) {
            return "login";
        }
        model.addAttribute("user", currentUser);
        return "dashboard";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password, Model model) {
        currentUser = facade.loginUser(name, password);
        if (currentUser != null) {
            model.addAttribute("user", currentUser);
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String password, Model model) {
        currentUser = facade.registerUser(name, password);
        model.addAttribute("user", currentUser);
        return "dashboard";
    }

    @GetMapping("/create-account")
    public String createAccountPage() {
        return "create-account";
    }

    @PostMapping("/create-account")
    public String createAccount(@RequestParam double initialBalance, Model model) {
        facade.createAccount(currentUser, initialBalance);
        model.addAttribute("user", currentUser);
        return "dashboard";
    }

    @GetMapping("/deposit")
    public String depositPage() {
        return "deposit";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String accountId, @RequestParam double amount, Model model) {
        facade.deposit(currentUser, accountId, amount);
        model.addAttribute("user", currentUser);
        return "dashboard";
    }

    @GetMapping("/withdraw")
    public String withdrawPage() {
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String accountId, @RequestParam double amount, Model model) {
        facade.withdraw(currentUser, accountId, amount);
        model.addAttribute("user", currentUser);
        return "dashboard";
    }

    @GetMapping("/transfer")
    public String transferPage() {
        return "transfer";
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam String fromAccountId, @RequestParam String toAccountId,
                           @RequestParam double amount, Model model) {
        facade.transfer(currentUser, fromAccountId, toAccountId, amount);
        model.addAttribute("user", currentUser);
        return "dashboard";
    }

    @GetMapping("/transaction-history")
    public String transactionHistory(Model model) {
        model.addAttribute("user", currentUser);
        return "transaction-history";
    }

    @GetMapping("/logout")
    public String logout() {
        currentUser = null;
        return "login";
    }
}
