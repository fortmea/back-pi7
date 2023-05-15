package entities;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

//create table hotel(codigo int not null auto_increment primary key, nomefantasia varchar(70) not null, cnpj varchar(14) not null unique);
@Data
@XmlRootElement(name="hotel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hotel {
    public Integer codigo;
    public String nomeFantasia;
    public String cnpj;

}
