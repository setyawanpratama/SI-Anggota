package apap.uts.PINI.controller;

import apap.uts.PINI.model.AnggotaModel;
import apap.uts.PINI.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AnggotaController {
    @Autowired
    private AnggotaService anggotaService;

    @GetMapping("/")
    private String home(Model model){
        List<AnggotaModel> listAnggota = anggotaService.getAnggotaList();

        model.addAttribute("listAnggota", listAnggota);
        return "home";
    }

    @GetMapping("/anggota/tambah")
    private String addAnggotaFormPage(Model model){
        model.addAttribute("anggota", new AnggotaModel());
        return "formadd-anggota";
    }

    @PostMapping(value = "/anggota/tambah/")
    private String addAnggota(
            @ModelAttribute AnggotaModel anggota, Model model
    ){
        try{
            anggotaService.addAnggota(anggota);
        }catch (Exception e){
            model.addAttribute("error", "true");
            model.addAttribute("nia", anggota.getNia());
            model.addAttribute("anggota", new AnggotaModel());
            return "formadd-anggota";
        }
        model.addAttribute("listAnggota", anggotaService.getAnggotaList());
        return "home";
    }

    @GetMapping("/anggota/{nia}")
    private String viewAnggota(
            @PathVariable("nia") String nia, Model model
    ){
        AnggotaModel anggota = anggotaService.getAnggotaByNia(nia);
        model.addAttribute("anggota",anggota);
        return "view-anggota";
    }

    @GetMapping("/anggota/ubah/{nia}")
    private String updateAnggotaFormPage(
            @PathVariable("nia") String nia, Model model
    ){
        AnggotaModel anggota = anggotaService.getAnggotaByNia(nia);
        model.addAttribute("submitted", "false");
        model.addAttribute("anggota", anggota);
        return "formupdate-anggota";
    }

    @PostMapping("/anggota/ubah/{nia}")
    private String updateAnggota(
            @ModelAttribute AnggotaModel anggota,
            @PathVariable("nia") Integer nia,
            Model model
    ){
        AnggotaModel previousanggota = anggotaService.getAnggotaByNia(anggota.getNia());
        anggotaService.deleteAnggota(previousanggota);

        AnggotaModel updatedanggota = anggotaService.updateAnggota(anggota);
        model.addAttribute("submitted", "true");
        model.addAttribute("anggota", anggota);
        return "formupdate-anggota";
    }
}
