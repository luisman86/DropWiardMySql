package com.itexico.rest;

import com.itexico.auth.DropwizardBlogAuthenticator;
import com.itexico.auth.DropwizardBlogAuthorizer;
import com.itexico.auth.User;
import com.itexico.configuration.DropWizardBlogConfiguration;
import com.itexico.health.DropwizardBlogApplicationHealthCheck;
import com.itexico.resource.PartsResource;
import com.itexico.services.PartsService;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import javax.sql.DataSource;

import org.eclipse.jetty.server.Authentication;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<DropWizardBlogConfiguration>
{
    private static final String SQL = "sql";
    private static final String DROPWIZARD_BLOG_SERVICE = "Dropwizard blog service";
    private static final String BEARER = "Bearer";

    public static void main( String[] args ) throws Exception {

        new App().run(args);
    }

    @Override
    public void run(DropWizardBlogConfiguration configuration, Environment environment) throws Exception {
        final DataSource dataSource =
                configuration.getDataSourceFactory().build(environment.metrics(), SQL);
        DBI dbi = new DBI(dataSource);

        DropwizardBlogApplicationHealthCheck healthCheck =
                new DropwizardBlogApplicationHealthCheck(dbi.onDemand(PartsService.class));
        environment.healthChecks().register(DROPWIZARD_BLOG_SERVICE, healthCheck);

        environment.jersey()
                .register(new AuthDynamicFeature(new OAuthCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new DropwizardBlogAuthenticator())
                        .setAuthorizer(new DropwizardBlogAuthorizer()).setPrefix(BEARER).buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);

        environment.jersey().register(new PartsResource(dbi.onDemand(PartsService.class)));
    }
}
