package context;

import akka.actor.ActorSystem;
import play.api.libs.concurrent.CustomExecutionContext;

import javax.inject.Inject;

/**
 * @author  MTK
 *
 */
public class NormalExecutionContext extends CustomExecutionContext {

    @Inject
    public NormalExecutionContext(ActorSystem actorSystem) {
        super(actorSystem,"normal-dispatcher");
    }
}
