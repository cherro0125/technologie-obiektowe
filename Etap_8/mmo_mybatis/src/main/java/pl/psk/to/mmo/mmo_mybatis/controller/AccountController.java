package pl.psk.to.mmo.mmo_mybatis.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.psk.to.mmo.mmo_mybatis.mapper.AccountMapper;
import pl.psk.to.mmo.mmo_mybatis.model.Account;
import pl.psk.to.mmo.mmo_mybatis.model.base.Criteria;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountMapper accountMapper;

    @PostMapping("/accounts/all")
    public ResponseEntity<List<Account>> getAllAccounts(@RequestBody Criteria criteria) {
        return ResponseEntity.ok(accountMapper.getAllAccounts(criteria));
    }
}
