package co.edu.iudigital.helpmeuid.service.iface;

import co.edu.iudigital.helpmeuid.dto.CasoDTO;

import java.util.List;

public interface ICasoService {

    // consultar todos los casos
    public List<CasoDTO> findAll();//TODO: Lanzar Excepcion personalizadas

    // crear un caso
    public CasoDTO save(CasoDTO casoDTO);//TODO: Lanzar Excepcion personalizadas

    // activar/inactivar caso
    //TODO: Lanzar Excepcion personalizadas
    public Boolean visible(Boolean visible, Long id);

    // consultar caso por ID
    //TODO: Lanzar Excepcion personalizadas
    public CasoDTO findById(Long id);

    public void deleteById(Long id);
}
