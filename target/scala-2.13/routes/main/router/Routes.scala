// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/MessagingApp/conf/routes
// @DATE:Fri Mar 26 03:02:08 IST 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  UserController_3: controllers.UserController,
  // @LINE:18
  GroupController_0: controllers.GroupController,
  // @LINE:28
  MessageController_1: controllers.MessageController,
  // @LINE:36
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    UserController_3: controllers.UserController,
    // @LINE:18
    GroupController_0: controllers.GroupController,
    // @LINE:28
    MessageController_1: controllers.MessageController,
    // @LINE:36
    Assets_2: controllers.Assets
  ) = this(errorHandler, UserController_3, GroupController_0, MessageController_1, Assets_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserController_3, GroupController_0, MessageController_1, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.getUserData()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createUser""", """controllers.UserController.createUser(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addContact""", """controllers.UserController.addToContact(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getContactsOnline""", """controllers.UserController.getContactsOnline(userId:java.lang.Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """setActiveInactive""", """controllers.UserController.setActiveInactive(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createGroup""", """controllers.GroupController.createGroup(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getGroupMembers""", """controllers.GroupController.getGroupMembers(userId:java.lang.Long, groupId:java.lang.Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addToGroup""", """controllers.GroupController.addToGroup(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendMessage""", """controllers.MessageController.sendMessage(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getMessageWindow""", """controllers.MessageController.getMessageWindow(fromUserId:java.lang.Long, receiversId:java.lang.Long, isGroupData:java.lang.Boolean)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_UserController_getUserData0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_getUserData0_invoker = createInvoker(
    UserController_3.getUserData(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUserData",
      Nil,
      "GET",
      this.prefix + """users""",
      """User Related Routes""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_UserController_createUser1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createUser")))
  )
  private[this] lazy val controllers_UserController_createUser1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_3.createUser(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "createUser",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """createUser""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UserController_addToContact2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addContact")))
  )
  private[this] lazy val controllers_UserController_addToContact2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_3.addToContact(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "addToContact",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """addContact""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_getContactsOnline3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getContactsOnline")))
  )
  private[this] lazy val controllers_UserController_getContactsOnline3_invoker = createInvoker(
    UserController_3.getContactsOnline(fakeValue[java.lang.Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getContactsOnline",
      Seq(classOf[java.lang.Long]),
      "GET",
      this.prefix + """getContactsOnline""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UserController_setActiveInactive4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("setActiveInactive")))
  )
  private[this] lazy val controllers_UserController_setActiveInactive4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_3.setActiveInactive(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "setActiveInactive",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """setActiveInactive""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_GroupController_createGroup5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createGroup")))
  )
  private[this] lazy val controllers_GroupController_createGroup5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      GroupController_0.createGroup(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "createGroup",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """createGroup""",
      """GroupRelated Routes""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_GroupController_getGroupMembers6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getGroupMembers")))
  )
  private[this] lazy val controllers_GroupController_getGroupMembers6_invoker = createInvoker(
    GroupController_0.getGroupMembers(fakeValue[java.lang.Long], fakeValue[java.lang.Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "getGroupMembers",
      Seq(classOf[java.lang.Long], classOf[java.lang.Long]),
      "GET",
      this.prefix + """getGroupMembers""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_GroupController_addToGroup7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addToGroup")))
  )
  private[this] lazy val controllers_GroupController_addToGroup7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      GroupController_0.addToGroup(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GroupController",
      "addToGroup",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """addToGroup""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_MessageController_sendMessage8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendMessage")))
  )
  private[this] lazy val controllers_MessageController_sendMessage8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      MessageController_1.sendMessage(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessageController",
      "sendMessage",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """sendMessage""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_MessageController_getMessageWindow9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getMessageWindow")))
  )
  private[this] lazy val controllers_MessageController_getMessageWindow9_invoker = createInvoker(
    MessageController_1.getMessageWindow(fakeValue[java.lang.Long], fakeValue[java.lang.Long], fakeValue[java.lang.Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MessageController",
      "getMessageWindow",
      Seq(classOf[java.lang.Long], classOf[java.lang.Long], classOf[java.lang.Boolean]),
      "GET",
      this.prefix + """getMessageWindow""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_Assets_versioned10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned10_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_UserController_getUserData0_route(params@_) =>
      call { 
        controllers_UserController_getUserData0_invoker.call(UserController_3.getUserData())
      }
  
    // @LINE:8
    case controllers_UserController_createUser1_route(params@_) =>
      call { 
        controllers_UserController_createUser1_invoker.call(
          req => UserController_3.createUser(req))
      }
  
    // @LINE:10
    case controllers_UserController_addToContact2_route(params@_) =>
      call { 
        controllers_UserController_addToContact2_invoker.call(
          req => UserController_3.addToContact(req))
      }
  
    // @LINE:12
    case controllers_UserController_getContactsOnline3_route(params@_) =>
      call(params.fromQuery[java.lang.Long]("userId", None)) { (userId) =>
        controllers_UserController_getContactsOnline3_invoker.call(UserController_3.getContactsOnline(userId))
      }
  
    // @LINE:14
    case controllers_UserController_setActiveInactive4_route(params@_) =>
      call { 
        controllers_UserController_setActiveInactive4_invoker.call(
          req => UserController_3.setActiveInactive(req))
      }
  
    // @LINE:18
    case controllers_GroupController_createGroup5_route(params@_) =>
      call { 
        controllers_GroupController_createGroup5_invoker.call(
          req => GroupController_0.createGroup(req))
      }
  
    // @LINE:20
    case controllers_GroupController_getGroupMembers6_route(params@_) =>
      call(params.fromQuery[java.lang.Long]("userId", None), params.fromQuery[java.lang.Long]("groupId", None)) { (userId, groupId) =>
        controllers_GroupController_getGroupMembers6_invoker.call(GroupController_0.getGroupMembers(userId, groupId))
      }
  
    // @LINE:22
    case controllers_GroupController_addToGroup7_route(params@_) =>
      call { 
        controllers_GroupController_addToGroup7_invoker.call(
          req => GroupController_0.addToGroup(req))
      }
  
    // @LINE:28
    case controllers_MessageController_sendMessage8_route(params@_) =>
      call { 
        controllers_MessageController_sendMessage8_invoker.call(
          req => MessageController_1.sendMessage(req))
      }
  
    // @LINE:30
    case controllers_MessageController_getMessageWindow9_route(params@_) =>
      call(params.fromQuery[java.lang.Long]("fromUserId", None), params.fromQuery[java.lang.Long]("receiversId", None), params.fromQuery[java.lang.Boolean]("isGroupData", None)) { (fromUserId, receiversId, isGroupData) =>
        controllers_MessageController_getMessageWindow9_invoker.call(MessageController_1.getMessageWindow(fromUserId, receiversId, isGroupData))
      }
  
    // @LINE:36
    case controllers_Assets_versioned10_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
