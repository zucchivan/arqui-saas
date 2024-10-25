package zucchivan.dev.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import zucchivan.dev.model.*;

@Mapper
public interface EntityDTOMapper {

    EntityDTOMapper INSTANCE = Mappers.getMapper(EntityDTOMapper.class);

    PlantDTO toPlantDTO(Plant plant);
    Plant toPlantEntity(PlantDTO plantDTO);

    AppUserDTO toAppUserDTO(AppUser appUser);
    AppUser toAppUserEntity(AppUserDTO appUserDTO);

    ProjectDTO toProjectDTO(Project project);
    Project toProjectEntity(ProjectDTO projectDTO);

    RoomDTO toRoomDTO(Room room);
    Room toRoomEntity(RoomDTO roomDTO);

    MaterialDTO toMaterialDTO(Material material);
    Material toMaterialEntity(MaterialDTO material);
}