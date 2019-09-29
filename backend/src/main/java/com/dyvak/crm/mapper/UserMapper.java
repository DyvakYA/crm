package com.dyvak.crm.mapper;

import com.dyvak.crm.domain.User;
import com.dyvak.crm.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDto, User> {
}
