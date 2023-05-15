package mappers;

import entities.Cidade;
import entities.Estado;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CidadeMapper {
    @Insert("insert into cidades (estado_codigo, nome) values (#{estado.codigo}, #{nome})")
    void inserir (Cidade cidade);

    @Select(
            "select\n" +
            "  c.codigo, c.nome,\n" +
            "  e.codigo as ecodigo, e.nome as enome, e.sigla as esigla\n" +
            "from\n" +
            "   cidades c\n" +
            "   inner join estados e on e.codigo = c.estado_codigo\n" +
            "order by\n" +
            "   c.nome\n"
    )
    @Results(value = {
            @Result (column = "ecodigo", property = "estado.codigo"),
            @Result (column = "enome", property = "estado.nome"),
            @Result (column = "esigla", property = "estado.sigla")
    })
    List<Cidade> listar();


}
