(ns calculator.runcukes
  ;(:require [clojure.test :refer [deftest is]]
  ;          [taoensso.timbre :as timbre
  ;           :refer-macros [log  trace  debug  info  warn  error  fatal  report
  ;                          logf tracef debugf infof warnf errorf fatalf reportf
  ;                          spy get-env]])
  (:import (cucumber.runtime RuntimeOptions)
           (cucumber.runtime.io MultiLoader)))

(deftest run-cukes
  (let [classloader (.getContextClassLoader (Thread/currentThread))
        runtime-options (RuntimeOptions.
                          (System/getProperties)
                          (into-array ["--format"
                                       "pretty"
                                       "html:target/cucumber/html"
                                       "json:target/cucumber/json/report.json"
                                       "junit:target/cucumber/junit/test-report.xml"
                                       "--glue"
                                       "test/acceptance/step_definitions"
                                       "test/acceptance/features"]))
        runtime (cucumber.runtime.Runtime.
                  (MultiLoader. classloader)
                  classloader
                  runtime-options)]
    (doto runtime
      (.writeStepdefsJson)

      (.run))
     (is (= 0 (.exitStatus runtime)))
    ))
