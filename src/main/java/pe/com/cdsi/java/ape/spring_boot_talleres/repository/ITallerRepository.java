package pe.com.cdsi.java.ape.spring_boot_talleres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.com.cdsi.java.ape.spring_boot_talleres.models.Taller;

import java.util.List;

@Repository
public interface ITallerRepository extends JpaRepository<Taller,Long> {
    //JPQL
    @Query("select t from taller t where upper(t.nombre) like upper(:nombre) and t.estado='1'")
    List<Taller> buscarXNombre(@Param("nombre") String nombre);
}
