package entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.io.Serializable;

//CREATE TABLE IF NOT EXISTS `hospedagem` (
//  `codigo` int NOT NULL AUTO_INCREMENT,
//  `entrada` datetime DEFAULT NULL,
//  `saida` datetime DEFAULT NULL,
//  `funcionario` int NOT NULL,
//  `hospede` int NOT NULL,
//  `quarto` int NOT NULL,
//  PRIMARY KEY (`codigo`),
//  KEY `funcionario` (`funcionario`),
//  KEY `hospede` (`hospede`),
//  KEY `quarto` (`quarto`),
//  CONSTRAINT `hospedagem_ibfk_1` FOREIGN KEY (`funcionario`) REFERENCES `funcionario` (`codigo`),
//  CONSTRAINT `hospedagem_ibfk_2` FOREIGN KEY (`hospede`) REFERENCES `hospede` (`codigo`),
//  CONSTRAINT `hospedagem_ibfk_3` FOREIGN KEY (`quarto`) REFERENCES `quarto` (`codigo`)
//  Gerei o sql pelo heidSQL pois havia esquecido de salvar.
@Data
@XmlRootElement(name="hospedagem")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hospedagem implements Serializable {
    private Integer codigo;
    private String entrada;
    private String saida;
    private Funcionario funcionario;
    private Hospede hospede;
    private Quarto quarto;

}
