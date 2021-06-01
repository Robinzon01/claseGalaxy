package pe.com.cdsi.java.ape.spring_boot_talleres.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.cdsi.java.ape.spring_boot_talleres.models.Taller;
import pe.com.cdsi.java.ape.spring_boot_talleres.services.ITallerService;

import java.util.List;

@Data
@RestController
@RequestMapping("/talleres/v1")
public class TallerController {
    @Autowired
    private ITallerService tallerService;

    @GetMapping("/{id}")
    public Taller getTaller(@PathVariable Long id){
        return this.getTallerService().getTaller(id);
    }

    @GetMapping
    @RequestMapping("/buscar")
    public List<Taller> getTallerXNombre(@RequestParam String nombre){
        Taller taller = Taller.builder().nombre(nombre).build();
        return this.getTallerService().buscarXNombre(taller);
    }

    @GetMapping("/listado")
    public List<Taller> getTalleres(){

        return this.getTallerService().getTalleres();
    }
    @PostMapping
    public Taller insertar(@RequestBody Taller taller){
        return this.getTallerService().grabar(taller);
    }
    @PutMapping("/{id}")
    public Taller actualizar(@RequestBody Taller taller,@PathVariable Long id){
        taller.setId(id);
        return this.getTallerService().grabar(taller);
    }
    @DeleteMapping("{/id}")
    public Taller eliminar(@PathVariable Long id){

        return this.getTallerService().eliminar(id);
    }



}
