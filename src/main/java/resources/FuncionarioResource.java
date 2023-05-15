package resources;

import entities.Funcionario;
import factories.MyBatisUtil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mappers.FuncionarioMapper;
import mappers.HotelMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Path("/funcionarios")
public class FuncionarioResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvarFuncionario(Funcionario funcionario) {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            FuncionarioMapper funcionarioMapper = sqlSession.getMapper(FuncionarioMapper.class);
            funcionarioMapper.inserir(funcionario);
            sqlSession.commit();
            return Response.status(Response.Status.CREATED).entity(funcionario).build();
        }
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public Response listarFuncionario() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            FuncionarioMapper funcionarioMapper = sqlSession.getMapper(FuncionarioMapper.class);
            List<Funcionario> estados = funcionarioMapper.listar();
            return Response.ok(estados).build();
        }
    }

    @DELETE
    @Path("/{codigo}")
    public Response excluirFuncionario(@PathParam("codigo") Integer codigo) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            FuncionarioMapper funcionarioMapper = sqlSession.getMapper(FuncionarioMapper.class);
            funcionarioMapper.excluir(codigo);
            sqlSession.commit();
            return Response.ok().build();
        }
    }

    @PUT
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response editarFuncionario(Funcionario funcionario) {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            FuncionarioMapper funcionarioMapper = sqlSession.getMapper(FuncionarioMapper.class);
            funcionarioMapper.editar(funcionario);
            sqlSession.commit();
            return Response.ok(funcionario).build();
        }
    }
}
