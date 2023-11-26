package kz.lkwwr.centerservice.services.impl;

import kz.lkwwr.centerservice.dtos.CenterDTO;
import kz.lkwwr.centerservice.entities.Center;
import kz.lkwwr.centerservice.repositories.CenterRepository;
import kz.lkwwr.centerservice.services.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterServiceImpl implements CenterService {
    @Autowired
    private CenterRepository centerRepository;
    @Override
    public void addCenter(Center center) {
        centerRepository.save(center);
    }

    @Override
    public List<Center> getAllCenters() {
        return centerRepository.findAll();
    }

    @Override
    public Center getCenter(Long id) {
        return centerRepository.getReferenceById(id);
    }

    @Override
    public void saveCenter(Center center) {
        centerRepository.save(center);
    }

    @Override
    public void deleteCenter(Center center) {
        centerRepository.delete(center);
    }

    @Override
    public CenterDTO convertToDTO(Center center) {
        CenterDTO centerDTO = new CenterDTO();

        centerDTO.setId(center.getId());
        centerDTO.setName(center.getName());
        centerDTO.setEmployees(center.getEmployees());

        return centerDTO;
    }
}
