package co.edu.iudigital.helpmeuid.controller;


import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.dto.RolDTO;
import co.edu.iudigital.helpmeuid.repository.IRoleRepository;
import co.edu.iudigital.helpmeuid.service.iface.IDelitoService;
import co.edu.iudigital.helpmeuid.service.iface.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping("/listar_roles")
    public ResponseEntity<List<RolDTO>> index(){
        return ResponseEntity
                .ok()
                .body(rolService.findAll());
    }

    @PostMapping("/crear-role")
    @ResponseBody
    public RolDTO crearRole(@RequestBody RolDTO rolDTO) {

        return rolService.save(rolDTO);
    }
    @GetMapping("/id_role/{id}")
    public ResponseEntity<RolDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .ok()
                .body(rolService.findById(id));
    }

    @DeleteMapping("/borrar_role/{id}")
    public String delete(@PathVariable Long id){
        rolService.delete(id);
        return "Se elimino el rol con id: " + id;
    }




}
