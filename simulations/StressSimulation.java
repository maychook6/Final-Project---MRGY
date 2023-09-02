
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;
import io.gatling.core.Predef.*;


import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class StressSimulation extends Simulation {
  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://github.com")
      .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
      .acceptHeader("image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8")
      .acceptEncodingHeader("gzip, deflate, br")
      .acceptLanguageHeader("en-US,en;q=0.9,he;q=0.8")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36").maxConnectionsPerHost(70);
    ;
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
    headers_0.put("pragma", "no-cache");
    headers_0.put("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "macOS");
    headers_0.put("sec-fetch-dest", "document");
    headers_0.put("sec-fetch-mode", "navigate");
    headers_0.put("sec-fetch-site", "cross-site");
    headers_0.put("sec-fetch-user", "?1");
    headers_0.put("upgrade-insecure-requests", "1");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("pragma", "no-cache");
    headers_1.put("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116");
    headers_1.put("sec-ch-ua-mobile", "?0");
    headers_1.put("sec-ch-ua-platform", "macOS");
    headers_1.put("sec-fetch-dest", "image");
    headers_1.put("sec-fetch-mode", "no-cors");
    headers_1.put("sec-fetch-site", "cross-site");
    
    String uri1 = "https://avatars.githubusercontent.com/u";


    ScenarioBuilder scn = scenario("Stress")
            .exec(
              http("request_0")
                      .get("/GilEmanuel22")
                      .headers(headers_0)
                      .resources(
                              http("request_1")
                                      .get(uri1 + "/108533998?v=4")
                                      .headers(headers_1),
                              http("request_2")
                                      .get(uri1 + "/91782705?v=4")
                                      .headers(headers_1)
                      )
      )
              .pause(2)
              .exec(
                      http("request_3")
                              .get("/maychook6")
                              .headers(headers_0)
                              .resources(
                                      http("request_4")
                                              .get(uri1 + "/91782705?v=4")
                                              .headers(headers_1)
                              )
              )
              .pause(1)
              .exec(
                      http("request_5")
                              .get("/RobiBar1")
                              .headers(headers_0)
              )
              .pause(1)
              .exec(
                      http("request_6")
                              .get(uri1 + "/97502126?v=4")
                              .headers(headers_1)
                              .resources(
                                      http("request_7")
                                              .get(uri1 + "/91782705?v=4")
                                              .headers(headers_1)
                              )
              )
              .pause(2)
              .exec(
                      http("request_8")
                              .get("/YairBuryak")
                              .headers(headers_0)
                              .resources(
                                      http("request_9")
                                              .get(uri1 + "/104583338?v=4")
                                              .headers(headers_1),
                                      http("request_10")
                                              .get(uri1 + "/91782705?v=4")
                                              .headers(headers_1)
                              )
              ).pause(120);

    setUp(scn.injectOpen(
                    atOnceUsers(20),
                    rampUsers(0).during(15),
                    atOnceUsers(20),
                    rampUsers(0).during(15),
                    atOnceUsers(20),
                    rampUsers(0).during(15),
                    atOnceUsers(20),
                    rampUsers(0).during(15),
                    atOnceUsers(20),
                    rampUsers(0).during(15),
                    atOnceUsers(20),
                    rampUsers(0).during(15),
                    atOnceUsers(20),
                    rampUsers(0).during(15)
    ).protocols(httpProtocol));
  }
}
