package co.edu.iudigital.helpmeuid.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class DelitoDTO {
    Long id;
    String nombre;
    String descripcion;
}
