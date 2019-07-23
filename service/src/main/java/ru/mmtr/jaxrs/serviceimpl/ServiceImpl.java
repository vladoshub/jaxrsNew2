package ru.mmtr.jaxrs.serviceimpl;

import ru.mmtr.jaxrs.converter.HumanConverter;
import ru.mmtr.jaxrs.dao.HumanDaoImpl;
import ru.mmtr.jaxrs.dto.HumanDto;
import ru.mmtr.jaxrs.service.ServiceApi;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Local(ServiceApi.class)
public class ServiceImpl implements ServiceApi {


    public List<HumanDto> getHumans() {
        HumanDaoImpl humanDao = new HumanDaoImpl();
        return HumanConverter.convertToHumanDtoList(humanDao.getHumans());
    }
    public void addHuman(HumanDto humanDto) {
        HumanDaoImpl humanDao = new HumanDaoImpl();
        humanDao.addHuman(HumanConverter.convertToHuman(humanDto));
    }

}
