package ch.heigvd.ptl.sc.rest;

import ch.heigvd.ptl.sc.CityEngagementException;
import ch.heigvd.ptl.sc.persistence.IssueTypeRepository;
import ch.heigvd.ptl.sc.converter.IssueTypeConverter;
import ch.heigvd.ptl.sc.model.IssueType;
import ch.heigvd.ptl.sc.to.IssueTypeTO;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/issue_types")
public class IssueTypeResource {
	@Autowired
	private IssueTypeRepository issuetypeRepository;
	
	@Autowired
	private IssueTypeConverter issuetypeConverter;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAll() {
		return Response.ok(issuetypeConverter.convertSourceToTarget(issuetypeRepository.findAll())).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(IssueTypeTO issuetypeTO) {
		IssueType issuetype = issuetypeRepository.save(issuetypeConverter.convertTargetToSource(issuetypeTO));
		
		return Response.ok(issuetypeConverter.convertSourceToTarget(issuetype)).status(201).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response read(@PathParam("id") String id) {
		IssueType issuetype = issuetypeRepository.findOne(id);
		
		if (issuetype == null) {
			throw new CityEngagementException(404, "Model not found.");
		}
		
		return Response.ok(issuetypeConverter.convertSourceToTarget(issuetype)).build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") String id, IssueTypeTO issuetypeTO) {
		IssueType issuetype = issuetypeRepository.findOne(id);

		if (issuetype == null) {
			throw new CityEngagementException(404, "Model not found.");
		}
		
		issuetypeConverter.fillSourceFromTarget(issuetype, issuetypeTO);
		
		issuetype = issuetypeRepository.save(issuetype);

		return Response.ok(issuetypeConverter.convertSourceToTarget(issuetype)).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") String id) {
		issuetypeRepository.delete(id);
		return Response.ok().status(204).build();
	}
}
