package co.edu.iudigital.helpmeuid.controller;

import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.service.iface.ICasoService;
import co.edu.iudigital.helpmeuid.service.iface.IDelitoService;
import co.edu.iudigital.helpmeuid.service.impl.DelitoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DelitoController {

    @Autowired
    private IDelitoService delitoService;

    @GetMapping("/listar_delitos")
    public ResponseEntity<List<DelitoDTO>> index(){
        return ResponseEntity
                .ok()
                .body(delitoService.findAll());
    }



}


