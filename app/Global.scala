import play.api._
import play.api.mvc._
import play.filters.gzip.GzipFilter
import play.api.mvc.Results._
import scala.concurrent.Future
import play.api.mvc.Result
import play.api.mvc.SimpleResult._
object Global extends WithFilters(new GzipFilter()) with GlobalSettings {
  // onStart, onStop etc...
  override def onHandlerNotFound(request: RequestHeader) = {
    Future.successful(NotFound(
      views.html.notfound()
    ))
  }
    
}


 
 