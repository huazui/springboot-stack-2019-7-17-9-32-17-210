package com.oocl.web.sampleWebApp.jpaSample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
@Column(name="name",length=255)
  private String name;

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Long id) {
    this.id = id;
  }



  public String getName() {
    return name;
  }
}
