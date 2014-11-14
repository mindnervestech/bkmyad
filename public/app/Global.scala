import play.api._
import play.api.mvc._
import play.filters.gzip.GzipFilter

object Global extends WithFilters(new GzipFilter(shouldGzip = (request, response) =>
  response.headers.get("Content-Type").exists(_.startsWith("image/png")))) with GlobalSettings {
  // onStart, onStop etc...
}