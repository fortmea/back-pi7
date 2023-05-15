package mappers;

import entities.Cargo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CargoMapper {
    @Insert("INSERT INTO cargo(nome) values (#{nome})")
    void inserir (Cargo cargo);

    @Select("SELECT * FROM cargo ORDER BY nome;")
    List<Cargo> listar();

    @Delete("DELETE FROM cargo where codigo = #{codigo}")
    void excluir (Integer codigo);

    @Update("UPDATE cargo set nome = #{nome} where codigo = #{codigo}")
    void editar (Cargo cargo);
}
