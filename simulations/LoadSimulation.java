
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

import io.gatling.core.Predef.*;

public class LoadSimulation extends Simulation {
    {
        HttpProtocolBuilder httpProtocol = http
                .baseUrl("https://github.com")
                .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
                .acceptHeader("image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8")
                .acceptEncodingHeader("gzip, deflate, br")
                .acceptLanguageHeader("en-US,en;q=0.9,he;q=0.8")
                .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36").maxConnectionsPerHost(70);

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

        Map<CharSequence, String> headers_3 = new HashMap<>();
        headers_3.put("accept", "application/json");
        headers_3.put("pragma", "no-cache");
        headers_3.put("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116");
        headers_3.put("sec-ch-ua-mobile", "?0");
        headers_3.put("sec-ch-ua-platform", "macOS");
        headers_3.put("sec-fetch-dest", "empty");
        headers_3.put("sec-fetch-mode", "cors");
        headers_3.put("sec-fetch-site", "same-origin");
        headers_3.put("x-requested-with", "XMLHttpRequest");

        Map<CharSequence, String> headers_4 = new HashMap<>();
        headers_4.put("accept", "*/*");
        headers_4.put("pragma", "no-cache");
        headers_4.put("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116");
        headers_4.put("sec-ch-ua-mobile", "?0");
        headers_4.put("sec-ch-ua-platform", "macOS");
        headers_4.put("sec-fetch-dest", "manifest");
        headers_4.put("sec-fetch-mode", "cors");
        headers_4.put("sec-fetch-site", "same-origin");

        Map<CharSequence, String> headers_5 = new HashMap<>();
        headers_5.put("accept", "*/*");
        headers_5.put("content-type", "text/plain;charset=UTF-8");
        headers_5.put("origin", "https://github.com");
        headers_5.put("pragma", "no-cache");
        headers_5.put("sec-ch-ua", "Chromium\";v=\"116\", \"Not)A;Brand\";v=\"24\", \"Google Chrome\";v=\"116");
        headers_5.put("sec-ch-ua-mobile", "?0");
        headers_5.put("sec-ch-ua-platform", "macOS");
        headers_5.put("sec-fetch-dest", "empty");
        headers_5.put("sec-fetch-mode", "no-cors");
        headers_5.put("sec-fetch-site", "same-site");

        String uri1 = "https://api.github.com/_private/browser/stats";

        String uri2 = "https://collector.github.com/github/collect";

        String uri3 = "https://avatars.githubusercontent.com/u";

        ScenarioBuilder scn = scenario("Load")
                .exec(
                        http("request_0")
                                .get("/GilEmanuel22")
                                .headers(headers_0)
                                .resources(
                                        http("request_1")
                                                .get(uri3 + "/91782705?v=4")
                                                .headers(headers_1),
                                        http("request_2")
                                                .get(uri3 + "/108533998?v=4")
                                                .headers(headers_1)
                                )
                )
                .pause(2)
                .exec(
                        http("request_3")
                                .get("/notifications/indicator")
                                .headers(headers_3)
                                .resources(
                                        http("request_4")
                                                .get("/manifest.json")
                                                .headers(headers_4),
                                        http("request_5")
                                                .post(uri2)
                                                .headers(headers_5)
                                                .body(RawFileBody("recordedsimulation/0005_request.bin")),
                                        http("request_6")
                                                .post(uri1)
                                                .headers(headers_5)
                                                .body(RawFileBody("recordedsimulation/0006_request.txt"))
                                )
                )
                .pause(1)
                .exec(
                        http("request_7")
                                .get("/maychook6")
                                .headers(headers_0)
                                .resources(
                                        http("request_8")
                                                .get(uri3 + "/91782705?v=4")
                                                .headers(headers_1),
                                        http("request_9")
                                                .get(uri3 + "/115576739?s=64&v=4")
                                                .headers(headers_1),
                                        http("request_10")
                                                .get(uri3 + "/91782705?s=30&v=4")
                                                .headers(headers_1)
                                )
                )
                .pause(3)
                .exec(
                        http("request_11")
                                .get("/RobiBar1")
                                .headers(headers_0)
                                .resources(
                                        http("request_12")
                                                .get(uri3 + "/97502126?v=4")
                                                .headers(headers_1),
                                        http("request_13")
                                                .get(uri3 + "/91782705?v=4")
                                                .headers(headers_1)
                                )
                )
                .pause(5)
                .exec(
                        http("request_14")
                                .get("/YairBuryak")
                                .headers(headers_0)
                                .resources(
                                        http("request_15")
                                                .get(uri3 + "/91782705?v=4")
                                                .headers(headers_1)
                                )
                );

        setUp(scn.injectOpen(rampUsers(63).during(120)).protocols(httpProtocol));

    }
}