package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.Document;
import com.oocl.web.sampleWebApp.jpaSample.entity.Procuratorate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcuratorateRespository extends JpaRepository<Procuratorate, Long> {
    List<Procuratorate> findAll();
    Procuratorate findById(long id);
    @Override
    void delete(Procuratorate entity);
}


