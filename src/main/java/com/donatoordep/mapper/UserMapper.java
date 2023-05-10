package com.donatoordep.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.donatoordep.dto.UserDTO;
import com.donatoordep.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User toEntity(UserDTO dto);

	@InheritInverseConfiguration
	UserDTO toDto(User user);

}
