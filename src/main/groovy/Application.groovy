/**
 * Created by liurui on 16/2/14.
 */


import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.sql.Sql

import static spark.Spark.*;

class Application {
    static JsonSlurper jsonSlurper = new JsonSlurper()
    static Sql db = Sql.newInstance("jdbc:jtds:sqlserver://192.168.180.12:1433/lrtest;instance=sql2008", "yseap", "189CF2F7-6734-4EFA-AB47-302A69674E3C", "net.sourceforge.jtds.jdbc.Driver")

    public static void main(String[] args) {
        port(9090)
        staticFileLocation("/static");

        get("/hello", { req, res -> "Hello World" });

        post('/login', { req, res ->
            println(req.body())

            def user = jsonSlurper.parseText(req.body())

            println(user)

            def u = db.firstRow("select * from test_user WHERE username = ?.username and password = ?.password", user)

            if (u) {
                halt(200, new JsonBuilder(u).toString())
            } else {
                halt(400, '用户名密码不正确')
            }

//            println(user)
        })
    }
}
