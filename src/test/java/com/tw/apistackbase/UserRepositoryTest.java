package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.LawCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

  @Autowired
  CaseRepository caseRepository;

  @Test
  public void test_should_return_user_when_the_user_exist() {
    //given
    LawCase lawCase = new LawCase();
    lawCase.setName("test");
    caseRepository.save(lawCase);

    //when
    List<LawCase> userList = caseRepository.findAll();

    //then
    Assertions.assertEquals(1, userList.size());
    Assertions.assertEquals("test", userList.get(0).getName());
  }
  @Test
  public void return_all_user_by_the_sanme_name(){
    LawCase lawCase = new LawCase();
    lawCase.setName("test");
    LawCase lawCase1=new LawCase();
    lawCase1.setName("another");
    caseRepository.save(lawCase);
    caseRepository.save(lawCase1);

    List<LawCase> lawCases = caseRepository.findUsersByName("test");

    Assertions.assertEquals(1, lawCases.size());
  }
  @Test
  public void delete_user_by_name(){
    LawCase lawCase = new LawCase();
    lawCase.setName("test");
    LawCase lawCase1=new LawCase();
    lawCase1.setName("another");
    caseRepository.save(lawCase);
    caseRepository.save(lawCase1);
    caseRepository.delete(lawCase);
    List<LawCase> lawCases = caseRepository.findAll();

    Assertions.assertEquals(1, lawCases.size());
  }
  @Test
  public void find_user_by_id(){
    LawCase lawCase = new LawCase();
    lawCase.setName("test");
    LawCase lawCase1=new LawCase();
    lawCase1.setName("another");
    long id=caseRepository.save(lawCase).getId();
    caseRepository.save(lawCase1);
    LawCase result = caseRepository.findById(id);
    Assertions.assertEquals("test", result.getName());
  }
}

