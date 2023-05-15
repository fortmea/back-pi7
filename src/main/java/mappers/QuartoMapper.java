package mappers;

import entities.Quarto;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface QuartoMapper {
    @Insert("INSERT INTO quarto(numero, hotel) values (#{numero}, #{hotel.codigo})")
    void inserir (Quarto quarto);

    @Select("SELECT q.codigo as quarto_codigo, q.numero as quarto_numero, " +
            "h.codigo as hotel_codigo, h.nomeFantasia as hotel_nomeFantasia, h.cnpj as hotel_cnpj " +
            "FROM quarto q " +
            "INNER JOIN hotel h ON q.hotel = h.codigo " +
            "ORDER BY q.numero")
    @Results(value = {
            @Result(column = "quarto_codigo", property = "codigo"),
            @Result(column = "quarto_numero", property = "numero"),
            @Result(column = "hotel_codigo", property = "hotel.codigo"),
            @Result(column = "hotel_nomeFantasia", property = "hotel.nomeFantasia"),
            @Result(column = "hotel_cnpj", property = "hotel.cnpj")
    })
    List<Quarto> listar();


    @Delete("DELETE FROM quarto where codigo = #{codigo}")
    void excluir (Integer codigo);

    @Update("UPDATE quarto set numero = #{numero}, hotel = #{hotel.codigo}  where codigo = #{codigo}")
    void editar (Quarto quarto);
}
