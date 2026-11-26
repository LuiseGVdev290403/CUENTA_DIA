package com.luisedev.cuentadia.mappers.Account;

import com.luisedev.cuentadia.dto.requets.AccountRequest;
import com.luisedev.cuentadia.dto.response.AccountResponse;
import com.luisedev.cuentadia.entities.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAccountMapper {
    Account toAccountEntity (AccountRequest accountRequest);
    AccountResponse toAccountResponse(Account account);
    List<AccountResponse> toAccountResponse (List<Account> accountList);
}
