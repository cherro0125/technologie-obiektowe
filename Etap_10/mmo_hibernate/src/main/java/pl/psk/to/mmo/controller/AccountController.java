package pl.psk.to.mmo.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.psk.to.mmo.model.Account;
import pl.psk.to.mmo.model.AccountPage;
import pl.psk.to.mmo.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<Page<Account>> getAccounts(AccountPage accountPage){
        return new ResponseEntity<>(accountService.getAccounts(accountPage), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.addAccount(account),HttpStatus.OK);
    }
}
