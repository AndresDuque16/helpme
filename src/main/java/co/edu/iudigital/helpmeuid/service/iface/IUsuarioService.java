package co.edu.iudigital.helpmeuid.service.iface;

import co.edu.iudigital.helpmeuid.dto.UsuarioDTO;
import co.edu.iudigital.helpmeuid.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<UsuarioDTO> findAll();//TODO: Lanzar Excepcion personalizadas

    public UsuarioDTO findById(Long id);//TODO: Lanzar Excepcion personalizadas

    public UsuarioDTO save(UsuarioDTO usuarioDTO);//TODO: Lanzar Excepcion personalizadas

    public Usuario findByUsername(String name);//TODO: Lanzar Excepcion personalizadas
}
