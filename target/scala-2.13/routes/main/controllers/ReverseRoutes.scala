// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/MessagingApp/conf/routes
// @DATE:Fri Mar 26 03:02:08 IST 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:28
  class ReverseMessageController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def getMessageWindow(fromUserId:java.lang.Long, receiversId:java.lang.Long, isGroupData:java.lang.Boolean): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getMessageWindow" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].unbind("fromUserId", fromUserId)), Some(implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].unbind("receiversId", receiversId)), Some(implicitly[play.api.mvc.QueryStringBindable[java.lang.Boolean]].unbind("isGroupData", isGroupData)))))
    }
  
    // @LINE:28
    def sendMessage(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "sendMessage")
    }
  
  }

  // @LINE:18
  class ReverseGroupController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def addToGroup(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addToGroup")
    }
  
    // @LINE:20
    def getGroupMembers(userId:java.lang.Long, groupId:java.lang.Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getGroupMembers" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].unbind("userId", userId)), Some(implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].unbind("groupId", groupId)))))
    }
  
    // @LINE:18
    def createGroup(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createGroup")
    }
  
  }

  // @LINE:36
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def addToContact(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addContact")
    }
  
    // @LINE:8
    def createUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createUser")
    }
  
    // @LINE:12
    def getContactsOnline(userId:java.lang.Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getContactsOnline" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].unbind("userId", userId)))))
    }
  
    // @LINE:14
    def setActiveInactive(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "setActiveInactive")
    }
  
    // @LINE:6
    def getUserData(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
  }


}
