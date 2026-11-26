package com.luisedev.cuentadia.mappers.Users;

import com.luisedev.cuentadia.dto.requets.UsersRequest;
import com.luisedev.cuentadia.dto.response.UsersResponse;
import com.luisedev.cuentadia.entities.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersResponse toUserResponse (Users users);
    Users toUserEntity (UsersRequest usersRequest);

}
