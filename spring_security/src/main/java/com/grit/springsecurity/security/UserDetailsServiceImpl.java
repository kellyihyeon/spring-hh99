package com.grit.springsecurity.security;

import com.grit.springsecurity.domain.Account;
import com.grit.springsecurity.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException("Username Not Found Exception!!!");
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(account.getRole()));

        // 굳이 왜 넘기지?
        AccountContext accountContext = new AccountContext(account, roles);

        return accountContext;

    }
}
