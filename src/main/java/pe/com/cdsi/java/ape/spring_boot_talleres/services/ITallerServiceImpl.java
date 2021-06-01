package pe.com.cdsi.java.ape.spring_boot_talleres.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cdsi.java.ape.spring_boot_talleres.models.Taller;
import pe.com.cdsi.java.ape.spring_boot_talleres.repository.ITallerRepository;

import java.util.List;

@Service
public class ITallerServiceImpl implements ITallerService {
    @Autowired
    private ITallerRepository tallerRepository;
    @Override
    public Taller getTaller(Long id) {
        return tallerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Taller> getTalleres() {
        return tallerRepository.findAll();
    }

    @Override
    public Taller grabar(Taller taller) {
        if (taller.getId() >0){
            Taller oTaller = this.getTaller(taller.getId());
            BeanUtils.copyProperties(taller,oTaller);
        }
        return tallerRepository.save(taller);
    }

    @Override
    public Taller eliminar(Long id) {
        //tallerRepository.delete(this.getTaller(id));
        Taller taller = this.getTaller(id);
        taller.setEstado("0");
        return tallerRepository.save(taller);
    }

    @Override
    public List<Taller> buscarXNombre(Taller taller) {
        String nombre = taller.getNombre();
        nombre=nombre==null?"":nombre;
        return tallerRepository.buscarXNombre("%"+nombre+"%");
    }
}
