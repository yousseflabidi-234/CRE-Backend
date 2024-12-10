package CRE.CRE.Entity;

import java.time.LocalDate;

import jakarta.persistence.Id;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Table(name = "BKCLI")
@Data
@Entity
public class Client {


    @Id
    private String cli;

    @Column(name = "TCLI", length = 1)
    private String tcli;

    @Column(name = "TID", length = 5)
    private String tid;

    @Column(name = "NID", length = 20)
    private String nid;

    @Column(name = "DID")
    private LocalDate did;

    @Column(name = "LID", length = 30)
    private String lid;

    @Column(name = "VID")
    private LocalDate vid;

    @Column(name = "NOM", length = 36)
    private String nom;

    @Column(name = "PRE", length = 30)
    private String pre;

    @Column(name = "SEXT", length = 1)
    private String sext;

    @Column(name = "DNA")
    private LocalDate dna;

    @Column(name = "VILN", length = 30)
    private String viln;


    @Column(name = "SIT", length = 1)
    private String sit;

    @Column(name = "DOU")
    private LocalDate dou;

    @Column(name = "NIDN", length = 20)
    private String nidn;

    @Column(name = "NRC", length = 20)
    private String nrc;

    @Column(name = "NIDF", length = 20)
    private String nidf;

    @Column(name = "RSO", length = 65)
    private String rso;

    @Column(name = "SIG", length = 20)
    private String sig;

    @Column(name = "NAT", length = 3)
    private String nat;

    @Column(name = "RES", length = 3)
    private String res;

    @Column(name = "CATN", length = 4)
    private String catn;

    @Column(name = "FJU", length = 2)
    private String fju;

    @Column(name = "DATC")
    private LocalDate datc;

    @Column(name = "DMO")
    private LocalDate dmo;


    public Client(String cli, String tcli, String tid, String nid, LocalDate did, String lid, LocalDate vid, String nom, String pre, String sext, LocalDate dna, String viln, String res, String sit, LocalDate dou, String nidn, String nrc, String nidf, String rso, String sig, String nat, String res2, String catn, String fju, LocalDate datc, LocalDate dmo) {
        this.cli = cli;
        this.tcli = tcli;
        this.tid = tid;
        this.nid = nid;
        this.did = did;
        this.lid = lid;
        this.vid = vid;
        this.nom = nom;
        this.pre = pre;
        this.sext = sext;
        this.dna = dna;
        this.viln = viln;
        this.sit = sit;
        this.dou = dou;
        this.nidn = nidn;
        this.nrc = nrc;
        this.nidf = nidf;
        this.rso = rso;
        this.sig = sig;
        this.nat = nat;
        this.res = res;
        this.catn = catn;
        this.fju = fju;
        this.datc = datc;
        this.dmo = dmo;

    }

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" +
                "cli='" + cli + '\'' +
                ", tcli='" + tcli + '\'' +
                ", tid='" + tid + '\'' +
                ", nid='" + nid + '\'' +
                ", did=" + did +
                ", lid='" + lid + '\'' +
                ", vid=" + vid +
                ", nom='" + nom + '\'' +
                ", pre='" + pre + '\'' +
                ", sext='" + sext + '\'' +
                ", dna=" + dna +
                ", viln='" + viln + '\'' +
                ", sit='" + sit + '\'' +
                ", dou=" + dou +
                ", nidn='" + nidn + '\'' +
                ", nrc='" + nrc + '\'' +
                ", nidf='" + nidf + '\'' +
                ", rso='" + rso + '\'' +
                ", sig='" + sig + '\'' +
                ", nat='" + nat + '\'' +
                ", res='" + res + '\'' +
                ", catn='" + catn + '\'' +
                ", fju='" + fju + '\'' +
                ", datc=" + datc +
                ", dmo=" + dmo +
                '}';
    }
}

