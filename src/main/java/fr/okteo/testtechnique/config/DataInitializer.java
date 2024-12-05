package fr.okteo.testtechnique.config;

import com.github.javafaker.Faker;
import fr.okteo.testtechnique.entity.Animal;
import fr.okteo.testtechnique.entity.Farm;
import fr.okteo.testtechnique.repository.AnimalRepository;
import fr.okteo.testtechnique.repository.FarmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initAnimalDatabase(AnimalRepository repository) {
        return args -> {
            Faker faker = new Faker();
            for (int i = 1; i <= 150; i++) {
                Animal animal = new Animal();
                animal.setGender(faker.options().option("Male", "Female"));
                animal.setNationalNumber("FR" + String.format("%06d", faker.number().randomNumber(6, true)));
                animal.setName(faker.animal().name());
                animal.setBirthDate(faker.date().birthday().toInstant().atZone(ZoneId.of(faker.options().option("Europe/Paris", "Europe/London"))).toLocalDate());
                repository.save(animal);
            }
        };
    }

    @Bean
    CommandLineRunner initFarmDatabase(FarmRepository repository) {
        return args -> {
            Faker faker = new Faker();
            for (int i = 1; i <= 150; i++) {
                Farm farm = new Farm();
                farm.setName(faker.company().name());
                farm.setType(faker.options().option("Cereal", "Livestock", "Mixed"));
                farm.setAddressLine1(faker.address().streetAddress());
                farm.setAddressLine2(faker.address().secondaryAddress());
                farm.setCity(faker.address().cityName());
                farm.setState(faker.address().state());
                farm.setPostalCode(faker.address().zipCode());
                farm.setCountry(faker.address().country());
                repository.save(farm);
            }
        };
    }
}
