package ieti.eci.lab01.lab01.controller;


import ieti.eci.lab01.lab01.datos.User;
import ieti.eci.lab01.lab01.dto.UserDto;
import ieti.eci.lab01.lab01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( "/v1/user" )
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody UserDto userDto){
        try{
            userService.create(new User(Integer.toString(userService.all().size()+1),userDto.getName(),userDto.getLastName(),userDto.getEmail(), LocalDateTime.now()));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity<>("No se a podido crear el usuario",HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.GET,path = {"/{id}"})
    public ResponseEntity<User>findById(@PathVariable("id") String id){
        try{
            return new ResponseEntity<>(userService.findById(id),HttpStatus.CREATED);
        }catch (Exception ex){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity("No se encontro Usuario por el id : "+id,HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<User>all(){
        try{
            return new ResponseEntity(userService.all(),HttpStatus.CREATED);
        }catch (Exception ex){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity("No se encontraron usuarios",HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.PUT,path = {"/id"})
    public ResponseEntity<User>update(@RequestBody UserDto userDto,@PathVariable("id")String id ){
        try{
            userService.update(new User(id,userDto.getName(),userDto.getEmail(),userDto.getLastName(),LocalDateTime.now()),id);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception ex){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity("No se a podido actulizar el usuario",HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.DELETE,path = {"/id"})
    public ResponseEntity<User>update(@PathVariable("id")String id ){
        try{
            userService.deleteById(id);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception ex){
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity("No se a podido eliminar el usuario",HttpStatus.NOT_FOUND);
        }
    }



}
