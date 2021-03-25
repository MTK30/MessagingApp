// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/MessagingApp/conf/routes
// @DATE:Fri Mar 26 03:02:08 IST 2021

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseMessageController MessageController = new controllers.ReverseMessageController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseGroupController GroupController = new controllers.ReverseGroupController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseMessageController MessageController = new controllers.javascript.ReverseMessageController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseGroupController GroupController = new controllers.javascript.ReverseGroupController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
  }

}
