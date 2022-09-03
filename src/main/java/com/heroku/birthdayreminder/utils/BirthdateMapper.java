package com.heroku.birthdayreminder.utils;

import com.heroku.birthdayreminder.DTO.BirthdateDTO;
import com.heroku.birthdayreminder.model.Birthdate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BirthdateMapper {
    BirthdateMapper INSTANCE = Mappers.getMapper( BirthdateMapper.class );

    Birthdate sourceToDestination(BirthdateDTO source);
    @Mapping(source = "date", target = "date", dateFormat = "dd.MM.yyyy")
    BirthdateDTO destinationToSource(Birthdate destination);
    void updateBirthDateFromDto(BirthdateDTO dto, @MappingTarget Birthdate entity);
}