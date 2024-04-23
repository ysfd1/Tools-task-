package App;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EJB.Calc;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless 
@Path ("cal")

public class ApplicationService {
	@PersistenceContext (unitName = "operation")
	private EntityManager entityManegar ; 
	@POST
	@Path ("calc")
	public String AddRow (Calc calc )
	{
		int N1 = calc.getNumber1(); 
		int N2 = calc.getNumber2();
		String Operation = calc.getOperation() ; 
		int result = calc.CalcResult(N1, N2, Operation) ; 
		calc.setResult(result);
		entityManegar.persist(calc);
		return "result : " + result ; 
		
	}
	@GET 
	@Path ("calculations")
	public List <Calc> Getall ()
	{
		TypedQuery <Calc> Query = entityManegar.createQuery("select c from Calc c ",Calc.class) ;
		List <Calc> Calculation = Query.getResultList() ; 
		return Calculation ; 
		
	}
	

}
