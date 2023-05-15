package resources;

import entities.Hospede;
import factories.MyBatisUtil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mappers.HospedeMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Path("/hospedes")
public class HospedeResource {

    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response salvarHospede (Hospede hospede) {
        System.out.println(hospede);
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            HospedeMapper hospedeMapper = sqlSession.getMapper(HospedeMapper.class);
            hospedeMapper.inserir(hospede);

            sqlSession.commit();
            return Response.status(Response.Status.CREATED).entity(hospede).build();
        }
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public Response listarHospede  () {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            HospedeMapper hospedeMapper = sqlSession.getMapper(HospedeMapper.class);
            List<Hospede> estados = hospedeMapper.listar();
            return Response.ok(estados).build();
        }
    }

    @DELETE
    @Path("/{codigo}")
    public Response excluirHospede (@PathParam("codigo") Integer codigo) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            HospedeMapper hospedeMapper = sqlSession.getMapper(HospedeMapper.class);
            hospedeMapper.excluir(codigo);
            sqlSession.commit();
            return Response.ok().build();
        }
    }

    @PUT
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response editarHospede (Hospede hospede) {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            HospedeMapper hospedeMapper = sqlSession.getMapper(HospedeMapper.class);
            hospedeMapper.editar(hospede);
            sqlSession.commit();
            return Response.ok(hospede).build();
        }
    }
}
