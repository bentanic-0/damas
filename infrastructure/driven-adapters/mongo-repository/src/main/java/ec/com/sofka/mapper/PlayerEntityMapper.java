package ec.com.sofka.mapper;

import ec.com.sofka.data.PlayerEntity;
import ec.com.sofka.gateway.dto.PlayerDTO;
import org.springframework.stereotype.Component;

@Component
public class PlayerEntityMapper {

    public static PlayerEntity mapToEntity(PlayerDTO playerDTO) {
        if (playerDTO == null) {
            return null;
        }

        return new PlayerEntity(
                playerDTO.getId(),
                playerDTO.getUserId()
        );
    }

    public static PlayerDTO mapToDTO(PlayerEntity playerEntity) {
        if (playerEntity == null) {
            return null;
        }

        return new PlayerDTO(
                playerEntity.getId(),
                playerEntity.getUserId(),
                null
        );
    }
}