package apap.uts.PINI.repository;

import apap.uts.PINI.model.AnggotaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnggotaDb extends JpaRepository<AnggotaModel, String> {
    Optional<AnggotaModel> findByNia(String nia);
}
