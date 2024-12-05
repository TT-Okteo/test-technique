package fr.okteo.testtechnique.controller;

import fr.okteo.testtechnique.model.FarmDto;
import fr.okteo.testtechnique.service.FarmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Farms", description = "Farm management")
@RestController
@Validated
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    @Operation(operationId = "getAllFarms", summary = "Retrieve the list of farms",
            tags = {"Farms"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Query successfully processed",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = FarmDto.class))}),})
    @GetMapping("/farms")
    public ResponseEntity<List<FarmDto>> getAllFarm() {
        return ResponseEntity.ok(farmService.getAllFarms());
    }

    @Operation(operationId = "getFarmsById", summary = "Retrieve a farm",
            tags = {"Farms"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Query successfully processed",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = FarmDto.class))}),})
    @GetMapping("/farms/{id}")
    public ResponseEntity<FarmDto> getFarmById(
            @Parameter(name = "id", description = "Farm object identifier", required = true, in = ParameterIn.PATH)
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok(farmService.getFarmById(id));
    }

    @Operation(operationId = "createFarm", summary = "Create a new farm",
            tags = {"Farms"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Farm successfully created",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = FarmDto.class))}),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            })
    @PostMapping("/farms")
    public ResponseEntity<FarmDto> createFarm(
            @RequestBody FarmDto farmDto) {
        FarmDto createdFarm = farmService.createFarm(farmDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFarm);
    }


}