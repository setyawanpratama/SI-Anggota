package apap.uts.PINI.service;

import apap.uts.PINI.model.AnggotaModel;
import apap.uts.PINI.repository.AnggotaDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnggotaServiceImpl implements AnggotaService{
    @Autowired
    AnggotaDb anggotaDb;

    @Override
    public List<AnggotaModel> getAnggotaList() {
        return anggotaDb.findAll();
    }

    @Override
    public AnggotaModel getAnggotaByNia(String Nia) {
        return anggotaDb.findByNia(Nia).get();
    }

    @Override
    public AnggotaModel updateAnggota(AnggotaModel anggota) {
        anggotaDb.save(anggota);

        return anggota;
    }

    @Override
    public void addAnggota(AnggotaModel anggota) {
        anggotaDb.save(anggota);
    }

    @Override
    public void deleteAnggota(AnggotaModel anggota) {
        anggotaDb.delete(anggota);
    }
}
