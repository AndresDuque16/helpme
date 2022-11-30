package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.CasoDTO;
import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.dto.RolDTO;
import co.edu.iudigital.helpmeuid.model.Caso;
import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.repository.ICasoRepository;
import co.edu.iudigital.helpmeuid.repository.IDelitoRepository;
import co.edu.iudigital.helpmeuid.repository.IRoleRepository;
import co.edu.iudigital.helpmeuid.service.iface.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CasoServiceImpl {
    private final ICasoRepository casoRepository;

    @Autowired
    public CasoServiceImpl(ICasoRepository casoRepository){
        this.casoRepository = casoRepository;
    }

/*
    @Override
    public List<CasoDTO> findAll() {
        List<Caso> casos = casoRepository.findAll();
        return casos.stream().map(c ->
                CasoDTO.builder()
                        .id(c.getId())
                        .altitud(c.getAltitud())
                        .latitud(c.getLatitud())
                        .descripcion(c.getDescripcion())
                        .delito(c.getDelito())
                        .fechaHora(c.getFechaHora())
                        .longitud(c.getLongitud())
                        .usuario(c.getUsuario())
                        .visible()

                )

    }*/

}
