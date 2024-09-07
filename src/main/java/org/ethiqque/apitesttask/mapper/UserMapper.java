package org.ethiqque.apitesttask.mapper;

import org.ethiqque.apitesttask.dto.UserInputDto;
import org.ethiqque.apitesttask.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    void updateUserFields(@MappingTarget User user, UserInputDto userInputDto);
}
