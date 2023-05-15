package resources;

import entities.Cargo;
import factories.MyBatisUtil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mappers.CargoMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Path("/cargos")
public class CargoResource {

    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response salvarCargo (Cargo cargo) {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            CargoMapper cargoMapper = sqlSession.getMapper(CargoMapper.class);
            cargoMapper.inserir(cargo);
            sqlSession.commit();
            return Response.status(Response.Status.CREATED).entity(cargo).build();
        }
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public Response listarCargo () {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            CargoMapper cargoMapper = sqlSession.getMapper(CargoMapper.class);
            List<Cargo> estados = cargoMapper.listar();
            return Response.ok(estados).build();
        }
    }

    @DELETE
    @Path("/{codigo}")
    public Response excluirCargo(@PathParam("codigo") Integer codigo) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            CargoMapper cargoMapper = sqlSession.getMapper(CargoMapper.class);
            cargoMapper.excluir(codigo);
            sqlSession.commit();
            return Response.ok().build();
        }
    }

    @PUT
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response editarCargo(Cargo cargo) {
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()){
            CargoMapper cargoMapper = sqlSession.getMapper(CargoMapper.class);
            cargoMapper.editar(cargo);
            sqlSession.commit();
            return Response.ok(cargo).build();
        }
    }
}
