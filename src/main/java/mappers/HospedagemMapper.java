package mappers;

import entities.Hospedagem;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface HospedagemMapper {
    @Insert("INSERT INTO hospedagem(entrada, saida, funcionario, hospede, quarto) values (#{entrada}, #{saida}, #{funcionario.codigo}, #{hospede.codigo}, #{quarto.codigo})")
    void inserir (Hospedagem hospedagem);

    @Select("SELECT h.codigo as hospedagem_codigo, h.entrada as hospedagem_entrada, h.saida as hospedagem_saida, " +
            "f.codigo as funcionario_codigo, f.nome as funcionario_nome, f.cpf as funcionario_cpf, " +
            "c.codigo as cargo_codigo, c.nome as cargo_nome, " +
            "o.codigo as hospede_codigo, o.nome as hospede_nome, o.cpf as hospede_cpf, o.celular as hospede_celular, o.email as hospede_email, o.endereco as hospede_endereco, " +
            "q.codigo as quarto_codigo, q.numero as quarto_numero, " +
            "t.codigo as hotel_codigo, t.nomeFantasia as hotel_nomeFantasia, t.cnpj as hotel_cnpj " +
            "FROM hospedagem h " +
            "INNER JOIN funcionario f ON f.codigo = h.funcionario " +
            "INNER JOIN cargo c ON f.cargo = c.codigo " +
            "INNER JOIN hospede o ON h.hospede = o.codigo " +
            "INNER JOIN quarto q ON q.codigo = h.quarto " +
            "INNER JOIN hotel t ON t.codigo = q.hotel " +
            "ORDER BY h.entrada")
    @Results(value = {
            @Result(column = "hospedagem_codigo", property = "codigo"),
            @Result(column = "hospedagem_entrada", property = "entrada"),
            @Result(column = "hospedagem_saida", property = "saida"),
            @Result(column = "funcionario_codigo", property = "funcionario.codigo"),
            @Result(column = "funcionario_nome", property = "funcionario.nome"),
            @Result(column = "funcionario_cpf", property = "funcionario.cpf"),
            @Result(column = "cargo_codigo", property = "funcionario.cargo.codigo"),
            @Result(column = "cargo_nome", property = "funcionario.cargo.nome"),
            @Result(column = "hospede_codigo", property = "hospede.codigo"),
            @Result(column = "hospede_nome", property = "hospede.nome"),
            @Result(column = "hospede_cpf", property = "hospede.cpf"),
            @Result(column = "hospede_celular", property = "hospede.celular"),
            @Result(column = "hospede_email", property = "hospede.email"),
            @Result(column = "hospede_endereco", property = "hospede.endereco"),
            @Result(column = "quarto_codigo", property = "quarto.codigo"),
            @Result(column = "quarto_numero", property = "quarto.numero"),
            @Result(column = "hotel_codigo", property = "quarto.hotel.codigo"),
            @Result(column = "hotel_nomeFantasia", property = "quarto.hotel.nomeFantasia"),
            @Result(column = "hotel_cnpj", property = "quarto.hotel.cnpj")
    })
    List<Hospedagem> listar();

    @Delete("DELETE FROM hospedagem where codigo = #{codigo}")
    void excluir (Integer codigo);

    @Update("UPDATE hospedagem " +
            "SET entrada = #{entrada}, saida = #{saida}, funcionario = #{funcionario.codigo}, hospede = #{hospede.codigo}, quarto = #{quarto.codigo} " +
            "WHERE codigo = #{codigo}")
    void editar(Hospedagem hospedagem);
}
