import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Probe extends Simulation{

  //val httpConf = http.baseUrl("https://revo.ru/client_cabinet/hs?api_key=MX8VXuuudchJULWFMgV72KjEZe3UT4BH")
  val httpConf = http.baseUrl("https://joinrpg.ru/account/login")

  val scn = scenario("Basic Simulation")
    .exec(http("request_1")
      .get(""))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(1000))
  ).protocols(httpConf)
}
