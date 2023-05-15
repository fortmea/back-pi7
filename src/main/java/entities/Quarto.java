package entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
//create table quarto(codigo int not null primary key auto_increment, numero int not null, hotel int not null, foreign key (hotel) references hotel(codigo), unique(numero, hotel));
@Data
@XmlRootElement(name="quarto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Quarto {
    private Integer codigo;
    private Integer numero;
    private Hotel hotel;


}
