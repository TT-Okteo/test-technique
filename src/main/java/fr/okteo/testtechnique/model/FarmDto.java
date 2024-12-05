package fr.okteo.testtechnique.model;

import fr.okteo.testtechnique.entity.Farm;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Farm}
 */
@Value
public class FarmDto implements Serializable {
    Long id;
    @NotNull
    @Size(min = 4)
    String name;
    @NotNull
    String type;
    String addressLine1;
    String addressLine2;
    String city;
    String state;
    String postalCode;
    String country;
}