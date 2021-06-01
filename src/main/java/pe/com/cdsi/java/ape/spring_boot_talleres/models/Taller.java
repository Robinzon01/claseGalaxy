package pe.com.cdsi.java.ape.spring_boot_talleres.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity(name = "taller")
@Table(name = "TALLERES")
@NoArgsConstructor
@AllArgsConstructor
public class Taller {
    @Id
    @Column(name = "id_taller")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqTaller")
    @SequenceGenerator(name = "seqTaller",allocationSize = 1,sequenceName = "SEQ_TALLER")
    @Builder.Default
    private Long id=0L;

    private String nombre;

    private String descripcion;

    private String estado;
}
