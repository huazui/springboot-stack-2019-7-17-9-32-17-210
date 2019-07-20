package com.oocl.web.sampleWebApp.jpaSample.entity;

import javax.persistence.*;

    @Entity
    public class Inquisitor {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        @Column(nullable = false,length = 255)
        private String name;
        @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
        @JoinColumn(name="pro_id")
        private Procuratorate procuratorate;
        public Inquisitor(String name){
            this.name=name;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


