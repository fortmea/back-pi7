package resources;

import entities.Hotel;
import factories.MyBatisUtil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mappers.HotelMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Path("/hoteis")
public class HotelResource {

    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response salvarHotel (Hotel hotel) {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            HotelMapper hotelMapper = sqlSession.getMapper(HotelMapper.class);
            hotelMapper.inserir(hotel);
            sqlSession.commit();
            return Response.status(Response.Status.CREATED).entity(hotel).build();
        }
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public Response listarHotel () {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            HotelMapper hotelMapper = sqlSession.getMapper(HotelMapper.class);
            List<Hotel> estados = hotelMapper.listar();
            return Response.ok(estados).build();
        }
    }

    @DELETE
    @Path("/{codigo}")
    public Response excluirHotel(@PathParam("codigo") Integer codigo) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            HotelMapper hotelMapper = sqlSession.getMapper(HotelMapper.class);
            hotelMapper.excluir(codigo);
            sqlSession.commit();
            return Response.ok().build();
        }
    }

    @PUT
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response editarHotel(Hotel hotel) {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            HotelMapper hotelMapper = sqlSession.getMapper(HotelMapper.class);
            hotelMapper.editar(hotel);
            sqlSession.commit();
            return Response.ok(hotel).build();
        }
    }
}
