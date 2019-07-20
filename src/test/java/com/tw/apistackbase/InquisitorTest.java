package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.Document;
import com.oocl.web.sampleWebApp.jpaSample.entity.Inquisitor;
import com.oocl.web.sampleWebApp.jpaSample.entity.LawCase;
import com.oocl.web.sampleWebApp.jpaSample.entity.Procuratorate;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class InquisitorTest {
    @Autowired
    ProcuratorateRespository proRepository;
    @Autowired
    InquisitorRespository inquisitorRespository;

    @Test
    public void should_return_procuratorate_when_lawCase_save_it() {
        //given
       Inquisitor inquisitor1=new Inquisitor("jianchaguan1");
        Inquisitor inquisitor2=new Inquisitor("jianchaguan2")  ;
        long id = inquisitorRespository.save(inquisitor1).getId();
        inquisitorRespository.save(inquisitor2);
        List<Inquisitor> inquisitors = new ArrayList<Inquisitor>();
        inquisitors.add(inquisitor1);
        inquisitors.add(inquisitor2);
        //when
        Procuratorate procuratorate=new Procuratorate();
        procuratorate.setName("yuan");
        procuratorate.setInquisitorList(inquisitors);
        //then
        Assertions.assertEquals(inquisitorRespository.findById(id).getName(),procuratorate.getInquisitorList().get(0).getName());

    }
}
