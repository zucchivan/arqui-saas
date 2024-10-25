package zucchivan.dev.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import zucchivan.dev.model.*;
import zucchivan.dev.model.repository.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@Profile("local")
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Bean
    public CommandLineRunner loadData(AppUserRepository appUserRepository,
                                      ProjectRepository projectRepository,
                                      PlantRepository plantRepository,
                                      RoomRepository roomRepository,
                                      MaterialRepository materialRepository) {
        return args -> {
            logger.info("Initializing data...");

            AppUser user = new AppUser();
            user.setName("Ivan Santos");
            user.setProfile("Admin");
            appUserRepository.save(user);
            logger.info("Saved AppUser: {}", user);

            Project project = new Project();
            project.setName("Project Alpha");
            project.setLocation("New York");
            project.setStartDate(LocalDate.now());
            project.setEndDate(LocalDate.now().plusMonths(6));
            project.setBudget(new BigDecimal("100000.00"));
            projectRepository.save(project);
            logger.info("Saved Project: {}", project);

            Plant plant = new Plant();
            plant.setDescription("Plant Description");
            plant.setCreatedAt(LocalDateTime.now());
            plant.setUpdatedAt(LocalDateTime.now());
            plantRepository.save(plant);
            logger.info("Saved Plant: {}", plant);

            Room room = new Room();
            room.setName("Room A");
            room.setPlant(plant);
            roomRepository.save(room);
            logger.info("Saved Room: {}", room);

            Material material = new Material();
            material.setName("Material X");
            material.setType("Type A");
            material.setCostPerUnit(new BigDecimal("10.00"));
            material.setQuantity(100);
            material.setAmountPaid(new BigDecimal("1000.00"));
            material.setSupplier("Supplier Y");
            material.setMetadata("{\"key\":\"value\"}");
            material.setRoom(room);
            materialRepository.save(material);
            logger.info("Saved Material: {}", material);
        };
    }
}