package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.CasoDTO;
import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.dto.RolDTO;
import co.edu.iudigital.helpmeuid.dto.UsuarioDTO;
import co.edu.iudigital.helpmeuid.model.Caso;
import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.model.Usuario;
import co.edu.iudigital.helpmeuid.repository.ICasoRepository;
import co.edu.iudigital.helpmeuid.repository.IDelitoRepository;
import co.edu.iudigital.helpmeuid.repository.IRoleRepository;
import co.edu.iudigital.helpmeuid.service.iface.ICasoService;
import co.edu.iudigital.helpmeuid.service.iface.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CasoServiceImpl implements ICasoService {
    private final ICasoRepository casoRepository;

    @Autowired
    public CasoServiceImpl(ICasoRepository casoRepository){
        this.casoRepository = casoRepository;
    }

    @Override
    public List<CasoDTO> findAll() {
        List<Caso> casos = casoRepository.findAll();
        return casos.stream().map(caso ->
                CasoDTO.builder()
                        .id(caso.getId())
                        .fechaHora(caso.getFechaHora()) //TODO llamar metodo
                        .latitud(caso.getLatitud())
                        .longitud(caso.getLongitud())
                        .altitud(caso.getAltitud())
                        .visible(caso.getVisible())
                        .descripcion(caso.getDescripcion())
                        .urlMap(caso.getUrlMap())
                        .rmiUrl(caso.getRmiUrl())
                        .delito(DelitoDTO.builder()
                                .nombre(caso.getDelito().getNombre())
                                .descripcion(caso.getDelito().getDescripcion())
                                .build())
                        .usuario(UsuarioDTO.builder()
                                .username(caso.getUsuario().getUsername())
                                .nombre(caso.getUsuario().getNombre())
                                .apellido(caso.getUsuario().getApellido())
                                .password(caso.getUsuario().getPassword())
                                .fechaNacimiento(caso.getUsuario().getFechaNacimiento())
                                .enabled(caso.getUsuario().getEnabled())
                                .redSocial(caso.getUsuario().getRedSocial())
                                .image(caso.getUsuario().getImage())
                                .build())
                        .build()

        ).collect(Collectors.toList());
    }

    @Override
    public CasoDTO save(CasoDTO casoDTO) {

        Caso caso = new Caso();

        //String str = "1986-04-08 12:30";
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
       //LocalDateTime dateTime = LocalDateTime.parse(casoDTO.getFechaHora(), formatter);

        caso.setFechaHora(casoDTO.getFechaHora());
        caso.setLatitud(casoDTO.getLatitud());
        caso.setLongitud(casoDTO.getLongitud());
        caso.setAltitud(casoDTO.getAltitud());
        caso.setVisible(casoDTO.getVisible());
        caso.setDescripcion(casoDTO.getDescripcion());
        caso.setUrlMap(casoDTO.getUrlMap());
        caso.setRmiUrl(casoDTO.getRmiUrl());

        Delito delito = new Delito();
        delito.setId(casoDTO.getDelito().getId());
        delito.setNombre(casoDTO.getDelito().getNombre());
        delito.setDescripcion(casoDTO.getDelito().getDescripcion());

        caso.setDelito(delito);

        Usuario usuario = new Usuario();
        usuario.setId(casoDTO.getUsuario().getId());
        usuario.setUsername(casoDTO.getUsuario().getUsername());
        usuario.setNombre(casoDTO.getUsuario().getNombre());
        usuario.setApellido(casoDTO.getUsuario().getApellido());
        usuario.setPassword(casoDTO.getUsuario().getPassword());
        usuario.setFechaNacimiento(casoDTO.getUsuario().getFechaNacimiento());
        usuario.setEnabled(casoDTO.getUsuario().getEnabled());
        usuario.setRedSocial(casoDTO.getUsuario().getRedSocial());
        usuario.setImage(casoDTO.getUsuario().getImage());

        caso.setUsuario(usuario);


        Caso resp = casoRepository.save(caso);

        return CasoDTO.builder()
                .id(resp.getId())
                .fechaHora(resp.getFechaHora())
                .latitud(resp.getLatitud())
                .longitud(resp.getLongitud())
                .altitud(resp.getAltitud())
                .visible(resp.getVisible())
                .descripcion(resp.getDescripcion())
                .urlMap(resp.getUrlMap())
                .rmiUrl(resp.getRmiUrl())
                .delito(DelitoDTO.builder()
                        .nombre(resp.getDelito().getNombre())
                        .descripcion(resp.getDelito().getDescripcion())
                        .build())
                .usuario(UsuarioDTO.builder()
                        .username(resp.getUsuario().getUsername())
                        .nombre(resp.getUsuario().getNombre())
                        .apellido(resp.getUsuario().getApellido())
                        .password(resp.getUsuario().getPassword())
                        .fechaNacimiento(resp.getUsuario().getFechaNacimiento())
                        .enabled(resp.getUsuario().getEnabled())
                        .redSocial(resp.getUsuario().getRedSocial())
                        .image(resp.getUsuario().getImage())
                        .build())
                .build();
    }

    @Override
    public Boolean visible(Boolean visible, Long id) {
        return null;
    }

    @Override
    public CasoDTO findById(Long id) {
        Optional<Caso> resp = casoRepository.findById(id);
        Caso caso = resp.get();
        return CasoDTO.builder()
                .id(caso.getId())
                .fechaHora(caso.getFechaHora())
                .latitud(caso.getLatitud())
                .longitud(caso.getLongitud())
                .altitud(caso.getAltitud())
                .visible(caso.getVisible())
                .descripcion(caso.getDescripcion())
                .urlMap(caso.getUrlMap())
                .rmiUrl(caso.getRmiUrl())
                .delito(DelitoDTO.builder()
                        .nombre(caso.getDelito().getNombre())
                        .descripcion(caso.getDelito().getDescripcion())
                        .build())
                .usuario(UsuarioDTO.builder()
                        .username(caso.getUsuario().getUsername())
                        .nombre(caso.getUsuario().getNombre())
                        .apellido(caso.getUsuario().getApellido())
                        .password(caso.getUsuario().getPassword())
                        .fechaNacimiento(caso.getUsuario().getFechaNacimiento())
                        .enabled(caso.getUsuario().getEnabled())
                        .redSocial(caso.getUsuario().getRedSocial())
                        .image(caso.getUsuario().getImage())
                        .build())
                .build();
    }

    @Override
    public void deleteById(Long id) {
        casoRepository.deleteById(id);
    }


}
