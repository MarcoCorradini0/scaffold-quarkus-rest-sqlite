package it.marcocorradini.mercatinocitta.persistence.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.marcocorradini.mercatinocitta.persistence.entity.MercatinoEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MercatinoRepository implements PanacheRepository<MercatinoEntity> {
    
}
