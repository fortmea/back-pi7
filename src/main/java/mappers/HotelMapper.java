package mappers;

import entities.Cargo;
import entities.Hotel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface HotelMapper {
    @Insert("INSERT INTO hotel(nomefantasia, cnpj) values(#{nomeFantasia}, #{cnpj})")
    void inserir (Hotel hotel);

    @Select("SELECT * FROM hotel ORDER BY nomefantasia")
    List<Hotel> listar();

    @Delete("DELETE FROM hotel where codigo = #{codigo}")
    void excluir (Integer codigo);

    @Update("UPDATE hotel set nomefantasia = #{nomeFantasia}, cnpj = #{cnpj} where codigo = #{codigo}")
    void editar (Hotel hotel);
}
