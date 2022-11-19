package com.example.projectOne.metier;

import com.example.projectOne.DbRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.*;

@Service
public class MainService {

    private UserRepo userRepo;

    @Autowired
    public MainService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Integer sommeService(Integer a,Integer b){
        return this.userRepo.addfromBase(a,b);
    }

    public String getpk_routeS(Double a,Double b){
        return this.userRepo.getpk_routeR(a,b);
    }

    // ajout fonction métier getsection_pkd_pkf_route
    public String getsection_pkd_pkf_route(Double pkd,Double pkf,String route){
        return this.userRepo.getsection_pkd_pkf_route(pkd,pkf,route);
    }


    public List<Map<String,?>> getsection_pkd_pkf_route1(Double pkd, Double pkf, String route){
        return this.userRepo.getsection_pkd_pkf_routeR1(pkd,pkf,route);
    }


    public List<Map<String, String>> project_point(Integer id_layer, Double x, Double y, Integer geom_format) throws SQLException, IOException {
        return this.Convert_clob_to_String(
                this.userRepo.project_point(id_layer,x,y,geom_format));
    }

    public List<Map<String, String>> projectLineByCoordEvent(Double x1, Double y1, Double x2, Double y2) throws SQLException, IOException {
        return this.Convert_clob_to_String(
                this.userRepo.projectLineByCoordEvent(x1,y1,x2,y2)


        );

    }

    public List<String> getRouteNames(){
        return this.userRepo.getAllROuteNames();
    }


    public  String Localiser_un_point( Double event_position,String route_name1){
        return this.userRepo.Localiser_un_point(event_position,route_name1);
    }


    public List<Map<String, String>> getSegments(Double pkd, Double pkf, String route_name1) throws IOException, SQLException {

       return this.Convert_clob_to_String(this.userRepo.getSegments(pkd,pkf,route_name1));

    }





    public List<Map<String, String>> Convert_clob_to_String(List<Map<String,?>> resultList ) throws SQLException, IOException {
        List<Map<String,String>> resultList2 = new ArrayList<>();
        int regionIndex = 1;
        for(Map<String, ?> intersection : resultList) {

            System.out.println("\nIndia Region - " + regionIndex);
            System.out.println("============================"
                    + "======================");

            // get entrySet() into Set
            Set<String> setOfIndianStates = intersection.keySet();

            // Collection Iterator
            Iterator<String> iterator =
                    setOfIndianStates.iterator();

            // iterate using while-loop after getting Iterator
            Map<String,String> map = new HashMap<String, String>();
            while(iterator.hasNext()) {

                String key = iterator.next();
                if(key.equals("ROUTE_GEOMETRY")){
                    Clob varr = (Clob) intersection.get(key);
                    Reader r = varr.getCharacterStream();
                    int j = 0;
                    StringBuffer buffer = new StringBuffer();
                    int ch;
                    while ((ch = r.read())!=-1) {
                        buffer.append(""+(char)ch);
                    }
                    String data = buffer.toString();
                    j++;
                    map.put(key,data);


                }else{
                    System.out.println("State : " + key
                            + "\tCapital : " + intersection.get(key));
                    map.put(key,"" + intersection.get(key));

                }

            }

            // increment region index by 1
            resultList2.add(map);
            regionIndex++;
        }

        return resultList2;
    }




}
