package ru.mmtr.jaxrs.converter;

import ru.mmtr.jaxrs.dto.HumanDto;
import ru.mmtr.jaxrs.model.Human;

import java.util.ArrayList;
import java.util.List;

public class HumanConverter {

    public static Human convertToHuman(HumanDto humanDto){
        return new Human(humanDto.getName(),humanDto.getAge(),humanDto.getGrowth(),humanDto.getId());
    }

    public static List<HumanDto> convertToHumanDtoList(List<Human> humans){
        List<HumanDto> humanDtos = new ArrayList<HumanDto>();
        for (Human human : humans) {
            humanDtos.add(convertToHuman(human));
        }
        return humanDtos;
    }

    public static HumanDto convertToHuman(Human human){
        return new HumanDto(human.getName(),human.getAge(),human.getGrowth(),human.getId());
    }
}
