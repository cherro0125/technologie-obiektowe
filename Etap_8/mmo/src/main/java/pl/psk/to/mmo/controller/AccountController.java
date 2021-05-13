package pl.psk.to.mmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.psk.to.mmo.AccountMapper;
import pl.psk.to.mmo.model.Account;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Account>> getAllAccounts(){
        return ResponseEntity.ok(accountMapper.getAllAccounts());
    }
}
