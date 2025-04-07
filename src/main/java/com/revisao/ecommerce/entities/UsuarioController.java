package com.revisao.ecommerce.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.dto.UsuarioDTO;
import com.revisao.ecommerce.services.UsuarioService;
@RestController
@RequestMapping ("User")
public class UsuarioController {
	
	@Autowired  
    UsuarioService usuarioService;

    @PostMapping(value = "cadastrar") 
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO dto) {  
        dto = usuarioService.salvarUsuario(dto);  
        return ResponseEntity.ok(dto); 
    }

    @PostMapping(value = "/login") 
    public ResponseEntity<?> logar(@RequestBody UsuarioDTO dto) {  
        boolean teste = usuarioService.login(dto); 

        if (teste) {
            return ResponseEntity.ok("Sucesso"); 
        }
        return ResponseEntity.status(401).body("Senha ou Login incorretos");  
    }

}
