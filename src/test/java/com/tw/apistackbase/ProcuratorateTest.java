package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.Document;
import com.oocl.web.sampleWebApp.jpaSample.entity.LawCase;
import com.oocl.web.sampleWebApp.jpaSample.entity.Procuratorate;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ProcuratorateTest {

        @Autowired
        CaseRepository case1Repository;
        @Autowired
       ProcuratorateRespository proRepository;

        @Test
        public void should_return_by_id() {
            Procuratorate doc = new Procuratorate();
            doc.setName("jianchayuan");
            long id = proRepository.save(doc).getId();

            Procuratorate itDoc = proRepository.findById(id);

            Assertions.assertEquals("jianchayuan", itDoc.getName());

        }

        @Test
        public void should_return_procuratorate_when_lawCase_save_it() {
            //given
            LawCase aCase = new LawCase("test", 123456789);
            case1Repository.save(aCase);
            Procuratorate doc = new Procuratorate();
            doc.setName("jianchayuan");
            //when
            long id = proRepository.save(doc).getId();
            Procuratorate itDoc = proRepository.findById(id);
            LawCase aCase2 = case1Repository.findByName("test");
            aCase2.setProcuratorate(itDoc);
            //then
            Assertions.assertEquals("jianchayuan", aCase2.getProcuratorate().getName());

        }

    }

