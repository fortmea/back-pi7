package entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

//create table hospede(codigo int primary key not null auto_increment, nome varchar(45) not null, cpf varchar(11) not null, celular varchar(12) not null unique, email varchar(60) not null unique, endereco varchar(160) not null, unique(nome, cpf));
@Data
@XmlRootElement(name="hospede")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hospede {
    private Integer codigo;
    private String nome;
    private String cpf;
    private String celular;
    private String email;
    private String endereco;
    
}
