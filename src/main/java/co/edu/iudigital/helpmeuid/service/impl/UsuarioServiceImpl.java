package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.RolDTO;
import co.edu.iudigital.helpmeuid.dto.UsuarioDTO;
import co.edu.iudigital.helpmeuid.model.Role;
import co.edu.iudigital.helpmeuid.model.Usuario;
import co.edu.iudigital.helpmeuid.repository.IUsuarioRepository;
import co.edu.iudigital.helpmeuid.service.iface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository iUsuarioRepository;

    @Autowired
    public UsuarioServiceImpl(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }


    @Override
    public List<UsuarioDTO> findAll() {

        List<Usuario> usuarios = iUsuarioRepository.findAll();
        return usuarios.stream().map(usuario ->
                UsuarioDTO.builder()
                        .id(usuario.getId())
                        .username(usuario.getUsername())
                        .nombre(usuario.getNombre())
                        .apellido(usuario.getApellido())
                        .password(usuario.getPassword())
                        .fechaNacimiento(usuario.getFechaNacimiento())
                        .enabled(usuario.getEnabled())
                        .image(usuario.getImage())
                        .redSocial(usuario.getRedSocial())
                        .rolDTO(RolDTO.builder()
                                .id(usuario.getRole().getId())
                                .nombre(usuario.getRole().getNombre())
                                .descripcion(usuario.getRole().getDescripcion())
                                .build())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findById(Long id) {

        Optional<Usuario> resp = iUsuarioRepository.findById(id);
        Usuario usuario=resp.get();
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .username(usuario.getUsername())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .password(usuario.getPassword())
                .fechaNacimiento(usuario.getFechaNacimiento())
                .enabled(usuario.getEnabled())
                .image(usuario.getImage())
                .redSocial(usuario.getRedSocial())
                .rolDTO(RolDTO.builder()
                        .id(usuario.getRole().getId())
                        .nombre(usuario.getRole().getNombre())
                        .descripcion(usuario.getRole().getDescripcion())
                        .build())
                .build();
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
        usuario.setEnabled(usuarioDTO.getEnabled());
        usuario.setRedSocial(usuarioDTO.getRedSocial());
        usuario.setImage(usuarioDTO.getImage());

        RolDTO rolDto=usuarioDTO.getRolDTO();
        Role role = new Role();
        role.setId(rolDto.getId());
        role.setNombre(rolDto.getNombre());
        role.setDescripcion(rolDto.getDescripcion());

        usuario.setRole(role);

        Usuario resp = iUsuarioRepository.save(usuario);
        return UsuarioDTO.builder()
                .id(resp.getId())
                .username(resp.getUsername())
                .nombre(resp.getNombre())
                .apellido(resp.getApellido())
                .password(resp.getPassword())
                .fechaNacimiento(resp.getFechaNacimiento())
                .enabled(resp.getEnabled())
                .image(resp.getImage())
                .redSocial(resp.getRedSocial())
                .rolDTO(RolDTO.builder()
                        .id(resp.getRole().getId())
                        .nombre(resp.getRole().getNombre())
                        .descripcion(resp.getRole().getDescripcion())
                        .build())
                .build();
    }

    @Override
    public Usuario findByUsername(String name) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        iUsuarioRepository.deleteById(id);
    }
}
