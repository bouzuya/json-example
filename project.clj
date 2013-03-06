(defproject json-example "0.1.0-SNAPSHOT"
  :description "Java JSON example."
  :url "http://github.com/bouzuya/json-example"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
                 [clj-json "0.5.3"]
                 [com.fasterxml.jackson.core/jackson-databind "2.1.3"]
                 [joda-time/joda-time "2.1"]]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler json-example.handler/app}
  :main json-example.client
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
