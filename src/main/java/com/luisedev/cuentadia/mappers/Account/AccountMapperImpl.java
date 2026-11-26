package com.luisedev.cuentadia.mappers.Account;

import com.luisedev.cuentadia.dto.requets.AccountRequest;
import com.luisedev.cuentadia.dto.response.AccountResponse;
import com.luisedev.cuentadia.entities.Account;

import java.util.Collections;
import java.util.List;

public class AccountMapperImpl implements IAccountMapper {

    @Override
    public Account toAccountEntity(AccountRequest accountRequest) {
        if (accountRequest == null) {
            return null;
        }
        return new Account(
                accountRequest.name(),
                accountRequest.type(),
                accountRequest.initialBalance()
        );
    }

    @Override
    public AccountResponse toAccountResponse(Account account) {
        if (account == null) {
            return null;
        }
        return new AccountResponse(
                account.getId(),
                account.getName(),
                account.getType(),
                account.getInitialBalance()
        );
    }

    @Override
    public List<AccountResponse> toAccountResponse(List<Account> accountList) {
        if (accountList == null) {
            return Collections.emptyList();
        }
        return (List<AccountResponse>) accountList.stream().map(account -> {
            return new AccountResponse(
                    account.getId(),
                    account.getName(),
                    account.getType(),
                    account.getInitialBalance()
            );
        }).toList();
    }
}
