package fr.okteo.testtechnique.service;

import fr.okteo.testtechnique.entity.Farm;
import fr.okteo.testtechnique.mapper.FarmMapper;
import fr.okteo.testtechnique.model.FarmDto;
import fr.okteo.testtechnique.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmService {

    private final FarmMapper farmMapper;

    private final FarmRepository farmRepository;

    public List<FarmDto> getAllFarms() {
        return farmMapper.toDto(farmRepository.findAll());
    }

    public FarmDto getFarmById(Long id) {
        return farmMapper.toDto(farmRepository.findById(id).orElseThrow());
    }

    public FarmDto createFarm(FarmDto farmDto) {
        validateCreateFarmDto(farmDto);
        Farm farm = farmMapper.toEntity(farmDto);
        farm.setId(null);
        return farmMapper.toDto(farmRepository.save(farm));
    }

    private void validateCreateFarmDto(FarmDto farmDto) {
        if (!farmDto.getType().matches("Cereal|Livestock|Mixed")) {
            throw new IllegalArgumentException("Farm type must be 'Cereal', 'Livestock', or 'Mixed'.");
        }

        if (farmDto.getPostalCode() != null && !farmDto.getPostalCode().matches("\\d{5}")) {
            throw new IllegalArgumentException("Postal code must be a 5-digit number.");
        }
    }
}
