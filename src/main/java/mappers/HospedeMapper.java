package mappers;

import entities.Cargo;
import entities.Hospede;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface HospedeMapper {
    @Insert("INSERT INTO hospede(nome, cpf, celular, email, endereco) values (#{nome}, #{cpf}, #{celular}, #{email}, #{endereco})")
    void inserir (Hospede hospede);

    @Select("SELECT * FROM hospede ORDER BY nome;")
    List<Hospede> listar();

    @Delete("DELETE FROM hospede where codigo = #{codigo}")
    void excluir (Integer codigo);

    @Update("UPDATE hospede set nome = #{nome}, cpf = #{cpf}, celular = #{celular}, endereco = #{endereco} where codigo = #{codigo}")
    void editar (Hospede hospede);
}
