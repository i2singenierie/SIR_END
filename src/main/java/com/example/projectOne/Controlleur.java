package com.example.projectOne;

import com.example.projectOne.Model.MapSectionPoints;
import com.example.projectOne.Model.Obj_pkd_pkf_route;
import com.example.projectOne.Model.Objets;
import com.example.projectOne.Model.Project_point;
import com.example.projectOne.metier.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/project1" ,method = { RequestMethod.GET, RequestMethod.POST })

public class Controlleur implements ErrorController {

    private MainService mainService;

    @Autowired
    public Controlleur(MainService mainService) {

        this.mainService = mainService;
    }

    @PostMapping("/somme")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> somme(@RequestBody Objets aa) {
        // System.out.println(aa);
        // Integer result = aa.getA() * aa.getB() ;
        // System.out.println("  b  = "+result);
        Integer result = this.mainService.sommeService(aa.getA(), aa.getB());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/getpk_route")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> getpk_route(@RequestBody Objets aa) {
        String result = this.mainService.getpk_routeS(aa.getX(), aa.getY());
        return new ResponseEntity<>(result, HttpStatus.OK);


    }

    // ajout fonction  getsection_pkd_pkf_route
//    @PostMapping("/getsection_pkd_pkf_route")
//    @CrossOrigin(origins = "*")
//    public ResponseEntity<?> getsection_pkd_pkf_route( @RequestBody Obj_pkd_pkf_route hh ) {
//        System.out.println(hh);
//        String result = this.mainService.getsection_pkd_pkf_route(hh.getPkd(),hh.getPkf(), hh.getRoute());
//        return new ResponseEntity<>(result, HttpStatus.OK);

//    }

    @PostMapping("/getsection_pkd_pkf_route")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> getsection_pkd_pkf_route1( @RequestBody Obj_pkd_pkf_route hh ) {
        System.out.println(hh);
        List<Map<String,?>> result = this.mainService.getsection_pkd_pkf_route1(hh.getPkd(),hh.getPkf(), hh.getRoute());
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    @PostMapping("/project_point")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> project_point( @RequestBody Project_point hh ) throws SQLException, IOException {
        System.out.println(hh);
        List<Map<String, String>> result = this.mainService.project_point(hh.getId_layer(),hh.getX(),hh.getY(), hh.getGeom_format());
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PostMapping("/projectLineByCoordEvent")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> projectLineByCoordEvent( @RequestBody MapSectionPoints hh ) throws SQLException, IOException {
        System.out.println(hh);
        List<Map<String, String>> result = this.mainService.projectLineByCoordEvent(hh.getX1(),hh.getY1(),hh.getX2(),hh.getY2());
        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getRouteNames")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> getRouteNames() {
        List<String> tt = this.mainService.getRouteNames();
        return new ResponseEntity<>(tt,HttpStatus.OK);
    }

    @PostMapping("/Localiser_un_point")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> Localiser_un_point( @RequestBody Obj_pkd_pkf_route hh ) {
        System.out.println(hh);
        String result = this.mainService.Localiser_un_point(hh.getPkd(),hh.getRoute());
        return new ResponseEntity<>(result, HttpStatus.OK);

    }


    @PostMapping("/getSegments")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> getSegments( @RequestBody Obj_pkd_pkf_route hh ) throws SQLException, IOException {
        System.out.println(hh);
        List<Map<String, String>> result = this.mainService.getSegments(hh.getPkd(),hh.getPkf(),hh.getRoute());
        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }


}


