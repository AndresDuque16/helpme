package co.edu.iudigital.helpmeuid.dto;

import co.edu.iudigital.helpmeuid.model.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class UsuarioDTO {
    Long id;

    String username;

    String nombre;

    String apellido;

    String password;

    LocalDate fechaNacimiento;

    Boolean enabled;

    Boolean redSocial;

    String image;

    RolDTO  rolDTO;

}
