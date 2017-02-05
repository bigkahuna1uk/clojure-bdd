(ns calculator.runcukes
  (:require [clojure.test :refer [deftest is]])
  (:import (cucumber.runtime RuntimeOptions)
           (cucumber.runtime.io MultiLoader)))

(deftest run-cukes
  (let [classloader (.getContextClassLoader (Thread/currentThread))
        runtime-options (RuntimeOptions.
                          (System/getProperties)
                          (into-array ["--format"
                                       "pretty"
                                       "html:target/test-report"
                                       "json:target/test-report.json"
                                       "junit:target/test-report.xml"
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
