package apap.uts.PINI.service;

import apap.uts.PINI.model.AnggotaModel;
import java.util.List;

public interface AnggotaService {
    List<AnggotaModel> getAnggotaList();

    AnggotaModel getAnggotaByNia(String Nia);

    AnggotaModel updateAnggota(AnggotaModel anggota);

    void addAnggota(AnggotaModel anggota);

    void deleteAnggota(AnggotaModel anggota);
}
