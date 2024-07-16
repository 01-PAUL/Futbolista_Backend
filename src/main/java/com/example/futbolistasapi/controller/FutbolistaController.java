package com.example.futbolistasapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.futbolistasapi.entity.Futbolista;
import com.example.futbolistasapi.entity.Posicion;
import com.example.futbolistasapi.service.FutbolistaService;
import com.example.futbolistasapi.util.AppSettings;

@RestController
@RequestMapping("/url")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class FutbolistaController {

	@Autowired
	private FutbolistaService futboliService;
	
	@ResponseBody
	@GetMapping("/futbolista")
	public ResponseEntity<List<Futbolista>> listaFutbolista() {
		List<Futbolista> lista = futboliService.listaFutbolista();
		return ResponseEntity.ok(lista);
	}
	
	@ResponseBody
	@GetMapping("/posicion")
	public ResponseEntity<List<Posicion>> listaPosicion() {
		List<Posicion> lista = futboliService.listaPosicion();
		return ResponseEntity.ok(lista);
	}
	
	@ResponseBody
	@GetMapping("/futbolista/{id}")
	public List<Futbolista> listaFutbolistaxID(@PathVariable("id")int idFutbolista){
		return  futboliService.listaFutbolistaxID(idFutbolista);
	}

	@PostMapping("/registraFutbolista")
	@ResponseBody
	public ResponseEntity<?> registra(@RequestBody Futbolista obj) {
	    HashMap<String, Object> salida = new HashMap<>();
	    try {

	        // Validations
	        List<Futbolista> lstBusqueda = futboliService.listaFutbolistaPorNombreIgualRegistra(obj.getNombres(), obj.getApellidos());
	        if (!lstBusqueda.isEmpty()) {
	            salida.put("mensaje", "El Futbolista " + obj.getNombres() + " " + obj.getApellidos() + " ya existe");
	            return ResponseEntity.ok(salida);
	        }

	        Futbolista objSalida = futboliService.insertaFutbolista(obj);
	        if (objSalida == null) {
	            salida.put("mensaje", "Ocurrió un error al registrar");
	        } else {
	            salida.put("mensaje", "Se registró exitosamente el Futbolista " + "'" + objSalida.getNombres() + " " 
	                + obj.getApellidos() + "'" + " ID asignado: " + objSalida.getIdFutbolista());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	    }
	    return ResponseEntity.ok(salida);
	}


	
	@PutMapping("/actualizaFutbolista")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaFutbolista(@RequestBody Futbolista obj) {
	    Map<String, Object> salida = new HashMap<>();
	    try {
	        // Si no hay coincidencias, proceder con la actualización
	        Futbolista objSalida = futboliService.insertaFutbolista(obj);
	        if (objSalida == null) {
	            salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
	        } else {
	            salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
	    }
	    return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaFutbolista/{id}") 
	@ResponseBody 
	public ResponseEntity<Map<String, Object>> eliminaFutbolista(@PathVariable("id") int idFutbolista) { 
		Map<String, Object> salida = new HashMap<>(); 
		try { 
				futboliService.eliminaFutbolista(idFutbolista); 
				salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO); 
		} catch (Exception e) { 
			e.printStackTrace(); 
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR); 
		} 
		return ResponseEntity.ok(salida); 
	} 
	

}
