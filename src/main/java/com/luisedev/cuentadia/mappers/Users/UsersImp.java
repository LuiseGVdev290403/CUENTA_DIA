package com.luisedev.cuentadia.mappers.Users;

import com.luisedev.cuentadia.dto.requets.UsersRequest;
import com.luisedev.cuentadia.dto.response.UsersResponse;
import com.luisedev.cuentadia.entities.Users;

public class UsersImp implements UsersMapper{
    @Override
    public UsersResponse toUserResponse(Users users) {
        return null;
    }

    @Override
    public Users toUserEntity(UsersRequest usersRequest) {
        return null;
    }
}
