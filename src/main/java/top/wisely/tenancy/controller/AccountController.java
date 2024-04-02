package top.wisely.tenancy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wisely.tenancy.entity.Dealership;
import top.wisely.tenancy.repository.AccountRepository;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public List<Dealership> getDealerAccounts() {
        return accountRepository.findAll();
    }
}