package co.edu.iudigital.helpmeuid.service.iface;

import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.dto.RolDTO;

import java.util.List;

public interface IRolService {

    //Lista todos los roles
    public List<RolDTO> findAll();


    //Lista un rol por ID
    public RolDTO findById(Long id);

    // guardar un rol
    public RolDTO save(RolDTO rolDTO);//TODO: Lanzar Excepcion personalizadas

    // borrar un rol por ID
    public void delete(Long id);//TODO: Lanzar Excepcion personalizadas
}
