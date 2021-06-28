package pl.psk.to.mmo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.psk.to.mmo.model.Account;
import pl.psk.to.mmo.model.AccountPage;
import pl.psk.to.mmo.repository.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Page<Account> getAccounts(AccountPage accountPage){
        Sort sort = Sort.by(accountPage.getSortDirection(),accountPage.getSortBy());
        Pageable pageable = PageRequest.of(accountPage.getPageNumber(),accountPage.getPageSize(),sort);

        return accountRepository.findAll(pageable);
    }

    public Account addAccount(Account account){
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account){
        Optional<Account> optionalAccount = accountRepository.findById(account.getId());
        Account result=null;
        if(optionalAccount.isPresent()){
            Account foundAccount = optionalAccount.get();
            foundAccount.setEmail(account.getEmail());
            foundAccount.setNickname(account.getNickname());
            foundAccount.setLogin(account.getLogin());
            foundAccount.setPasswordHash(account.getPasswordHash());
            foundAccount.setBanExpiredAt(account.getBanExpiredAt());
            result = accountRepository.save(foundAccount);
        }
        return result;
    }

    public Boolean deleteAccount(Long id){
        accountRepository.deleteById(id);
        return Boolean.TRUE;
    }
}


