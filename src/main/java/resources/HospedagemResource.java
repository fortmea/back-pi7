package resources;

import entities.Hospedagem;
import factories.MyBatisUtil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mappers.HospedagemMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Path("/hospedagens")
public class HospedagemResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarHospedagem(Hospedagem hospedagem) {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            HospedagemMapper hospedagemMapper = sqlSession.getMapper(HospedagemMapper.class);
            hospedagemMapper.inserir(hospedagem);
            sqlSession.commit();
            return Response.status(Response.Status.CREATED).entity(hospedagem).build();
        }
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public Response listarHospedagem() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            HospedagemMapper hospedagemMapper = sqlSession.getMapper(HospedagemMapper.class);
            List<Hospedagem> estados = hospedagemMapper.listar();
            return Response.ok(estados).build();
        }
    }

    @DELETE
    @Path("/{codigo}")
    public Response excluirHospedagem(@PathParam("codigo") Integer codigo) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            HospedagemMapper hospedagemMapper = sqlSession.getMapper(HospedagemMapper.class);
            hospedagemMapper.excluir(codigo);
            sqlSession.commit();
            return Response.ok().build();
        }
    }

    @PUT
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response editarHospedagem(Hospedagem hospedagem) {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            HospedagemMapper hospedagemMapper = sqlSession.getMapper(HospedagemMapper.class);
            hospedagemMapper.editar(hospedagem);
            sqlSession.commit();
            return Response.ok(hospedagem).build();
        }
    }
}
