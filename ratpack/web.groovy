@Grapes([
        @Grab('org.slf4j:slf4j-simple:1.7.25'),
        @Grab('io.ratpack:ratpack-groovy:1.5.0-rc-2')
])

import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            render "Hello World!"
        }
        get(":name") {
            render "Hello $pathTokens.name!"
        }
    }
}
