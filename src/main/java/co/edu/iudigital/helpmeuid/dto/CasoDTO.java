package co.edu.iudigital.helpmeuid.dto;

import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.model.Usuario;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
public class CasoDTO {

    Long id;

    LocalDateTime fechaHora;

    Float latitud;

    Float longitud;

    Float altitud;

    Boolean visible;

    String descripcion;

    String urlMap;

    String rmiUrl;

    DelitoDTO delito;

    UsuarioDTO usuario;
}




