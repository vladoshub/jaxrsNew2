package ru.mmtr.jaxrs.service;

import com.sun.jndi.toolkit.dir.SearchFilter;
import ru.mmtr.jaxrs.dto.HumanDto;
import ru.mmtr.jaxrs.searchcriteria.SearchCriteria;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ServiceApi {

    public void addHuman(HumanDto humanDto);

    public List<HumanDto> getHumans();

    public List<HumanDto> getHumansByParams(SearchCriteria searchCriteria);

}
