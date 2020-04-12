package tech.donau;

import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    JsonWebToken jwt;

    @GET
    @RolesAllowed("user")
    @NoCache
    public JsonWebToken getUserInfo() {
        return jwt;
    }


    @GET
    @Path("/admin")
    @RolesAllowed("admin")
    public String getAdminSecret() {
        return "ADMIN IS GOD";
    }
}
