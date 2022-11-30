package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.RolDTO;
import co.edu.iudigital.helpmeuid.model.Role;
import co.edu.iudigital.helpmeuid.repository.IRoleRepository;
import co.edu.iudigital.helpmeuid.service.iface.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements IRolService {

    private final IRoleRepository roleRepository;

    @Autowired
    public RolServiceImpl(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RolDTO> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(
                role ->
                        RolDTO.builder()
                                .id(role.getId())
                                .nombre(role.getNombre())
                                .descripcion(role.getDescripcion())
                                .build()
        ).collect(Collectors.toList());
    }

    @Override
    public RolDTO findById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return RolDTO.builder()
                .id(role.get().getId())
                .nombre(role.get().getNombre())
                .descripcion(role.get().getDescripcion())
                .build();
    }

    @Override
    public RolDTO save(RolDTO rolDTO) {

        Role role = new Role();
        role.setNombre(rolDTO.getNombre());
        role.setDescripcion(rolDTO.getDescripcion());

        Role rolex = roleRepository.save(role);

        return RolDTO.builder()
                .id(rolex.getId())
                .nombre(rolex.getNombre())
                .descripcion(rolex.getDescripcion())
                .build();
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);

    }
}
