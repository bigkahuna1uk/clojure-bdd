(ns calculator.core
  (:require
    [taoensso.timbre :as timbre
     :refer [log trace debug info warn error fatal report
             logf tracef debugf infof warnf errorf fatalf reportf
             spy get-env]]))

(def add
  "Adds numbers"
  +)

(def subtract
  "Subtracts numbers"
  -)

(def multiply
  "Multiplies numbers"
  *)

(def divide
  "Divides numbers"
  /)
