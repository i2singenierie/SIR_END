package com.example.projectOne.DbRepo;

import com.example.projectOne.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserRepo extends JpaRepository<Users,Long> {

    @Query(value="select  somme_db(:a,:b) from dual" , nativeQuery = true)
    Integer addfromBase(@Param("a") Integer a,@Param("b") Integer b);


    @Query(value="select  getpk_route(:x,:y) from dual" , nativeQuery = true)
    String getpk_routeR(@Param("x") Double x,@Param("y") Double y);

    // ajout fonction
    @Query(value="select  getsection_pkd_pkf_route(:pkd,:pkf,:route) from dual" , nativeQuery = true)
    String getsection_pkd_pkf_route(@Param("pkd") Double pkd,@Param("pkf") Double pkf,@Param("route") String route);


    @Query(value="select * from Table(getsection_pkd_pkf_route_1(:pkd,:pkf,:route))" , nativeQuery = true)
    List<Map<String,?>> getsection_pkd_pkf_routeR1(@Param("pkd") Double pkd, @Param("pkf") Double pkf, @Param("route") String route);


    @Query(value="select * from Table(project_point(:id_layer,:x,:y,:geom_format))" , nativeQuery = true)
    List<Map<String,?>> project_point(@Param("id_layer") Integer id_layer, @Param("x") Double x,@Param("y") Double y, @Param("geom_format") Integer geom_format);

    @Query(value="select * from Table(projectLineByCoordEvent(:x1,:y1,:x2,:y2))" , nativeQuery = true)
    List<Map<String,?>> projectLineByCoordEvent(@Param("x1") Double x1, @Param("y1") Double y1, @Param("x2") Double x2,@Param("y2") Double y2);

    @Query( value ="select distinct axe from graphe_arc_lrs", nativeQuery = true)
    List<String> getAllROuteNames();

    @Query(value="select Localiser_un_point(:event_position,:route_name1) from dual" , nativeQuery = true)
    String Localiser_un_point(@Param("event_position") Double event_position,@Param("route_name1") String route_name1);


    @Query(value="select * from Table(getSegments(:pkDebut,:pkFin,:route_name1))" , nativeQuery = true)
    List<Map<String,?>> getSegments(@Param("pkDebut") Double pkDebut, @Param("pkFin") Double pkFin, @Param("route_name1") String route_name1);


}
