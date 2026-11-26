package com.luisedev.cuentadia.services.Account;

import com.luisedev.cuentadia.dto.requets.AccountRequest;
import com.luisedev.cuentadia.dto.response.AccountResponse;

import java.util.List;

public interface IAccountService {

    List<AccountResponse> accountResponsesList();
    AccountResponse accountSave(AccountRequest accountRequest);
    boolean accountDeleted(Long id);
    AccountResponse accountById(Long id);
}
