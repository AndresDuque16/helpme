package co.edu.iudigital.helpmeuid.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "casos")
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class Caso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "fecha_hora", nullable = false)
    LocalDateTime fechaHora;

    @Column
    Float latitud;

    @Column
    Float longitud;

    @Column
    Float altitud;

    @Column
    Boolean visible;

    @Column
    String descripcion;

    @Column(name = "url_map")
    String urlMap;

    @Column(name = "rmi_url")
    String rmiUrl;

    @ManyToOne
    @JoinColumn(name = "delitos_id")
    Delito delito;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    Usuario usuario;

    @PrePersist
    public void prePersist(){
        if(Objects.isNull(fechaHora)){
            fechaHora = LocalDateTime.now();
        }
    }
}
