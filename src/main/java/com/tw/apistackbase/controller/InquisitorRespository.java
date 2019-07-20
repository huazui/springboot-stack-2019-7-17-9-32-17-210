package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.Inquisitor;
import com.oocl.web.sampleWebApp.jpaSample.entity.Procuratorate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InquisitorRespository extends JpaRepository<Inquisitor, Long> {
    List<Inquisitor> findAll();
    Inquisitor findById(long id);
    @Override
    void delete(Inquisitor entity);
}
