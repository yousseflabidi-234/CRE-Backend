package CRE.CRE.dto;
import java.time.LocalDate;
public class ClientPPDTO {
    private String cli;
    private String tcli;
    private String tid;
    private String nid;
    private LocalDate did;
    private String lid;
    private LocalDate vid;
    private String nom;
    private String pre;
    private String sext;
    private LocalDate dna;
    private String viln;
    private String res;
    private String sit;

    public String getCli() {
        return cli;
    }

    public void setCli(String cli) {
        this.cli = cli;
    }

    public String getTcli() {
        return tcli;
    }

    public void setTcli(String tcli) {
        this.tcli = tcli;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public LocalDate getDid() {
        return did;
    }

    public void setDid(LocalDate did) {
        this.did = did;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public LocalDate getVid() {
        return vid;
    }

    public void setVid(LocalDate vid) {
        this.vid = vid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getSext() {
        return sext;
    }

    public void setSext(String sext) {
        this.sext = sext;
    }

    public LocalDate getDna() {
        return dna;
    }

    public void setDna(LocalDate dna) {
        this.dna = dna;
    }

    public String getViln() {
        return viln;
    }

    public void setViln(String viln) {
        this.viln = viln;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getSit() {
        return sit;
    }

    public void setSit(String sit) {
        this.sit = sit;
    }

    public ClientPPDTO(String cli, String tcli, String tid, String nid, LocalDate did, String lid, LocalDate vid, String nom, String pre, String sext, LocalDate dna, String viln, String res, String sit) {
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
        this.res = res;
        this.sit = sit;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
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
                ", res='" + res + '\'' +
                ", sit='" + sit + '\'' +
                '}';
    }
}

