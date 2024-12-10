package CRE.CRE.dto;

import java.time.LocalDate;

public class ClientPMDTO {
    private String cli;  // Code du client
    private String tcli; // Type de client
    private String nidn; // Numéro d'identité nationale
    private String nrc;  // Numéro du registre du commerce
    private String nidf; // Numéro d'identité fiscale
    private String rso;  // Raison sociale de déclaration
    private String sig;  // Sigle
    private String nat;  // Nationalité
    private String res;  // Code du pays de résidence
    private String catn; // Code de la catégorie de la Banque Centrale
    private String fju;  // Code de la forme juridique
    private LocalDate datc; // Date de création de l'entreprise
    private LocalDate dmo;  // Date de dernière modification

    // Constructeur
    public ClientPMDTO(String cli, String tcli, String nidn, String nrc, String nidf, String rso, String sig, String nat, String res, String catn, String fju, LocalDate datc, LocalDate dmo) {
        this.cli = cli;
        this.tcli = tcli;
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

    // Getters et setters
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

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getNidf() {
        return nidf;
    }

    public void setNidf(String nidf) {
        this.nidf = nidf;
    }

    public String getRso() {
        return rso;
    }

    public void setRso(String rso) {
        this.rso = rso;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getCatn() {
        return catn;
    }

    public void setCatn(String catn) {
        this.catn = catn;
    }

    public String getFju() {
        return fju;
    }

    public void setFju(String fju) {
        this.fju = fju;
    }

    public LocalDate getDatc() {
        return datc;
    }

    public void setDatc(LocalDate datc) {
        this.datc = datc;
    }

    public LocalDate getDmo() {
        return dmo;
    }

    public void setDmo(LocalDate dmo) {
        this.dmo = dmo;
    }

    @Override
    public String toString() {
        return "ClientPMDTO{" +
                "cli='" + cli + '\'' +
                ", tcli='" + tcli + '\'' +
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

