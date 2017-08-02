@Grapes([
        @Grab('org.slf4j:slf4j-simple:1.7.25'),
        @Grab('io.github.http-builder-ng:http-builder-ng-core:0.17.0')
])
import static groovyx.net.http.HttpBuilder.configure
//https://http-builder-ng.github.io/http-builder-ng/asciidoc/html5/
configure {
    request.uri = 'http://localhost:5050/'
}.head {
    response.success {
        println 'workedsogood'
    }
    response.exception {

    }
}