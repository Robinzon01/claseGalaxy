package pe.com.cdsi.java.ape.spring_boot_talleres.services;

import pe.com.cdsi.java.ape.spring_boot_talleres.models.Taller;

import java.util.List;

public interface ITallerService {
    public Taller getTaller(Long id);
    public List<Taller> getTalleres();
    public Taller grabar(Taller taller);
    Taller eliminar(Long id);

    List<Taller> buscarXNombre(Taller taller);
}
