// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/MessagingApp/conf/routes
// @DATE:Fri Mar 26 03:02:08 IST 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
