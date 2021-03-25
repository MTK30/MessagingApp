// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/MessagingApp/conf/routes
// @DATE:Fri Mar 26 03:02:08 IST 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:28
  class ReverseMessageController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:30
    def getMessageWindow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessageController.getMessageWindow",
      """
        function(fromUserId0,receiversId1,isGroupData2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getMessageWindow" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].javascriptUnbind + """)("fromUserId", fromUserId0), (""" + implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].javascriptUnbind + """)("receiversId", receiversId1), (""" + implicitly[play.api.mvc.QueryStringBindable[java.lang.Boolean]].javascriptUnbind + """)("isGroupData", isGroupData2)])})
        }
      """
    )
  
    // @LINE:28
    def sendMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MessageController.sendMessage",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "sendMessage"})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseGroupController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def addToGroup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.addToGroup",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addToGroup"})
        }
      """
    )
  
    // @LINE:20
    def getGroupMembers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.getGroupMembers",
      """
        function(userId0,groupId1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getGroupMembers" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].javascriptUnbind + """)("userId", userId0), (""" + implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].javascriptUnbind + """)("groupId", groupId1)])})
        }
      """
    )
  
    // @LINE:18
    def createGroup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GroupController.createGroup",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createGroup"})
        }
      """
    )
  
  }

  // @LINE:36
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def addToContact: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.addToContact",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addContact"})
        }
      """
    )
  
    // @LINE:8
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.createUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createUser"})
        }
      """
    )
  
    // @LINE:12
    def getContactsOnline: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getContactsOnline",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getContactsOnline" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].javascriptUnbind + """)("userId", userId0)])})
        }
      """
    )
  
    // @LINE:14
    def setActiveInactive: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.setActiveInactive",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "setActiveInactive"})
        }
      """
    )
  
    // @LINE:6
    def getUserData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUserData",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
  }


}
