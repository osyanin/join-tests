import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Probe extends Simulation{

  val httpConf = http.baseUrl("https://eosdt.com")

  val scn = scenario("Basic Simulation")
    .exec(http("request_1")
      .get(""))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(1000))
  ).protocols(httpConf)
}
