package mappers;

import entities.Estado;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EstadoMapper {
    @Insert("insert into estados (sigla, nome) values (#{sigla}, #{nome})")
    void inserir (Estado estado);

    @Select("select codigo, sigla, nome from estados order by nome")
    List<Estado> listar();

    @Delete("delete from estados where codigo = #{codigo}")
    void excluir (Integer codigo);

    @Update("update estados set nome = #{nome}, sigla = #{sigla} where codigo = #{codigo}")
    void editar (Estado estado);
}
