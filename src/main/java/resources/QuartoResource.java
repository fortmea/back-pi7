package resources;

import entities.Quarto;
import factories.MyBatisUtil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mappers.QuartoMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
@Path("/quartos")
public class QuartoResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarQuarto(Quarto quarto) {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            QuartoMapper quartoMapper = sqlSession.getMapper(QuartoMapper.class);
            quartoMapper.inserir(quarto);
            sqlSession.commit();
            return Response.status(Response.Status.CREATED).entity(quarto).build();
        }
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public Response listarQuarto() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            QuartoMapper quartoMapper = sqlSession.getMapper(QuartoMapper.class);
            List<Quarto> quartos = quartoMapper.listar();
            return Response.ok(quartos).build();
        }
    }

    @DELETE
    @Path("/{codigo}")
    public Response excluirQuarto(@PathParam("codigo") Integer codigo) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            QuartoMapper quartoMapper = sqlSession.getMapper(QuartoMapper.class);
            quartoMapper.excluir(codigo);
            sqlSession.commit();
            return Response.ok().build();
        }
    }

    @PUT
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response editarQuarto(Quarto quarto) {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            QuartoMapper quartoMapper = sqlSession.getMapper(QuartoMapper.class);
            quartoMapper.editar(quarto);
            sqlSession.commit();
            return Response.ok(quarto).build();
        }
    }
}
