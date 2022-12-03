package co.edu.iudigital.helpmeuid.controller;

import co.edu.iudigital.helpmeuid.dto.CasoDTO;
import co.edu.iudigital.helpmeuid.service.iface.ICasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CasoController {

    @Autowired
    private ICasoService casoService;


    @GetMapping("listar-casos")
    public ResponseEntity<List<CasoDTO>> findAll(){

        return ResponseEntity.ok().body(casoService.findAll());
    }

    @PostMapping("/crear-caso")
    @ResponseBody
    public CasoDTO save(@RequestBody CasoDTO casoDTO){

        return casoService.save(casoDTO);
    }

    @GetMapping("/findCasoById/{id}")
    public ResponseEntity<CasoDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .ok()
                .body(casoService.findById(id));
    }

    @DeleteMapping("/borrar_caso/{id}")
    public String delete(@PathVariable Long id){
        casoService.deleteById(id);
        return "Se elimino el caso con id: " + id;
    }
}
