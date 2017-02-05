(use 'cucumber.runtime.clj)
(use 'calculator.core)
(use 'clojure.test)


(def world (atom {:inputs []
                  :actual-result nil}))

(Given #"^I have entered (\d+) into the calculator$" [input]
       (swap! world update :inputs conj (bigdec input)))

(When #"^I press add$" []
      ;;(swap! world assoc :actual-result (+ 1 (reduce add (:inputs @world)))))
      (swap! world assoc :actual-result (reduce add (:inputs @world))))

(Then #"^the result should be (\d+) on the screen$" [expected-result]
      (assert (= (bigdec expected-result) (:actual-result @world))))

;; REPL(
;; (require 'calculator.runcukes :reload-all)
;; (run-tests 'calculator.runcukes)