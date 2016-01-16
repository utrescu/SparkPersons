package net.xaviersala.persons.auth;

import org.pac4j.core.context.HttpConstants;
import org.pac4j.core.context.WebContext;
import org.pac4j.sparkjava.DefaultHttpActionAdapter;

import spark.Spark;

public class PersonsHttpActionAdapter extends DefaultHttpActionAdapter {


    public PersonsHttpActionAdapter() {

    }

    @Override
    public Object adapt(int code, WebContext context) {
        if (code == HttpConstants.UNAUTHORIZED) {
            Spark.halt(401, "Non authorized");
        } else if (code == HttpConstants.FORBIDDEN) {
            Spark.halt(403,"Forbidden");
        } else {
            return super.adapt(code, context);
        }
        return null;
    }
}

