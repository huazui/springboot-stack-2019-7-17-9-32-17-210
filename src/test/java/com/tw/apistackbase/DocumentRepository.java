package com.oocl.web.sampleWebApp.jpaSample.repository;
import com.oocl.web.sampleWebApp.jpaSample.entity.Document;
import com.oocl.web.sampleWebApp.jpaSample.entity.LawCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class DocumentRepository {
    @Autowired
    CaseRepository case1Repository;
    @Autowired
    DocRepository docRepository;

    @Test
    public void should_return_by_id() {
        Document doc = new Document("major", "cijor");
        long id = docRepository.save(doc).getId();

        Document itDoc = docRepository.findById(id);

        Assertions.assertEquals("major", itDoc.getSbujectElement());

    }

    @Test
    public void should_getAll_when_lawCase_save_document() {
       //given
        LawCase aCase = new LawCase("test", 123456789);
        case1Repository.save(aCase);
        Document doc = new Document("major", "cijor");
        //when
        long id = docRepository.save(doc).getId();
        Document itDoc = docRepository.findById(id);
        LawCase aCase2 = case1Repository.findByName("test");
        aCase2.setDocument(itDoc);
        //then
        Assertions.assertEquals("major", aCase2.getDocument().getSbujectElement());

    }
}
