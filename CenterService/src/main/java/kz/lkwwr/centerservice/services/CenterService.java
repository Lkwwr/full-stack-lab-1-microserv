package kz.lkwwr.centerservice.services;

import kz.lkwwr.centerservice.entities.Center;

import java.util.List;

public interface CenterService {
    void addCenter(Center center);

    List<Center> getCenters();

    Center getCenter(Long id);

    void saveCenter(Center center);

    void deleteCenter(Center center);
}
