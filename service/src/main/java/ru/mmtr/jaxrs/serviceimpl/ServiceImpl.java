package ru.mmtr.jaxrs.serviceimpl;


import ru.mmtr.jaxrs.api.HumanDao;
import ru.mmtr.jaxrs.converter.HumanConverter;
import ru.mmtr.jaxrs.dto.HumanDto;
import ru.mmtr.jaxrs.searchcriteria.SearchCriteria;
import ru.mmtr.jaxrs.service.ServiceApi;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ServiceImpl implements ServiceApi {


    @Inject
    private HumanDao humanDao;

    public List<HumanDto> getHumans() {
        return HumanConverter.convertToHumanDtoList(humanDao.getHumans());
    }
    public void addHuman(HumanDto humanDto) {
        humanDao.addHuman(HumanConverter.convertToHuman(humanDto));
    }

    @Override
    public List<HumanDto> getHumansByParams(SearchCriteria searchCriteria) {
       return HumanConverter.convertToHumanDtoList(humanDao.getHumansByParams(searchCriteria));
    }
}
