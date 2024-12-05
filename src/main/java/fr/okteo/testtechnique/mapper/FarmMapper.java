package fr.okteo.testtechnique.mapper;

import fr.okteo.testtechnique.entity.Farm;
import fr.okteo.testtechnique.model.FarmDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Named("FarmMapper")
@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface FarmMapper {
    @Named("toDto")
    FarmDto toDto(Farm entity);

    @IterableMapping(qualifiedByName = "toDto")
    List<FarmDto> toDto(List<Farm> entityList);

    @Named("toEntity")
    Farm toEntity(FarmDto model);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Farm> toEntity(List<FarmDto> modelList);

}