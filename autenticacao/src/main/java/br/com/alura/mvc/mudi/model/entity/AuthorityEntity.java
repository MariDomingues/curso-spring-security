package br.com.alura.mvc.mudi.model.entity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "authority")
public class AuthorityEntity {

    private String authority;

    public AuthorityEntity() {
    }

    public AuthorityEntity(String authority) {
        this.authority = authority;
    }
}