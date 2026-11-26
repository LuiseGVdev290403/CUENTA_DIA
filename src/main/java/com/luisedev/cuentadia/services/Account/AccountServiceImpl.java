package com.luisedev.cuentadia.services.Account;

import com.luisedev.cuentadia.dto.requets.AccountRequest;
import com.luisedev.cuentadia.dto.response.AccountResponse;
import com.luisedev.cuentadia.entities.Account;
import com.luisedev.cuentadia.mappers.Account.IAccountMapper;
import com.luisedev.cuentadia.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService  {

    private AccountRepository accountRepository;
    private IAccountMapper iAccountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, IAccountMapper iAccountMapper) {
        this.accountRepository = accountRepository;
        this.iAccountMapper = iAccountMapper;
    }

    @Override
    public List<AccountResponse> accountResponsesList() {
        List<Account> accountList = accountRepository.findAll();
        return iAccountMapper.toAccountResponse(accountList);
    }

    @Override
    public AccountResponse accountSave(AccountRequest accountRequest) {
        Account account = iAccountMapper.toAccountEntity(accountRequest);
        Account accountSave = accountRepository.save(account);
        return iAccountMapper.toAccountResponse(accountSave);
    }

    @Override
    public boolean accountDeleted(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public AccountResponse accountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        return iAccountMapper.toAccountResponse(account);
    }
}
