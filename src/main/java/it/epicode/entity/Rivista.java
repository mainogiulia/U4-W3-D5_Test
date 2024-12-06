package it.epicode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "riviste")
@NamedQuery(name = "trovaRiviste", query = "SELECT a FROM Rivista a")

public class Rivista extends Pubblicazione {
    private Periodicita periodicita;
}
