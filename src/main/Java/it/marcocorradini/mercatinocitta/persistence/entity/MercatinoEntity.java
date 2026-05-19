package it.marcocorradini.mercatinocitta.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mercatini")
public class MercatinoEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titolo;
    private String descrizione;
    @Column(nullable = false)
    private LocalDateTime dataOra;
    @Column(nullable = false)
    private String piazza;
    @Enumerated(EnumType.STRING)
    private Tema tema;
    @Column(nullable = false)
    private Integer banchiTotali;
    @Column(nullable = false)
    private Integer banchiAssegnati=0;

    public MercatinoEntity() {}
    public Long getId(){
        return id;
    }
    public String getTitolo(){
        return titolo;
    } public void setTitolo(String titolo){
        this.titolo=titolo;
    }
    public String getDescrizione(){
        return descrizione;
    } public void setDescrizione(String descrizione){
        this.descrizione=descrizione;
    }
    public LocalDateTime getDataOra(){
        return dataOra;
    } public void setDataOra(LocalDateTime dataOra){
        this.dataOra=dataOra;
    }
    public String getPiazza(){
        return piazza;
    } public void setPiazza(String piazza){
        this.piazza=piazza;
    }
    public Tema getTema(){
        return tema;
    } public void setTema(Tema tema){
        this.tema=tema;
    }
    public Integer getBanchiTotali(){
        return banchiTotali;
    } public void setBanchiTotali(Integer banchiTotali){
        this.banchiTotali=banchiTotali;
    }
    public Integer getBanchiAssegnati(){
        return banchiAssegnati;
    } public void setBanchiAssegnati(Integer banchiAssegnati){
        this.banchiAssegnati=banchiAssegnati;
    }
}