(require
  '[taoensso.timbre :as timbre
    :refer [log trace debug info warn error fatal
            logf tracef debugf infof warnf errorf fatalf
            spy get-env]])

(use 'cucumber.runtime.clj)
(use 'calculator.core)
(use 'clojure.test)


(def world (atom {:inputs        []
                  :actual-result nil}))

(Before []
        (reset! world {:inputs        []
                       :actual-result nil})
        (info "Reset state: " @world "\n"))

(Given #"^I have entered -(\d+) into the calculator$" [input]
       (swap! world update :inputs conj (bigdec input))
       (info "Added " input " to " (:inputs @world)))

(Given #"^I have entered (\d+) into the calculator$" [input]
       (swap! world update :inputs conj (bigdec input))
       (info "Added " input " to " (:inputs @world)))

(When #"^I press add$" []
      ;;(swap! world assoc :actual-result (+ 1 (reduce add (:inputs @world)))))
      (swap! world assoc :actual-result (reduce add (:inputs @world))))

(When #"^I press subtract$" []
      (swap! world assoc :actual-result (reduce subtract (:inputs @world))))

(When #"^I press multiply$" []
      (swap! world assoc :actual-result (reduce multiply (:inputs @world))))

(When #"^I press divide$" []
      (swap! world assoc :actual-result (reduce divide (:inputs @world))))

;; Had to use two step because cannot get cuke to recognise a single regex for negative and postive numbers
;(Then #"^the result should be (-?\d+\\(\.\d\\)?) on the screen$" [expected-result]
;      (is (= (bigdec expected-result) (:actual-result @world))))

(defn- do-assert [expected-result]
  (info "Expected="expected-result " actual="(:actual-result @world) " ")
  (assert (= (bigdec expected-result) (:actual-result @world))))

(Then #"^the result should be (\d+) on the screen$" [expected-result]
      (do-assert expected-result))


(Then #"^the result should be -(\d+) on the screen$" [expected-result]
      (do-assert expected-result))


;; REPL(
;; (require 'calculator.runcukes :reload-all)
;; (run-tests 'calculator.runcukes)