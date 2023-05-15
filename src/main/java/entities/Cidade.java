package entities;

import lombok.Data;

@Data
public class Cidade {
    private Integer codigo;
    private String nome;
    private Estado estado;
}
