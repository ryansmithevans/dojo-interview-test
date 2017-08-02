@Grapes([
  @Grab('io.ratpack:ratpack-groovy:1.5.0-rc-2'),
  @Grab('io.ratpack:ratpack-groovy-test:1.4.6'),
  @Grab('org.slf4j:slf4j-simple:1.7.25')
])
import ratpack.groovy.handling.GroovyHandler
import ratpack.groovy.handling.GroovyContext
import ratpack.groovy.test.handling.GroovyRequestFixture

class MyHandler extends GroovyHandler {
  void handle(GroovyContext context) {
    context.with {
      def outputHeaderValue = request.headers.get("input-value") + ":bar"
      response.headers.set("output-value", outputHeaderValue)
      render "received: " + request.path
    }
  }
}

def result = GroovyRequestFixture.handle(new MyHandler()) {
  header "input-value", "foo"
  uri "some/path"
}

assert result.rendered(String) == "received: some/path"
assert result.headers.get("output-value") == "foo:bar"
