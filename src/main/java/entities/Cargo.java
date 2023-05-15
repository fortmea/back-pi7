package entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

//create table cargo(codigo int primary key not null auto_increment, nome varchar(20) not null unique);
@Data
public class Cargo {
    private Integer codigo;
    private String nome;
}
