(defproject calculator "0.1.0-SNAPSHOT"
  :description "BDD Calculator example"
  :url "https://github.com/bigkahuna1uk/clojure-bdd"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-cucumber "1.0.2"]]
  :test-paths ["test/acceptance/features" "test/acceptance/step_definitions" "test/clj"]
  :cucumber-feature-paths ["test/acceptance/features"]
  :cucumber-glue-paths ["test/acceptance/step_definitions"]
  :cucumber {:formatter {:type :html :path "target/test-reports.html"}}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [info.cukes/cucumber-clojure "1.1.1"]])
