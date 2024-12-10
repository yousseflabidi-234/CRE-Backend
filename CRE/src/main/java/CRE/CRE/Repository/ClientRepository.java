package CRE.CRE.Repository;

import CRE.CRE.Entity.Client;
import CRE.CRE.dto.*;
import CRE.CRE.dto.ClientPPDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {

    // Récupérer tous les clients PP
    @Query("SELECT new CRE.CRE.dto.ClientPPDTO(c.cli, c.tcli, c.tid, c.nid, c.did, c.lid, c.vid, c.nom, c.pre, c.sext, c.dna, c.viln, c.res, c.sit) " +
            "FROM Client c " +
            "WHERE c.tcli = '1'")
    List<ClientPPDTO> findAllClientsPP();

    // Récupérer tous les clients PM
    @Query("SELECT new CRE.CRE.dto.ClientPMDTO(c.cli, c.tcli, c.nidn, c.nrc, c.nidf, c.rso, c.sig, c.nat, c.res, c.catn, c.fju, c.datc, c.dmo) " +
            "FROM Client c " +
            "WHERE c.tcli IN ('2', '3')")
    List<ClientPMDTO> findAllClientsPM();

    @Query("SELECT new CRE.CRE.dto.ClientPPDTO(c.cli, c.tcli, c.tid, c.nid, c.did, c.lid, c.vid, c.nom, c.pre, c.sext, c.dna, c.viln, c.res, c.sit) " +
            "FROM Client c " +
            "WHERE c.tcli = '1' AND c.dou BETWEEN :startDate AND :endDate")
    List<ClientPPDTO> findClientsPPByOpeningDate(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    @Query("SELECT new CRE.CRE.dto.ClientPMDTO(c.cli, c.tcli, c.nidn, c.nrc, c.nidf, c.rso, c.sig, c.nat, c.res, c.catn, c.fju, c.datc, c.dmo) " +
            "FROM Client c " +
            "WHERE c.tcli IN ('2', '3') AND c.dou BETWEEN :startDate AND :endDate")
    List<ClientPMDTO> findClientsPMByOpeningDate(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);


    @Query("SELECT new CRE.CRE.dto.ClientPPDTO(c.cli, c.tcli, c.tid, c.nid, c.did, c.lid, c.vid, c.nom, c.pre, c.sext, c.dna, c.viln, c.res, c.sit) FROM Client c WHERE c.cli = :id AND c.tcli = '1'")
    ClientPPDTO findClientPPByCli(String id);


    @Query("SELECT new CRE.CRE.dto.ClientPMDTO(c.cli, c.tcli, c.nidn, c.nrc, c.nidf, c.rso, c.sig, c.nat, c.res, c.catn, c.fju, c.datc, c.dmo) " +
            "FROM Client c " +
            "WHERE c.cli = :id AND c.tcli IN ('2', '3')")
    ClientPMDTO findClientPMByCli(@Param("id") String cli);
}
