package co.edu.iudigital.helpmeuid.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "delitos")
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class Delito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nombre", nullable = false)
    String nombre;

    @Column
    String descripcion;

    // si quiero llevar un registro de quien creó este delito
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarios_id")
    Usuario usuario;
}
