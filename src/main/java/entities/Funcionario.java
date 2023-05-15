package entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

//create table funcionario(codigo int primary key not null auto_increment, nome varchar(45) not null, cpf varchar(11) not null, cargo int not null, foreign key (cargo) references cargo(codigo), unique(nome, cpf));
@Data
@XmlRootElement(name="funcionario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Funcionario {
    private Integer codigo;
    private String nome;
    private String cpf;
    private Cargo cargo;

}
