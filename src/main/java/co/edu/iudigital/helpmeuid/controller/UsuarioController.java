package co.edu.iudigital.helpmeuid.controller;

import co.edu.iudigital.helpmeuid.dto.UsuarioDTO;
import co.edu.iudigital.helpmeuid.service.iface.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("listar-usuarios")
    public ResponseEntity<List<UsuarioDTO>> findAll(){

        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @PostMapping("/crear-usuario")
    @ResponseBody
    public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuarioDto){

        return usuarioService.save(usuarioDto);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .ok()
                .body(usuarioService.findById(id));
    }

    @DeleteMapping("/borrar_usuario/{id}")
    public String delete(@PathVariable Long id){
        usuarioService.deleteById(id);
        return "Se elimino el usuario con id: " + id;
    }
}
