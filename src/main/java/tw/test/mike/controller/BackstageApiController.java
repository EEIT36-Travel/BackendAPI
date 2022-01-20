package tw.test.mike.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.test.mike.service.BackstageService;


@RestController
@RequestMapping({"/backstage"})
public class BackstageApiController {

    @Autowired
    private BackstageService backstageService;

    @GetMapping({"/membercountbycity"})
    public ResponseEntity<?> selectmembercountbycity(){
        JSONArray result = backstageService.selectmembercountbycity();
        if(result!=null){
            return ResponseEntity.ok(result.toString());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping({"/membercountbyarea"})
    public ResponseEntity<?>selectcountbyarea(){
        JSONArray result = backstageService.selectcountbyarea();
        if(result!=null){
            return ResponseEntity.ok(result.toString());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping({"/membercountbyall"})
    public ResponseEntity<?> selectcountAll(){
        Integer result = backstageService.countAllBy();

        if(result!=null){
            return ResponseEntity.ok(result.toString());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping({"/allmemberagedata"})
    public ResponseEntity<?> selectallmemberagedata(){
        JSONArray result = backstageService.allmemberagedata();

        if(result!=null){
            return ResponseEntity.ok(result.toString());
        }
        return ResponseEntity.notFound().build();
    }
}
