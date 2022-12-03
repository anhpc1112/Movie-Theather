package com.training.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/account")
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping(path = "/add")
    public ResponseEntity<String> addAccount(@RequestBody Account account){
//        Account account = Account.builder().email(email).password(password).build();
        accountRepository.save(account);
        Integer a = 10;
        Integer b = 10;

        return new ResponseEntity<>("created account", HttpStatus.OK);
    }
    @PostMapping(path="/login")
    public ResponseEntity<String> checkLogin(@RequestBody Account account){
        Optional<Account> accountDb = accountRepository.findAccountByEmailAndPassword(account.getEmail(), account.getPassword());
        if (accountDb.isPresent()){
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        return new ResponseEntity<>("fail", HttpStatus.NOT_FOUND);
    }
}
