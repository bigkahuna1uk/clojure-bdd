(defproject calculator "0.1.0-SNAPSHOT"
  :description "BDD Calculator example"
  :url "https://github.com/bigkahuna1uk/clojure-bdd"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-cucumber "1.0.2"]]
  :test-paths ["features" "test"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [info.cukes/cucumber-clojure "1.1.1"]])
