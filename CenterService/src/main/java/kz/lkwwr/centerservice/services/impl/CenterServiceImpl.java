package kz.lkwwr.centerservice.services.impl;

import kz.lkwwr.centerservice.entities.Center;
import kz.lkwwr.centerservice.repositories.CenterRepository;
import kz.lkwwr.centerservice.services.CenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CenterServiceImpl implements CenterService {
    private final CenterRepository centerRepository;
    @Override
    public void addCenter(Center center) {
        centerRepository.save(center);
    }

    @Override
    public List<Center> getCenters() {
        return centerRepository.findAll();
    }

    @Override
    public Center getCenter(Long id) {
        return centerRepository.getById(id);
    }

    @Override
    public void saveCenter(Center center) {
        centerRepository.save(center);
    }

    @Override
    public void deleteCenter(Center center) {
        centerRepository.delete(center);
    }
}
