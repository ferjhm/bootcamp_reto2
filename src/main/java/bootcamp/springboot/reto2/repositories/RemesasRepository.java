package bootcamp.springboot.reto2.repositories;

import bootcamp.springboot.reto2.persistence.entities.Remesas;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RemesasRepository extends JpaRepository<Remesas, Long> {



}
