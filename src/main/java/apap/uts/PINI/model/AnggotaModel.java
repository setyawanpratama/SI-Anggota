package apap.uts.PINI.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "anggota")
public class AnggotaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 16)
    @Column(name = "nia", unique = true)
    private String nia;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama")
    private String nama;

    @NotNull
    @Column(name = "jenis_kelamin")
    private Integer jenisKelamin;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tanggal_lahir")
    private Date tanggalLahir;

    @NotNull
    @Size(max = 100)
    @Column(name = "alamat")
    private String alamat;

    @NotNull
    @Size(max = 20)
    @Column(name = "no_hp")
    private String noHp;

    @NotNull
    @Size(max = 50)
    @Column(name = "pekerjaan")
    private String pekerjaan;

    @NotNull
    @Column(name = "status")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNia() {
        return nia;
    }

    public void setNia(String nia) {
        this.nia = nia;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Integer jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
