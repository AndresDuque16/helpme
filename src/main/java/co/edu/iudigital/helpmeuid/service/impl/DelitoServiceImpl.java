package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.dto.RolDTO;
import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.model.Role;
import co.edu.iudigital.helpmeuid.repository.IDelitoRepository;
import co.edu.iudigital.helpmeuid.service.iface.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DelitoServiceImpl implements IDelitoService {
    private final IDelitoRepository delitoRepository;

    @Autowired
    public DelitoServiceImpl(IDelitoRepository delitoRepository){
        this.delitoRepository = delitoRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<DelitoDTO> findAll() {
        List<Delito> delitos = delitoRepository.findAll();
        // TODO: Refactoring a un mapper en paquete util
        return delitos.stream().map(d ->
            DelitoDTO.builder()
              .id(d.getId())
              .nombre(d.getNombre())
              .descripcion(d.getDescripcion())
              .build()
        ).collect(Collectors.toList());
    }

    @Override
    public DelitoDTO findById(Long id) {
        Optional<Delito> delito = delitoRepository.findById(id);
        return DelitoDTO.builder()
                .id(delito.get().getId())
                .nombre(delito.get().getNombre())
                .descripcion(delito.get().getDescripcion())
                .build();
    }


    @Override
    public DelitoDTO save(DelitoDTO delitoDTO) {
        Delito delito = new Delito();
        delito.setNombre(delitoDTO.getNombre());
        delito.setDescripcion(delitoDTO.getDescripcion());


        Delito delitos = delitoRepository.save(delito);

        return DelitoDTO.builder()
                .id(delitos.getId())
                .nombre(delitos.getNombre())
                .descripcion(delitos.getDescripcion())
                .build();
    }



    @Override
    public void delete(Long id) {
            delitoRepository.deleteById(id);
    }


    public DelitoDTO edit( DelitoDTO delitoDTO){
        Optional<Delito> res = delitoRepository.findById(delitoDTO.getId());
        Delito delito = res.get();
        delito.setNombre(delitoDTO.getNombre());
        delito.setDescripcion(delitoDTO.getDescripcion());
        Delito delitos = delitoRepository.save(delito);

        return DelitoDTO.builder()
                .id(delitos.getId())
                .nombre(delitos.getNombre())
                .descripcion(delitos.getDescripcion())
                .build();
    }


}
