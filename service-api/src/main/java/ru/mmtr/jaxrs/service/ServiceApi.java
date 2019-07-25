package ru.mmtr.jaxrs.service;

import ru.mmtr.jaxrs.dto.HumanDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ServiceApi {

    public void addHuman(HumanDto humanDto);

    public List<HumanDto> getHumans();

    public List<HumanDto> getHumansByParams(String name,Long age,Long growth);

}
