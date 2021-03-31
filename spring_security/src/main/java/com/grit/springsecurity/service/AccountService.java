package com.grit.springsecurity.service;

import com.grit.springsecurity.domain.Account;
import com.grit.springsecurity.dto.AccountForm;
import com.grit.springsecurity.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AccountService {

    private final AccountRepository accountRepository;


    @Transactional
    public Long createUser(AccountForm accountForm) {
        Account account = accountForm.toEntity();       // toEntity()
        accountRepository.save(account);
        return account.getId();
    }
}
