package mappers;

import entities.Funcionario;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FuncionarioMapper {
    @Insert("INSERT INTO funcionario(nome, cpf, cargo) values (#{nome},#{cpf}, #{cargo.codigo})")
    void inserir (Funcionario funcionario);

    @Select("SELECT f.codigo as funcionario_codigo, f.nome as funcionario_nome, f.cpf as funcionario_cpf, " +
            "c.codigo as cargo_codigo, c.nome as cargo_nome " +
            "FROM funcionario f " +
            "INNER JOIN cargo c ON c.codigo = f.cargo " +
            "ORDER BY f.nome")
    @Results(value = {
            @Result(column = "funcionario_codigo", property = "codigo"),
            @Result(column = "funcionario_nome", property = "nome"),
            @Result(column = "funcionario_cpf", property = "cpf"),
            @Result(column = "cargo_codigo", property = "cargo.codigo"),
            @Result(column = "cargo_nome", property = "cargo.nome")
    })
    List<Funcionario> listar();

    @Delete("DELETE FROM funcionario where codigo = #{codigo}")
    void excluir (Integer codigo);

    @Update("UPDATE funcionario set nome = #{nome}, cpf = #{cpf}, cargo = #{cargo.codigo} where codigo = #{codigo}")
    void editar (Funcionario funcionario);
}
